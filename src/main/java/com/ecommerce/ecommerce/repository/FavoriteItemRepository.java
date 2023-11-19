package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.FavoriteItem;

import java.util.List;

public interface FavoriteItemRepository {
    Long createItemAddToFavorites(FavoriteItem favoriteItem);
    void updateFavorites(Long id, FavoriteItem favoriteItem);
    FavoriteItem getFavoriteItemListById(Long id);
    void removeFromFavorites(Long id);
    void deleteAllItemFromFavoriteByUserId(Long userId);
    List<FavoriteItem> getFavoriteItemsByUserId(Long userId);

}
