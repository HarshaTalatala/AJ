<%@ page contentType="text/html" %>
<html>
<head>
    <title>Addition Result</title>
</head>
<body>
    <h2>Addition Result</h2>

    <%
        String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");

        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        int sum = a + b;
    %>

    <p>Number 1: <%= a %></p>
    <p>Number 2: <%= b %></p>
    <p>Sum: <strong><%= sum %></strong></p>
</body>
</html>