<%-- 
    Document   : customerInfo
    Created on : May 10, 2021, 11:56:49 PM
    Author     : OS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Điền thông tin vào form</h1>  
<c:url value="/customerInfo/submit" var="action" />
<form:form method="post"  action="${action}" modelAttribute="customerInfo">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />

    <div class="form-group">
        <label><spring:message code="cus.name" /></label>
        <form:input cssClass="form-control" path="name" />
        <form:errors path="name" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="cus.phone" /></label>
        <form:input cssClass="form-control" path="phone" />
        <form:errors path="phone" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="cus.address" /></label>
        <form:input cssClass="form-control" path="address" />
        <form:errors path="address" cssClass="text-danger" />
    </div>


    <div class="form-group">
        <label for="user"><spring:message code="cus.username" /></label>
        <form:select path="user" cssClass="form-control">
            <c:forEach items="${user}" var="u">
                <c:if test="${u.username == pageContext.request.userPrincipal.name}">
                    <div id="user${u.id}">
                        <option value="${u.id}">${u.username}</option>
                    </div>
                </c:if>
            </c:forEach>
        </form:select>
    </div>

    <div>
        <input type="submit" class="btn btn-success" value="<spring:message code="cus.submit" />" />
    </div>
</form:form>