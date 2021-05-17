

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error1" /></p>
    </div>    
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        <p><spring:message code="user.login.error2" /></p>
    </div>    
</c:if>
<form:errors path="*" element="div" 
             cssClass="alert alert-danger" />
<spring:url value="/login" var="action" />
<form action="${action}" method="post" >
    <div class="form-group">
        <label for="usernameId">
            <spring:message code="user.username" />
        </label>
        <input name="username" id="usernameId" class="form-control" />
    </div>
    <div class="form-group">
        <label for="passwordId">
            <spring:message code="user.password" />
        </label>
        <input id="passwordId" name="password" 
               class="form-control" type="password" />
    </div>
    <div class="form-group">
        <button class="btn btn-danger" type="submit">
            <spring:message code="user.login" />
        </button>
    </div>
    <small><div class="text-muted">Bạn chưa có tài khoản? <a class="text-secondary ml-2" href="register" >Đăng kí</a></div></small>
</form>
