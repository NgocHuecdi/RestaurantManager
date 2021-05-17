<%-- 
    Document   : header
    Created on : Apr 7, 2021, 1:05:26 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row bg-info sticky-top">
    <div class="col-md-8">
        <nav class="navbar navbar-expand-sm ">
            <ul class="navbar-nav">

                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/" />">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/employee" />">Nhân Viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/services" />">Dịch Vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="<c:url value="/feedback" />">Phản Hồi</a>
                </li>


                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/bookParty" />">Đặt Tiệc</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/viewBook" />">Đơn Đặt Tiệc   
                        <span class="badge badge-danger">${totalBook}</span>
                    </a>
                </li>
<!--                <li class="nav-item active">
                    <a class="nav-link text-white" href="<c:url value="/statsRe" />">Thống Kê</a>
                </li>-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" data-toggle="dropdown" href="javascript:;" role="button" aria-haspopup="true" aria-expanded="false">Thống Kê</a>
                    <div class="dropdown-menu ">
                        <a class="dropdown-item" href="<c:url value="/statsRe" />">Doanh Thu</a>
                        <a class="dropdown-item"  href="<c:url value="/statsDen" />">Mật Độ Tiệc Cưới</a>       
                    </div>
                </li>

            </ul>
        </nav>
    </div>
    <div class="col-md-4 text-center">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <div style="padding: 8px">
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/login" />">
                        Đăng nhập
                    </a>
                    <a class="nav-link text-white d-inline-block" href="<c:url value="/register" />">
                        Đăng ký
                    </a> 
                </div>

            </c:when>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <a class="nav-link text-white d-inline-block" href="#">
                    ${pageContext.request.userPrincipal.name}
                </a>
                <a class="nav-link text-white d-inline-block" href="<c:url value="/logout" />">
                    Đăng xuất
                </a>
            </c:when>
        </c:choose>
    </div>
</div>


