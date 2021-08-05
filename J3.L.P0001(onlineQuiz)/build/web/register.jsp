<%-- 
    Document   : register
    Created on : Jun 13, 2021, 11:12:38 PM
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
                <div class="register">
                    <c:if test="${check == 1}">
                        <h3 style="color: blue;">${mess}</h3>
                        <a href="index.jsp">Login</a>
                    </c:if>
                    <c:if test="${check !=1}">
                        <h3 style="color: red;">${mess}</h3>
                        <form action="registerController">
                            <table>
                                <div class="title">Registration Form</div>
                                <tbody>
                                    <tr>
                                        <td>User Name:</td>
                                        <td><input type="text" name="userName" value="" required /></td>
                                    </tr>
                                    <tr>
                                        <td>Password:</td>
                                        <td><input type="password" name="passWord" value="" required /></td>
                                    </tr>
                                    <tr>
                                        <td>User Type:</td>
                                        <td>
                                            <select name="role">
                                                <option value="1">Teacher</option>
                                                <option value="2">Student</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><input type="text" name="email" value="" required /></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <button type="submit" value="Register">Register</button>
                                            <a href="index.jsp">Login</a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
