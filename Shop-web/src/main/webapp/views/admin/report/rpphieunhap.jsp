<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/21/2020
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Hóa đơn Phiếu nhập</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/template/adminHome/assets/libs/flot/css/float-chart.css" />" rel="stylesheet">
</head>
<body class="container">
        <div class="-address-book ">
            <h2 class="text-center">Hóa Đơn Nhập</h2>
            <P>Mã Hóa Đơn     : ${item.phieunhapDTO.id}</P>

            <p>Tên Nhà Sản Xuất : ${item.phieunhapDTO.nhasanxuatEntity.tennhasanxuat}</p>
            <p>Người Nhập : ${item.phieunhapDTO.nguoinhap}</p>
            <p>Số điện Thoại : ${item.phieunhapDTO.ghichu}</p>
        </div>
        <table class="table table-cell">
            <thead>
            <tr>

                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Số Lượng</th>
                <th scope="col">Tiền</th>
                <%--  <th scope="col">Ngày Nhập</th>--%>
            </tr>
            <tbody>

            </tr>
            <c:set var="tonghoadon" value="${0}"/>
            <c:forEach var="item" items="${chitietphieunhap.chitietphieunhapDTOS}">
                <tr>
                    <td scope="row">${item.sanphamDTO.tensp}</td>
                    <td>${item.soluong}</td>
                    <c:set var="tonghoadon" value="${item.thanhtien + tonghoadon}"/>
                    <td scope="row"><fmt:formatNumber value="${item.thanhtien}"/> VNĐ</td>
                </tr>
            </c:forEach>

            </tbody>

            </thead>
        </table>
        <h4>Tông Tiền :<fmt:formatNumber value="${tonghoadon}"/> VNĐ</h4>
        <script>
            $(document).ready(function () {
                window.print();
            })
        </script>

</body>
</html>
