package peaksoft.dto.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.entities.Restaurant;
import peaksoft.enums.Role;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String email;
    String phoneNumber;
    Role role;
    int experience;
    Restaurant restaurant;

    public UserResponse(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, Role role, int experience, Restaurant restaurant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.experience = experience;
        this.restaurant = restaurant;
    }
}
