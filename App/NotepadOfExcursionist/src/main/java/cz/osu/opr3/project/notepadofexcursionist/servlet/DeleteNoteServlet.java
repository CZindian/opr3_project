package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteNoteServlet", value = "/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("page_main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int tripId = Integer.parseInt(request.getParameter("tripIdDelete"));

            DBService.deleteTrip(tripId);
            updateUsersClientData();
            response.sendRedirect("page_main.jsp");

        } catch (Exception e) {
            response.sendRedirect("page_main.jsp");
            e.printStackTrace();
        }

    }

    private void updateUsersClientData() {
        UserEntity userEntity = LoggedInUserManager.getUserData();
        List<TripEntity> trips = DBService.getUsersTrips(userEntity.getUserId());
        LoggedInUserManager.setTripData(trips);

    }

}
