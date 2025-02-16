package peaksoft.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.Restaurant;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {
    String name;
    String location;
    String restType;
    int numberOfEmployees;
    String service;

    public RestaurantRequest(Restaurant restaurant) {
    }
}
