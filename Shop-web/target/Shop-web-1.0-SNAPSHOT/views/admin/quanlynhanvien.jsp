<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2020
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/ajax-editnhanvien.html" var="hienthithemnhanvien">
    <c:param name="urlType" value="themnhanvien"/>
</c:url>
<c:url value="/ajax-editnhanvien.html" var="themnhanvien">
    <c:param name="urlType" value="themnhanvien"/>
</c:url>
<div id="thaydoinhanvien">
<div class="col-12 blockquote">
    <H2>Quản Lý Nhân Viên</H2>
    <div>
        <button class="chinh" onclick="addnhanvien(this)"><i id="myBtn" class="fa fa-2x fa-address-card">Thêm Nhân
            Viên</i>
        </button>
    </div>
    <div class="phai">
        <form method="post" action="">
            <input type="text" name="pojo.tennhanvien" class="form-control col-3 float-xl-left"
                   placeholder="tên nhân viên">
            <select class="form-control  col-3 float-xl-left" name="">
                <c:forEach var="item" items="${chucvu.chucvuDTOS}">
                    <option value="${item.id}">${item.tenChucVu}</option>
                </c:forEach>
            </select>
            <button class="bg-success sd" type="submit"><i class="fa fa-2 fa-search-plus"></i></button>
        </form>
    </div>
    <table class="table table-view">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Địa chỉ</th>
            <th>số điện thoại</th>
            <th>Email</th>
            <th>Chức vụ</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listItem.nhanvienDTOS}" var="item">
            <c:url value="/ajax-editnhanvien.html" var="updatenhanvien">
                <c:param name="urlType" value="updatenhanvien"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <c:url value="/ajax-editnhanvien.html" var="removenhanvien">
                <c:param name="urlType" value="removenhanvien"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <tr>
                <td>${item.tennhanvien}</td>
                <td>${item.diachi}</td>
                <td>${item.sdt}</td>
                <td>${item.email}</td>
                <td>${item.chucvuEntity.tenChucVu}</td>
                <td>
                    <BUTTON class="btn-orange" sc-url="${removenhanvien}" onclick="remove(this)" > XÓA </BUTTON>
                    <BUTTON class="bg-success" sc-url="${updatenhanvien}" onclick="updatenhanvien(this)" >CẬP NHẬT</BUTTON>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    <div class="modal fade" id="myModal1" role="dialog">

    </div>



<!-- Modal -->



<script>
    $(document).ready(function () {
        $(document.body).removeClass("modal-open");
        $(".modal-backdrop").remove();
    });

    function addnhanvien(i) {
        var url = '${hienthithemnhanvien}';
        $('#myModal1').load(url, '', function () {
            $('#myModal1').modal();
            themnhanvien();
        });
        function themnhanvien() {
            $('#btnaddnv').click(function () {
                $('#formaddnv').submit();
            });
            $('#formaddnv').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    datatype: 'html',
                    success: function (res) {
                        $('#thaydoinhanvien').html(res);
                    },
                    function(res) {
                        console.log(res);
                    },
                });
            })
        }

    }
    function updatenhanvien(i) {
        var url=$(i).attr('sc-url');
        $('#myModal1').load(url, '', function () {
            $('#myModal1').modal();
            themnhanvien();
        });
        function themnhanvien() {
            $('#btnaddnv').click(function () {
                $('#formaddnv').submit();
            });
            $('#formaddnv').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    datatype: 'html',
                    success: function (res) {
                        $('#thaydoinhanvien').html(res);
                    },
                    function(res) {
                        console.log(res);
                    },
                });
            })
        }
    }
    function remove(i) {
            var url=$(i).attr('sc-url');
        $.ajax({
            type: 'POST',
            url: url,
            data: $(this).serialize(),
            datatype: 'html',
            success: function (res) {
                $('#thaydoinhanvien').html(res);
            },
            function(res) {
                console.log(res);
            },
        });
    }
</script>
</div>