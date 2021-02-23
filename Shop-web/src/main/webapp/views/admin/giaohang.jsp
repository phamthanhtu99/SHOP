<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/16/2020
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/admin-giaohang.html" var="report">
    <c:param name="urlType" value="report"/>
</c:url>
<div id="132">
    <div class="blockquote container-fluid ">

        <div class="row">
            <H2 class="">Danh Sách chờ Giao Hàng</H2>
            <table class="table table-view">
                <thead>
                <tr>
                    <th scope="col">Mã Hóa Đơn</th>
                    <th scope="col">Ngày Mua</th>
                    <th scope="col">tinh trang</th>
                    <th scope="col">Phương Thức Thanh Toán</th>
                    <th scope="col">Tên khách Hàng</th>
                    <th scope="col">Địa Chỉ Giao Hàng</th>
                    <th>Thao Tác</th>
                </tr>
                <tbody>
                <c:forEach items="${listItem.listResult}" var="item">
                <tr>
                    <td scope="row">${item.id}</td>
                    <td>${item.ngaymua}</td>
                    <td scope="row"><button class="btn-secondary">${item.tinhtrangDTO.tinhtrang}</button></td>
                    <td scope="row"><button class="btn-info">${item.phuongthucthanhtoanDTO.tenphuongthuc}</button></td>
                    <td scope="row">${item.khachHangDTO.tenKhachhang}</td>
                    <td>${item.diachigiaohang}</td>
                    <c:url value="/ajax-giaphang.html" var="chitiethoadon">
                        <c:param name="pojo.id" value="${item.id}"/>
                        <c:param name="urlType" value="chitiethoadon"/>
                    </c:url>
                    <td><button class="btn-success"><a  sc-url="${chitiethoadon}" onclick="chitiethoadon(this)">Xem chi tiết đơn hàng</a></button></td>

                </tr>
                </tbody>

                </c:forEach>
                </thead>
            </table>

        </div>
        <div class="modal fade" id="myModal132" role="dialog">

        </div>

    </div>
    <script>
        $(document).ready(function () {
            $(document.body).removeClass("modal-open");
            $(".modal-backdrop").remove();
        });
        function chitiethoadon(i) {
            var url=$(i).attr('sc-url');
            $('#myModal132').load(url,'',function () {
                $('#myModal132').modal();
            })
        }


    </script>
</div>