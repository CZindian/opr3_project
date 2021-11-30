package cz.osu.opr3.project.notepadofexcursionist.servlet;

import java.util.List;

import cz.osu.opr3.project.notepadofexcursionist.db.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.db.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;
import cz.osu.opr3.project.notepadofexcursionist.service.NotepadManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static cz.osu.opr3.project.notepadofexcursionist.Constants.EMAIL;
import static cz.osu.opr3.project.notepadofexcursionist.Constants.PASSWORD;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            UserEntity userEntity = DBService.getCurrentUserEntity(request.getParameter(EMAIL), request.getParameter(PASSWORD));
            List<TripEntity> trips = null;
            Map<UserEntity, List<TripEntity>> currentUserData = new HashMap<>();
            //TODO trips!!!
            currentUserData.put(userEntity, trips);
            NotepadManager.setCurrentUserData(currentUserData);
            NotepadManager.setIsClientLoggedIn(true);

            response.sendRedirect("page_main.jsp");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }

    }
}
