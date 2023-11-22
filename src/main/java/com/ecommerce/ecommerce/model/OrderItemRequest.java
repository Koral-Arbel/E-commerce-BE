package com.ecommerce.ecommerce.model;

public class OrderItemRequest {
    private Long itemId;
    private int quantity;
    private OrderStatus orderStatus;
    private Item item;
    private Order order;
    public OrderItemRequest(){}

    public OrderItemRequest(Long itemId, int quantity, OrderStatus orderStatus, Item item, Order order) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.item = item;
        this.order = order;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Item getItem() {
        return item;
    }

    public Order getOrder() {
        return order;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem toOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderItem.getOrderId());
        orderItem.setItemId(itemId);
        orderItem.setPrice(getItem().getPrice());
        orderItem.setQuantity(quantity);
        orderItem.setTotalPrice(toOrderItem().getTotalPrice());
        orderItem.setOrderStatus(orderStatus);
        return orderItem;
    }
}
