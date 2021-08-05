<%-- 
    Document   : preTakeQuiz
    Created on : Jun 16, 2021, 3:59:31 PM
    Author     : Hùng
--%>

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
                <form action="preTakeQuizController">
                    <div class="preTake">
                        <h3>Welcome <span>${sessionScope.student.userName}${sessionScope.teacher.userName}</span></h3>
                        <p>Enter number of questions:</p>
                        <input type="number" name="numberQuestion" required /><br />
                        <input class="btnStart" type="submit" value="Start" />
                        <p style="color: red;">${mess}</p>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
