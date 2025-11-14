<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<body>

<h3>JSTL Functions Tag Demo</h3>

<c:set var="str" value="Hello World" />

<p>Length: ${fn:length(str)}</p>

<p>Uppercase: ${fn:toUpperCase(str)}</p>

<p>Contains 'World'? ${fn:contains(str, 'World')}</p>

<p>Substring (0,5): ${fn:substring(str, 0, 5)}</p>

</body>
</html>