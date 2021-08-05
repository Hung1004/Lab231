<%-- 
    Document   : Contact
    Created on : May 10, 2021, 4:43:01 PM
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
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="content">
                <div class="left_contact">
                    <div class="about">
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="country">
                            <p>
                                Address: ${Contact.address} <br />
                                City: ${Contact.city}<br />
                                Country: ${Contact.country}<br/><br/><br/>
                                Tel: ${Contact.telephone}<br/><br/>
                                Email: ${Contact.email}
                            </p>
                        </div>
                        <div class="map">
                            <iframe
                                src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d493111.24646305334!2d105.7515510436846!3d20.94120920135194!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e1!3m2!1svi!2s!4v1621243360133!5m2!1svi!2s"
                                style="border: 0"
                                allowfullscreen=""
                                loading="lazy"
                                ></iframe>
                        </div>
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
