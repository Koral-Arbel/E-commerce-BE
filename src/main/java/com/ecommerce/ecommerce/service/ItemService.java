package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Item;

import java.util.List;

public interface ItemService {
    Long createItem(Item item);
    Item getItemById(Long itemId);
    List<Item> getAllItems();
}
