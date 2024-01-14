package com.hospital.services;

import com.hospital.models.Event;
import com.hospital.repos.HospitalRepository;
import com.hospital.repos.EventRepository;
import com.hospital.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    PatientRepository roomRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    PatientRepository patientRepository;
    private Integer getIdFromEntity(Event event){
        return Integer.valueOf(event.getEntity().substring(event.getEntity().indexOf("=") + 1,
                event.getEntity().indexOf(",")));
    }

    private Event getExistingEvent(Event event){
        var events = eventRepository.findAll();
        var id = getIdFromEntity(event);

        var object = switch (event.getModel()) {
            case Room -> roomRepository.findById(id);
            case Hospitals -> hospitalRepository.findById(id);
            case Patient -> patientRepository.findById(id);
        };

        for (var event_ : events) {
            if (getIdFromEntity(event_).equals(id)) {
                event_.setEntity(object.toString());
                event_.setEventType(event.getEventType());
                return event_;
            }
        }
        return null;
    }
    public void save(Event event) {
        System.out.println(event);
        var event_ = getExistingEvent(event);
        System.out.println(event_);
        if (event_ == null){
            eventRepository.save(event);
            return;
        }

        eventRepository.save(event_);
    }
}