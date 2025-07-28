package dd.projects.ddshop.dto;

import lombok.Data;

@Data
public class ResetPasswordDTORequest {
    private String token;
    private String newPassword;
}
