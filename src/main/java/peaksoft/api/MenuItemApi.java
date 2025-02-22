package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.MenuItemRequest;
import peaksoft.dto.responses.MenuItemResponse;
import peaksoft.dto.responses.SimpleResponse;

import peaksoft.service.MenuItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menuItems")
public class MenuItemApi {
    private final MenuItemService menuItemService;

    @PostMapping
    public SimpleResponse saveMenuItem(@RequestBody MenuItemRequest menuItemRequest) {
        menuItemService.saveMenuItem(menuItemRequest);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Saved menu item")
                .build();
    }
    @GetMapping("/{id}")
    public MenuItemResponse getMenuItemById(@PathVariable("id") Long id) {
        return menuItemService.getMenuItem(id);
    }
}
