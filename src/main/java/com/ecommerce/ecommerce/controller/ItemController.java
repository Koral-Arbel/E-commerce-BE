package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping(value = "/create")
    @CrossOrigin
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }
    @PutMapping("/update")
    @CrossOrigin
    public void updateItemById(@RequestBody Item item){
        itemService.updateItemById(item);
    }

    @GetMapping(value = "/{id}")
    @CrossOrigin
    public Item getItemById(@PathVariable Long itemId){
        return itemService.getItemById(itemId);
    }

    @GetMapping(value = "/all")
    @CrossOrigin
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping(value = "/getItemByOrderId/{orderId}")
    @CrossOrigin
    public List<Item> getItemsByOrderId(@PathVariable Long orderId){
        return itemService.getItemsByOrderId(orderId);
    }
}
