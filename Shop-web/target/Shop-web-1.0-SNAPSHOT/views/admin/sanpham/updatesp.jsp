<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/10/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/admin-quanlysanpham.jsp" var="capnhat">
    <c:param name="urlType" value="capnhat"/>
</c:url>
            <form action="${capnhat}" method="post" enctype="multipart/form-data"  id="capnhatform">
                <input type="hidden" name="pojo.id" value="${item.id}">
                <div class="form-row">
                    <div class="form-group col-sm-6">
                        <label>Tên Sản Phẩm</label>
                        <input type="text" class="form-control"
                               name="pojo.tensp" value="${item.tensp}" placeholder="Tên sản phẩm" required>
                    </div>
                    <div class="form-group col-sm-6">
                        <label>Giá tiền</label>
                        <input type="number" class="form-control"
                               name="pojo.giatien" value="${item.giatien}" min="1" step="any"  placeholder="Giá tiền" required>
                    </div>

                </div>
                <div class="form-group ">
                    <label>Mô Tả</label>
                    <textarea cols="70" id="mota" data-value="" name="pojo.mota" class="form-control" required>${item.mota}</textarea>
                </div>
                <div class="form-row">
                    <div class="form-group col-sm-6">
                        <label>Nhà Cung cấp </label>
                        <select class="form-control" name="pojo.nhacungcapdto">
                            <c:forEach var="item" items="${nhacungcap.nhacungcapDTOList}">
                                <option value="${item.id}">${item.nhacungcap}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-sm-6">
                        <label>Loại Sản phẩm</label>
                        <select class="form-control" name="pojo.loaisanpham">
                            <c:forEach var="item" items="${loaisanpham.loaisanphamDTOList}">
                                <option value="${item.id}">${item.tenSp}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="container text-center" >
                    <button type="submit" class="btn btn-primary btn-sm col-5">cập nhật</button>

                </div>
            </form>
<script>
    CKEDITOR.replace('mota');
    $('#uploadfile').change(function () {
        readUrl(this, "viewsImge");
    });

</script>