<%-- 
    Document   : updateEmp
    Created on : Apr 15, 2021, 4:18:32 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-success m-3">Cập Nhật Nhân Viên</h1>  

<c:url value="/updateEmp/add" var="action" />

<form:form method="post"  action="${action}" modelAttribute="updateEmp">
      <form:errors path="*" element="div" 
                 cssClass="alert alert-danger" />
  
    <div class="form-group">
        <label><spring:message code="updateEmp.name" /></label>
        <form:input cssClass="form-control" path="name" />
    </div>
    <div class="form-group">
        <label><spring:message code="updateEmp.mail" /></label>
        <form:input cssClass="form-control" path="mail" />
    </div>
    <div class="form-group">
        <label><spring:message code="updateEmp.address" /></label>
        <form:input cssClass="form-control" path="address" />
    </div>
    <div class="form-group">
        <label><spring:message code="updateEmp.birth" /></label>
        <form:input type="date" cssClass="form-control" path="birth" placeholder="yyyy/mm/dd"/>
    </div>
    <div class="form-group">
        <label for = "user"><spring:message code="updateEmp.username" /></label>
        
        <form:select path="user" cssClass="form-control" id="user">
            <c:forEach items="${user}" var="u">
                <c:if test="${Integer.parseInt(updateEmp.user) == u.id}">
                    <option value="${u.id}">${u.username}</option>
                </c:if>
            </c:forEach>
        </form:select>
        
    </div>
    <div>
        <form:hidden path="empId" />
        <input type="submit" class="btn btn-success" value="<spring:message code="updateEmp.submit" />" />
    </div>
</form:form>