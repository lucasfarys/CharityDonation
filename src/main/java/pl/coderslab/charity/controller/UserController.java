package pl.coderslab.charity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.EditUserDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/editUser")
    public String prepareEditUser(Model model){
        model.addAttribute("editUserDTO",new EditUserDTO());
        model.addAttribute("user",userService.findByUserName(SecurityContextHolder.getContext().
                getAuthentication().getName()));
        return "editUser";
    }
    @PostMapping("/editUser")
    public String editUser(@ModelAttribute @Valid EditUserDTO editUserDTO, BindingResult result){
        System.out.println(editUserDTO.getOldPassword());
        if(result.hasErrors()){
            return "editUser";
        }
        if(!userService.isPasswordCorrect(editUserDTO)){
            result.rejectValue("oldPassword","Błędne hasło");
            return "editUser";
        }
        userService.registerEditUser(editUserDTO);
        return "redirect:/";
    }
}
