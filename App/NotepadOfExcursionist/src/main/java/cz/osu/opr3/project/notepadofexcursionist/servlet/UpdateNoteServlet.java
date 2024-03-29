package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateNoteServlet", value = "/UpdateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("page_main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int tripId = Integer.parseInt(request.getParameter("tripIdUpdate"));
            findTripEntityToUpdate(tripId);
            response.sendRedirect("page_update_note.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("page_main.jsp");
        }

    }

    private void findTripEntityToUpdate(int tripId) {
        TripEntity tripEntityToUpdate = DBService.getTripById(tripId);
        LoggedInUserManager.setTripEntityToUpdate(tripEntityToUpdate);

    }

}
