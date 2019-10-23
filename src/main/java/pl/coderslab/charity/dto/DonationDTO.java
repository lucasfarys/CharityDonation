package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DonationDTO {
    Long id;
    Long quantity;
    String street;
    String city;
    String zip_code;
    LocalDate pick_up_date;
    LocalDateTime pick_up_time;
    String pick_up_comment;
    List<Category> categories;
    Institution institution;

}
