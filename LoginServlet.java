import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    // Hardcoded valid credentials (replace with database check later)
    private static final String VALID_USERNAME = "student1";
    private static final String VALID_PASSWORD = "pass1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Get form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. Validate credentials
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            
            // 3. Create session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            // 4. Set cookie (optional)
            Cookie userCookie = new Cookie("user", username);
            userCookie.setMaxAge(60 * 60 * 24); // 1 day expiry
            response.addCookie(userCookie);
            
            // 5. Redirect to dashboard
            response.sendRedirect("dashboard");
            
        } else {
            // 6. Failed login - redirect back with error
            response.sendRedirect("login.html?error=1");
        }
    }
}
