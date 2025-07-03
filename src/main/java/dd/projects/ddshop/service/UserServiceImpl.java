package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Data
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public List<UserDTO> getAllUsers(){
        List<User> users= userRepository.findAll();
        return users.stream().map(it->fromUserToUserDTO(it)).collect(Collectors.toList());
    }
    public UserDTO fromUserToUserDTO(User user){
        return new UserDTO(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber());
    }
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(int userId,User updatedUser) {
        User existingUser = userRepository.findById(userId);// first we try and find the user we want to update their data
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        existingUser.setDefaultDeliveryAddress(updatedUser.getDefaultDeliveryAddress());
        existingUser.setDefaultBillingAddress(updatedUser.getDefaultBillingAddress());
        return userRepository.save(existingUser);
    }

    @Override
    public User updateEmail(int userId, String email) {
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
