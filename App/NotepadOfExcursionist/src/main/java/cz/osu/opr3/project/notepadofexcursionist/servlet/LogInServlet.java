package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static cz.osu.opr3.project.notepadofexcursionist.utils.Constants.EMAIL;
import static cz.osu.opr3.project.notepadofexcursionist.utils.Constants.PASSWORD;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter(EMAIL).toLowerCase().trim();
        String userPassword = request.getParameter(PASSWORD).trim();

        try {
            logInUser(request, userEmail, userPassword);
            response.sendRedirect("page_main.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            LoggedInUserManager.setIsErrorRaised(true);

            response.sendRedirect("index.jsp");
        }
    }

    private void logInUser(HttpServletRequest request, String userEmail, String userPassword) {
        setSessionFor(userEmail, request);

        UserEntity loggedInUser = DBService.getUserEntity(userEmail, userPassword);
        List<TripEntity> usersTrips = DBService.getUsersTrips(loggedInUser.getUserId());

        LoggedInUserManager.initialize(loggedInUser, usersTrips);
    }

    private void setSessionFor(String userEmail, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user_email", userEmail);
    }

}
