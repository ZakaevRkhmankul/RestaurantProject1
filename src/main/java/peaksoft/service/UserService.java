package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.responses.SimpleResponse;
import peaksoft.dto.responses.UserResponse;
import peaksoft.entities.User;

import java.util.List;


@Service
public interface UserService {
    SimpleResponse saveUser(UserRequest userRequest);
    UserResponse getUser(Long id);
    List<UserResponse> getUsers();
    SimpleResponse updateUser(Long id,UserRequest userRequest);
    SimpleResponse deleteUser(Long id);
    User getByEmail(String email);
}
