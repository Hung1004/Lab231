<%-- 
    Document   : index
    Created on : Jun 28, 2021, 5:25:35 PM
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
            <div class="header">
                <h1>FPT Education System</h1>
                <h3>Teacher Control Panel</h3>
            </div>
            <div class="content">
                <div class="left">
                    <table>
                        <tbody>
                            <c:if test="${sessionScope.account eq null}">
                                <tr>
                                    <td><a href="#">Login</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">Home</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">View Request</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">Solve Request</a></td>
                                </tr>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                                <tr>
                                    <td><a href="Logout">Welcome ${sessionScope.account.fullname}, Logout!</a></td>
                                </tr>
                                <tr>
                                    <td><a href="HomeController">Home</a></td>
                                </tr>
                                <tr>
                                    <td><a href="SelectViewRequest?select=1">View Request</a></td>
                                </tr>
                                <tr>
                                    <td><a href="#">Solve Request</a></td>
                                </tr>
                            </c:if>
                            <tr>
                                <td><a>Today is: ${sessionScope.date}</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="right">
                    <c:if test="${sessionScope.account eq null}">
                        <div class="login">
                            <form action="LoginController" method="POST">
                                <h2>Member Login</h2>
                                <p>Using your username and password.</p>
                                <p style="color: red;padding-left: 20px;">${mess}</p>
                                <table>
                                    <tr>
                                        <td>Username</td>
                                        <td><input type="text" required name="username" value="${username}"/><span>(*)</span></td>
                                    </tr>
                                    <tr>
                                        <td>Password</td>
                                        <td><input type="password" required name="password" value="${password}"/><span>(*)</span></td>
                                    </tr>
                                </table>
                                <button type="submit">Log in</button>
                                <p>The field <span>(*)</span> is required.</p>
                            </form>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.account != null}">
                        <div class="request">
                            <h3>Request received by today - ${sessionScope.date}</h3>
                            <table>
                                <th>Department name</th>
                                <th>Number of request</th>
                                <th>View detail</th>
                                    <c:forEach items="${listRequestToday}" var="o">
                                    <tr>
                                        <td>${o.dname}</td>
                                        <td>${o.countRequest}</td>
                                        <td><a href="SelectViewRequest?select=${o.did}">View</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <h3>Request received by last 2 days</h3>
                            <table>
                                <th>Department name</th>
                                <th>Number of request</th>
                                <th>View detail</th>
                                    <c:forEach items="${listRequestLast2days}" var="o">
                                    <tr>
                                        <td>${o.dname}</td>
                                        <td>${o.countRequest}</td>
                                         <td><a href="SelectViewRequest?select=${o.did}">View</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div> 
                    </c:if>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
