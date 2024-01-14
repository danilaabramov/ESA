package com.example.demo.controllers;

import com.example.demo.models.Comment;
import com.example.demo.models.Serial;
import com.example.demo.models.Rating;
import com.example.demo.models.User;
import com.example.demo.repos.CommentRepository;
import com.example.demo.repos.SerialRepository;
import com.example.demo.repos.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Controller
@RequestMapping("/poster")
public class PosterController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private SerialRepository serialRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("{title}")
    public String getPageSerial(Model model, @PathVariable String title) {
        Serial serial = serialRepository.findByTitle(title);
        if (serial.getView() != null) {
            Integer countView = serial.getView() + 1;
            serial.setView(countView);
        } else {
            serial.setView(1);
        }

        serialRepository.save(serial);
        model.addAttribute("serial", serial);
        return "pageSerial";
    }

    @PostMapping("{title}")
    public String addComment(@AuthenticationPrincipal User user, @RequestParam int value, @RequestParam String comment, Model model, @PathVariable String title) {
        Serial serial = serialRepository.findByTitle(title);
        Rating rating = new Rating(user, value);

        Set<Rating> ratingsSet = new HashSet<>(serial.getRating());
        ratingsSet.add(rating);
        serial.setRating(ratingsSet);
        ratingRepository.save(rating);

        Comment com = new Comment(user, comment, rating, serial);
        Set<Comment> commentSet = new HashSet<>(serial.getComments());
        commentSet.add(com);
        serial.setComments(commentSet);
        commentRepository.save(com);

        model.addAttribute("serial", serialRepository.findByTitleOrderByCommentsDesc(title));
        return "pageSerial";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{title}/{user}")
    public String getEditSerial(@PathVariable String title, Model model, @PathVariable String user) {
        Serial oneSerial = serialRepository.findByTitle(title);

        model.addAttribute("serial", oneSerial);
        return "pageSerialEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("{title}/update")
    public String updateSerial(Model model, @RequestParam("id") Serial serial, @RequestParam("file") MultipartFile file, @RequestParam Map<String, String> form) throws URISyntaxException, IOException {
        if (form.get("title") == null) {
            throw new IllegalArgumentException("Пришла пустая строка в название фильма");
        }
        serial.setGenres(ControllerUtils.getSetGenres(form));
        if (file != null) {
            ControllerUtils.savePicture(serial, file, uploadPath);
        }

        if (!form.get("description").isEmpty()) {
            serial.setTitle(form.get("description"));
        }
        serial.setTitle(form.get("title"));

        serialRepository.save(serial);

        URI uri = new URI("/poster/" + serial.getTitle().replace(" ", "%20"));

        model.addAttribute("serial", serial);
        return "redirect:" + uri.toASCIIString();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("{title}/delete")
    public String deleteSerial(Model model, @PathVariable String title){
        serialRepository.delete(serialRepository.findByTitle(title));

        model.addAttribute("serials", serialRepository.findAll());
        return "redirect:main";
    }
}
