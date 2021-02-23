<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/1/2020
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url var="capnhapttcn"  value="/ajax-capnhatttcn.html">
    <c:param name="urlType" value="capnhatttcn"/>
    <c:param name="pojo.id" value="${Idkhachhang}"/>
</c:url>
<c:url var="hdchuaxn"  value="/ajax-quanlydhchoxacnhan.html">
    <c:param name="urlType" value="hdchuaxacnhan"/>
    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
</c:url>
<c:url var="dahuy"  value="/ajax-quanlydhchoxacnhan.html">
    <c:param name="urlType" value="huyvalichsu"/>
    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
</c:url>
<c:url var="dangcho"  value="/ajax-quanlydhchoxacnhan.html">
    <c:param name="urlType" value="dangcho"/>
    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
</c:url>
<div class="container">
    <div class="row canhan">
        <button class="col-sm-3 nht btn-danger" sc-url="${dangcho}" onclick="luachon(this)"><i class="fa fa-truck">Chờ Giao</i></button>
        <button class="col-sm-3 nht btn-danger" sc-url="${dahuy}" onclick="luachon(this)"><i class="fa fa-remove">Đã Hủy</i></button>
        <button class="col-sm-3 nht btn-danger" sc-url="${hdchuaxn}" onclick="luachon(this)" ><i class="fa fa-th-list">Chờ Xác Nhận</i></button>
        <button class="col-sm-3 nht btn-danger"  sc-url="${capnhapttcn}" onclick="luachon(this)"><i class="fa fa-th-list">Cập nhật thông tin cá nhân</i></button>
    </div>
    <div id="luachon1">
    </div>
</div>



<script>
    $(document).ready(function () {
            luachon();
    })
    function luachon(i) {
        var url=$(i).attr('sc-url');
        if (typeof url == 'undefined'){
            url ='${capnhapttcn}';
        }

        $('#luachon1').load(url);
    }
</script>