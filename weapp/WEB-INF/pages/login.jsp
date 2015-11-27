<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>${message}</h1>

<h1>Login Page</h1>

<c:if test="${param.error != null}">
<h3>Invalid username and password!</h3>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="POST">
	
	<input type="text" name="username" placeholder="Username" required/> <br/>
	
	<input type="text" name="password" placeholder="password" /> <br/>
	
	<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}"/>.

	<input type="submit" />

</form>
</body>
</html>