<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/1/2020
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/ajax-capnhatttcn.html" var="capnhat">
    <c:param name="urlType" value="capnhat"/>
</c:url>

<h2>Cập Nhật Thông Tin Cá Nhân </h2>
<c:if test="${not empty messageResponse}">
    <div class="alert alert-${alert} " >
        <button type="button" class="close" data-dismiss="alert">
            <i class="ace-icon fa fa-times"></i>
        </button>
            ${messageResponse}
    </div>
</c:if>
<form name="t1" action="${capnhat}" method="post" id="formupdate">
    <input type="hidden" value="${item.pojo.id}" name="pojo.id">
    <label class="col-5">Tên Khách Hàng : <input class=" form-control" type="text" placeholder="tên" name="pojo.tenKhachhang" value="${item.pojo.tenKhachhang}" required></label>
    <label class="col-7">Email :  <input class="form-control" name="pojo.email" type="text" value="${item.pojo.email}" placeholder="email" required></label>
    <label class="col-7">Số điện Thoại :<input class="form-control" name="pojo.sdt" value="${item.pojo.sdt}" type="number" placeholder="số điện thoai" required></label>
    <label class="col-12">Đại chỉ :<input class="form-control" name="pojo.diaChi" value="${item.pojo.diaChi}" placeholder="Địa Chỉ" required></label>
    <label class="col-lg-5">Password 1 : <input class="form-control"  value="${item.pojo.passWord}" type="password"name="pojo.passWord" placeholder="mật khẩu mới" required></label>
    <label class="col-sm-5">Password 2 : <input class="form-control" value="${item.pojo.passWord}" type="password" name="password1" placeholder="Nhập lại mật khẩu" required></label>
    <button class="btn-skype ma col-sm-3" type="submit" onclick="capnhap()" id="btbupdate" >Cập Nhật</button>
</form>
<script type="text/javascript" >
    $(document).ready(function () {

    })
    function capnhap() {
        $('#formupdate').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type: 'POST',
                url: $(this).attr('action'),
                data: $(this).serialize(),
                datatype: 'html',
                success: function (res) {
                 $('#luachon1').html(res);
                },
                function(res) {
                    console.log(res);
                },
            });
        });

    }
</script>