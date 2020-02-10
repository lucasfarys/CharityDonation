package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.validation.ValidZipCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class DonationDTO {

    private Long id;
    @NotBlank
    private Long quantity;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @ValidZipCode
    private String zipCode;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotBlank
    private String pickUpTime;
    @NotBlank
    private String pickUpComment;
    @NotBlank
    private String phoneNumber;

    private List<Long> categories;
    private String institution;
    private UserDTO user;

}
