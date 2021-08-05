<%-- 
    Document   : Gallery
    Created on : May 10, 2021, 4:45:39 PM
    Author     : Hùng
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/styte.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>

        <div class="container">
            <jsp:include page="header.jsp"></jsp:include>
                <div class="content">
                    <div class="left_gallery">
                        <h3>View ${getGalleryById.name}</h3>
                    <img onclick="start()" id="start" src="images/play-button.png">
                    <div class="changeImg">
                        <img id="imgs" src="images/${getGalleryById.url_img}">
                    </div>   
                    <img onclick="pause()" id="pause" src="images/pause.png">       
                    <div class="contentGalery">
                        <ul>
                            <c:forEach items="${getImgGallery}" var="o">
                                <li><img  src="images/${o.image}"></li>
                                </c:forEach>
                        </ul>
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
        <script>
            var numImg = ${numImg};
            var index = 0;
            var imgs = [];
            var bool = false;
            <c:forEach items="${getImgGallery}" var="d">
            imgs.push("${d.image}");
            </c:forEach>
            function changeImage() {
                setTimeout(function () {
                    // 0 1 2 3 
                    if (bool === true) {

                        index++;
                        if (index < 0 || index >= numImg) {
                            document.getElementById("start").style.display = "inline-block";
                            document.getElementById("pause").style.display = "none";
                            document.getElementById("imgs").src = "images/" + imgs[0];
                            index = 0;
                            bool = false;
                            return;
                        }
                        document.getElementById("imgs").src = "images/" + imgs[index];
                        if (index > 0 && index < numImg) {
                            changeImage();
                        }
                    }
                }, 1000);
            }
            ;
            function pause() {
                bool = false;
                document.getElementById("start").style.display = "inline-block";
                document.getElementById("pause").style.display = "none";
                document.getElementById("imgs").src = "images/" + imgs[index ];
                return;
            }
            ;
            function start() {
                bool = true;
                changeImage();
                document.getElementById("start").style.display = "none";
                document.getElementById("pause").style.display = "inline-block";
            }
            ;
        </script>
    </body>
</html>
