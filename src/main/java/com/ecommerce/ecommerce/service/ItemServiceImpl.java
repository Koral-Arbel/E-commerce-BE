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
    @Autowired
    OrderService orderService;

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
        Item existingItem = getItemById(itemId);

        if (existingItem != null) {
            // בדיקה אם יש מלאי זמין
            if (availableStock < 0) {
                throw new IllegalArgumentException("Cannot set negative stock for item with id " + itemId);
            }

            // עדכון כמות המלאי
            existingItem.setAvailableStock(availableStock);

            // שמירת השינויים בבסיס הנתונים
            itemRepository.updateAvailableStock(itemId, availableStock);

            // בדיקה אם המוצר אזל מהמלאי
            if (availableStock == 0) {
                // כאן ניתן להוסיף לוגיקה נוספת או להתממשק עם שירותים נוספים כדי לטפל במצב שבו המוצר אזל מהמלאי
                 orderService.handleOutOfStockItem(existingItem);
            }
        } else {
            // אם המוצר לא נמצא, ניתן להכניס לוג רלוונטי או לטפל בדרך אחרת
            throw new IllegalArgumentException("Item with id " + itemId + " not found");
        }
    }

    @Override
    public List<Item> getItemsByOrderId(Long orderId) {
        return itemRepository.getItemsByOrderId(orderId);
    }

    @Override
    public List<Item> searchItems(String title) {
        return itemRepository.searchItems(title);
    }
}
