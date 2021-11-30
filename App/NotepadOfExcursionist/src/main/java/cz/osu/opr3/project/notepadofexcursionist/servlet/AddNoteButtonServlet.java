package cz.osu.opr3.project.notepadofexcursionist.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddNoteButtonServlet", value = "/AddNoteButtonServlet")
public class AddNoteButtonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getRequestURI());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.sendRedirect("page_new_note.jsp");
        } catch (Exception e) {
            response.sendRedirect(request.getRequestURI());
        }
        
    }
}
