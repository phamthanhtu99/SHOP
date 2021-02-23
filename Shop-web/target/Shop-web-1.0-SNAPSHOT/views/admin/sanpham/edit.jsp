<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url value="/ajax-themsanpham.html" var="themnhacungcap">
    <c:param name="urlType" value="nhacungcap"></c:param>
</c:url>

<div class="modal-dialog">
<div class="modal-content">
    <div class="modal-header">
        <h4 class="modal-title">Thêm Nhà Cung cấp</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
    </div>
    <form action="${themnhacungcap}"z method="post" id="formNCC">
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