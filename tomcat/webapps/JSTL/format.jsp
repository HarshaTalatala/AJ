<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<h3>JSTL Format Tags Demo</h3>

<fmt:formatNumber value="12345.678" type="number" /> <br/>

<fmt:formatNumber value="499.99" type="currency" /> <br/>

<fmt:formatNumber value="0.85" type="percent" /> <br/>

<fmt:formatDate value="<%= new java.util.Date() %>" pattern="dd-MM-yyyy" /> <br/>

</body>
</html>