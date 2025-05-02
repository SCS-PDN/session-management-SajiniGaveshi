package com.example;  

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Invalidate session
        HttpSession session = request.getSession(false);  
        if (session != null) {
            session.invalidate();
        }

        // 2. Remove cookies (optional)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {  
                    cookie.setMaxAge(0);  
                    response.addCookie(cookie);
                }
            }
        }

        
        response.sendRedirect("login.html");
    }
}
