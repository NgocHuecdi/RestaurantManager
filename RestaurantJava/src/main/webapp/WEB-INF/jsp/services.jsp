<%-- 
    Document   : servcies
    Created on : Apr 23, 2021, 2:30:26 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="<c:url value="/css/employee.css"/>"
              rel="stylesheet" />
    </head>
    <body>
        <h1 class="text-center mt-3 mb-5">Danh Sách Dịch Vụ</h1>
        <br/>  
        <a href="<c:url value="/addService" />" class="btn btn-success">Thêm dịch vụ mới</a> 
        <table border="1" class = "table table-striped table-responsive-md mt-3">
            <thead>
                <tr >
                    <th class="text-center">
                        Mã Dịch Vụ
                    </th>
                    <th class="text-center">
                        Tên Dịch Vụ
                    </th>
                    <th class="text-center">
                        Giá
                    </th>
                    <th class="text-center">
                        Xóa
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${services}" var = "ser">

                    <tr id="services${ser.serviceId}">
                        <td> ${ser.serviceId}</td>
                        <td>${ser.name}</td>
                        <td>${ser.unit_price} USD</td>
                        <td class="text-center"> 
                            <a href="javascript:;" class="btn btn-danger" onclick="deleteService(${ser.serviceId})">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="<c:url value="/js/main.js" />"></script>
    </body>
</html>
