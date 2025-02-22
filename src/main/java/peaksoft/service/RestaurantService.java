package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.responses.RestaurantResponse;
import peaksoft.dto.responses.SimpleResponse;


import java.util.List;
@Service
public interface RestaurantService {
    SimpleResponse createRestaurant(RestaurantRequest restaurantRequest);
    RestaurantResponse getRestaurant(Long id);
    List<RestaurantResponse> getAllRestaurants();
    RestaurantResponse updateRestaurant(Long id, RestaurantRequest restaurantRequest);
    SimpleResponse deleteRestaurant(Long id);
}
