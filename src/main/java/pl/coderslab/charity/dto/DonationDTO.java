package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.validation.ZipCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
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
    @ZipCode
    private String zipCode;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotBlank
    private LocalTime pickUpTime;
    @NotBlank
    private String pickUpComment;
    @NotBlank
    private String phoneNumber;

    private List<CategoryDTO> categories;
    private Institution institution;

}
