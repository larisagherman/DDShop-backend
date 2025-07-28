package dd.projects.ddshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForgotPasswordDTORequest {
    private String email;
}
