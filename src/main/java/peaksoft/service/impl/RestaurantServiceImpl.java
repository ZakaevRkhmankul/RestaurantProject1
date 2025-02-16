package peaksoft.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.RestaurantRequest;
import peaksoft.dto.responses.RestaurantResponse;
import peaksoft.entities.Restaurant;
import peaksoft.repository.RestaurantRepo;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }


    @Override
    public RestaurantRequest createRestaurant(RestaurantRequest restaurantRequest) {
        
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.getName());
        restaurant.setLocation(restaurantRequest.getLocation());
        restaurant.setRestType(restaurantRequest.getRestType());
        restaurant.setNumberOfEmployees(restaurantRequest.getNumberOfEmployees());
        restaurant.setService(restaurantRequest.getService());
        restaurantRepo.save(restaurant);
        return restaurantRequest;
    }


    @Override
    public RestaurantResponse getRestaurant(Long id) {
        return restaurantRepo.getRestaurant(id);
    }

    @Override
    public List<RestaurantResponse> getAllRestaurants() {
        return restaurantRepo.getAllRestaurants();
    }

    @Override
    public RestaurantResponse updateRestaurant(Long id, RestaurantRequest restaurantRequest) {

        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant with id " + id + " not found"));


        if (restaurantRequest.getName() != null)
            restaurant.setName(restaurantRequest.getName());
        if (restaurantRequest.getLocation() != null)
            restaurant.setLocation(restaurantRequest.getLocation());
        if (restaurantRequest.getRestType() != null)
            restaurant.setRestType(restaurantRequest.getRestType());
        if (restaurantRequest.getNumberOfEmployees() != 0)
            restaurant.setNumberOfEmployees(restaurantRequest.getNumberOfEmployees());
        if (restaurantRequest.getService() != null)
            restaurant.setService(restaurantRequest.getService());
        restaurantRepo.save(restaurant);

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getRestType(),
                restaurant.getNumberOfEmployees(),
                restaurant.getService()
        );
    }

    @Override
    public String deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant with id " + id + " not found"));
        restaurantRepo.delete(restaurant);
        return "Restaurant with id " + id + " was deleted";
    }

}
