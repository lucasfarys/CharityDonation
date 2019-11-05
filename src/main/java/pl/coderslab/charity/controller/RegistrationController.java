package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegisterPage(Model model){
        model.addAttribute("user",new UserDTO());
        return "register";
    }
    @PostMapping
    public String registerUser(@ModelAttribute("user") @Valid UserDTO user, BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        if (!user.getPassword().equals(user.getRePassword())) {
            result.rejectValue("rePassword", null, "Hasło i powtórzone hasło muszą być zgodne");
            return "register";
        }
        if (!userService.isEmailAvailable(user.getEmail())) {
            result.rejectValue("email", null, "Email już zajęty");
            return "register";
        }
        userService.registerUser(user);
        return "redirect:/login";
    }
}
