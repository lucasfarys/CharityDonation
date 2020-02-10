package pl.coderslab.charity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.EditUserDTO;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private InstitutionService institutionService;
    private RoleService roleService;
    private UserService userService;

    public AdminController(InstitutionService institutionService, RoleService roleService,
                           UserService userService) {
        this.institutionService = institutionService;
        this.roleService = roleService;
        this.userService = userService;
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
        List<User> admins = userService.findUsersByRole("ROLE_ADMIN");
        model.addAttribute("admins",admins);
        return "admins";
    }
    @GetMapping("/editAdmin")
    public String prepareManageAdmin(@RequestParam String username, Model model){
        model.addAttribute("admin", userService.findByUserName(username));
        return "editAdmin";
    }
    @PostMapping("/editAdmin")
    public String manageAdmin(@ModelAttribute UserDTO admin, BindingResult result){
        if(result.hasErrors()){
            return "editAdmin";
        }
        userService.editAdmin(admin);
        return "redirect:/admin/admins";
    }
    @GetMapping("/newAdmin")
    public String prepareNewAdmin(Model model){
        List<Long> adminList = new ArrayList<>();
        model.addAttribute("users",userService.findUsersByRole("ROLE_USER"));
        model.addAttribute("adminList",adminList);
        return "newAdmin";
    }
    @PostMapping("/newAdmin")
    public String newAdmin(@RequestParam List<Long> adminList){
        // do dokonczenia
        return "redirect:/admin/admins";
    }
    @GetMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email){
        if(email.equals(SecurityContextHolder.getContext().
                getAuthentication().getName())){
            return "redirect:/admin/admins";
        }else{
            userService.deleteUser(email);
            return "redirect:/admin/admins";
        }
    }
    @GetMapping("/users")
    public String prepareUsersPage(Model model){
        model.addAttribute("users",userService.findUsersByRole("ROLE_USER"));
        return "users";
    }
    @GetMapping("/editUsers")
    public String prepareEditUser(@RequestParam String username, Model model){
        model.addAttribute("editUserDTO",new EditUserDTO());
        model.addAttribute("user", userService.findByUserName(username));
        return "editUser";
    }
    @PostMapping("/editUsers")
    public String editUser(@ModelAttribute @Valid EditUserDTO editUserDTO, BindingResult result){
        if(result.hasErrors()){
            return "editUser";
        }
        userService.editUser(editUserDTO);
        return "redirect:/admin/users";
    }
}
