<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/5/2020
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <H2 class=""> Đơn Hàng </H2>
        </div>
        <div class="modal-body">
            <lable>Mã Hóa Đơn     : ${chitiethoadon.hoadonDTO.id}</lable>
            <p>Tổng tiền          : <fmt:formatNumber value="${chitiethoadon.hoadonDTO.tongtien} "/>VNĐ</p>
            <p>Tên Khách hàng     : ${chitiethoadon.hoadonDTO.khachHangDTO.tenKhachhang}</p>
            <p>Ngày Mua           : ${chitiethoadon.hoadonDTO.ngaymua}</p>
            <p>Số điện Thoại      : ${chitiethoadon.hoadonDTO.sdt}</p>
            <table class="table table-dark">

                <thead>
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col" colspan="2">Giá tiền</th>
                </tr>
                <c:forEach var="item" items="${chitiethoadon.chitiethoadonDTOS}">
                <tr>
                    <td scope="row">${item.sanphamDTO.tensp}</td>
                    <td>${item.soluong}</td>
                    <td scope="row"><fmt:formatNumber value="${item.giatien}"/> VNĐ</td>
                </tr>
                </c:forEach>
                <tbody>
            </table>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>

</div>