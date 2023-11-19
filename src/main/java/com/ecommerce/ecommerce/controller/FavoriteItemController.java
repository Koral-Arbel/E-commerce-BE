package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.service.FavoriteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoriteItem")
public class FavoriteItemController {
    @Autowired
    FavoriteItemService favoriteItemService;
    @PostMapping("/add")
    public ResponseEntity<String> addToFavorites(@RequestParam FavoriteItem favoriteItem) throws Exception {
        favoriteItemService.createItemAddToFavorites(favoriteItem);
        return ResponseEntity.ok("Item added to favorites successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateFavorites(@PathVariable Long id, @RequestParam FavoriteItem favoriteItem){
        favoriteItemService.updateFavorites(id, favoriteItem);
        return ResponseEntity.ok("Item quantity updated successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FavoriteItem>> getFavoriteItemsByUserId(@PathVariable Long userId) {
        List<FavoriteItem> favoriteItems = favoriteItemService.getFavoriteItemsByUserId(userId);
        return ResponseEntity.ok(favoriteItems);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromFavorites(@RequestParam Long id) {
        favoriteItemService.removeFromFavorites(id);
        return ResponseEntity.ok("Item removed from favorites successfully");
    }
}
