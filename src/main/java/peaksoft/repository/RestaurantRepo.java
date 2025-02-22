package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.responses.RestaurantResponse;
import peaksoft.entities.Restaurant;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {

    @Query("select new peaksoft.dto.responses.RestaurantResponse(r.id,r.name,r.location,r.restType,r.numberOfEmployees,r.service) from Restaurant r where r.id = :id")
    RestaurantResponse getRestaurant(Long id);

    @Query("select new peaksoft.dto.responses.RestaurantResponse(r.id,r.name,r.location,r.restType,r.numberOfEmployees,r.service)from Restaurant r")
   List<RestaurantResponse> getAllRestaurants();
}
