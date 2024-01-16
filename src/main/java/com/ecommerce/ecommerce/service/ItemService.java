package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    void updateItemById(Item item);
    Item getItemById(Long itemId);
    List<Item> getAllItems();

    void updateAvailableStock(Long itemId, Integer availableStock);

    List<Item> getItemsByOrderId(Long orderId);

    List<Item> searchItems(String title);
}
