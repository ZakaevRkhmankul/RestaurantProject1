package peaksoft.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.dto.responses.UserResponse;
import peaksoft.entities.Restaurant;
import peaksoft.entities.User;
import peaksoft.enums.Role;
import peaksoft.repository.RestaurantRepo;
import peaksoft.repository.UserRepo;
import peaksoft.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;

    @PostConstruct
    public void initAdmin() {
        if (userRepo.findByEmail("admin@example.com").isEmpty()) {
            User admin = new User();
            admin.setFirstName("Default");
            admin.setLastName("Admin");
            admin.setDateOfBirth(LocalDate.of(1980, 1, 1));
            admin.setEmail("admin@example.com");
            admin.setPassword("admin123");
            admin.setPhoneNumber("+1234567890");
            admin.setRole(Role.ADMIN);
            admin.setExperience(20);
            userRepo.save(admin);
        }
    }

    @Override
    public SimpleResponse saveUser( UserRequest userRequest) {
        Restaurant restaurant = restaurantRepo.findById(userRequest.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        if (restaurant.getUsers().size() >= 15) {
            return SimpleResponse
                    .builder()
                    .httpStatus(HttpStatus.OK)
                    .message("Вакансия жок! Бул ресторан кызматкерлердин максималдуу саны жетти.")
                    .build();
        }
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        user.setExperience(userRequest.getExperience());
        user.setRole(Role.WAITER);
        user.setRestaurant(restaurant);
        restaurant.getUsers().add(user);
        userRepo.save(user);

        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }


    @Override
    public UserResponse getUser(Long id) {
        return userRepo.getUser(id);
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepo.getUsers();
    }

    @Override
    public SimpleResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        if (userRequest.getFirstName() != null)
            user.setFirstName(userRequest.getFirstName());
        if (userRequest.getLastName() != null)
            user.setLastName(userRequest.getLastName());
        if (userRequest.getDateOfBirth() != null)
            user.setDateOfBirth(userRequest.getDateOfBirth());
        if (userRequest.getEmail() != null)
            user.setEmail(userRequest.getEmail());
        if (userRequest.getPassword() != null)
            user.setPassword(userRequest.getPassword());
        if (userRequest.getPhoneNumber() != null)
            user.setPhoneNumber(userRequest.getPhoneNumber());
        if (userRequest.getRole() != null)
            user.setRole(userRequest.getRole());
        if (userRequest.getExperience() != 0)
            user.setExperience(userRequest.getExperience());
        userRepo.save(user);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("User successfully updated")
                .build();
    }

    @Override
    public SimpleResponse deleteUser(Long id) {
        userRepo.deleteById(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("User successfully deleted")
                .build();
    }

    @Override
    public User getByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found" + email));
    }
}
