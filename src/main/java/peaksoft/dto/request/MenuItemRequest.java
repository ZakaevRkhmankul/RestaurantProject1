package peaksoft.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.StopList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MenuItemRequest {
    String name;
    String image;
    int price;
    String description;
    Boolean isVegetarian;
    Long restaurantId;
}
