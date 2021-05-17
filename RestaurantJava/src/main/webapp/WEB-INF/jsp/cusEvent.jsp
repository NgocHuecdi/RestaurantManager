<%-- 
    Document   : cusEvent
    Created on : May 4, 2021, 9:31:45 AM
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
        <h1>Sự Kiện Tiệc Cưới</h1>

        <ul class="nav justify-content-center">
            <div class = "event1" style="display: flex; justify-content: space-around; width: 100%">

                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/event8.jpeg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event2.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event4.jpg" />" alt="Third slide">
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
                    <c:forEach items="${event}" var="ev" begin="0" end = "0">        

                        <h2 class="nav-link active " style="color: #007bff">${ev.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;"> Có Giá  ${ev.price} USD</p>

                    </c:forEach>
                </div>

            </div>
            <div class="hollow" style="height: 20px; width: 5px">
                <h1></h1>
            </div>


            <div class="event2" style="display: flex; justify-content: space-around; width: 100%;">
                <div class="discription">
                    <c:forEach items="${event}" var="ev" begin="1" end = "1">        

                        <h2 class="nav-link active " style="color: #007bff">${ev.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;"> Có Giá  ${ev.price} USD</p>

                    </c:forEach>
                </div>
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 550px">
                    <div class="carousel-inner" >
                        <div class="carousel-item active">

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/event5.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event6.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event7.jpg" />" alt="Third slide">
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

                            <img class="d-block w-100"  alt="First slide" src="<c:url value="/img/event2.jpg" />" >
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event6.jpg" />" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="<c:url value="/img/event9.jpg" />" alt="Third slide">
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
               <c:forEach items="${event}" var="ev" begin="2" end = "2">        

                        <h2 class="nav-link active " style="color: #007bff">${ev.name}</h2>
                        <p style="font-size: 20px;   font-style: italic;"> Có Giá  ${ev.price} USD</p>

                    </c:forEach>
                </div>
            </div>



    
         
        </ul>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>



