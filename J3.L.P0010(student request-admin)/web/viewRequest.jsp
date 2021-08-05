<%-- 
    Document   : viewRequest
    Created on : Jun 28, 2021, 5:26:16 PM
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
                    <div class="view">
                        <h2>View request</h2>
                        <div class="content_view">
                            <div class="header_view">
                                <form action="SelectViewRequest">
                                    <span>Select department</span>
                                    <select style="margin-left: 15px" name="select" onchange="this.form.submit()">
                                        <c:forEach items="${listDepartment}" var="o">
                                            <option ${choose eq o.id ?"selected":""} value="${o.id}">${o.name}</option>
                                        </c:forEach>
                                    </select>
                                </form>
                                <form action="SearchViewRequest">
                                    <br />
                                    <span>or Enter request title department </span>
                                    <input style="margin: 15px" width="20vw;" type="text" name="textTitle" required value="${textTitle}"/>
                                    <button style="margin-bottom: 15px" type="submit">View</button>
                                </form>
                            </div>
                            <table>
                                <tr>
                                    <td>Request title</td>
                                    <td>Date created</td>
                                    <td>Close created</td>
                                    <td>Status</td>
                                    <td>Report to</td>
                                    <td>Detail</td>
                                </tr>
                                <c:forEach items="${list}" var="o">
                                    <tr>
                                        <td>${o.title}</td>
                                        <td>${o.dateCreate}</td>
                                        <td>${o.closeDate}</td>
                                        <c:if test="${o.state == 1}">
                                            <td style="color: blue;">Approved</td>
                                        </c:if>
                                        <c:if test="${o.state == 0}">
                                            <td style="color: red;">Rejected</td>
                                        </c:if>
                                        <c:if test="${o.state == -1}">
                                            <td>In progress</td>
                                        </c:if>
                                        <td>${o.dname}</td>
                                        <td>
                                            <c:if test="${o.state !=-1}">
                                                <a href="PreEditRequestController?rid=${o.id}">Edit</a>
                                            </c:if>
                                            <c:if test="${o.state ==-1}">
                                                <a href="PreSolveRequestController?rid=${o.id}">View</a>
                                            </c:if>

                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
