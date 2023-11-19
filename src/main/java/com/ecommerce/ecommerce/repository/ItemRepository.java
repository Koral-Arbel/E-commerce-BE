package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Item;

import java.util.List;

public interface ItemRepository {
    Long createItem(Item item);
    Item getItemById(Long itemId);
    List<Item> getAllItems();
}
