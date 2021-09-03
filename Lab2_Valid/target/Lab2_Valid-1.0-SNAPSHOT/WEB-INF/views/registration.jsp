<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
</head>
<body>
<div id="global">
    <form:form modelAttribute="student" action="registration" method="post">
        <fieldset>
            <legend>Add an student</legend>
            <p>
                <form:errors path="*" cssStyle="color : red;" />
            </p>
            <p>
                <label for="id">ID: </label>
                    <form:input path="id" id="id" />
            <div style="text-align: center;">
                <form:errors path="id" cssStyle="color : red;" />
            </div>
            </p>
            <p>
                <label for="firstName">First Name: </label>
                    <form:input path="firstName" />
            <div style="text-align: center;">
                <form:errors path="firstName" cssStyle="color : red;" />
            </div>
            </p>
            <p>
                <label for="lastName">Last Name: </label>
                    <form:input path="lastName" />
            <div style="text-align: center;">
                <form:errors path="lastName" cssStyle="color : red;" />
            </div>
            </p>

            <p>
                <label for="email">Email: </label>
                    <form:input path="email" />
            <div style="text-align: center;">
                <form:errors path="email" cssStyle="color : red;" />
            </div>
            </p>

            <p>
                <label for="gender">Gender:</label>
                <select name="gender" id="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            <div style="text-align: center;">
                <form:errors path="gender" cssStyle="color : red;" />
            </div>
            </p>

            <p>
                <label for="birthday">Date Of Birth: </label>
                <form:input path="birthday" id="birthday" />
                <form:errors path="birthday" cssStyle="color : red;" />
            </p>

            <h4>Phone:</h4>
            <p>
                <label for="area">Area: </label>
                    <form:input path="phone.area" id="area" />
            <div style="text-align: center;">
                <form:errors path="phone.area" cssStyle="color : red;" />
            </div>
            </p>
            <p>
                <label for="prefix">Prefix: </label>
                    <form:input path="phone.prefix" id="prefix" />
            <div style="text-align: center;">
                <form:errors path="phone.prefix" cssStyle="color : red;" />
            </div>
            </p>
            <p>
                <label for="number">Number: </label>
                    <form:input path="phone.number" id="number" />
            <div style="text-align: center;">
                <form:errors path="phone.number" cssStyle="color : red;" />
            </div>
            </p>

            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Student">
            </p>

        </fieldset>
    </form:form>
</div>
</body>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
</body>
</html>