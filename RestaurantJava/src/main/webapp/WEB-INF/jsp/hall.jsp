<%-- 
    Document   : hall
    Created on : May 4, 2021, 1:21:09 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <link href="<c:url value="/css/hall.css"/>"
              rel="stylesheet" />
    </head>
    <body>
        <h1>Sảnh</h1>

        <ul class="nav justify-content-center">
            <div class = "hall1" style="display: flex; justify-content: space-around; width: 100%">

                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/hall1.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall2.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall6.jpg" />" alt="Third slide">
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
                <div class="discription">
                    <c:forEach items="${hall}" var="ha" begin="0" end = "0">        

                        <h2 class="nav-link active " style="color: #007bff">${ha.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;">  Với ${ha.seat} chổ ngồi</p>

                    </c:forEach>
                </div>

            </div>
            <div class="hollow" style="height: 20px; width: 5px">
                <h1></h1>
            </div>


            <div class="hall2" style="display: flex; justify-content: space-around; width: 100%;">
                <div class="discription">
                    <c:forEach items="${hall}" var="ha" begin="1" end = "1">        
                        <h2 class="nav-link active " style="color: #007bff">${ha.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;">  Với ${ha.seat} chổ ngồi</p>
                    </c:forEach>
                </div>
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/hall7.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall8.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall9.jpg" />" alt="Third slide">
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
            </div>
            <div class="hollow" style="height: 20px; width: 5px">
                <h1></h1>
            </div>
            <div class = "hall3" style="display: flex; justify-content: space-around; width: 100%">

                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/hall2.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall17.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall6.jpg" />" alt="Third slide">
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
                <div class="discription">
                    <c:forEach items="${hall}" var="ha" begin="2" end = "2">        

                        <h2 class="nav-link active " style="color: #007bff">${ha.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;">  Với ${ha.seat} chổ ngồi</p>

                    </c:forEach>
                </div>
            </div>



          <div class="hollow" style="height: 20px; width: 5px">
                <h1></h1>
            </div>


            <div class="hall2" style="display: flex; justify-content: space-around; width: 100%;">
                <div class="discription">
                    <c:forEach items="${hall}" var="ha" begin="3" end = "3">        
                        <h2 class="nav-link active " style="color: #007bff">${ha.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;">  Với ${ha.seat} chổ ngồi</p>
                    </c:forEach>
                </div>
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/hall7.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall8.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/hall9.jpg" />" alt="Third slide">
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
            </div>
        </ul>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>


