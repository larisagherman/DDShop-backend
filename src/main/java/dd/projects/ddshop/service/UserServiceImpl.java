package dd.projects.ddshop.service;

import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
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

    public User updateEmail(int userId, String email) {
        User existingUser = userRepository.findById(userId);
        existingUser.setEmail(email);
        return userRepository.save(existingUser);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
