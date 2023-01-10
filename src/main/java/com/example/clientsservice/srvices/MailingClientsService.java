package com.example.clientsservice.srvices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingClientsService {
    public static final String subject="Client balance";
    public static final String text="Client your amount is less than or equal to 0 !";//(ДЗ УСЛОВИЕ Реализуйте в этой ветке рассылку сообщений клиентам, у которых количество средств на счету меньше или равно <= 0)
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(final String toClients, String surname) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toClients);
        message.setSubject(subject);
        message.setText(surname + ", " + text);
        javaMailSender.send(message);
    }
}
