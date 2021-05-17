<%-- 
    Document   : index
    Created on : Mar 31, 2021, 7:20:24 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">-->
    </head>
    <body>
        <h1 class="text-center mt-3 mb-5">NHÀ HÀNG TIỆC CƯỚI</h1>
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="display:block; bottom: 40px">
            <div class="carousel-inner" >
                <div class="carousel-item active">
                    <!--                    <img class="d-block w-100"  alt="First slide">-->
                    <img style="height: 600px" class="d-block w-100"  alt="First slide" src="<c:url value="/img/1.jpg" />" >
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="<c:url value="/img/banner3.jpg" />" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="<c:url value="/img/4.jpg" />" alt="Third slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="<c:url value="/img/banner5.jpg" />" alt="Four slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
                
        <div class="container" style="display:block; top: 50px; bottom: 50px">
            <div class="row">
                <div class="col">
                    <div class="card" style="width: 30rem;">
                        <a href="<c:url value="/cusEvent" />" style="text-decoration: none;">
                            <img class="card-img-top" src="<c:url value="/img/event2.jpg" />" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-text" style="color:#007bff; text-align: center">Tiệc Cưới</h4>
                            </div>
                        </a>    
                    </div>
                </div>
                <div class="col">
                    <div class="card" style="width: 30rem;">
                        <a href="<c:url value="/cusService" />" style="text-decoration: none;">
                            <img class="card-img-top" src="<c:url value="/img/service1_1.jpg" />" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-text" style="color:#007bff; text-align: center">Dịch Vụ</h4>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="w-100"></div>
                <div class="col">
                    <div class="card" style="width: 30rem; top: 6%;  margin: auto;margin-bottom: 6%">
                        <a href="<c:url value="/hall" />" style="text-decoration: none;">
                            <img class="card-img-top" src="<c:url value="/img/hall1.jpg" />" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-text" style="color:#007bff; text-align: center">Sảnh</h4>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
 

    </body>
</html>





