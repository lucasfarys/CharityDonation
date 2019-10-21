package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    Long quantity;
    @NotBlank
    String street;
    @NotBlank
    String city;
    String zip_code;
    LocalDate pick_up_date;
    LocalDateTime pick_up_time;
    String pick_up_comment;


    @OneToMany(mappedBy = "donation")
    List<Category> categories;
    @ManyToOne
    Institution institution;
}
