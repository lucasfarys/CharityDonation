package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.model.Donation;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    @NotBlank
    private String name;
    private boolean torf=false;

    private List<Donation> donation;

}
