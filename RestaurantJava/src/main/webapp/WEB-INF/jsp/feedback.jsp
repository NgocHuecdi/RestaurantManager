<%-- 
    Document   : feedback
    Created on : Apr 24, 2021, 9:41:17 PM
    Author     : OS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h1 class="text-center m-3">Phản Hồi Của Khách Hàng</h1>

<c:url value="/feedback" var="action"/>

<ul class="list-unstyled">
    <c:forEach items="${feedback}" var="fb">
        <li class="media border border-secondary rounded p-3 mb-3">
            <div class="media-body">
                <div class="font-weight-bold">${fb[1]}</div> 
                <small><div class="mt-0 mb-1 font-italic">Đăng ngày ${fb[3]}</div></small>
                ${fb[2]}
            </div>
        </li>
    </c:forEach>
</ul>

<a href="<c:url value="/addFeedback" />" class="btn btn-success d-block text-center">Thêm bình luận</a>

