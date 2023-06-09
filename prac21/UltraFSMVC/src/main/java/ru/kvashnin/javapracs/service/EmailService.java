package ru.kvashnin.javapracs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.kvashnin.javapracs.models.Adress;
import ru.kvashnin.javapracs.models.Building;


@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendAddAdressEmail(Adress adress){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("kvashnin.iura@yandex.ru");
        message.setTo("kvashnin.y.v@edu.mirea.ru");
        message.setSubject("Message from Spring Boot Application");
        message.setText(adress.toString());

        emailSender.send(message);
        System.out.println("Email successfully sent!");
    }

    @Async
    public void sendAddBuildingEmail(Building building){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("kvashnin.iura@yandex.ru");
        message.setTo("kvashnin.y.v@edu.mirea.ru");
        message.setSubject("Message from Spring Boot Application");
        message.setText(building.toString());

        emailSender.send(message);
        System.out.println("Email successfully sent!");
    }
}