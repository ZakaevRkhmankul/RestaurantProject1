package peaksoft.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemResponse {
    Long id;
    String name;
    String image;
    int price;
    String description;
    Boolean isVegetarian;
    RestaurantResponse restaurantResponse;
    SubcategoryResponse subcategoryResponse;
}
