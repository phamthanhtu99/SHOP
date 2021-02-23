<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2020
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url value="/ajax-phieunhap.html" var="themsanphamvaophieunhap">
    <c:param name="urlType" value="themsanphamvaophieunhap"></c:param>
</c:url>

<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Chiêt tiết nhập </h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <form action="${themsanphamvaophieunhap}" method="post" id="nhapsl">
            <div class="modal-body">
                <label class="row">Tên Sản Phâm : ${chitietsanpham.tensp}</label>
                <label class="row">Giá Tiền: <fmt:formatNumber value="${chitietsanpham.giatien}" /></label>
                <c:forEach  items="${chitietsanpham.hinhanhDTOS}" var="hinh">
                    <c:set var="hinhanh" value="/repository/${hinh.tenhinh}"/>
                </c:forEach>
                <label  class="row">Hình Ảnh :</label><img class="anhsp responsive" src="<c:url value="${hinhanh}"/>  " alt="" height="200px">
                <label  class="row">Số Lượng nhập :</label><input class="form-control" name="pojo.soluong" type="text" placeholder="nhập số lượng">
                <label  class="row">Số  Giá tiền :</label><input class="form-control" name="pojo.giatien" type="text" placeholder="nhập giá tiền">
                <input type="hidden" name="id" value="${chitietsanpham.id}">
            </div>

            <div class="modal-footer">
                <button type="button" id="btbthemsanpham" class="btn  btn-danger" data-dismiss="modal">save</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>
        </form>
    </div>
</div>