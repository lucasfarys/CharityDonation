package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.IstitutionService;

import java.util.List;


@Controller
public class HomeController {
    private IstitutionService institutionService;
    private DonationService donationService;

    public HomeController(IstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions = institutionService.getAllInstitutions();
        model.addAttribute("institutions",institutions);
        model.addAttribute("quantityOfBags", donationService.getQuantityOfBags());
        model.addAttribute("quantityOfInstitutions", donationService.getQuantityOfInstitutions());
        return "index";
    }
}
