<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRM</title>
    <style>
        .tasks{

        }
        .outdatedCards{
            width: 33%;
            background-color: #f1f1f1;
            color: #293137;
            display: inline-grid;
        }
        .todayCards{
            width: 33%;
            background-color: #f1f1f1;
            color: #293137;
            display: inline-grid;
        }
        .otherCards{
            width: 33%;
            background-color: #f1f1f1;
            color: #293137;
            display: inline-grid;
        }
        .card{
            width: 90%;
            border-style: dashed;
            border-color: lightslategrey;
            border-width: 1px;
            background-color: white;
            color: #293137;
            margin-left: 5%;
            margin-bottom: 5%;
        }
        .tasksCounter{
            text-align: center;
        }
        .cardStatus{
            text-align: center;
        }
       /*Outdated status*/
        .outdatedStatusBlock{
            width: 10px;
            height: 10px;
            background-color: brown;
            display: inline-block;
        }
        .outdatedStatus{
            display: inline-block;
        }
        .outdatedStatusText{
            color: brown;
            text-align: center;
        }

        /*New Status*/
        .newStatusBlock{
            width: 10px;
            height: 10px;
            background-color: cornflowerblue;
            display: inline-block;
        }
        .newStatus{
            display: inline-block;
        }
        .newStatusText{
            color: cadetblue;
            text-align: center;
        }

        /*Done Status*/
        .doneStatusBlock{
            width: 10px;
            height: 10px;
            background-color: forestgreen;
            display: inline-block;
        }
        .doneStatus{
            display: inline-block;
        }
        .doneStatusText{
            color: forestgreen;
            text-align: center;
        }

        /*Canceled*/
        .canceledStatusBlock{
            width: 10px;
            height: 10px;
            background-color: #6b62a8;
            display: inline-block;
        }
        .canceledStatus{
            display: inline-block;
        }
        .canceledStatusText{
            color: #6b62a8;
            text-align: center;
        }

        .taskMessageBlock{
            background-color: #f0f0f0;
            padding: 10px;
            margin: 10px;
        }
        .taskMessage{
            padding: 5px;
        }

        h2{
            text-align: center;
            font-size: medium;
        }
        .controlButtons{
            padding-top: 15px;
            margin-left: 68%;
            margin-bottom: 5px;
            display: inline-block;
        }
        .controlButton{
            background-color: lightslategrey;
            color: white;
            border-style: none;
        }
        .customerLink{
            text-align: center;
        }
        .companyLink{
            padding-bottom: 5px;
        }
        .managerName{
            display: inline-block;
        }
        .noTaskMessage{
            text-align: center;
            color: #293137;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="tasks">
    <div class="outdatedCards">
        <h2>Outdated Tasks</h2>
        <c:if test="${tasks.outdatedTasks.size() == 0}">
            <div class="noTaskMessage">
                <p>Congratulations! You have no outdated tasks.</p>
            </div>
        </c:if>
        <c:if test="${tasks.outdatedTasks.size() != 0}">
            <div class="tasksCounter">
                <p><c:out value="${tasks.outdatedTasks.size()}"/> tasks</p>
            </div>
        </c:if>
        <c:forEach items="${tasks.outdatedTasks}" var="task">
        <form:form modelAttribute="task" method="post">
        <div class="card">
            <div class="customerLink"><a href=""><c:out value="${task.deal.customer.firstName}  ${task.deal.customer.lastName}"/></a></div>

            <div class="cardStatus">
            <div class="outdatedStatusBlock"></div>
                <div class="outdatedStatus"><p class="outdatedStatusText"><c:out value="${task.status.status}"/></p></div>
            </div>

            <div class="taskMessageBlock">
                <div class="taskMessage">
                    <p class="taskMessageText"><c:out value="${task.message}"/></p>
                </div>
            </div>

            <div class="bottomCard">
                <div class="managerName"><a href="customer.jsp"><c:out value="${task.deal.manager.firstName} ${task.deal.manager.lastName}"/></a><p><c:out value="— ${task.scheduledDate}"/></p></div>
                <div class="controlButtons">
                    <div class="companyLink"><a href="">Netpeak Software</a></div>
                    <input class="controlButton" type="button" onclick="location.href=''" value="View deal"/>
                    <input class="controlButton" type="button" onclick="location.href=''" value="Cancel"/>
                </div>
            </div>
        </div>
        </form:form>
        </c:forEach>
    </div>

    <div class="todayCards">
        <h2>Tasks for Today</h2>
        <c:if test="${tasks.todayTasks.size() == 0}">
            <div class="noTaskMessage">
                <p>Sorry, there are no tasks for today. </p>
            </div>
        </c:if>
        <c:forEach items="${tasks.todayTasks}" var="task">
        <form:form modelAttribute="task" method="post">
        <div class="card">
            <div class="customerLink"><a href=""><c:out value="${task.deal.customer.firstName}  ${task.deal.customer.lastName}"/></a></div>

            <c:if test="${task.status.status == 'Done'}">
                <div class="cardStatus">
                    <div class="doneStatusBlock"></div>
                    <div class="doneStatus"><p class="doneStatusText"><c:out value="${task.status.status}"/></p></div>
                </div>
            </c:if>

            <c:if test="${task.status.status == 'New'}">
                <div class="cardStatus">
                    <div class="newStatusBlock"></div>
                    <div class="newStatus"><p class="newStatusText"><c:out value="${task.status.status}"/></p></div>
                </div>
            </c:if>

            <div class="taskMessageBlock">
                <div class="taskMessage">
                    <p class="taskMessageText"><c:out value="${task.message}"/></p>
                </div>
            </div>

            <div class="bottomCard">
                <div class="managerName"><a href="customer.jsp"><c:out value="${task.deal.manager.firstName} ${task.deal.manager.lastName}"/></a></div>
                <div class="controlButtons">
                    <div class="companyLink"><a href="">Netpeak Software</a></div>
                    <input class="controlButton" type="button" onclick="location.href=''" value="View deal"/>
                    <input class="controlButton" type="button" onclick="location.href=''" value="Cancel"/>
                </div>
            </div>
        </div>
        </form:form>
        </c:forEach>
    </div>

    <div class="otherCards">
        <h2>Other Tasks</h2>
        <c:forEach items="${tasks.otherTasks}" var="task">
        <form:form modelAttribute="task" method="post">
        <div class="card">
            <div class="customerLink"><a href=""><c:out value="${task.deal.customer.firstName}  ${task.deal.customer.lastName}"/></a></div>

            <c:if test="${task.status.status == 'Done'}">
            <div class="cardStatus">
                <div class="doneStatusBlock"></div>
                <div class="doneStatus"><p class="doneStatusText"><c:out value="${task.status.status}"/></p></div>
            </div>
            </c:if>

            <c:if test="${task.status.status == 'New'}">
                <div class="cardStatus">
                    <div class="newStatusBlock"></div>
                    <div class="newStatus"><p class="newStatusText"><c:out value="${task.status.status}"/></p></div>
                </div>
            </c:if>

            <c:if test="${task.status.status == 'Canceled'}">
                <div class="canceledStatus">
                    <div class="canceledStatusBlock"></div>
                    <div class="canceledStatus"><p class="canceledStatusText"><c:out value="${task.status.status}"/></p></div>
                </div>
            </c:if>

            <div class="taskMessageBlock">
                <div class="taskMessage">
                    <p class="taskMessageText"><c:out value="${task.message}"/></p>
                </div>
            </div>

            <div class="bottomCard">
                <div class="managerName"><a href="customer.jsp"><c:out value="${task.deal.manager.firstName} ${task.deal.manager.lastName}"/></a></div>
                <div class="controlButtons">
                    <div class="companyLink"><a href="">Netpeak Software</a></div>
                    <input class="controlButton" type="button" onclick="location.href=''" value="View deal"/>
                    <input class="controlButton" type="button" onclick="location.href=''" value="Cancel"/>
                </div>
            </div>
        </div>
        </form:form>
        </c:forEach>
    </div>
</div>
</body>
</html>