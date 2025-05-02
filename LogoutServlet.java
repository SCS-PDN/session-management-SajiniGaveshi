package com.example;  // Add your package if needed

import com.exmaple.HttpServlet;
import com.exmaple.WebServlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Invalidate session
        HttpSession session = request.getSession(false);  // Added 'false' parameter
        if (session != null) {
            session.invalidate();
        }

        // 2. Remove cookies (optional)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {  // Fixed missing parenthesis
                    cookie.setMaxAge(0);  // Set expiry to 0 to delete cookie
                    response.addCookie(cookie);
                }
            }
        }

        // 3. Redirect to login page
        response.sendRedirect("login.html");
    }
}
