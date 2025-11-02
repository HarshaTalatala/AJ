<%@ page contentType="text/html" %>
<html>
  <head>
    <title>Simple JSP Example</title>
  </head>
  <body>
    <h2>Hello from JSP!</h2>
    <%
        String name = "Harsha";
        int roll = 01;
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Roll No: " + roll + "</p>");
    %>
    <p>Current Time: <%= new java.util.Date() %></p>
  </body>
</html>