package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.CartDTORequest;
import dd.projects.ddshop.dto.LoginDTORequest;
import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.dto.UserDTOResponse;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.mapper.UserMapper;
import dd.projects.ddshop.repository.UserRepository;
import dd.projects.ddshop.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final CartService cartService;

    public ResponseEntity login(LoginDTORequest loginDTORequest) {
        User existingUser = userRepository.findByEmail(loginDTORequest.getEmail());
        System.out.println(existingUser.getId());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        }

        if (!existingUser.getPassword().equals(loginDTORequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password.");
        }
        UserDTOResponse userDTOResponse = userMapper.entityToDTOResponse(existingUser);
        String token = jwtUtil.generateToken(existingUser.getEmail());

        // Combine token and user info in a response map
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", userDTOResponse);

        return ResponseEntity.ok(response);

    }

    public ResponseEntity register(UserDTORequest userDTORequest) {
        User existingUser = userRepository.findByEmail(userDTORequest.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use.");
        }
//        userService.createUser(userDTORequest);

        User user =userMapper.dtoRequestToEntity(userDTORequest);
        User savedUser = userRepository.save(user);

        CartDTORequest cartDTORequest = new CartDTORequest();
        cartDTORequest.setUserId(savedUser.getId());
        cartDTORequest.setTotalPrice(0);
        cartService.createCart(cartDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("user created");
    }
}
