package com.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hospital.models.Hospitals;
import com.hospital.models.Room;
import com.hospital.models.Patient;
import com.hospital.repos.HospitalRepository;
import com.hospital.repos.RoomRepository;
import com.hospital.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@Controller
@RequestMapping(
        value = "xsl",
        produces = {"application/xml"}
)
public class XslController {
    @Autowired
    private PatientRepository patientService;

    @Autowired
    private RoomRepository roomService;

    @Autowired
    private HospitalRepository hospitalService;

    @ResponseBody
    @GetMapping(path = "/patient")
    private ModelAndView getPatient() throws JsonProcessingException {
        Iterable<Patient> list = patientService.findAll();
        return getModelAndView(list, "patientXSL");
    }

    @ResponseBody
    @GetMapping(path = "/room")
    public ModelAndView getRoom() throws JsonProcessingException {
        Iterable<Room> list = roomService.findAll();
        return getModelAndView(list, "roomXSL");
    }

    @ResponseBody
    @GetMapping(path = "/hospital")
    public ModelAndView get() throws JsonProcessingException {
        Iterable<Hospitals> list = hospitalService.findAll();
        return getModelAndView(list, "dormXSL");
    }

    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        System.out.println(mod);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("List", src);
        System.out.println(mod.getView());
        return mod;
    }

}