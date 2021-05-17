<%-- 
    Document   : 
    Created on : Mar 31, 2021, 7:20:24 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="<c:url value="/css/employee.css"/>"
              rel="stylesheet" />
    </head>
    <body>
        <h1 class="text-center mt-3 mb-5">Danh Sách Nhân Viên</h1>

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
        <a href="<c:url value="/addemp" />" class="btn btn-success">Thêm nhân viên mới</a> 
        <table border="1" class = "table table-striped table-responsive-md mt-3">
            <thead>
                <tr>
                    <th class="text-center">
                        Mã Nhân Viên
                    </th>
                    <th class="text-center">
                        Tên
                    </th>
                    <th class="text-center">
                        Email
                    </th>
                    <th class="text-center">
                        Địa Chỉ
                    </th>
                    <th class="text-center">
                        Ngày Sinh
                    </th>
                    <th class="text-center">
                        Chỉnh sửa
                    </th>
                    
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${employees}" var = "emp">
                    <tr id="employee${emp[0]}">
                        <td>${emp[0]}</td>
                        <td>${emp[2]}</td>
                        <td>${emp[3]}</td>
                        <td>${emp[4]}</td>
                        <td>${emp[5]}</td>
                        <td class="text-center"> 
                            <a href="<c:url value="/updateEmp" />/?empId=${emp[0]}"  class="btn btn-primary">Cập Nhật</a>
                            <a href="javascript:;" class="btn btn-danger" onclick="deleteEmployee(${emp[0]})">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <script src="<c:url value="/js/main.js" />"></script>
    </body>
</html>





