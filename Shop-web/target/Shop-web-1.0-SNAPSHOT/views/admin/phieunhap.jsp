<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/28/2020
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/ajax-phieunhap.html" var="nhapsoluong">
    <c:param name="urlType" value="nhapsoluong"/>
</c:url>
<c:url value="/ajax-phieunhap.html" var="themsanphamvaophieunhap">
    <c:param name="urlType" value="themsanphamvaophieunhap"></c:param>
</c:url>
<c:url value="/admin-thanhtoanphieunhap.html" var="thanhtoan">

</c:url>
<div id="thaydoiphieunhap">
    <div class="row col-12 blockquote">
        <div class="col-9 ">
            <H2>Phiếu Nhập</H2>

            <div class="phai">
                <form action="${thanhtoan}" method="post" id="formthanhtoan">
                    <label class="float-left m-1">Chọn Sản Phẩm:</label>
                    <input type="text" class="form-control col-lg-2 float-left" id="txt_ide" list="ide" name="pojo.id"
                           placeholder="Chọn sản phẩm"/>
                    <datalist id="ide">
                        <c:forEach items="${sanpham.sanphamDTOList}" var="item">
                            <option value="${item.id}">${item.tensp}</option>
                        </c:forEach>
                        <option>Lịch sử Tìm Kiếm</option>
                    </datalist>
                </form>
                <button class="bg-success sd" id="tu"onclick="themsppn(this)"><i
                        class="fa fa-2 fa-search-plus">Thêm sản
                    Phẩm</i></button>
            </div>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Tên Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Giá Tiền</th>
                    <th>Tông Giá Tiền</th>
                    <th>Thao Tác</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="tongtien" value="${0}"/>
                <c:forEach items="${addspphieunhap}" var="item">
                    <tr>
                    <c:forEach items="${item.list}" var="enty">
                        <tr onload="chuyentien(this)">
                            <td>${enty.key.tensp} <br> ${enty.key.id}</td>
                            <td>${enty.value}</td>
                            <td id="${enty.key.id}"><fmt:formatNumber maxFractionDigits="3" value="${item.giaotien}"
                                                                      type="number"/> VND
                            </td>
                            <td id="${enty.key.id}"><fmt:formatNumber maxFractionDigits="3"
                                                                      value="${item.giaotien*enty.value}" type="number"/>
                                VND
                            </td>
                            <c:url value="/ajax-phieunhap.html" var="xoasp">
                                <c:param name="urlType" value="xoasp"/>
                                <c:param name="id" value="${enty.key.id}"/>
                                <c:param name="tongtien" value="${item.giaotien}"/>
                            </c:url>
                            <c:set value="${tongtien+item.giaotien*enty.value}" var="tongtien"/>
                            <td>
                                <a><i class="fas fa-user-times ht" sc-url="${xoasp}" onclick="removesppn(this)"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>


        <%-- -----------thanh toán -------------------------------%>
        <div class="col-3">
            <div class="row col-12">
                <h4 class="h2-t text-center border-bottom-0  mt-5">Thông Tín Hóa Đơn</h4>
                <form action="${thanhtoan}" method="post" id="formthantoan">
                    <div class="modal-body">
                        <label>Mã Hóa Đơn : Hệ thống tự đông sinh</label>
                        <label>Tên Người Nhập : ${nhanvienquanly} </label><br>
                        <input type="hidden" name="pojo.nguoinhap" value="${nhanvienquanly}">
                        <label>Ngày Nhập :</label><input class="form-control" name="pojo.date" type="date" required>
                        <label>Ghi Chú :</label><input class="form-control" name="pojo.ghichu" type="text"
                                                       placeholder="Địa chỉ" required>
                        <select class="form-control  col-4 mt-1 float-xl-left" name="nhasanxuat">
                            <c:forEach var="item" items="${nhasanxuat.nhasanxuatDTOS}">
                                <a>
                                    <option value="${item.id}">${item.tennhasanxuat}</option>
                                </a>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="pojo.tongtien" value="${tongtien}">
                    </div>
                    <button type="submit"  class="hnf btn  btn-danger" data-dismiss="modal">Thanh Toán</button>
                </form>
            </div>
            <div class="row modal-body">
                <h4 class="">Hình thức Thanh toán:</h4>
                <label style="width: 100%;">Hình thức thanh toán : Hệ thống tự đông sinh</label>
                <p></p>
                <label style="width: 100%;">Tiền Thuế :</label>
                <label style="width: 100%;">Tổng Tiền : <fmt:formatNumber value="${tongtien}"/>
                    <VNĐ></VNĐ>
                </label>
            </div>

        </div>

    </div>
    <div class="modal fade" id="myModal2" role="dialog">

    </div>

    <script>


        function removesppn(i) {
            var url = $(i).attr('sc-url');
            $.ajax({
                type: 'POST',
                url: url,
                data: $(this).serialize(),
                datatype: 'html',
                success: function (res) {
                    $('#thaydoiphieunhap').html(res);
                },
                error: function (res) {
                    console.log(res);
                }
            });
        }

        function themsppn(i) {
            var sanpham = '&pojo.id=' + $('#txt_ide').val();
            var url = '${nhapsoluong}' + sanpham;
            $('#myModal2').load(url, '', function () {
                $('#myModal2').modal();
                themsanpham();
            });

            function themsanpham() {
                $('#btbthemsanpham').click(function () {
                    $('#nhapsl').submit();
                });
                $('#nhapsl').submit(function (e) {
                    e.preventDefault();
                    $.ajax({
                        type: 'POST',
                        url: $(this).attr('action'),
                        data: $(this).serialize(),
                        datatype: 'html',
                        success: function (res) {
                            $('#thaydoiphieunhap').html(res);
                        },
                        function(res) {
                            console.log(res);
                        },
                    });
                })
            }
        }

        $(document).ready(function () {
            $(document.body).removeClass("modal-open");
            $(".modal-backdrop").remove();
            $("#tu").prop('disabled', true);
            $('#txt_ide').change(function () {
                    if ($('#txt_ide').val() != "") {
                        $("#tu").prop('disabled', false);
                    }
                }
            )
        });
    </script>
</div>