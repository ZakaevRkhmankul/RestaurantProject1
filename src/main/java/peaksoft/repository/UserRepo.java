package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.responses.UserResponse;
import peaksoft.entities.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select new peaksoft.dto.responses.UserResponse(u.id,u.firstName,u.lastName,u.dateOfBirth,u.email,u.phoneNumber,u.role,u.experience,u.restaurant) from User u where u.id = :id")
    UserResponse getUser(Long id);

    @Query("select new peaksoft.dto.responses.UserResponse(u.id,u.firstName,u.lastName,u.dateOfBirth,u.email,u.phoneNumber,u.role,u.experience,u.restaurant) from User u")
    List<UserResponse> getUsers();

    Optional<User> findByEmail(String email);
}
