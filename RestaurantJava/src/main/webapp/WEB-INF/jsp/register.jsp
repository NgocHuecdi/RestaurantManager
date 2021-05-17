

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-uppercase text-success">
    <spring:message code="user.register" />
</h1>
<spring:url value="/register" var="action" />
<form:form action="${action}" modelAttribute="user" method="post" >
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    <div class="form-group">
        <label for="usernameId">
            <spring:message code="user.username" />
        </label>
        <form:input path="username" id="usernameId" cssClass="form-control" />
        <form:errors path="username" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            <spring:message code="user.password" />
        </label>
        <form:input id="passwordId" path="password" 
                    cssClass="form-control" type="password" />
        <form:errors path="password" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="confirmPasswordId">
            <spring:message code="user.confirmPassword" />
        </label>
        <form:input id="confirmPasswordId" path="confirmPassword" 
                    cssClass="form-control" type="password" />
        <form:errors path="confirmPassword" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <form:button class="btn btn-danger">
            <spring:message code="user.register" />
        </form:button>
    </div>
</form:form>