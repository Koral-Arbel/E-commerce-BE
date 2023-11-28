package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Item;

import java.util.List;

public interface ItemRepository {
    Item createItem(Item item);
    void updateItemById(Item item);
    void deleteItemById(Long id);
    Item getItemById(Long itemId);
    List<Item> getAllItems();

    void updateAvailableStock(Long itemId, Integer availableStock);

    List<Item> getItemsByOrderId(Long orderId);
}
