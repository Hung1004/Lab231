<%-- 
    Document   : Header
    Created on : May 10, 2021, 4:43:55 PM
    Author     : Hùng
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="nav">
            <div class="nav-inner">
                <ul>
                    <li class="nav-subInner">
                        <a href="HomeServlet">My front page</a>
                    </li>
                    <c:forEach items="${getDataTop3Gallery}" var="o">
                        <li><a class="${active==o.id?"active":""}" href="GalleryServlet?id=${o.id}">${o.name}</a></li>
                    </c:forEach>
                    <li><a class="${active=="0"?"active":""}" href="ContactServlet">Contact</a></li>
                </ul>
            </div>
        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"></div>
                <div class="title">photographer</div>
                <div class="subTitle">Welcome to this website</div>
            </div>
        </div>

    </body>
</html>
