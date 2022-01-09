package cz.osu.opr3.project.notepadofexcursionist.servlet;

import cz.osu.opr3.project.notepadofexcursionist.service.DBService;

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

    }

}
