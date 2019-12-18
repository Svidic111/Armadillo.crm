<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRM</title>
    <style>
        .links{
            width: 100%;
            padding-bottom: 30px;
        }
        .menuButtons{
            background-color: #4CAF50;
            color: white;
            border-style: none;
        }
    </style>
</head>
<body>
<div class="links">
    <spring:eval expression="@environment.getProperty('server.port')" var="port" />
    <input class="menuButtons" type="button" onclick="location.href='http://localhost:8088/managers'" value="Managers"/>
    <input class="menuButtons" type="button" onclick="location.href='http://localhost:8088/customers'" value="Customers"/>
    <input class="menuButtons" type="button" onclick="location.href='http://localhost:8088/companies'" value="Companies"/>
    <input class="menuButtons" type="button" onclick="location.href='http://localhost:8088/deals'" value="Deals"/>
    <input class="menuButtons" type="button" onclick="location.href='http://localhost:8088/tasks'" value="Tasks"/>
</div>
</body>
</html>