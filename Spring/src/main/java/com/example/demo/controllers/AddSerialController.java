package com.example.demo.controllers;

import com.example.demo.models.Serial;
import com.example.demo.models.User;
import com.example.demo.repos.SerialRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;


@Controller
public class AddSerialController {
    @Value("${upload.path}")
    private String uploadPath;

    private final SerialRepository serialRepository;

    public AddSerialController(SerialRepository serialRepository) {
        this.serialRepository = serialRepository;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/addSerial")
    public String getAddSerial() {
        return "addSerial";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/addSerial")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Serial serial,
            BindingResult bindingResult,
            Model model,
            @RequestParam("file") MultipartFile file,
            @RequestParam Map<String, String> form
    ) throws IOException {
        serial.setAuthor(user);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("serial", serial);
            return "main";

        } else {
            serial.setGenres(ControllerUtils.getSetGenres(form));
            ControllerUtils.savePicture(serial, file, uploadPath);
            model.addAttribute("serial", null);
            serialRepository.save(serial);
        }
        Iterable<Serial> serials = serialRepository.findAll();
        model.addAttribute("serials", serials);
        return "main";
    }
}
