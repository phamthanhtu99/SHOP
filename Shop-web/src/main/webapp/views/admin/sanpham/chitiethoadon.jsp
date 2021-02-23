<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div class="modal-dialog chinh ">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title"> Đơn Hàng</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <P>Mã Hóa Đơn     : ${chitiethoadon.hoadonDTO.id}</P>
        <p>Tổng tiền      : <fmt:formatNumber value="${chitiethoadon.hoadonDTO.tongtien} "/>VNĐ</p>
        <p>Tên Khách hàng : ${chitiethoadon.hoadonDTO.khachHangDTO.tenKhachhang}</p>
        <p>Ngày Mua : ${chitiethoadon.hoadonDTO.ngaymua}</p>
        <p>Số điện Thoại : ${chitiethoadon.hoadonDTO.sdt}</p>
        <p>Địa chỉ  : ${chitiethoadon.hoadonDTO.diachigiaohang}</p>
        <c:url value="/ajax-quanlidonhang.html" var="nhandonhang">
            <c:param name="pojo.id" value="${chitiethoadon.hoadonDTO.id}"/>
            <c:param name="urlType" value="nhandonhang"/>
        </c:url>
        <c:url value="/ajax-quanlidonhang.html" var="huydonhang">
            <c:param name="pojo.id" value="${chitiethoadon.hoadonDTO.id}"/>
            <c:param name="urlType" value="huydonhang"/>
        </c:url>
        <div class="modal-body">
            <table class="table table-dark">
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
        </div>

        <div class="modal-footer">
            <button type="button" onclick="nhandonhang()" id="nhandonhang" class="btn  btn-danger" data-dismiss="modal">Nhân Đơn Hàng</button>
            <button type="button" onclick="huydonhang()" id="huydonhang" class="btn  btn-danger" data-dismiss="modal">Hủy Đơn Hàng</button>

            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
<script>
    function nhandonhang() {
        var url ='${nhandonhang}';
        $.ajax({
            type: 'Get',
            url:url,
            data: $(this).serialize(),
            datatype: 'html',
            success :  function (res) {
                $('#12').html(res);
                alert("thành công")
            },
            function (res) {
                console.log(res);
            },
        });

    }

    function huydonhang() {
        var url ='${huydonhang}';
        $.ajax({
            type: 'Get',
            url:url,
            data: $(this).serialize(),
            datatype: 'html',
            success :  function (res) {
                $('#12').html(res);
                alert("thành công")
            },
            function (res) {
                console.log(res);
            },
        });

    }
</script>