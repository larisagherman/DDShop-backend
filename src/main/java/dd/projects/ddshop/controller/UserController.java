package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.dto.UserDTOResponse;
import dd.projects.ddshop.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
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
    public void createUser(@RequestBody UserDTORequest userDTORequest) {
        userService.createUser(userDTORequest);
    }
    @GetMapping
    public List<UserDTOResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserDTOResponse updateUser(@PathVariable("id") int id, @RequestBody UserDTORequest userDTORequest) {
        return userService.update(id, userDTORequest);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTOResponse> deleteUser(@PathVariable("id") int id) {
        UserDTOResponse deletedUser=userService.delete(id);
        return ResponseEntity.ok(deletedUser);
    }
    @GetMapping("{id}")
    public UserDTOResponse getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }


}
