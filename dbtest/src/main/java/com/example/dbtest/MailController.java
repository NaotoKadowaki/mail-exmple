package com.example.dbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private final JavaMailSender javaMailSender;
    @Autowired
    MailController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @RequestMapping(value = "/mail/send", method = {RequestMethod.POST} )
    public String send() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("vivienne7070westwood@gmail.com");
        mailMessage.setReplyTo("vivienne7070westwood@gmail.com");
        mailMessage.setFrom("vivienne7070westwood@gmail.com");
        mailMessage.setSubject("テストメール");
        mailMessage.setText("テストメールです\nほげほげ");
        javaMailSender.send(mailMessage);
        return "メール送信しました";
    }
}