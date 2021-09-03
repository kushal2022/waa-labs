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
    <h2>Student Save successfully</h2>

    <p>
        Student Id: ${student.id}<br>
        Student FirstName: ${student.firstName}<br>
        Student LastName: ${student.lastName}<br>
        Student Email: ${student.email}<br>
        Student Gender: ${student.gender}<br>
        Student Phone: ${student.phone.area}-${student.phone.prefix}-${student.phone.number}<br>
    </p>
</div>

</body>
</html>