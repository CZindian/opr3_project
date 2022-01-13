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

@WebServlet(name = "ProcessUpdateServlet", value = "/ProcessUpdateServlet")
@MultipartConfig
public class ProcessUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("page_update_note.jsp");
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
        String base64String = getBase64ImageString(picturePart);

        int tripToUpdateId = LoggedInUserManager.getTripEntityToUpdate().getTripId();
        UserEntity loggedInUser = LoggedInUserManager.getUserData();

        try {
            updateTripEntity(
                    title, category, date, time, distance, notes, places,
                    base64String, tripToUpdateId, loggedInUser
            );
            updateLoggedInUser(loggedInUser);
            LoggedInUserManager.clearTripEntityToUpdate();

            response.sendRedirect("page_main.jsp");
        } catch (Exception e) {
            response.sendRedirect("page_update_note.jsp");
            e.printStackTrace();
        }

    }

    private void updateTripEntity(
            String title, String category, String date, String time,
            String distance, String notes, String places, String base64String,
            int tripToUpdateId, UserEntity loggedInUser) {

        DBService.deleteTrip(tripToUpdateId);
        DBService.saveNewTrip(
                title, reformatTripCategory(category), date, time,
                distance, notes, places, base64String,
                loggedInUser
        );

    }

    private String getBase64ImageString(Part picturePart) throws IOException {
        String base64;

        String base64ImgString = Base64Provider.getBase64Img(picturePart);
        if (isTripToUpdatePictureEmpty())
            base64 = "";
        else if (!base64ImgString.isEmpty())
            base64 = base64ImgString;
        else
            base64 = LoggedInUserManager.getTripEntityToUpdate().getTripPicture();

        return base64;
    }

    private boolean isTripToUpdatePictureEmpty() {
        return LoggedInUserManager.getTripEntityToUpdate().
                getTripPicture().isEmpty();
    }

    private void updateLoggedInUser(UserEntity loggedInUser) {
        List<TripEntity> usersTrips = DBService.getUsersTrips(loggedInUser.getUserId());
        LoggedInUserManager.setTripData(usersTrips);
    }

}
