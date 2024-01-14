package com.hospital.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hospital.models.Hospitals;

import com.hospital.repos.PatientRepository;
import com.hospital.repos.RoomRepository;
import com.hospital.repos.HospitalRepository;

import com.hospital.models.Patient;
import com.hospital.models.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;


@Controller
@RequestMapping(value = "xsl")
public class XslController {

    @Autowired
    private PatientRepository patientService;

    @Autowired
    private RoomRepository roomService;

    @Autowired
    private HospitalRepository hospitalService;

    @ResponseBody
    @GetMapping(path = "/patient", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getPatient() throws JsonProcessingException {
        Iterable<Patient> list = patientService.findAll();
        return getModelAndView(list, "patientXSL");
    }

    @ResponseBody
    @GetMapping(path = "/room", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView getRoom() throws JsonProcessingException {
        Iterable<Room> list = roomService.findAll();
        return getModelAndView(list, "roomXSL");
    }

    @ResponseBody
    @GetMapping(path = "/hospital", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView get() throws JsonProcessingException {
        Iterable<Hospitals> list = hospitalService.findAll();
        return getModelAndView(list, "hospitalXSL");
    }

    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("List", src);
        return mod;
    }

}