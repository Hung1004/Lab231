<%-- 
    Document   : Index
    Created on : May 10, 2021, 4:45:26 PM
    Author     : Hùng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styte.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"></jsp:include>
                <div class="content">
                    <div class="left_index">
                        <div class="image">
                            <img src="images/${getDataTop1Gallery.url_img}"/>
                    </div>
                    <div class="description">${getDataTop1Gallery.title}</div>
                    <div class="sub_content">
                        <ul>
                            <c:forEach items="${listGallery}" var="o">
                                <li>
                                    <img src="images/${o.url_img}" />
                                    <a href="GalleryServlet?id=${o.id}">View ${o.name}</a>
                                    <p>${o.description}</p>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="page">
                        <c:if test="${numpage>1}" >
                            <c:forEach begin="1" end="${numpage}" var="i">
                                <a href="HomeServlet?index=${i}"  ${index == i? "style=\"color: red;\"":""}>${i}</a>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                        <p>${getDataTop1Gallery.description}</p>
                    </div>
                </div>
                <div class="right">
                    <div class="header-right">
                        <h4>Share this page</h4>
                    </div>
                    <div class="social">
                        <ul>
                            <li>
                                <img src="images/face.png" /><a href="#">Share on Facebook</a>
                            </li>
                            <li>
                                <img src="images/twitter.png" /><a href="#">Share on Twitter</a>
                            </li>
                            <li>
                                <img src="images/google.png" /><a href="#">Share on Google</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="link"> 
                    <a href="#">Created with SimpleSite </a>
                    <span>0</span>
                    <span>4</span>
                    <span>4</span>
                    <span>0</span>
                    <span>6</span>
                    <span>0</span>
                </div>
            </div>
        </div>
    </body>
</html>
