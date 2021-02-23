<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/3/2020
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglib.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="lichsumuahang"  value="/ajax-quanlylichsuvadahuy.html">
    <c:param name="urlType" value="lichsumuahang"/>
    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
</c:url>
<c:url var="dahuy"  value="/ajax-quanlydhchoxacnhan.html">
    <c:param name="urlType" value="huyvalichsu"/>
    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
</c:url>
    <div class="row">
        <h2>Đơn Hàng Đã Hủy và Lịch sử mua hàng</h2>
        <div class="col-3"><button onclick="dahuy()" class=" btn-danger" >Đơn Hàng Đã Hủy</button><button onclick="lichsumuahang()" class="btn-orange"> Lịch Sử Mua Hàng</button></div>
        <div class="blockquote container">

            <div class="row">
                <H2 class="">${messageResponse}</H2>
                <table class="table table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Mã Hóa Đơn</th>
                        <th scope="col">Ngày Mua</th>
                        <th scope="col">Tình trạng</th>
                        <th scope="col">Phương Thức Thanh Toán</th>
                        <th>Tổng hóa đơn</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${listItem.listResult}" var="item">
                    <tr>
                        <td scope="row">${item.id}</td>
                        <td>${item.ngaymua}</td>
                        <td scope="row">${item.tinhtrangDTO.tinhtrang}</td>
                        <c:url value="/ajax-quanlylichsuvadahuy.html" var="chitiethoadon">
                            <c:param name="pojo.id" value="${item.id}"/>
                            <c:param name="urlType" value="chitiethoadon"/>
                            <c:param name="tenkhachhang" value="${Idkhachhang}"/>
                        </c:url>
                        <td><a sc-url="${chitiethoadon}" onclick="chitiethoadon(this)">Xem chi tiết đơn hàng</a></td>
                        <td><fmt:formatNumber value="${item.tongtien}"/> VNĐ </td>
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
        </div>
    </div>
<script>
 function chitiethoadon(i) {
        var url=$(i).attr('sc-url');
        $('#myModal').load(url,'',function () {
                $('#myModal').modal();
        });
 }
 function lichsumuahang() {
     var url='${lichsumuahang}';
    $('#luachon1').load(url);
 }
 function dahuy() {
     var url='${dahuy}';
     $('#luachon1').load(url);
 }
</script>