package peaksoft.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import peaksoft.enums.Role;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String email;
    String password;
    String phoneNumber;
    Role role;
    int experience;
    Long restaurantId;
}
