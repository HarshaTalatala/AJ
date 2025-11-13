import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        // Simple check (for demo)
        if ("admin".equals(user) && "123".equals(pass)) {

            // ---- Using Cookies ----
            Cookie c = new Cookie("username", user);
            res.addCookie(c);

            // ---- Using HttpSession ----
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // ---- Using URL Rewriting ----
            String url = "WelcomeServlet?user=" + user;

            out.println("<h3>Login successful!</h3>");
            out.println("<a href='" + url + "'>Continue (via URL rewriting)</a>");

        } else {
            out.println("<h3>Invalid login. Try again!</h3>");
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
    }
}
