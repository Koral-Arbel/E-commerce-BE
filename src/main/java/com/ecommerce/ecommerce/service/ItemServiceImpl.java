package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @Override
    public void updateItemById(Item item) {
        updateItemById(item);
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.getItemById(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    @Override
    public void updateAvailableStock(Long itemId, Integer availableStock) {
        if (itemId != null){
            Item getItemId = itemRepository.getItemById(itemId);
            if(getItemId != null){
                itemRepository.updateAvailableStock(itemId, availableStock);
            }else {
                new Exception(getItemId.getId() + "is not exist");
            }
        }else {
            new Exception("request is empty");
        }
    }

    @Override
    public List<Item> getItemsByOrderId(Long orderId) {
        return itemRepository.getItemsByOrderId(orderId);
    }
}
