<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/1/2020
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<div class="row">
    <H2 class="">Đơn Hàng</H2>
    <c:if test="${not empty messageResponse}">
        <div class="alert alert-${alert} " >
            <button type="button" class="close" data-dismiss="alert">
                <i class="ace-icon fa fa-times"></i>
            </button>
                ${messageResponse}
        </div>
    </c:if>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Mã Hóa Đơn</th>
            <th scope="col">Ngày Mua</th>
            <th scope="col">Sản Phẩm</th>
            <th scope="col">Tổng Hóa Đơn</th>
            <th scope="col">Phương Thức Thanh Toán</th>
            <th>Thao Tác</th>
        </tr>
        <tbody>
        <c:forEach items="${listItem.listResult}" var="item">
        <tr>
            <td scope="row">${item.id}</td>
            <td><fmt:formatDate value="${item.ngaymua}"/></td>
            <td>

                <c:forEach var="sanpham" items="${item.chitiethoadonDTOS}">
                    <c:url value="/phukien-chitietsanpham.js" var="chitietsanpham">
                        <c:param name="urlType" value="chitietsanpham"/>
                        <c:param name="pojo.id" value="${sanpham.sanphamDTO.id}"/>

                    </c:url>
                    <a href="${chitietsanpham}">${sanpham.sanphamDTO.tensp}</a><br>
                </c:forEach>
            </td>
            <td><fmt:formatNumber value="${item.tongtien}"/> VNĐ </td>
            <td scope="row">${item.tinhtrangDTO.tinhtrang}</td>
            <c:url value="/ajax-quanlydhchoxacnhan.html" var="huydonhang">
                <c:param name="pojo.id" value="${item.id}"/>
                <c:param name="urlType" value="huydonhang"/>
                <c:param name="tenkhachhang" value="${Idkhachhang}"/>
            </c:url>
            <c:url value="/ajax-quanlydhchoxacnhan.html" var="chitiethoadon">
                <c:param name="pojo.id" value="${item.id}"/>
                <c:param name="urlType" value="chitiethoadon"/>
                <c:param name="tenkhachhang" value="${Idkhachhang}"/>
            </c:url>
            <td><button class="btn-success"  sc-url="${chitiethoadon}" onclick="chitiethoadon(this)">Xem chi tiết đơn hàng</button></td>
            <td><button class="btn-github" sc-url="${huydonhang}"  onclick="huydonhang(this)"> Hủy Đơn Hàng</button></td>
        </tr>
        </tbody>

        </c:forEach>
        </thead>
    </table>

</div>
<div class="container">
    <div class="modal fade" id="myModal" role="dialog">

    </div>
</div>

<script>
    $(document).ready(function(){
    });
    function chitiethoadon(i) {
        var url=$(i).attr('sc-url');
            $('#myModal').load(url,'',function () {
                $('#myModal').modal();
        })
    }
    function huydonhang(i) {
        var url=$(i).attr('sc-url');
        $('#luachon1').load(url);
    }
</script>
