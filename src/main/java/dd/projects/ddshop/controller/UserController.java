package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @PutMapping(value = "/{id}/email")
    public User updateEmail(@PathVariable int id, @RequestBody String email) {
        return userService.updateEmail(id, email);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


}
