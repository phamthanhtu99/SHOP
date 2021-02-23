<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/10/2020
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<div class="blockquote container-fluid ">
    <H2 class="">Đơn Hàng</H2>
    <form method="post" action="/admin-quanlythongtindonhang.html" class="m-1">
        <input type="text" name="hoadon" class="form-control col-3 float-xl-left"
               placeholder="Mã Hóa Đơn">
        <input type="date" name="ngaybatday" class="form-control col-3 float-xl-left"
               placeholder="Ngày Bắt đầu">
        <input type="date" name="ngaycuoi" class="form-control col-2 float-xl-left"
               placeholder="Ngày kết thúc">
        <input type="text" name="idnhanvien" class="form-control col-3 float-xl-left"
               placeholder="id nhân viên">
        <button class="bg-success sd" type="submit"><i class="fa fa-2 fa-search-plus"></i></button>
    </form>
    <div class="row">

        <div class="col-9">
            <table class="table tree-table-row-cell ">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Mã Hóa đơn</th>
                    <th scope="col">tinh trang</th>
                    <th scope="col">Phương Thức Thanh Toán</th>
                    <th scope="col">Tên khách Hàng</th>
                    <th scope="col">Địa Chỉ Giao Hàng</th>
                    <th scope="col">Ngày Mua</th>
                    <th scope="col">Tên Nhân Viên</th>
                    <th>Tông tiền Hóa Đơn</th>
                </tr>
                <tbody>
                <c:set var="salary" scope="session" value="đã Giao"/>
                <c:set var="salary1" scope="session" value="Khách hàng đã hủy"/>
                <c:set var="tongtien" value="${0}"/>
                <c:set var="tongtiendathu" value="${0}"/>
                <c:set var="tongtiendahuy" value="${0}"/>

                <c:set var="tonghoadon" value="${0}"/>
                <c:set var="sohoadondanhan" value="${0}"/>
                <c:set var="sohoadondahuy" value="${0}"/>

                <c:forEach items="${listItem.listResult}" var="item">
                <c:set var="tonghoadon" value="${tonghoadon + 1}"/>
                <c:set var="tongtien" value="${item.hoadonDTO.tongtien + tongtien}"/>


                <c:if test="${item.hoadonDTO.tinhtrangDTO.tinhtrang ==salary}">
                    <c:set var="tongtiendathu" value="${item.hoadonDTO.tongtien + tongtiendathu}"/>
                    <c:set var="sohoadondanhan" value="${sohoadondanhan+1}"/>
                </c:if>

                <c:if test="${item.hoadonDTO.tinhtrangDTO.tinhtrang ==salary1}">
                    <c:set var="tongtiendahuy" value="${item.hoadonDTO.tongtien + tongtiendathu}"/>
                    <c:set var="sohoadondahuy" value="${sohoadondahuy + 1}"/>
                </c:if>
                <tr>
                    <td scope="row">${item.id}</td>
                    <td>${item.hoadonDTO.id}</td>
                    <td scope="row">
                        <button class="btn-secondary">${item.hoadonDTO.tinhtrangDTO.tinhtrang}</button>
                    </td>
                    <td scope="row">
                        <button class="btn-info">${item.hoadonDTO.phuongthucthanhtoanDTO.tenphuongthuc}</button>
                    </td>
                    <td scope="row">${item.hoadonDTO.khachHangDTO.tenKhachhang}</td>
                    <td>${item.hoadonDTO.diachigiaohang}</td>
                    <td>${item.hoadonDTO.ngaymua}</td>
                    <td>${item.nhanvienDTO.tennhanvien}</td>
                    <c:url value="/ajax-quanlidonhang.html" var="chitiethoadon">
                        <c:param name="pojo.id" value="${item.id}"/>
                        <c:param name="urlType" value="chitiethoadon"/>
                    </c:url>
                    <td><p class="btn-primary"><fmt:formatNumber value="${item.hoadonDTO.tongtien}"/> VNĐ</p></td>
                </tr>
                </tbody>
                </c:forEach>

                </thead>
            </table>
        </div>
        <div class="col-3">
            <div class="row m-4 ">
                <label with="100px" class="btn-primary"> Tổng Tiền Đã Bán: <fmt:formatNumber value="${tongtien}"/> VNĐ
                    || Số hóa đơn :${tonghoadon}</label><br>
            </div>
            <div class="row m-4 ">
                <label with="100px" class="btn-success">Tổng Tiền Đã Thu: <fmt:formatNumber value="${tongtiendathu}"/>
                    VNĐ || Số hóa đơn :${sohoadondanhan}</label> </label>
            </div>
            <div class="row m-4" >
                <label with="100px" class="btn-orange">Tổng Tiền Đã Mà Khách Hàng Đã Hủy: <fmt:formatNumber
                        value="${tongtiendahuy}"/> VND || Số hóa đơn :${sohoadondahuy}</label> </label>
            </div>

        </div>
    </div>
</div>