package pl.coderslab.charity.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private InstitutionService institutionService;
    private RoleService roleService;

    public AdminController(InstitutionService institutionService, RoleService roleService) {
        this.institutionService = institutionService;
        this.roleService = roleService;
    }

    @GetMapping
    public String prepareAdminPage(){
        return "admin";
    }
    @GetMapping("/institution")
    public String prepareInstitutionsPage(Model model){
        model.addAttribute("institutions",institutionService.getAllInstitutions());
        return "institutions";
    }
    @GetMapping("/deleteInstitution/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionService.deleteInstitution(id);
        return "redirect:/admin/institution";
    }
    @GetMapping("/createInstitution")
    public String prepareCreateInstitution(Model model){
        model.addAttribute("institution", new InstitutionDTO());
        return "manageInstitution";
    }
    @PostMapping("/createInstitution")
    public String createInstitution(@ModelAttribute InstitutionDTO institutionDTO){
        institutionService.saveInstitution(institutionDTO);
        return "redirect:/admin/institution";
    }
    @GetMapping("/editInstitution/{id}")
    public String prepareEditInstitution(@PathVariable Long id, Model model){
        if(id!=null){
            model.addAttribute("institution",institutionService.getInstitutionById(id));
        }else{
            model.addAttribute("institution",new InstitutionDTO());
        }
        return  "manageInstitution";
    }
    @PostMapping("/editInstitution/{id}")
    public String editInstitution (@ModelAttribute InstitutionDTO institutionDTO){
        if(institutionDTO.getId()!=0){
            institutionService.updateInstitution(institutionDTO);
        }
        return "redirect:/admin/institution";
    }
    @GetMapping("/admins")
    public String manageAdmins(Model model){
        Role role = roleService.findRole("ROLE_ADMIN");
        model.addAttribute("admins",role.getUsers());
        return "manageAdmin";
    }
}
