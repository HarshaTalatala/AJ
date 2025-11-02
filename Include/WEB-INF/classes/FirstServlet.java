import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html"); //Optional line
        PrintWriter out = res.getWriter();
        String user = req.getParameter("user");

        out.println("<h3>Welcome, " + user + "</h3>");
        out.println("<p>This is from FirstServlet</p>");

        // Include content from SecondServlet
        RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
        rd.include(req, res);

        out.println("<p>Back to FirstServlet after inclusion</p>");
        out.close();
    }
}
