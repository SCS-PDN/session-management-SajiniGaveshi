package com.exmaple;

import javax.servlet;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException; 

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)  
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");  
            return;
        }

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
