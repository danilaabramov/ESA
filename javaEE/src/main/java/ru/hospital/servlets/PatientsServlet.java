package ru.hospital.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.hospital.models.dto.PatientsRequest;
import ru.hospital.services.PatientsService;
import ru.hospital.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "patientsServlet", value = "/patients")
public class PatientsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();
    @Inject
    private PatientsService patientsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(patientsService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PatientsRequest patientRequest = new PatientsRequest();
        patientRequest.setId_room(Integer.parseInt(req.getParameter("id_room")));
        patientRequest.setId(Integer.parseInt(req.getParameter("id")));
        patientRequest.setName((req.getParameter("name")));
        patientRequest.setG((req.getParameter("gender")));
        patientRequest.setScore(Float.parseFloat(req.getParameter("score")));
        patientRequest.setYears(Integer.parseInt(req.getParameter("years")));
        patientsService.create(patientRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int patientId = Integer.parseInt(req.getParameter("id"));
        patientsService.delete(patientId);
    }
}