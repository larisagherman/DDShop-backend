package dd.projects.ddshop.dto;

import lombok.Data;

@Data
public class ContactMessageDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String subject;
    private String message;
}
