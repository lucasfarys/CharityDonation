package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotBlank(message = "Pole Name nie może być puste")
    private String name;
    @NotBlank(message = "Pole surname nie może być puste")
    String surname;
    @Email
    @NotBlank(message = "Pole login nie może być puste")
    private String email;
    @ValidPassword(message = "Hasło nie spełnia wymagań")
    private String password;
    @ValidPassword
    private  String rePassword;
    private Set<Role> roles = new HashSet<>();

}
