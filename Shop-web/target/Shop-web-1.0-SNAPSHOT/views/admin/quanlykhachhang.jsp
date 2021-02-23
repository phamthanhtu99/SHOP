<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2020
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<div class="mt-3">
<form method="post" action="/admin-quanlykhachhang">
    <input type="text" name="pojo.tenKhachhang" class="form-control col-3 float-xl-left"
           placeholder="tên khách hàng">
    <input type="text" name="pojo.sdt" class="form-control col-3 float-xl-left"
           placeholder="Số điện Thoại">
    <button class="bg-success sd" type="submit"><i class="fa fa-2 fa-search-plus"></i></button>
</form>
<table class="mt-1 table table-bordered">
    <thead>
    <tr>
        <th>Firstname</th>
        <th>Địa chỉ</th>
        <th>số điện thoại</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listItem.listResult}" var="item">
        <c:url value="/ajax-editnhanvien.html" var="updatenhanvien">
            <c:param name="urlType" value="updatenhanvien"/>
            <c:param name="pojo.id" value="${item.id}"/>
        </c:url>
        <c:url value="/ajax-editnhanvien.html" var="removenhanvien">
            <c:param name="urlType" value="removenhanvien"/>
            <c:param name="pojo.id" value="${item.id}"/>
        </c:url>
        <tr>
            <td>${item.tenKhachhang}</td>
            <td>${item.diaChi}</td>
            <td>${item.sdt}</td>
            <td>${item.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>