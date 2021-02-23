<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/4/2020
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/taglib.jsp" %>
<div class="blockquote container">

    <div class="row">
        <H2 class="">Đơn Hàng</H2>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Mã Hóa Đơn</th>
                <th scope="col">Ngày Mua</th>
                <th scope="col">Phương Thức Thanh Toán</th>
                <th>Thao Tác</th>
            </tr>
            <tbody>
            <c:forEach items="${danhsachhoadon.hoadonDTOS}" var="item">
            <tr>
                <td scope="row">${item.id}</td>
                <td>${item.ngaymua}</td>
                <td scope="row">${item.tinhtrangDTO.tinhtrang}</td>
                <c:url value="/ajax-thanhtoanhoadon.html" var="chitiethoadon">
                    <c:param name="pojo.id" value="${item.id}"/>
                    <c:param name="urlType" value="chitiethoadon"/>
                    <c:param name="tenkhachhang" value="${Idkhachhang}"/>
                </c:url>
                <c:url value="/phukien-thanhtoanhoadon.html" var="huydonhang">
                    <c:param name="pojo.id" value="${item.id}"/>
                    <c:param name="urlType" value="huydonhang"/>
                </c:url>
                <c:url value="/phukien-thanhtoanhoadon.html" var="datlaidonhang">
                    <c:param name="pojo.id" value="${item.id}"/>
                    <c:param name="urlType" value="datlai"/>
                </c:url>
                <td><a sc-url="${chitiethoadon}" onclick="chitiethoadon(this)">Xem chi tiết đơn hàng</a></td>
                <c:set var="salary" scope="session" value="Chờ Xác Nhận"/>
                <c:set var="salary1" scope="session" value="đã hủy"/>
                <c:if test="${item.tinhtrangDTO.tinhtrang ==salary1}">
                    <td><a href="${datlaidonhang}">Đặt Lại</a></td>
                </c:if>
                <c:if test="${item.tinhtrangDTO.tinhtrang ==salary}">
                    <td><a href="${huydonhang}"> Hủy Đơn Hàng</a></td>
                </c:if>
            </tr>
            </tbody>

            </c:forEach>
            </thead>
        </table>

    </div>
    <div class="row" id="ct">

    </div>
</div>
<script>
    function chitiethoadon(i) {
        var url = $(i).attr('sc-url');
        $.ajax({
            type: 'GET',
            url: url,
            data: $(this).serialize(),
            datatype: 'html',
            success: function (res) {
                $('#ct').html(res)
            },
            error: function (res) {
                console.log(res);
            }
        });
    }
</script>