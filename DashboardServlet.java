package com.exmaple;

import javax.servlet;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;  // Fixed import

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)  // Added missing parameter
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");  // Fixed lowercase filename
            return;
        }

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
