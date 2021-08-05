<%-- 
    Document   : doneQuiz
    Created on : Jun 16, 2021, 4:02:24 PM
    Author     : Hùng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div class="container">
            <div class="content">
                <jsp:include page="header.jsp"/>
                <div class="doneTake">
                    <h3>Welcome <span>${sessionScope.student.userName}${sessionScope.teacher.userName}</span></h3>
                    <c:if test="${result<50}">
                        <p>Your score: <span style="color: red;">${result/10} (${result}%) - Not Passed</span></p>
                    </c:if>
                    <c:if test="${result>=50}">
                        <p>Your score: <span style="color: blue;">${result/10} (${result}%) - Passed</span></p>
                    </c:if>
                    <h3>
                        Take another test<a href="preTakeQuiz.jsp"><input type="button" onclick="" value="Start" /></a> 
                    </h3>
                </div>
            </div>
        </div>
    </body>
</html>
