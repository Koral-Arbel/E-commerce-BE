package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.model.ItemDto;
import com.ecommerce.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }
    @CrossOrigin
    @PutMapping("/update")
    public void updateItemById(@RequestBody Item item){
        itemService.updateItemById(item);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable Long itemId){
        return itemService.getItemById(itemId);
    }
    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @CrossOrigin
    @GetMapping(value = "/getItemByOrderId/{orderId}")
    public List<Item> getItemsByOrderId(@PathVariable Long orderId){
        return itemService.getItemsByOrderId(orderId);
    }

    @CrossOrigin
    @GetMapping(value = "/searchItems")
    public List<Item> searchItems(@RequestParam String title) {
        return getAllItems().stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
