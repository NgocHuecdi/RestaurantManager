<%-- 
    Document   : addEmp
    Created on : Apr 2, 2021, 3:26:42 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Thêm Nhân Viên Mới</h1>  
<c:url value="/addemp" var="action" />
<form:form method="post"  action="${action}" modelAttribute="addemp">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="addemp.name" /></label>
        <form:input cssClass="form-control" path="name" />
        <form:errors path="name" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="addemp.mail" /></label>
        <form:input cssClass="form-control" path="mail" />
        <form:errors path="mail" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="addemp.address" /></label>
        <form:input cssClass="form-control" path="address" />
        <form:errors path="address" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label><spring:message code="addemp.birth" /></label>
        <form:input type="date" cssClass="form-control" path="birth" placeholder="yyyy/mm/dd"/>
    </div>
    <div class="form-group">
        <label for="user"><spring:message code="addemp.username" /></label>
        <form:select id="user" path="user" cssClass="form-control">
            <c:forEach items="${user}" var="u">
                <c:if test="${u.username == pageContext.request.userPrincipal.name}">
                    <option value="${u.id}">${u.username}</option>
                </c:if>
                
            </c:forEach>
        </form:select>
 
    <div>
        <input type="submit" class="btn btn-success mt-3" value="<spring:message code="addemp.submit" />" />
    </div>
</form:form>