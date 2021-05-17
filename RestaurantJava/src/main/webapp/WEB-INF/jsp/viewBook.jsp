<%-- 
    Document   : viewBook
    Created on : Apr 28, 2021, 9:06:54 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">Đơn Đặt Tiệc</h1>

<form class="mb-5">
    <div class="row">
        <div class="col-md-10 form-group">
            <input type="text" 
                   name="kw" value="${kw}"
                   class="form-control" 
                   placeholder="Nhập từ khoá để tìm..." />
           

        </div>
        <div class="col-md-2">
            <input type="submit" 
                   class="btn btn-secondary"
                   value="Tìm kiếm" />
        </div>
    </div>
</form>

<table class="table" style="font-size: 14px">

    <tr>
        <th>Mã Tiệc</th>
        <th>Khách Hàng</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Dịch vụ</th>
        <th>Sự kiện</th>
        <th>Sảnh</th>
        <th>Ngày tổ chức</th>
        <th>Số lượng khách</th>
        <th>Ghi chú</th>
        <th></th>
    </tr>

    <c:forEach items="${bookDetails}" var="stats">
        <tr id="bookDetail${stats[0]}">
            <td>${stats[0]}</td>
            <td>${stats[1]} </td>
            <td>${stats[2]}</td>
            <td>${stats[3]}</td>
            <td>${stats[4]}</td>
            <td>${stats[5]}</td>
            <td>${stats[6]}</td>
            <td>${stats[7]}</td>
            <td>${stats[8]}</td>
            <td>${stats[9]}</td>

            <td class="text-center"> 
                <a href="<c:url value="/billParty"/>/?bookDetailId=${stats[0]}"  class="btn btn-primary">Thanh Toán</a>
                <a href="javascript:;" class="btn btn-danger" onclick="deleteBookDetail(${stats[0]})">Hủy Đơn</a>
            </td>

        </tr>
    </c:forEach>


</table>
     <script src="<c:url value="/js/main.js" />"></script>

