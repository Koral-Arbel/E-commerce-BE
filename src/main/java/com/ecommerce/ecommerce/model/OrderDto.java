package com.ecommerce.ecommerce.model;

import java.util.List;

public class OrderDto {
    private Order order;
    private List<ItemDto> item;

    public OrderDto(){}

    public OrderDto(Order order, List<ItemDto> item) {
        this.order = order;
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public List<ItemDto> getItem() {
        return item;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItem(List<ItemDto> item) {
        this.item = item;
    }
}