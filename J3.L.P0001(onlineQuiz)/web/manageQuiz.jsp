<%-- 
    Document   : managerQuiz
    Created on : Jun 13, 2021, 11:12:20 PM
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
                <div class="managerQuiz">
                    <h2>Number of question: <span style="color: blue;">${numQues}</span> </h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Question</th>
                                <th>Date Created</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listQues}" var="o">
                                <tr>
                                    <td>${o.question}</td>
                                    <td>${o.date}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
</html>
