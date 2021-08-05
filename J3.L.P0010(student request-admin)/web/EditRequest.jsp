<%-- 
    Document   : EditRequest
    Created on : Jul 14, 2021, 4:40:53 PM
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
        <style>
            .noDown{
                pointer-events: none;
                color: #b4b4b4;
            }

            .hide{
                visibility: hidden;
            }
            .hide2{
                visibility: visible;
            }
        </style>
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
                    <div class="solve">
                        <form action="EditRequestController" >
                            <h3>Request ID: ${getRequest.id}</h3>
                            <table>
                                <tr>
                                    <td>Request to department</td>
                                    <td><input type="hidden" name="rid" value="${getRequest.id}">          
                                        <input type="text" readonly value="${getRequest.dname}" /></td>
                                </tr>
                                <tr>
                                    <td>Student ID</td>
                                    <td><input type="text" readonly value="${getRequest.studentID}"/></td>
                                </tr>
                                <tr>
                                    <td>Student Name</td>
                                    <td><input type="text" readonly value="${getRequest.studentName}"/></td>
                                </tr>
                                <tr>
                                    <td>Date Create</td>
                                    <td><input type="text" readonly value="${getRequest.dateCreate}"/></td>
                                </tr>
                                <tr>
                                    <td>Request Title</td>
                                    <td><input type="text" readonly value="${getRequest.title}"/></td>
                                </tr>
                                <tr>
                                    <td>Request Content</td>
                                    <td><textarea name="option" readonly >${getRequest.content}</textarea></td>
                                </tr>
                                <tr>
                                    <td>Request State</td>
                                    <td>
                                        <input type="radio" name="status" style="width: auto" value="1" ${getRequest.state == 1 ? "checked":""}  ${getRequest.status == 1 ? "disabled":""}/>
                                        <span style="color: blue">Approved</span>
                                        <input type="radio" name="status" style="width: auto" value="0" ${getRequest.state != 1 ? "checked":""} ${getRequest.status == 1 ? "disabled":""}  />
                                        <span style="color: red">Rejected</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Date Close</td>
                                    <td><input type="text" readonly value="${getRequest.closeDate}"/></td>
                                </tr>
                                <tr>
                                    <td>Solve By</td>
                                    <td><input type="text" readonly value="${getRequest.solved}"/></td>
                                </tr>
                                <tr>
                                    <td>Attached (if have)</td>
                                    <td>
                                        <a class="${getRequest.attached eq null ? "noDown":""}" href="attached/${getRequest.attached}" download><input style="width: 80px;" type="button" value="Download"></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td>School's Solution</td>
                                    <td><textarea name="solution">${getRequest.solution}</textarea></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <button type="submit">Edit</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
