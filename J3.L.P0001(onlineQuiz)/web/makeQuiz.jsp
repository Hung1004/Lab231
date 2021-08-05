<%-- 
    Document   : makeQuiz
    Created on : Jun 13, 2021, 11:11:58 PM
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
        <div class="container">
            <div class="content">
                <jsp:include page="header.jsp"/>
                <div class="makeQuiz">
                    <c:if test="${check == 0 ||check == null}">
                        <form action="makeQuizController">
                            <table>
                                <tbody>
                                    <tr>
                                        <td>Question:</td>
                                        <td>
                                            <textarea class="question" name="question" required>${question}</textarea>
                                        </td>
                                    </tr>
                                    <c:forEach begin="1" end="4" var="o">
                                        <tr>
                                            <td>Option ${o}:</td>
                                            <td><textarea name="option" required></textarea></td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td>Answer(s):</td>
                                        <td>
                                            <c:forEach begin="1" end="4" var="o">
                                                <input type="checkbox" name="answer" value="${o}" />Option ${o}
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit"value="Save" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </c:if>
                    <c:if test="${check == 1}">
                        <h3 style="color: blue; padding: 3% ;">Add Quiz Successfully!</h3>
                        <a style="padding: 0 3%" href="makeQuiz.jsp"> Make new quiz!</a>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
