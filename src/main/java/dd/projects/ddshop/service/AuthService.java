package dd.projects.ddshop.service;

import dd.projects.ddshop.dto.*;
import dd.projects.ddshop.entity.PasswordResetToken;
import dd.projects.ddshop.entity.User;
import dd.projects.ddshop.mapper.UserMapper;
import dd.projects.ddshop.repository.PasswordResetTokenRepository;
import dd.projects.ddshop.repository.UserRepository;
import dd.projects.ddshop.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public ResponseEntity login(LoginDTORequest loginDTORequest) {
        User existingUser = userRepository.findByEmail(loginDTORequest.getEmail());
        System.out.println(existingUser.getId());
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        }

        if (!passwordEncoder.matches(loginDTORequest.getPassword(), existingUser.getPassword())) {
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

        User user = userMapper.dtoRequestToEntity(userDTORequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        CartDTORequest cartDTORequest = new CartDTORequest();
        cartDTORequest.setUserId(savedUser.getId());
        cartDTORequest.setTotalPrice(0);
        cartService.createCart(cartDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("user created");
    }

    public ResponseEntity<?> forgotPassword(String email) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }

        User user = optionalUser.get();

        // Create token
        String token = UUID.randomUUID().toString();
        LocalDateTime expiry = LocalDateTime.now().plusHours(1);

        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setUser(user);
        resetToken.setToken(token);
        resetToken.setExpiration(expiry);
        passwordResetTokenRepository.save(resetToken);

        String resetLink = "http://localhost:3000/auth/reset-password?token=" + token;
        emailService.sendPasswordResetEmail(user, resetLink);

        return ResponseEntity.ok("Reset email sent.");
    }
    // service/AuthService.java
    public ResponseEntity<?> resetPassword(ResetPasswordDTORequest resetPasswordDTORequest) {
        PasswordResetToken tokenEntity = passwordResetTokenRepository.findByToken(resetPasswordDTORequest.getToken())
                .orElseThrow(() -> new RuntimeException("Invalid or expired token"));

        if (tokenEntity.getExpiration().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token has expired");
        }

        User user = tokenEntity.getUser();
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String encodedPassword = passwordEncoder.encode(resetPasswordDTORequest.getNewPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        passwordResetTokenRepository.delete(tokenEntity);
        return ResponseEntity.ok("Password reset successful");

    }

}
