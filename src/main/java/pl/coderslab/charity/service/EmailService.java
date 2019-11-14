package pl.coderslab.charity.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
        private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    public void sendActivationEmail(String digest, String emailAddress){
        String subject = "Aktywacja konta";
        StringBuilder message = new StringBuilder();
        message.append("http://localhost:8080/user/activation/");
        message.append(digest);
        sendSimpleMessage(emailAddress,subject,message.toString());
    }
}
