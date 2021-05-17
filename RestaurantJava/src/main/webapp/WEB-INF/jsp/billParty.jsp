<%-- 
    Document   : billParty
    Created on : May 10, 2021, 1:14:55 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1 class="text-center text-danger">Thanh Toán</h1>
<c:url value="/billParty/add" var="action" />
<form:form method="POST" 
           action="${action}" 
           modelAttribute="billParty">

    <div class="form-group">
        <label for="">Tên Nhân Viên</label>   
        <form:select path="employee" cssClass="form-control">
            <c:forEach items="${employees}" var="emp">
                <option value="${emp[0]}">${emp[2]}</option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-group">
        <label for="">Tên Khách Hàng</label>  
        <c:forEach items="${bookDetails}" var="stats">
            <c:if test = "${stats[0] == bookDetail.id}">
                <form:select path="customer" cssClass="form-control">
                    <c:forEach items="${customer}" var="cus">
                        <c:if test="${cus[2] == stats[1]}">
                        <div id="bookDetail${stats[0]}">
                            <option value="${cus[0]}">${stats[1]}</option>
                        </div>
                    </c:if>
                    </c:forEach>
                </form:select>
            </c:if>
        </c:forEach>
    </div>
    
    
    <div class="form-group">
        <label for="service">Dịch vụ</label>
        <c:forEach items="${bookDetails}" var="stats">
            <c:if test = "${stats[0] == bookDetail.id}">
                <form:select path="services" cssClass="form-control">
                    <c:forEach items="${services}" var="ser">
                        <c:if test="${ser.name == stats[4]}">
                        <div id="bookDetail${stats[0]}">
                            <option value="${ser.serviceId}">${stats[4]}</option>
                        </div>
                    </c:if>
                    </c:forEach>
                </form:select>
            </c:if>
        </c:forEach>
    </div>
    <div class="form-group">
        <label for="event">Sự kiện</label>
       <c:forEach items="${bookDetails}" var="stats">
            <c:if test = "${stats[0] == bookDetail.id}">
                <form:select path="event" cssClass="form-control">
                    <c:forEach items="${event}" var="evt">
                        <c:if test="${evt.name == stats[5]}">
                        <div id="bookDetail${stats[0]}">
                            <option value="${evt.eventId}">${stats[5]}</option>
                        </div>
                    </c:if>
                    </c:forEach>
                </form:select>
            </c:if>
        </c:forEach>
    </div>
    <div class="form-group">
        <label for="hall">Sảnh</label>
       <c:forEach items="${bookDetails}" var="stats">
            <c:if test = "${stats[0] == bookDetail.id}">
                <form:select path="hall" cssClass="form-control">
                    <c:forEach items="${hall}" var="hal">
                        <c:if test="${hal.name == stats[6]}">
                        <div id="bookDetail${stats[0]}">
                            <option value="${hal.hallId}">${stats[6]}</option>
                        </div>
                    </c:if>
                    </c:forEach>
                </form:select>
            </c:if>
        </c:forEach>

    </div>
    <div class="form-group">
        <label for="">Ngày Trả</label>
        <form:input cssClass="form-control" path="datePay" type = "date" />
    </div>
    <div class="form-group">
        <label for="">Đơn Đặt</label>

        <c:forEach items="${bookDetails}" var="stats">
            <c:if test = "${stats[0] == bookDetail.id}">
                <div id="bookDetail${stats[0]}">
                    <form:input cssClass="form-control" path="bookDetail.id" value = "${stats[0]}"/>  
                </div>
            </c:if>
        </c:forEach>

    </div>
    <div class="form-group">
        <form:hidden path="billId" />
        <input type="submit" value="Thanh toán" 
               class="btn btn-danger" onclick="deleteBookParty(${bookDetail.id})"/>
    </div>
</form:form>

<script src="<c:url value="/js/main.js" />"></script>
