<%-- 
    Document   : addService
    Created on : Apr 23, 2021, 2:43:56 PM
    Created on : Apr 23, 2021, 12:53:28 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Thêm Dịch Vụ Mới</h1>  

<c:url value="/addService/add" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addService">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
    <div class="form-group">
        <label>Tên dịch vụ</label>
        <form:input cssClass="form-control" path="name" />
    </div>
    <div class="form-group">
        <label for="price">Giá dịch vụ</label>
        <form:input 
            cssClass="form-control" 
            path="unit_price" />
    </div>


    <div>
        <form:hidden path="serviceId" />
        <input type="submit" class="btn btn-success" value="Thêm Dịch Vụ" />
    </div>
</form:form>
