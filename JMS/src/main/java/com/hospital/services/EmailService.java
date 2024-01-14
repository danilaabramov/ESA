package com.hospital.services;

import com.hospital.models.Event;
import com.hospital.repos.EmailRepository;
import com.hospital.services.senders.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    EmailSenderService emailSenderService;

    public void send(Event event) {
        var emails = emailRepository.findAll();
        for (var email : emails) {
            var events = email.getEvents();
            var models = email.getModels();
            if (events.contains(event.getEventType()) || models.contains(event.getModel())) {
                String result = ("Отправка письма клиенту: " + email.getReceiver()
                        + ", было изменен класс: " + event.getModel() + ", действие: "
                        + event.getEventType() + "результативный объект: " + event.getEntity()
                );
                System.out.println(result);
                emailSenderService.sendMessage(email.getReceiver(), result);
            }
        }
    }
}
