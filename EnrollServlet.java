package com.exmaple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        String courseId = request.getParameter("courseId");
        List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");

        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }

       
        enrolledCourses.add(new Course(courseId, "Sample Course", "Instructor"));
        session.setAttribute("enrolledCourses", enrolledCourses);

        response.sendRedirect("dashboard");
    }
}
