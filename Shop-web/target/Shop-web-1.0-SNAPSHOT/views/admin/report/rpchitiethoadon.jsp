<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/18/2020
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="<c:url value="/template/adminHome/assets/libs/flot/css/float-chart.css" />" rel="stylesheet">
<div class="container">
    <h2>Thông Tin Đặt Hàng</h2>
    <P>Mã Hóa Đơn     : ${chitiethoadon.hoadonDTO.id}</P>
    <p>Tổng tiền      : <fmt:formatNumber value="${chitiethoadon.hoadonDTO.tongtien} "/>VNĐ</p>
    <p>Tên Khách hàng : ${chitiethoadon.hoadonDTO.khachHangDTO.tenKhachhang}</p>
    <p>Ngày Mua : ${chitiethoadon.hoadonDTO.ngaymua}</p>
    <p>Số điện Thoại : ${chitiethoadon.hoadonDTO.sdt}</p>
    <p>Địa chỉ  : ${chitiethoadon.hoadonDTO.diachigiaohang}</p>
    <table class="table table-cell">
        <thead>
        <tr>

            <th scope="col">Tên Sản Phẩm</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Tiền</th>
            <%--  <th scope="col">Ngày Nhập</th>--%>
        </tr>
        <tbody>
        `  </tr>
        <c:forEach var="item" items="${chitiethoadon.listResult}">
            <tr>
                <td scope="row">${item.sanphamDTO.tensp}</td>
                <td>${item.soluong}</td>
                <td scope="row"><fmt:formatNumber value="${item.giatien}"/> VNĐ</td>
            </tr>
        </c:forEach>

        </tbody>

        </thead>
    </table>
    <hr>
    <h4 class="col-lg-5"> Cảm Ơn Quý Khách Đã Mua Sản phẩm Tại cửa hàng</h4>
    <p> Số điện thoại hỗ trợ : 0399625447</p>
    <p> Đại Chỉ Cửa Hàng :Thôn Phú Trung Đại Hiệp Đại Lộc</p>
</div>

<script>
    $(document).ready(function () {
            window.print();
    })
</script>
