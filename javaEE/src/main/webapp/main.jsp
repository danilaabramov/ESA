<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.hospital.models.RoomsEntity" %>
<%@ page import="ru.hospital.models.PatientsEntity" %>
<%@ page import="ru.hospital.models.HospitalsEntity" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>ASC</title>
</head>
<body>
<% List<HospitalsEntity> uns = (List<HospitalsEntity>) request.getAttribute("table_university");%>
<table>
    <thead>
    <tr>
        <th>University</th>
        <th>id_hospital</th>
    </tr>
    </thead>
    <tbody>
    <% for (HospitalsEntity un : uns) { %>
    <tr>
        <td><%= un.getId_hospital() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<RoomsEntity> rooms = (List<RoomsEntity>) request.getAttribute("table_rooms");%>
<table>
    <thead>
    <tr>
        <th>id_hospital</th>
        <th>id_room</th>
    </tr>
    </thead>
    <tbody>
    <% for (RoomsEntity room : rooms) { %>
    <tr>
        <td><%= room.getId_hospital() %>
        <td><%= room.getId_hospital() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<PatientsEntity> patients = (List<PatientsEntity>) request.getAttribute("table_patients");%>
<table>
    <thead>
    <tr>
        <th>id_card</th>
        <th>id_room</th>
        <th>name</th>
        <th>gender</th>
        <th>score</th>
        <th>years</th>
    </tr>
    </thead>
    <tbody>
    <% for (PatientsEntity patient: patients) { %>
    <tr>
        <td><%= patient.getId() %>
        <td><%= patient.getId_room() %>
        <td><%= patient.getName() %>
        <td><%= patient.getGender() %>
        <td><%= patient.getScore() %>
        <td><%= patient.getYears() %>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>

