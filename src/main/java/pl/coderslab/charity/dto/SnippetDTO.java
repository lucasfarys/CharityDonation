package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SnippetDTO {
    List<CategoryDTO> categories;
    CategoryDTO[] categories2;
    List<InstitutionDTO> institutions;
    DonationDTO donationDTO;
    Long bags;
}
