package com.hospital.controller;

import com.hospital.models.Email;
import com.hospital.repos.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class EmailController {
    @Autowired
    EmailRepository emailRepository;

    @GetMapping("/email")
    public @ResponseBody Iterable<Email> getEmails() {
        return emailRepository.findAll();
    }

    @PostMapping("/email")
    public @ResponseBody Email createEmail(@RequestBody Email email) {
        return emailRepository.save(email);
    }

    @DeleteMapping("/email/{id}")
    public @ResponseBody void deleteEmail(@PathVariable Integer id) {
        emailRepository.deleteById(id);
    }

    @GetMapping("/email/{id}")
    public @ResponseBody Optional<Email> getEmail(@PathVariable Integer id) {
        return emailRepository.findById(id);
    }

    @PutMapping("/email/{id}")
    public @ResponseBody Email updateEmail(@PathVariable Integer id, @RequestBody Email newEmail) {
        return emailRepository.findById(id)
                .map(email -> {
                    email.setEvents(newEmail.getEvents());
                    email.setReceiver(newEmail.getReceiver());
                    email.setModels(newEmail.getModels());
                    return emailRepository.save(email);
                })
                .orElseGet(() -> {
                    return emailRepository.save(newEmail);
                });
    }
}
