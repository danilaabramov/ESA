package com.example.demo.controllers;

import com.example.demo.models.Serial;
import com.example.demo.models.Genres;
import com.example.demo.repos.SerialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.io.Resource;

import javax.annotation.security.PermitAll;
import java.io.IOException;
import java.nio.file.Files;


@Controller
public class MainController {
    @Autowired
    private SerialRepository serialRepository;

    @GetMapping("/")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       @RequestParam(required = false, defaultValue = "") Genres genre,
                        Model model) {
        Iterable<Serial> serials = serialRepository.findAll();
        if (genre != null) {
            serials = serialRepository.findByGenres(genre);

         }

        if (filter != null && !filter.isEmpty()) {
            serials = serialRepository.findSerialsByTitle(filter);

        } else if (filter == null) {
            serials = serialRepository.findAll();
        }
        model.addAttribute("serials", serials);
        model.addAttribute("filter", filter);


        return "main";
    }
}
