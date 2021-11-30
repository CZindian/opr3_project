package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.CurrentUserManager;
import cz.osu.opr3.project.notepadofexcursionist.service.DBService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
            CurrentUserManager.initialize(userEntity);

            response.sendRedirect("page_main.jsp");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            response.sendRedirect("index.jsp");
        }

    }
}
