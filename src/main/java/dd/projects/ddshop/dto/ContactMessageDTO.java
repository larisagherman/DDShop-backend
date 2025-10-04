package dd.projects.ddshop.dto;

import lombok.Data;

@Data
public class ContactMessageDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String subject;
    private String message;
}
