package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/sendEmail")
    public String prepareSendEmailPage(Model model){
        model.addAttribute("users",userService.findAllUsers());
        return "sendEmail";
    }
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String selectedUser, @RequestParam String message,
                            @RequestParam String subject){
        if(message!="" || subject!=""){
            emailService.sendSimpleMessage(selectedUser,subject,message);
        }
        return "redirect:/";
    }
}
