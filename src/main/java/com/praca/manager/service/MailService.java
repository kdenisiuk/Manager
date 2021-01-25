package com.praca.manager.service;

import com.praca.manager.entity.Mail;
import com.praca.manager.repository.MailRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;
    private final MailRepository mailRepository;

    public MailService(JavaMailSender javaMailSender,
                       MailRepository mailRepository){
        this.javaMailSender = javaMailSender;
        this.mailRepository = mailRepository;
    }

    public void sendMail(String address, String subject, String text)
        throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(address);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text);
        javaMailSender.send(mimeMessage);
    }

    public void saveMail(Mail mail){
        mailRepository.save(mail);
    }
}
