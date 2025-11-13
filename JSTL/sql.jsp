<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h3>JSTL SQL Tags Demo</h3>

<sql:setDataSource
    var="db"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/testdb"
    user="root"
    password="root"
/>

<sql:query var="result" dataSource="${db}">
    SELECT * FROM student;
</sql:query>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>

    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.id}</td>
            <td>${row.name}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>