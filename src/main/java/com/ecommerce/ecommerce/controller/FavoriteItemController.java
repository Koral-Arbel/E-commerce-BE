package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.service.FavoriteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoriteItem")
public class FavoriteItemController {
    @Autowired
    FavoriteItemService favoriteItemService;
    @PostMapping("/add")
    @CrossOrigin
    public ResponseEntity<Long> addToFavorites(@RequestBody FavoriteItem favoriteItem) {
        try {
            Long itemId = favoriteItemService.createItemAddToFavorite(favoriteItem);
            return ResponseEntity.ok(itemId);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PutMapping("/{id}/update")
    @CrossOrigin
    public ResponseEntity<String> updateFavorites(@PathVariable Long id, @RequestBody FavoriteItem favoriteItem) {
        favoriteItemService.updateFavoriteById(id, favoriteItem);
        return ResponseEntity.ok("Item quantity updated successfully");
    }

    @GetMapping(value = "/{id}")
    @CrossOrigin
    public FavoriteItem getFavoriteItemById(@PathVariable Long id){
        return favoriteItemService.getFavoriteItemListById(id);
    }

    @DeleteMapping("/{id}/delete")
    @CrossOrigin
    public ResponseEntity<String> removeFromFavorites(@PathVariable Long id) {
        favoriteItemService.deleteFavoriteItemById(id);
        return ResponseEntity.ok("Item removed from favorites successfully");
    }

    @GetMapping(value = "/{userId}/all")
    @CrossOrigin
    public ResponseEntity<List<Item>> getAllFavoriteItemByUserId(@PathVariable Long userId) {
        List<Item> favoriteItems = favoriteItemService.getFavoriteItemsByUserId(userId);
        return ResponseEntity.ok(favoriteItems);
    }
}
