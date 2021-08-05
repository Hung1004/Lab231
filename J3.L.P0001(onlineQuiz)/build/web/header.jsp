<%-- 
    Document   : header
    Created on : Jun 13, 2021, 11:17:20 PM
    Author     : Hùng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <div class="header">

            <div class="nav">
                <c:if test="${sessionScope.student == null && sessionScope.teacher == null}">
                    <a href="#" class="disabled">Home</a>
                    <a href="#" class="disabled">Take Quiz</a>
                    <a href="#" class="disabled">Make Quiz</a>
                    <a href="#" class="disabled">Manage Quiz</a>
                </c:if>
                <c:if test="${sessionScope.student != null }">
                    <a href="index.jsp">Home</a>
                    <a href="preTakeQuiz.jsp" class="${sessionScope.active eq "active" ? "disabled":""}"> Take Quiz</a>
                    <a href="#" class="disabled">Make Quiz</a>
                    <a href="#" class="disabled">Manage Quiz</a>
                    <a href="logoutController">Log Out</a>
                </c:if>

                <c:if test="${sessionScope.teacher != null }">
                    <a href="index.jsp">Home</a>
                    <a href="preTakeQuiz.jsp">Take Quiz</a>
                    <a href="makeQuiz.jsp">Make Quiz</a>
                    <a href="manageQuizController">Manage Quiz</a>
                    <a href="logoutController">Log Out</a>
                </c:if>

            </div>
        </div>
    </body>
</html>
