package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.service.FavoriteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favoriteItem")
public class FavoriteItemController {
    @Autowired
    FavoriteItemService favoriteItemService;
    @CrossOrigin
    @PostMapping(value = "/itemAddFavorite")
    public Long createItemAddToFavorite(@RequestBody FavoriteItem favoriteItem) throws Exception {
        return favoriteItemService.createItemAddToFavorite(favoriteItem);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateFavoriteById(@PathVariable Long id, @RequestBody FavoriteItem favoriteItem) {
        favoriteItemService.updateFavoriteById(id, favoriteItem);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public FavoriteItem getFavoriteItemListById(@PathVariable Long id){
        return favoriteItemService.getFavoriteItemListById(id);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteFavoriteItemById(@PathVariable Long id) {
        favoriteItemService.deleteFavoriteItemById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/all/{userId}")
    public List<Item> getFavoriteItemsByUserId(@PathVariable Long userId){
       return favoriteItemService.getFavoriteItemsByUserId(userId);
    }
}
