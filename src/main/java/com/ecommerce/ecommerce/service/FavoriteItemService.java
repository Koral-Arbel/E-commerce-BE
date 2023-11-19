package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.FavoriteItem;

import java.util.List;

public interface FavoriteItemService {
    Long createItemAddToFavorites(FavoriteItem favoriteItem) throws Exception;

    void updateFavorites(Long id, FavoriteItem favoriteItem);

    FavoriteItem getFavoriteItemListById(Long id);

    void removeFromFavorites(Long id);

    void deleteAllItemFromFavoriteByUserId(Long userId);

    List<FavoriteItem> getFavoriteItemsByUserId(Long userId);
}
