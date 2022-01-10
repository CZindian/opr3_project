package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.TripDBRepository;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

        StringBuilder sbBase64Img = getBase64Img(picturePart);
        UserEntity loggedInUser = LoggedInUserManager.getUserData();

        try {
            saveNewTrip(
                    title, category, date, time,
                    distance, notes, places, sbBase64Img.toString(),
                    loggedInUser
            );
            updateLoggedInUser(loggedInUser);
            response.sendRedirect("page_main.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("page_new_note.jsp");
        }

    }

    private StringBuilder getBase64Img(Part picturePart) throws IOException {
        StringBuilder sbBase64 = new StringBuilder();

        InputStream pictureContent = picturePart.getInputStream();
        byte[] byteContent = pictureContent.readAllBytes();

        if (byteContent.length == 0)
            sbBase64.append("");
        else
            sbBase64.append("data:").
                    append(
                            picturePart.getContentType()
                    ).
                    append(";base64,").
                    append(
                            DatatypeConverter.printBase64Binary(byteContent)
                    );
        return sbBase64;
    }

    private void updateLoggedInUser(UserEntity loggedInUser) {
        List<TripEntity> usersTrips = DBService.getUsersTrips(loggedInUser.getUserId());
        LoggedInUserManager.setTripData(usersTrips);
    }

    private void saveNewTrip(
            String title, String category, String date, String time,
            String distance, String notes, String places, String picture,
            UserEntity loggedInUser
    ) {
        TripEntity tripEntity = new TripEntity(
                loggedInUser.getUserId(),
                title, category, date, time,
                distance, notes, places, picture
        );
        new TripDBRepository().create(tripEntity);
    }

}
