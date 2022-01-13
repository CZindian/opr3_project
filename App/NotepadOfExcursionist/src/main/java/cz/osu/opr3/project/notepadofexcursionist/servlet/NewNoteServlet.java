package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.Base64Provider;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static cz.osu.opr3.project.notepadofexcursionist.utils.Validator.reformatTripCategory;

@WebServlet(name = "NewNoteServlet", value = "/NewNoteServlet")
@MultipartConfig
public class NewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("page_main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //region Form inputs
        String title = request.getParameter("heading");
        String category = request.getParameter("type");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String distance = request.getParameter("distance");
        String notes = request.getParameter("notes");
        String places = request.getParameter("places");
        Part picturePart = request.getPart("picture");
        //endregion

        String base64String = Base64Provider.getBase64Img(picturePart);
        UserEntity loggedInUser = LoggedInUserManager.getUserData();

        try {
            DBService.saveNewTrip(
                    title, reformatTripCategory(category), date, time,
                    distance, notes, places, base64String,
                    loggedInUser
            );
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

}
