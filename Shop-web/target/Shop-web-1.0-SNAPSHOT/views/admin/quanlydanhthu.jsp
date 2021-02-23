<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/18/2020
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="//cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
<c:url value="/ajax-danhthu.html" var="timkiem">
    <c:param name="urlType" value="timkiem"/>
</c:url>
<div id="thaydoiphieunhap">
    <div class="row col-12 blockquote">
        <div class="col-12">
            <H2>Danh Thu cửa hàng</H2>

            <div class="phai">
                <form action="${timkiem}" method="get" id="formtimkiem">
                    <label class="float-left m-1">Chọn Sản Phẩm:</label>
                    <input type="text" class="form-control col-lg-2 float-left" id="txt_ide" list="ide" name="sanpham"
                           placeholder="Chọn sản phẩm"/>
                    <datalist id="ide">
                        <c:forEach items="${sanpham.sanphamDTOList}" var="item">
                            <option value="${item.id}">${item.tensp}</option>
                        </c:forEach>
                        <option>Lịch sử Tìm Kiếm</option>
                    </datalist>
                    <label class="float-left m-1">Chọn Nhân Viên:</label>
                    <input type="text" class="form-control col-lg-2 float-left" id="txt_ide1" list="ide1"
                           name="idnhanvien"
                           placeholder="Nhập Tên Hoặc Mã"/>
                    <datalist id="ide1">
                        <c:forEach items="${nhanvien.nhanvienDTOS}" var="item">
                            <option value="${item.id}">${item.tennhanvien}</option>
                        </c:forEach>
                        <option>Lịch sử Tìm Kiếm</option>
                    </datalist>
                    <label class="float-left m-1">Mã Hóa Đơn:</label>
                    <input type="text" class="form-control col-lg-2 float-left" id="txt_ide2" list="ide2" name="hoadon"
                           placeholder="Nhập Tên Hoặc Mã"/>
                    <datalist id="ide2">
                        <c:forEach items="${danhsachhoadon.all}" var="item">
                            <option value="${item.id}">${item.id}</option>
                        </c:forEach>
                        <option>Lịch sử Tìm Kiếm</option>
                    </datalist>
                    <div class="row col-8">
                        <label class="float-left">Ngày Đầu:</label>
                        <input type="date" class="form-control col-lg-3 float-left" name="ngaybatday"
                               placeholder="Ngày Bắt đầu"/>
                        <label class="float-left m-1">Ngày Cuối:</label>
                        <input type="date" class="form-control col-lg-3 float-left" name="ngaycuoi"
                               placeholder="Ngày Kết thúc"/>
                    </div>
                    <div class="row col-8 checkcss" >
                        <h4>Chọn tình trạng Đơn hàng</h4>
                        <input type="radio" height="10px" class="" value="7" name="tinhtrang"/> Đã giao <br/>
                        <input type="radio" value="5" name="tinhtrang"/> Đã hủy <br/>
                        <input type="radio" value="6" name="tinhtrang"/> Khách hàng đã hủy <br/>

                    </div>
                    <button onclick="timkiem()">Tìm Kiếm</button>
                    <button  type="reset" >Reset</button>
                </form>

            </div>
            <button id="ex" class="btn-cyan">Xuất File Excel</button>

            <div id="tablesanpham" class="row">

            </div>

        </div>
    </div>
</div>

<c:url value="/ajax-danhthu.html" var="views">
    <c:param name="urlType" value="viewsp"/>
</c:url>
<script>
    $(document).ready(function () {
        $("#ex").click(function () {
            $("#in").table2excel({
                exclude: ".noExl",
                name: "Results",
                filename: "Report",
                fileext: ".xls",
            });
        });
        views();
    });

    function views() {
        var url = '${views}';
        $('#tablesanpham').load(url);
    }

    function timkiem() {
        $('#formtimkiem').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'get',
                url: $(this).attr('action'),
                data: $(this).serialize(),
                datatype: 'html',
                success: function (res) {
                    $('#tablesanpham').html(res);
                },
                function(res) {
                    console.log(res);
                },
            });

        })
    }

/*    document.getElementById("btn1").onclick = function () {
        var checkbox = document.getElementsByName("gender");
        for (var i = 0; i < checkbox.length; i++) {
            if (checkbox[i].checked === true) {
                alert(checkbox[i].value);
            }
        }
    };*/
</script>