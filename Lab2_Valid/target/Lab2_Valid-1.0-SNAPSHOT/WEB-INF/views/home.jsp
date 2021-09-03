<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
</head>
<body>
<div id="global">
	<h1>
		Hello Student!!!
	</h1>

	<p>

		<button onclick="window.location='<spring:url value="/registration" />' ">
			Student Registration</button>

	</p>
</div>

</body>
</html>
