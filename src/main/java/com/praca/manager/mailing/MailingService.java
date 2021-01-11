package com.praca.manager.mailing;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService {

    private JavaMailSender javaMailSender;

    public MailingService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message){
         var mailMessage = new SimpleMailMessage();

         mailMessage.setTo(toEmail);
         mailMessage.setSubject(subject);
         mailMessage.setText(message);
         mailMessage.setFrom("mapet.dev.test@gmail.com");

         javaMailSender.send(mailMessage);
    }
}
