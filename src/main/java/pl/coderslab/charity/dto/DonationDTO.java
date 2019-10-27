package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.model.Category;
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
    private String zip_code;
    @NotBlank
    private LocalDate pick_up_date;
    @NotBlank
    private LocalTime pick_up_time;
    @NotBlank
    private String pick_up_comment;


    private List<Category> categories;
    private Institution institution;

}
