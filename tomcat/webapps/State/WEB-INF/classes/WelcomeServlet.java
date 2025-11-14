import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String user = null;

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    user = c.getValue();
                    break;
                }
            }
        }

        if (user == null) {
            HttpSession session = req.getSession(false);
            if (session != null)
                user = (String) session.getAttribute("user");
        }

        if (user == null)
            user = req.getParameter("user");

        if (user != null)
            out.println("<h3>Welcome " + user + "!</h3>");
        else
            out.println("<h3>No user found. Please login again.</h3>");
    }
}