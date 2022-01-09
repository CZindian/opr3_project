package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.TripDBRepository;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewNoteServlet", value = "/NewNoteServlet")
public class NewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("page_main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("heading");
        String category = request.getParameter("type");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String distance = request.getParameter("distance");
        String notes = request.getParameter("notes");
        String places = request.getParameter("places");
        String picture = request.getParameter("picture");

        UserEntity loggedInUser = LoggedInUserManager.getUserData();

        try {
            saveNewTrip(title, category, date, time, distance, notes, places, picture, loggedInUser);
            updateLoggedInUser(loggedInUser);
            response.sendRedirect("page_main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("page_new_note.jsp");
        }

    }

    private void updateLoggedInUser(UserEntity loggedInUser) {
        List<TripEntity> usersTrips = DBService.getUsersTrips(loggedInUser.getUserId());
        LoggedInUserManager.setTripData(usersTrips);
    }

    private void saveNewTrip(String title, String category, String date, String time, String distance, String notes, String places, String picture, UserEntity loggedInUser) {
        TripEntity tripEntity = new TripEntity(
                loggedInUser.getUserId(),
                title, category, date, time,
                distance, notes, places, picture
        );
        new TripDBRepository().create(tripEntity);
    }

}
