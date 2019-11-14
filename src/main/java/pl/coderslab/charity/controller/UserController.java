package pl.coderslab.charity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.EditUserDTO;
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
        if(result.hasErrors()){
            return "editUser";
        }
        userService.editUser(editUserDTO);
        return "redirect:/";
    }
    @GetMapping("/activation/{activation}")
    @ResponseBody
    public String activationAccount(@PathVariable String activation){
        String message;
        if(userService.activationAccount(activation)){
            message = "Aktywacja zakończona pomyślnie";
        }else{
            message = "aktywacja nieudana";
        }
        return message;
    }
    @GetMapping("/resetPassword")
    public String prepareRestorPassword(Model model){

        return "resetPassword";
    }
}
