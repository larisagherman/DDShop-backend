package dd.projects.ddshop.controller;

import dd.projects.ddshop.dto.ContactMessageDTO;
import dd.projects.ddshop.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000",
        allowCredentials = "true"
)
@RequiredArgsConstructor
public class ContactMessageController {
    private final EmailService emailService;
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody ContactMessageDTO contactMessageDTO) {
        emailService.sendUsAMessage(contactMessageDTO);
        return ResponseEntity.ok("Message sent");
    }
}
