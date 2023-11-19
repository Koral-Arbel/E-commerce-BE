package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.model.FavoriteItem;
import com.ecommerce.ecommerce.model.Item;
import com.ecommerce.ecommerce.repository.FavoriteItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteItemServiceImpl implements FavoriteItemService {
    @Autowired
    private FavoriteItemRepository favoriteItemRepository;

    @Override
    public Long createItemAddToFavorites(FavoriteItem favoriteItem) throws Exception {
        return null;
    }

    @Override
    public void updateFavorites(Long id, FavoriteItem favoriteItem) {

    }

    @Override
    public FavoriteItem getFavoriteItemListById(Long id) {
        return null;
    }

    @Override
    public void removeFromFavorites(Long id) {

    }

    @Override
    public void deleteAllItemFromFavoriteByUserId(Long userId) {

    }

    @Override
    public List<FavoriteItem> getFavoriteItemsByUserId(Long userId) {
        return null;
    }
}