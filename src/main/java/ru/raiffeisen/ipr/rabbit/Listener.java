package ru.raiffeisen.ipr.rabbit;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@EnableRabbit
@Component
public class Listener {
    Logger logger = Logger.getLogger(Listener.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @RabbitListener(queues = "clients")
    public void processQueue1(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Successful registration");
        msg.setText("Hello you were successful registered on this email");

        javaMailSender.send(msg);
        logger.info("The letter has been sent to this email: " + email);
    }
}
