<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url  value="/phukien-home.css?urlType=seach" var="giohang">
</c:url>
<c:url value="phukien-order.html" var="car"/>
<div class="top1">
    <div class="container">
        <div class="row">
            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                <img src="<c:url value="/template/webphukien/images/logo.png"/>">
            </div>

            <div class="col-xs-6 col-sm-4 col-md-2 col-lg-2 lienhe">
                <i class="fa fa-phone"></i>
                <i>016524155835</i>
            </div><!-- end lienhe -->

            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 timkiem text-center">
                <form action="${giohang}" method="get" role="form">

                    <div class="form-group">
                        <input type="text" class="form-control" name="seach" placeholder="Tìm kiếm">
                        <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>
                    </div>


                </form>
            </div><!-- end timkiem -->

            <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 thoigian">
                <div class="col-xs-6 col-sm-6 col-md-12 col-lg-12 cainay">
                    <i class="fa fa-shopping-bag"></i>
                    <p>${soluongsanphamtronggiohang} <a href="${car}">sản phẩm</a></p>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-12 col-lg-12 cainay">
                    <i class="fa fa-clock-o"></i>
                    <p>Giờ mở cửa: 7:00 am - 18:00 pm</p>
                </div>
            </div><!-- end thoigian -->
        </div><!-- end row -->
    </div><!-- end container -->
</div><!-- end top -->
<div class="top2">
    <div class="container menu">
        <ul class="danhsach">
            <li class="trangchu muc"><a href="/phukien-home.css">Trang chủ</a></li>
            <li class="muc"><a href="">Giới thiệu</a></li>
            <li class="muc">
                <a href="">Sản phẩm</a>
                <ul class="sub-menu">
                    <li><a href="">Đặt hàng</a></li>
                    <li><a href="">sub-menu</a></li>
                    <li><a href="">sub-menu</a></li>
                </ul>
            </li>
            <li class="muc"><a href="">Báo giá</a></li>
            <li class="muc"><a href="">Bảo hành</a></li>
            <li class="muc"><a href="">Tin tức</a></li>
            <li class="muc"><a href="">Tuyển dụng</a></li>
            <li class="muc"><a href="">Login</a></li>
            <li class="muc">
                <a href="">Sản phẩm</a>
                <ul class="sub-menu">
                    <li><a href="">Đặt hàng</a></li>
                    <li><a href="">sub-menu</a></li>
                    <li><a href="">sub-menu</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>