<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bank App</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="table">
    <form:form modelAttribute="customer" action="add_customer" method="post">
        <table>
            <tr>
                <td><form:label path="firstName">First Name: </form:label></td>
                <td><form:input path="firstName"/>
                    <form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="lastName">Last Name: </form:label></td>
                <td><form:input path="lastName"/>
                    <form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="birthDate">Birth Date: </form:label></td>
                <td><form:input path="birthDate"/>
                    <form:errors path="birthDate" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="gender">Gender: </form:label></td>
                <td><form:radiobutton path="gender" value="male" label="Male"/>
                    <form:radiobutton path="gender" value="female" label="Female"/>
                    <form:errors path="gender" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="email">Email: </form:label></td>
                <td><form:input path="email"/>
                    <form:errors path="email" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="phoneNumber">Phone Number: </form:label></td>
                <td><form:input path="phoneNumber"/>
                    <form:errors path="phoneNumber" cssClass="error" /></td>
            </tr>
            <tr>
                <td><form:label path="phoneNumber">Company: </form:label></td>
                <td> <select name="company">
                    <option value="company_id">Netpeak Software</option>
                    <option value="company_id">Netcracker</option>
                    <option value="company_id">HYS</option>
                </select></td>
            </tr>

        </table>
        <input type="submit" value="Save"/>
    </form:form>
</div>
</body>
</html>