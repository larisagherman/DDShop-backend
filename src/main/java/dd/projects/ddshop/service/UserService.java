package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> getAllUsers();

    public User createUser(User user);

    public User getUserById(int id);
    public User updateUser(int userId,User updatedUser);
    public User updateEmail(int userId,String email);
    public void deleteUser(int id);


}

