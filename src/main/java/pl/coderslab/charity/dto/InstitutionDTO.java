package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.model.Donation;

import java.util.List;

@Getter
@Setter
public class InstitutionDTO {

    private Long id;
    private String name;
    private String description;
    private boolean trusted;


    private List<Donation> donations;
}
