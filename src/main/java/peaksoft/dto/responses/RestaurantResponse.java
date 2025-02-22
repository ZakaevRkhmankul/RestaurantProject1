package peaksoft.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.MenuItem;
import peaksoft.entities.User;
import peaksoft.enums.RestType;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantResponse {
    Long id;
    String name;
    String location;
    RestType restType;
    int numberOfEmployees;
    String service;
    List<User> users = new ArrayList<>();
    List<MenuItem> menuItems = new ArrayList<>();

    public RestaurantResponse(Long id, String name, String location, RestType restType, int numberOfEmployees, String service) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.restType = restType;
        this.numberOfEmployees = numberOfEmployees;
        this.service = service;
    }

    public RestaurantResponse() {

    }
}
