import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    
    private static final String VALID_USERNAME = "student1";
    private static final String VALID_PASSWORD = "pass1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        String username = request.getParameter("username");
        String password = request.getParameter("password");

       
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {

        
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

         
            Cookie userCookie = new Cookie("user", username);
            userCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(userCookie);

            
            response.sendRedirect("dashboard");

        } else {
            
            response.sendRedirect("login.html?error=1");
        }
    }
}
