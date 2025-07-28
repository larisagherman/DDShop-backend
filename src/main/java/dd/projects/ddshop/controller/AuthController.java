package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ForgotPasswordDTORequest;
import dd.projects.ddshop.dto.LoginDTORequest;
import dd.projects.ddshop.dto.ResetPasswordDTORequest;
import dd.projects.ddshop.dto.UserDTORequest;
import dd.projects.ddshop.service.AuthService;
import dd.projects.ddshop.service.CartService;
import dd.projects.ddshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000",
        allowCredentials = "true"
)

public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final CartService cartService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTORequest loginDTORequest) {
        return authService.login(loginDTORequest);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTORequest userDTORequest) {
        return authService.register(userDTORequest);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordDTORequest request) {
        return authService.forgotPassword(request.getEmail());
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordDTORequest resetPasswordDTORequest) {
        return authService.resetPassword(resetPasswordDTORequest);
    }
}
