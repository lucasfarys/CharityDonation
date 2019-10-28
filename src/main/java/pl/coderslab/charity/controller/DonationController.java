package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.dto.DonationDTO;
import pl.coderslab.charity.dto.SnippetDTO;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DonationController {
    private CategoryService categoryService;
    private InstitutionService institutionService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
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
        System.out.println(donationDTO.getCategories());
        return "redirect:/snippet";
    }
}
