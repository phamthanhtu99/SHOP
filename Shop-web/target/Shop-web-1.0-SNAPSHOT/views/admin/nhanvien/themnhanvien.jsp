<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/25/2020
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:if test="${empty item.pojo.id}">
    <c:url value="/ajax-editnhanvien.html" var="themnhanvien" >
        <c:param name="urlType" value="themnhanvien"/>
    </c:url>
</c:if>
<c:if test="${not empty item.pojo.id}">
    <c:url value="/ajax-editnhanvien.html" var="themnhanvien" >
        <c:param name="urlType" value="edit"/>
    </c:url>
</c:if>
<div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Cập Nhật Nhân Viên</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form action="${themnhanvien}"method="post" id="formaddnv">
                <div class="modal-body">
                    <input type="hidden" name="pojo.id" value="${item.pojo.id}">
                    <label>Tên Nhân Viên :</label><input class="form-control"  name="pojo.tennhanvien" value="${item.pojo.tennhanvien}" type="text" placeholder="Tên Nhân Viên">
                    <label>SDT :</label><input class="form-control" name="pojo.sdt"value="${item.pojo.sdt}"  type="text" placeholder="Số điện thoại">
                    <label>Email :</label><input class="form-control" name="pojo.email"value="${item.pojo.email}"  type="email" placeholder="email">
                    <label>Password :</label><input class="form-control" name="pojo.passWord"value="${item.pojo.passWord}"  type="password" placeholder="password">
                    <label>Địa chỉ :</label><input class="form-control" name="pojo.diachi"value="${item.pojo.diachi}"  type="text" placeholder="Địa chỉ">
                    <select class="form-control  col-4 mt-1 float-xl-left" name="chucvu">
                        <c:forEach var="item" items="${chucvu.chucvuDTOS}">
                            <option value="${item.id}">${item.tenChucVu}</option>
                        </c:forEach>
                    </select>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" id="btnaddnv" class="btn  btn-danger" data-dismiss="modal">save</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
