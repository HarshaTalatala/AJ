<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h3>JSTL Core Tags Demo</h3>

<c:set var="name" value="Harsha" />

<p>Name is: <c:out value="${name}" /></p>

<c:if test="${name == 'Harsha'}">
  <p>Condition is True</p>
</c:if>

<c:forEach var="i" begin="1" end="5">
  <p>Number: ${i}</p>
</c:forEach>

</body>
</html>