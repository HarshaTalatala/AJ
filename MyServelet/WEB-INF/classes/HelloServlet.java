import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            
        response.setContentType("text/html"); //optional-line
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello from Servlet!</h1>");
    }
}