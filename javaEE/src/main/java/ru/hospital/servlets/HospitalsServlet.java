package ru.hospital.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.hospital.models.dto.HospitalsRequest;
import ru.hospital.services.HospitalsService;
import ru.hospital.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hospital")
public class HospitalsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private HospitalsService hospitalsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(hospitalsService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HospitalsRequest roomsRequest = new HospitalsRequest();
        roomsRequest.setUniversity(req.getParameter("university"));
        roomsRequest.setId_hospital(Integer.parseInt(req.getParameter("id_hospital")));
        hospitalsService.create(roomsRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String university = req.getParameter("university");
        int id_hospital = Integer.parseInt(req.getParameter("id_hospital"));
        hospitalsService.delete(university, id_hospital);
    }
}