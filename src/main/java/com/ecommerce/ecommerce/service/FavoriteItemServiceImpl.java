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
    @Autowired
    ItemService itemService;

    @Override
    public Long createItemAddToFavorite(FavoriteItem favoriteItem) throws Exception {
        if (favoriteItem != null){
            Item wantedItem = itemService.getItemById(favoriteItem.getItemId());
            if (wantedItem != null){
                List<Item> userFavoriteItem = favoriteItemRepository.getFavoriteItemsByUserId(favoriteItem.getUserId());
                boolean isFound = false;
                for (Item item : userFavoriteItem) {
                    if (item.getId().equals(wantedItem.getId())) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    throw new Exception("item already in favorite List");

                } else {
                    return favoriteItemRepository.createItemAddToFavorites(favoriteItem);
                }
            }else {
                throw new Exception("No such item");
            }
        }else {
            throw new Exception("no favorite item list to add");
        }

    }

    @Override
    public void updateFavoriteById(Long id, FavoriteItem favoriteItem) {
        favoriteItemRepository.updateFavorites(id, favoriteItem);
    }

    @Override
    public FavoriteItem getFavoriteItemListById(Long userId) {
        return favoriteItemRepository.getFavoriteItemListById(userId);
    }

    @Override
    public void removeItemFromFavorites(Long itemId) {
        favoriteItemRepository.removeItemFromFavorites(itemId);
    }

    @Override
    public void deleteFavoriteItemById(Long id) {
        favoriteItemRepository.removeItemFromFavorites(id);
    }

    @Override
    public void deleteAllItemFromFavoriteByUserId(Long userId) {
        favoriteItemRepository.deleteAllItemFromFavoriteByUserId(userId);
    }

    @Override
    public List<Item> getFavoriteItemsByUserId(Long userId) {
        return favoriteItemRepository.getFavoriteItemsByUserId(userId);
    }
}