<%-- 
    Document   : login
    Created on : Jun 13, 2021, 11:11:27 PM
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
        <div class="login">
            <c:if test="${sessionScope.student == null && sessionScope.teacher ==null}">
                <form action="loginController" method="POST">
                    <h4>${mess}</h4>
                    <table>
                        <div class="title">Login Form</div>
                        <thead>
                            <tr>
                                <td>User Name: </td>
                                <td><input type="text" name="userName" value="" required=""/></td>
                            </tr>
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" name="passWord" value="" required=""/></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Login" /><a href="register.jsp">Register</a></td>
                            </tr>
                        </thead>
                    </table>
                </form>
            </c:if>
            <c:if test="${sessionScope.student != null || sessionScope.teacher !=null}">
                <h3 style="padding:20px 10px;">Welcome <span>${sessionScope.student.userName}${sessionScope.teacher.userName} </span></h3>
            </c:if>
        </div>
    </body>
</html>
