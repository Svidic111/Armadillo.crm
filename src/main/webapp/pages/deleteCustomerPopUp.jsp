<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRM</title>
    <style>
        h2{
            text-align: center;
            color: white;
        }
        .buttons{
            text-decoration-color: white;
            width: 80px;
            height: 20px;
            border-style: none;
            color: white;
            font-family: Consolas;
        }
        .divButtons{
            width: 100%;
            text-align: center;
        }
        .content{
            background-color: lightslategrey;
        }
    </style>
</head>
<body>
<div class="content">
<h2>Are you sure you want to delete this customer?</h2>
<div class="divButtons">
<input class="buttons" style="background-color: #4CAF50" type="button" onclick="location.href='delete${customerId}'" value="Yes"/>
<input class="buttons" style="background-color: brown" type="button" onclick="window.close()" value="No"/>
</div>
</div>
</body>
</html>