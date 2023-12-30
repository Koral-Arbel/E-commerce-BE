    package com.ecommerce.ecommerce.service;
    import com.ecommerce.ecommerce.model.*;
    import com.ecommerce.ecommerce.repository.OrderItemRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.acls.model.NotFoundException;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;

    @Service
    public class OrderItemServiceImpl implements OrderItemService {
        @Autowired
        OrderItemRepository orderItemRepository;
       @Autowired
        OrderService orderService;
       @Autowired
        ItemService itemService;
        @Override
        public OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest) throws Exception {
            if (orderItemRequest == null) {
                throw new IllegalArgumentException("OrderItemRequest is null");
            }
            // Retrieve item information
            Item itemInformation = itemService.getItemById(orderItemRequest.getItemId());
            if (itemInformation == null) {
                throw new NotFoundException("Item with id " + orderItemRequest.getItemId() + " not found");
            }
            // Check item availability
            if (itemInformation.getAvailableStock() == 0) {
                throw new IllegalArgumentException("Item is not available in stock");
            }
            Long orderId = orderService.getOpenOrderForUserId(orderItemRequest.getUserId());

            if (orderId == null) {
                LocalDateTime date = LocalDateTime.now();
                Order newOrder = new Order(null, orderItemRequest.getUserId(), date, null, OrderStatus.TEMP);
                orderId = orderService.createOrder(newOrder);
            }

            Order openOrder = orderService.getOrderById(orderId);

            // Check if the item already exists in the order
            List<Item> orderItems = itemService.getItemsByOrderId(orderId);
            if (isItemAlreadyInOrder(orderItems, orderItemRequest.getItemId())) {
                throw new IllegalArgumentException("Item is already in the order");
            }

            OrderItem orderItem = new OrderItem(
                    null,
                    orderItemRequest.getUserId(),
                    orderId,
                    orderItemRequest.getItemId(),
                    itemInformation.getPrice(),
                    orderItemRequest.getQuantity()
            );

            // Update item availability and create the order item
            itemService.updateAvailableStock(itemInformation.getId(), itemInformation.getAvailableStock() - 1);
            orderItemRepository.createOrderItem(orderItem);
            orderService.updateOrderById(openOrder);

            // Retrieve updated order items
            orderItems = itemService.getItemsByOrderId(orderId);

            // Calculate total price dynamically
            Double totalPrice = orderItems.stream()
                    .mapToDouble(item -> item.getPrice() * orderItem.getQuantity())
                    .sum();

            // Update the response DTO with the total price
            orderItem.calculateSubtotal();

            // Create the response DTO
            OrderItemResponse orderItemResponse = new OrderItemResponse(openOrder, orderItems, totalPrice);
            return orderItemResponse;
        }
        @Override
        public void updateOrderItemById(Long customerOrderId, OrderItem orderItem ) {
            orderItemRepository.updateOrderItemById(customerOrderId, orderItem);
        }

        @Override
        public void deleteOrderItemById(Long itemId) {
            orderItemRepository.deleteOrderItemById(itemId);
        }

        @Override
        public OrderItem getOrderItemById(Long id) {
            return orderItemRepository.getOrderItemById(id);
        }

        @Override
        public List<OrderItem> getAllItemsByOrderId(Long orderId) {
            return orderItemRepository.getAllItemsByOrderId(orderId);
        }


        private boolean isItemAlreadyInOrder(List<Item> orderItems, Long itemId) {
            return orderItems.stream().anyMatch(item -> item.getId().equals(itemId));
        }
    }
