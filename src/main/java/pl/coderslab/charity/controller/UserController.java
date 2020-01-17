package pl.coderslab.charity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.EditUserDTO;
import pl.coderslab.charity.repository.UuidRepository;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.validation.ValidPassword;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private EmailService emailService;
    private UuidRepository uuidRepository;

    public UserController(UserService userService, EmailService emailService,
                          UuidRepository uuidRepository) {
        this.userService = userService;
        this.emailService = emailService;
        this.uuidRepository = uuidRepository;
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
    public String prepareRestorePassword(Model model){
        model.addAttribute("email",new String());
        return "resetPassword";
    }
    @PostMapping("/resetPassword")
    public String restorePassword(@RequestParam String email, Model model){
        if(userService.isEmailAvailable(email)){
            String message = "Podany użytkownik nie istnieje";
            model.addAttribute("message",message);
           return "resetPassword";
        }else{
            userService.sendRestorePasswordEmailAndSaveUuid(email);
            model.addAttribute("message", "Sprawdź skrzynkę mailową.");
            return "resetPassword";
        }
    }
    @GetMapping("/newPassword/{uuid}")
    public String prepareCreateNewPassword(@PathVariable String uuid, Model model){
        if(uuidRepository.countAllByUuid(uuid) > 0){
            model.addAttribute("uuid",uuid);
            return "newPassword";
        }else{
            model.addAttribute("message","Nieprawidłowy link, wygeneruj ponownie");
            return "resetPassword";
        }
    }
    @PostMapping("/newPassword")
    public String createNewPassword(@RequestParam @ValidPassword String password, @RequestParam @ValidPassword String rePassword,
                                    @RequestParam String uuid, Model model){
        if(!password.equals(rePassword)){
            model.addAttribute("message", "Hasła muszą być takie same");
            return "newPassword";
        }
        userService.changePassword(password, uuid);
        return "redirect:/login";
    }
    @GetMapping("/myDonation")
    public String prepareMyDonation(){

        return "myDonation";
    }
}
