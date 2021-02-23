<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/31/2020
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/ajax-themsanpham.html" var="addnhacungcap">
    <c:param name="urlType" value="themloaisanpham"></c:param>
</c:url>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Thêm Loại Sản Phẩm</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <form action="${addnhacungcap}"z method="post" id="formNCC">
            <div class="modal-body">

                <label>Tên Nhà Cung Cấp :</label><input class="form-control"  name="pojo.nhacungcap" type="text" placeholder="Tên Nhà cung cấp" required>
                <label>Đại Chỉ :</label><input class="form-control" name="pojo.email" type="text" placeholder="Đại Chỉ" required>
                <label>SDT :</label><input class="form-control" name="pojo.sdt" type="text" placeholder="số điện thoại" required>

            </div>
            <div class="modal-footer">
                <button type="button" id="btnadd" class="btn  btn-danger" data-dismiss="modal">save</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </form>
    </div>
</div>
