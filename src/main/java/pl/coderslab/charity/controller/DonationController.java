package pl.coderslab.charity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;


@Controller
public class DonationController {
    private CategoryService categoryService;
    private InstitutionService institutionService;
    private DonationService donationService;
    private UserService userService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService,
                              DonationService donationService, UserService userService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping("/snippet")
    public String prepareSnippet(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("institutions",institutionService.getAllInstitutions());
        model.addAttribute("donation",new DonationDTO());
        return "snippet";
    }
    @PostMapping("/snippet")
    public String snippet(@ModelAttribute(name = "donation") DonationDTO donationDTO, BindingResult result){
        donationDTO.setUser(userService.findByUserName(SecurityContextHolder.getContext().
                getAuthentication().getName()));
        donationService.saveDonation(donationDTO);
        return "redirect:/snippet";
    }
}
