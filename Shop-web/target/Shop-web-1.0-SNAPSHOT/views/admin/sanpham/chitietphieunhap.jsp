<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/1/2020
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Chiết Tiết Nhập</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <table class="table table-dark">
                <thead>
                <tr>
                    <%--    <th scope="col">MaNhap</th>--%>
                    <th scope="col">Tên Sản Phẩm</th>
                    <th scope="col">Số Lượng</th>
                    <th scope="col">Tiền</th>
                    <%--  <th scope="col">Ngày Nhập</th>--%>
                </tr>


                <c:forEach items="${chitietphieunhap.chitietphieunhapDTOS}" var="item">
               <%-- <c:url value="/ajax-thanhtoanphieunhap.html" var="capnhatsoluong">
                    <c:param name="urlType" value="capnhapsoluong"/>
                    <c:param name="idsp" value="${item.sanphamDTO.id}"/>
                    <c:param name="idhoadon" value="${item.phieunhapDTO.id}"/>
                </c:url>--%>
                <form action="" method="post">
                <tr>

                        <td scope="row">${item.sanphamDTO.tensp}</td>
                        <td><input type="text" class="form-control" id="${item.sanphamDTO.id}" width="10px" value="${item.soluong}"></td>
                        <td><fmt:formatNumber value="${item.thanhtien}"/> VNĐ</td>

                </tr>
                </form>

                </c:forEach>

                </thead>
            </table>
        </div>

        <div class="modal-footer">
            <button type="button" id="" class="btn  btn-danger" data-dismiss="modal">save</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
    </div>
</div>
<script>


</script>