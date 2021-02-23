<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/31/2020
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<div class="col-sm-10">
  <table class="table -table-tennis" id="in">
                <thead>
                <tr>
                    <th scope="col">Mã Hóa Đơn</th>
                    <th scope="col">Ngày Mua</th>
                    <th scope="col">Tình Trạng</th>
                    <th scope="col">Phương Thức Thanh Toán</th>
                    <th scope="col">Tên khách Hàng</th>
                    <th scope="col">Tên Nhân Viên</th>
                    <th scope="col">Địa Chỉ Giao Hàng</th>
                    <th scope="col">Sản phẩm</th>
                    <th>Tổng Hóa Đơn</th>
                </tr>
                <tbody>
                <c:set var="tongtiendathu" value="${0}"/>
                <c:forEach items="${listItem.listResult}" var="item">
                <tr>
                    <td>${item.hoadonDTO.id}</td>
                    <td>${item.hoadonDTO.ngaymua}</td>

                    <td scope="row">
                        <button class="btn-secondary">${item.hoadonDTO.tinhtrangDTO.tinhtrang}</button>
                    </td>
                    <td scope="row">
                        <button class="btn-info">${item.hoadonDTO.phuongthucthanhtoanDTO.tenphuongthuc}</button>
                    </td>
                    <td scope="row">${item.hoadonDTO.khachHangDTO.tenKhachhang}</td>
                    <td>${item.nhanvienDTO.tennhanvien}</td>
                    <td>${item.hoadonDTO.diachigiaohang}</td>

                    <c:set var="stt" value="0"/>
                    <td>
                        <c:forEach var="sanpham" items="${item.hoadonDTO.chitiethoadonDTOS}">
                            <c:set value="${stt + 1}" var="stt"/>
                            <a>${stt}: ${sanpham.sanphamDTO.tensp}</a><br>
                        </c:forEach>
                    </td>
                    <c:set var="tongtiendathu" value="${item.hoadonDTO.tongtien+tongtiendathu }"/>
                    <td><fmt:formatNumber value="${item.hoadonDTO.tongtien}"/> VNĐ</td>
                </tr>
                </c:forEach>

            <td>  <p class="btn-success">
                Tổng Danh thu: <fmt:formatNumber value="${tongtiendathu}"/> VNĐ
            </p></td>
                </tbody>


                </thead>
            </table>
            </table>
        </div>
</div>
<div class="col-sm-2">
    <H3>Thông Kê Danh Thu</H3>
    <div>
        <p class="btn-success">
            Tổng Danh thu: <fmt:formatNumber value="${tongtiendathu}"/> VNĐ
        </p>
    </div>
</div>
<div class="container">
    <div class="modal fade" id="myModal2" role="dialog">
        <div class="modal-dialog"></div>
    </div>
</div>
