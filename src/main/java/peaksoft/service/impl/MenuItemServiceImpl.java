package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.MenuItemRequest;
import peaksoft.dto.responses.*;
import peaksoft.entities.Restaurant;
import peaksoft.entities.Subcategory;
import peaksoft.repository.MenuItemRepo;
import peaksoft.repository.RestaurantRepo;
import peaksoft.service.MenuItemService;
import peaksoft.entities.MenuItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepo menuItemRepo;
    private final RestaurantRepo restaurantRepo;

    @Override
    @Transactional
    public void saveMenuItem(MenuItemRequest menuItemRequest) {
        Restaurant restaurant = restaurantRepo.findById(menuItemRequest.getRestaurantId())
                .orElseThrow(()->new RuntimeException("Restaurant not found"));

        MenuItem menuItem = new MenuItem();

        menuItem.setName(menuItemRequest.getName());
        menuItem.setImage(menuItemRequest.getImage());
        menuItem.setPrice(menuItemRequest.getPrice());
        menuItem.setDescription(menuItemRequest.getDescription());
        menuItem.setIsVegetarian(menuItemRequest.getIsVegetarian());
        menuItem.setRestaurant(restaurant);
        restaurant.getMenuItems().add(menuItem);
        menuItemRepo.save(menuItem);
    }

    @Override
    @Transactional
    public MenuItemResponse getMenuItem(Long id) {
        MenuItem menuItem = menuItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        MenuItemResponse menuItemResponse = new MenuItemResponse();
        menuItemResponse.setId(menuItem.getId());
        menuItemResponse.setName(menuItem.getName());
        menuItemResponse.setImage(menuItem.getImage());
        menuItemResponse.setPrice(menuItem.getPrice());
        menuItemResponse.setDescription(menuItem.getDescription());
        menuItemResponse.setIsVegetarian(menuItem.getIsVegetarian());
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        Restaurant restaurant = menuItem.getRestaurant();
        restaurantResponse.setId(restaurant.getId());
        restaurantResponse.setName(restaurant.getName());
        menuItemResponse.setRestaurantResponse(restaurantResponse);
        SubcategoryResponse subcategoryResponse = new SubcategoryResponse();
        Subcategory subcategory = menuItem.getSubcategory();
        subcategoryResponse.setId(subcategory.getId());
        subcategoryResponse.setName(subcategory.getName());
        menuItemResponse.setSubcategoryResponse(subcategoryResponse);
        return menuItemResponse;
    }

    @Override
    public List<MenuItemResponse> getMenuItems() {
        return List.of();
    }

    @Override
    public void updateMenuItem(Long id, MenuItemRequest menuItemRequest) {

    }

    @Override
    public void deleteMenuItem(Long id) {

    }
}
