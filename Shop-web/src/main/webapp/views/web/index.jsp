<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2020
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/ajax-xemmay.html" var="xemthemsanpham">
    <c:param name="urlType" value="xemthemsanpham"></c:param>
    <c:param name="limit" value="${listItem.limit+4}"/>
</c:url>
<div class="arriv">
    <div class="container">
        <div class="arriv-top">
        <c:forEach var="item" items="${listItem.listResult}" >
            <div class="col-md-6 " style="height: 35rem">
                <c:forEach var="hinhanh" items="${item.sanphamDTO.hinhanhDTOS}">
                    <c:set var="anh" value="${hinhanh.tenhinh}"/>
                </c:forEach>
                <img src="<c:url value="/repository/${anh}"/>"  height="180px"  class="img-responsive" alt="" >
                <div class="arriv-info ch">
                    <h3 class="btn-github mau">${item.sanphamDTO.tensp}</h3>
                    <p class="text-danger"><a class="text-dark">
                            <fmt:formatNumber value="${item.sanphamDTO.giatien}" /> VND</p>
                    </a>
                    <c:url value="/web-xe-chitiet.html" var="chitiet">
                        <c:param name="pojo.id" value="${item.sanphamDTO.id}"/>
                    </c:url>
                    <div class="crt-btn">
                        <a style="color: red;" href="${chitiet}">Chi Tiết Xe</a>
                    </div>
                </div>

            </div>
        </c:forEach>
        </div>

    </div>
    <div class="float-left row suy">
        <a onclick="xemtheosanpham()" >Xem Thêm sản phẩm</a>
    </div>

</div>

<script>
    function xemtheosanpham() {
        var url= '${xemthemsanpham}';
        $.get(url,function (data) {
                $('.arriv').html(data);
        })
    }
</script>