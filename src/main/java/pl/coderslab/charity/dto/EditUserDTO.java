package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EditUserDTO {
    private Long id;
    @NotBlank(message = "Pole Name nie może być puste")
    private String name;
    @NotBlank(message = "Pole surname nie może być puste")
    String surname;
    @Email
    private String email;
    @ValidPassword(message = "Hasło jest niepoprawne")
    private  String oldPassword;
    @ValidPassword(message = "Hasło jest niepoprawne")
    private String newPassword;
    @ValidPassword(message = "Powtórzone hasło różni się.")
    private  String reNewPassword;
}
