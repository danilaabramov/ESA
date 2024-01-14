package ru.hospital.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.hospital.services.HospitalsService;
import ru.hospital.services.RoomsService;
import ru.hospital.services.PatientsService;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Inject
    private RoomsService roomsService;
    @Inject
    private PatientsService PatientsService;
    @Inject
    private HospitalsService hospitalsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");
        try {
            request.setAttribute("table_rooms", roomsService.getAll());
            request.setAttribute("table_patients", patientsService.getAll());
            request.setAttribute("table_university", hospitalsService.getAll());
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch (Exception ignored) {

        }
    }
}
