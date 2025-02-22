package peaksoft.service;

import peaksoft.dto.request.MenuItemRequest;
import peaksoft.dto.responses.MenuItemResponse;

import java.util.List;

public interface MenuItemService {
    void saveMenuItem(MenuItemRequest menuItemRequest);
    MenuItemResponse getMenuItem(Long id);
    List<MenuItemResponse> getMenuItems();
    void updateMenuItem(Long id,MenuItemRequest menuItemRequest);
    void deleteMenuItem(Long id);
}
