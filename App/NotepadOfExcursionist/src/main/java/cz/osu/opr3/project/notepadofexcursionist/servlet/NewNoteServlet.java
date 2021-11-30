package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.repository.TripDBRepository;
import cz.osu.opr3.project.notepadofexcursionist.repository.UserDBRepository;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.TripEntity;
import cz.osu.opr3.project.notepadofexcursionist.repository.entity.UserEntity;
import cz.osu.opr3.project.notepadofexcursionist.service.CurrentUserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewNoteServlet", value = "/NewNoteServlet")
public class NewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getRequestURI());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("heading");
        String category = request.getParameter("type");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String distance = request.getParameter("distance");
        String tripGPX = request.getParameter("gpx_file");
        String notes = request.getParameter("notes");
        String places = request.getParameter("places");
        String pictures = request.getParameter("pictures");

        try{
            TripEntity tripEntity = new TripEntity(
                    CurrentUserManager.getCurrentUserDada(), title, category, date, time,
                    distance, "", notes, places, ""
            );
            new TripDBRepository().create(tripEntity);

            UserEntity userEntity = new UserDBRepository().findById(
                    CurrentUserManager.getCurrentUserDada().getUserId()
            );
            CurrentUserManager.update(userEntity);

            response.sendRedirect("page_main.jsp");
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(request.getRequestURI());
        }

    }

}
