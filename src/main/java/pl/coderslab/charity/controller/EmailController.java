package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.EmailService;
import pl.coderslab.charity.service.UserService;

@Controller
public class EmailController {
    private UserService userService;
    private EmailService emailService;

    public EmailController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String name, @RequestParam String surname,
                            @RequestParam String message, Model model){
        System.out.println("dupa");
        System.out.println(name);
        System.out.println(surname);
        System.out.println(message);
        if(message!=""){
            emailService.sendSimpleMessage(name,surname,message);
            model.addAttribute("message", "Wiadomość wysłana");
        }else{
            model.addAttribute("message", "Nieudana próba wysłania wiadomości");
        }
        return "redirect:/#contact";
    }
}
