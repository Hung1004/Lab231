<%-- 
    Document   : Index
    Created on : May 20, 2021, 10:32:18 PM
    Author     : Hùng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <div class="header">
                <div class="preheader"></div>
                <div class="header1">
                    <h3>My Digital News</h3>
                </div>
                <div class="menu">
                    <a href="HomeControl">News</a>
                </div>
            </div>
            <div class="content">
                <div class="left">
                    <div class="title">
                        ${getNews.title}
                    </div>
                    <div class="image">
                        <img src="images/${getNews.image}" />
                    </div>
                    <div class="text">
                        ${getNews.des}
                    </div>
                    <div class="author">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By  ${getNews.author} |  ${getNews.date}
                    </div>
                </div>
                <div class="right">
                    <div class="part">
                        <div class="titleNews">Digital News</div>
                        <div class="contentNews">
                            ${getMostNews.shortDes}
                        </div>
                    </div>
                    <div class="part">
                        <div class="titleNews">Search</div>
                        <form action="SearchControl">
                            <input class="searchBox" type="text" name="txtSearch"size="15"value="${txt}"required/>
                            <input class="searchButton"type="submit"value="Go"/>
                        </form>
                    </div>
                    <div class="part">
                        <div class="titleNews">Last Articles</div>
                        <c:forEach items="${Top5}" var="o" >
                            <div class="lastArticles">
                                <a href="DetailControl?id=${o.id}">${o.title}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
