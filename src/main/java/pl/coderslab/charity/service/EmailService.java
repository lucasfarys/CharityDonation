package pl.coderslab.charity.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
        private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMessage(
            String name, String surname, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("lukaszfarys@gmail.com");
        message.setSubject("Zapytanie " + name + " " + surname);
        message.setText(text);
        javaMailSender.send(message);
    }
    public void sendActivationEmail(String digest, String emailAddress){
        SimpleMailMessage message = new SimpleMailMessage();
        String subject = "Potwierdź email";
        StringBuilder text = new StringBuilder();
        text.append("Aby potwierdzić email kliknij link: http://localhost:8080/user/activation/");
        text.append(digest);
        message.setTo(emailAddress);
        message.setSubject(subject);
        message.setText(text.toString());
        javaMailSender.send(message);
    }
}
