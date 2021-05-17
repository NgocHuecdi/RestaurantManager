<%-- 
    Document   : addFeedback
    Created on : Apr 27, 2021, 6:11:02 PM
    Author     : OS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1 class="text-center text-success m-3">Thêm Bình Luận</h1>  
<a href="<c:url value="/customerInfo"/>">Bạn chưa là thành viên?</a>
<br/>

<c:url value="/addFeedback/add" var="action" />

<form:form method="post"  action="${action}" modelAttribute="addFeedback" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
        <label><spring:message code="addfb.name" /></label>
        <form:select path="customer" cssClass="form-control">
            <c:forEach items="${customer}" var="cus">
                <c:if test="${cus[1] == pageContext.request.userPrincipal.name}">
                    <option value="${cus[0]}">${cus[2]}</option>
                </c:if>
            </c:forEach>
        </form:select>
    </div>


    <div class="form-group">
        <label><spring:message code="addfb.date" /></label>
        <fieldset disabled>
            <form:input type="date" cssClass="form-control" path="date" placeholder="yyyy/mm/dd"/>
        </fieldset>
    </div>

    <div class="form-group">
        <label><spring:message code="addfb.description" /></label>
        <form:textarea  path="description" 
                        cssClass="form-control" />
        <form:errors path="description" cssClass="text-danger" />
    </div>
    <div class="form-group text-right">
        <input type="submit" class="btn btn-success" value="<spring:message code="addfb.submit" />" />
    </div>
</form:form>

