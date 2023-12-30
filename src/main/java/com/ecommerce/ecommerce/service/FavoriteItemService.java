package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.model.Item;

import java.util.List;

public interface FavoriteItemService {
    Long createItemAddToFavorite(FavoriteItem favoriteItem) throws Exception;

    void updateFavoriteById(Long id, FavoriteItem favoriteItem);

    FavoriteItem getFavoriteItemListById(Long userId);

    void deleteFavoriteItemById(Long id);

    void deleteAllItemFromFavoriteByUserId(Long userId);

    List<Item> getFavoriteItemsByUserId(Long userId);
}
