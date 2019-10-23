package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoryDTO {
    Long id;
    @NotBlank
    String name;
}
