<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRM</title>
</head>
<body>
<style>
    DIV.customersTable
    {
        display:table; width: 100%;;
    }

    FORM.tr, DIV.tr
    {
        display:table-row;
        padding: 10px;
        margin: 10px;
    }
    SPAN.td
    {
        display:table-cell;
        padding: 10px;
        margin: 10px;
    }
    SPAN.th
    {
        display:table-cell;
        font-weight: bold;
    }
</style>
<div class="customersTable">
    <div class="tr">
        <span class="th">First name</span>
        <span class="th">Last name</span>
        <span class="th">Birth date</span>
        <span class="th">Email</span>
        <span class="th">Phone number</span>
        <span class="th">Company name</span>
        <span class="th">Action</span>
    </div>
    <c:forEach items="${customers}" var="customer">

        <form:form class="tr" modelAttribute="customer" method="post">
            <span class="td"><c:out value="${customer.firstName}"/> </span>
            <span class="td"><c:out value="${customer.lastName}"/> </span>
            <span class="td"><c:out value="${customer.birthDate} "/> </span>
            <span class="td"><c:out value="${customer.email}"/> </span>
            <span class="td"><c:out value="${customer.phoneNumber}"/> </span>
            <span class="td"><c:out value="${customer.company.name}"/> </span>
            <span class="td"><input type="button" onclick="location.href='deals/${customer.id}'" value="View deals"/>
                <input type="button" onclick="location.href='edit${customer.id}'" value="Edit"/>
               <%-- <input type="button" onclick="location.href='delete/${customer.id}'" value="Delete"/>--%>
                <input type="button" onclick='javascript:window.open("customers/deleteCustomerPopUp/${customer.id}", "_blank", "scrollbars=0,resizable=0,height=150,width=450");' title='Pop Up' value="Delete"/>
        </form:form>
    </c:forEach>
</div>

<input type="button" onclick="location.href='add';" value="Add new customer"/>
</body>
</html>