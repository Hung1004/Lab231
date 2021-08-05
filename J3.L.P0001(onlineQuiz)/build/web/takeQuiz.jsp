<%-- 
    Document   : takeQuiz
    Created on : Jun 13, 2021, 11:13:14 PM
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
                <div class="take">
                    <h3>Welcome <span>${sessionScope.student.userName}${sessionScope.teacher.userName}</span></h3>
                    <p>Time Remaining: <span id="time"></span></p>
                    <div class="contentQuiz">
                        <form action="preNextController" method="POST">
                            <h4>${question}</h4>
                            <c:forEach items="${option}" var="o" >
                                <input type="checkbox" name="answer" value="${o.idAnswer}"/>${o.option}
                                <br />
                            </c:forEach>
                            <c:if test="${sessionScope.countQues==0}">
                                <input class="finish" type="submit" onclick="" value="Finish" />
                            </c:if>
                            <c:if test="${sessionScope.countQues!=0}">
                                <input  class="next" type="submit" name="btnNext" value="Next" />
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function startTime(time) {
                var num = document.getElementById("time");
                var numTime = time;
                var seconds, minutes;
                setInterval(function () {
                    minutes = parseInt(numTime / 60);
                    seconds = parseInt(numTime % 60);
                    minutes = minutes < 10 ? "0" + minutes : minutes;
                    seconds = seconds < 10 ? "0" + seconds : seconds;
                    num.innerHTML = minutes + ":" + seconds;
                    if (numTime === 0) {
                        location.href = "preNextController?cQ=ok";
                    }
                    numTime--;
                }, 1000);
            }

            onload = function () {
                startTime(${sessionScope.timeQuiz});
            };
        </script>
    </body>
</html>
