package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {
    private InstitutionService institutionService;
    private DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<InstitutionDTO> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutions",institutions);
        model.addAttribute("quantityOfBags", donationService.getQuantityOfBags());
        model.addAttribute("quantityOfInstitutions", donationService.getQuantityOfInstitutions());
        return "index";
    }
}
