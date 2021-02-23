<%@ include file="/common/taglib.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2020
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><dec:title default="trang quan lý"/></title>
    <link rel="icon" type="image/png" sizes="16x16"
          href="<c:url value="/template/adminHome/assets/images/favicon.png"/>">
    <title>Matrix Template - The Ultimate Multipurpose admin template</title>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link href="<c:url value="/template/adminHome/assets/libs/flot/css/float-chart.css" />" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <script src="<c:url value="/template/paging/jquery.twbsPagination.js"/> "></script>
    <link href="<c:url value="/template/adminHome/style.css"/>" rel="stylesheet">
    <link href="<c:url value="/template/adminHome/dist/css/style.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
    <script type='text/javascript' src='<c:url value="/template/sweetalert/sweetalert2.min.js"/>'></script>
    <link rel="stylesheet" href="<c:url value="/template/sweetalert/sweetalert2.min.css"/>">
    <dec:head/>
</head>
<body>
<div id="main-wrapper">
    <%@include file="/common/adminhome/header.jsp" %>
    <%@include file="/common/adminhome/menu.jsp" %>
    <div class="page-wrapper" >
        <dec:body/>
    </div>
</div>

<script src="<c:url value="/template/adminHome/assets/libs/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="<c:url value="/template/adminHome/assets/libs/popper.js/dist/umd/popper.min.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/extra-libs/sparkline/sparkline.js"/>"></script>
<!--Wave Effects -->
<script src="<c:url value="/template/adminHome/dist/js/waves.js"/>"></script>

<script src="<c:url value="/template/adminHome/dist/js/sidebarmenu.js"/>"></script>
<script src="//cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
<script src="<c:url value="/template/adminHome/dist/js/custom.min.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/excanvas.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/jquery.flot.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/jquery.flot.pie.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/jquery.flot.time.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/jquery.flot.stack.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot/jquery.flot.crosshair.js"/>"></script>
<script src="<c:url value="/template/adminHome/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"/>"></script>
<script src="<c:url value="/template/adminHome/dist/js/pages/chart/chart-page-init.js"/>"></script>
    <script type="text/javascript">
        function showdetele(callback){
            swal({
                title: "Xác nhận xóa?",
                text: "Bạn có chắc chắn xóa những dòng đã chọn!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonText: "Xác nhận",
                cancelButtonText: "Hủy bỏ",
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger"
            }).then(function (isConfirm) {
                    if (isConfirm){
                        callback();
                        swal({
                            title: "Thành Công!",
                            text: "Đã Xóa Thành Công!",
                            icon: "success",
                            button: "Aww yiss!",
                        });
                    }
            })
        }

    </script>
</body>
</html>
