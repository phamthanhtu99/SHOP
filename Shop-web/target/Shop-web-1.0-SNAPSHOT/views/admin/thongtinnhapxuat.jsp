<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/30/2020
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<div id="12">
<div class=" blockquote tt">
    <H2 class="">Thông tin Nhập hàng</H2>
    <form method="get" action="/admin-thanhtoanphieunhap.html" class="m-1">
        <input type="text" name="idhoadon" class="form-control col-3 float-xl-left"
               placeholder="Mã Nhập">
        <input type="date" name="ngaydau" class="form-control col-3 float-xl-left"
               placeholder="Ngày Bắt đầu">
        <input type="date" name="ngaycuoi" class="form-control col-2 float-xl-left"
               placeholder="Ngày kết thúc">
        <button class="bg-success sd" type="submit"><i class="fa fa-2 fa-search-plus"></i></button>
    </form>
</div>
<div class="modal fade" id="myModal13" role="dialog">
</div>
    <table id="table_id" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th scope="col">MaNhap</th>
            <th scope="col">Tên Người Nhập</th>
            <th scope="col">Nhà sản Xuất</th>
            <th scope="col">Ghi chú</th>
            <th scope="col">Ngày Nhập</th>
            <th>    </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listItem.phieunhapDTOList}" var="item">
        <tr>
            <th scope="row">${item.id}</th>
            <td>${item.nguoinhap}</td>
            <th scope="row">${item.nhasanxuatEntity.tennhasanxuat}</th>
            <td>${item.ghichu}</td>

            <td>${item.date}</td>
            <c:url value="/ajax-thanhtoanphieunhap.html" var="thongtinphieunhap">
                <c:param name="urlType" value="thongtinphieunhap"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <c:url value="/report-phieunhap.html" var="inhoadon">
                <c:param name="urlType" value="inhoadon"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <td>
                <button class="btn-facebook float-left ml-2" sc-url="${thongtinphieunhap}" onclick="chitietphieunhap(this)">Chi tiết phiếu nhập</button>
                <button class="btn-orange" onclick="window.open('${inhoadon}')">IN HÓA ĐƠN NHẬP</button>
            </td >
        </tr>

        </c:forEach>
        </tbody>
    </table>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script>
        $('#table_id').DataTable();

        function chitietphieunhap(i) {
                var url= $(i).attr('sc-url');
            $('#myModal13').load(url,'',function () {
                $('#myModal13').modal();
            })
        }

</script>
</div>