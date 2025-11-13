<%@ page import="java.sql.*" %>
<html>
<head><title>Database Access through JSP</title></head>
<body>
<h2>Student Table Data</h2>

<%
    String url = "jdbc:postgresql://localhost:5432/student";
    String user = "postgres";
    String pass = "2785";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, pass);
        st = con.createStatement();

        rs = st.executeQuery("SELECT * FROM student");

        out.println("<table border='1'>");
        out.println("<tr><th>Roll No</th><th>Name</th><th>Address</th></tr>");

        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("rollno") + "</td>");
            out.println("<td>" + rs.getString("name") + "</td>");
            out.println("<td>" + rs.getString("address") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    } catch (Exception e) {
        out.println("Error: " + e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (SQLException ex) {}
    }
%>

</body>
</html>
