<%@include file="/common/taglib.jsp"%>
<c:url value="/LoginAdmin.py" var="login">
</c:url>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg fixed-top navbar-light bg-light ">
    <a class="navbar-brand" href="#">
        <img src="<c:url value="/template/anh/sanpham/camera-2-final4k-021-1_cutout_730.jpg"/>" class="img-thumbnail" height="100" width="80"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <h2>Quản Trị Viên</h2>
                <a>Quản lý</a>
            </li>

        </ul>
        <ul class="float-left navbar-nav ">

            <li class="nav-item ">
                <a class="nav-link" href="${login}">Thoát</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="#"> || </a>
            </li>
            <c:if test="${ empty name}">
                <li class="nav-item ">
                    <a class="nav-link" href="${login}">Đăng Nhập </a>
                </li>
            </c:if>
            <c:if test="${not empty name}">
                <li class="nav-item ">
                    <a class="nav-link">${name}</a>
                </li>
            </c:if>


        </ul>
    </div>

</nav>