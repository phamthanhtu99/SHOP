<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url value="/phukien-home.css" var="timkiemsanpham">

</c:url>
<div class="top3">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 danhmuc">
                <div class="menutrai">
                    <div class="tieude">
                        <a class="" href="#"><b>Danh mục sản phẩm</b></a>
                    </div>
                    <div class="box">
                        <ul class="menudoc">
                            <li class="muc"><i class="fa fa-laptop"></i><a class="" href="${timkiemsanpham}?loaisanpham=4">Tem,DECAL</a><hr></li>
                            <li class="muc"><i class="fa fa-laptop"></i><a class="" href="">Phụ Kiện Xe máy</a><i class="fa fa-angle-right"></i><hr>
                                <ul class="menucon">
                                    <c:forEach items="${loaisanpham.loaisanphamDTOList}" var="item">
                                        <li class="mucnho"><a href="${timkiemsanpham}?loaisanpham=${item.id}">${item.tenSp}</a><hr></li>
                                    </c:forEach>
                                </ul><!-- end menucon -->
                            </li>
                            <li class="muc"><i class="fa fa-laptop"></i><a class="" href="${timkiemsanpham}?loaisanpham=3">Móc Kóa</a><hr></li>
                            <li class="muc"><i class="fa fa-laptop"></i><a class="" href="">Sản Phẩm khác</a><hr></li>


                        </ul><!-- end menudoc -->

                    </div><!-- end box -->
                </div><!-- end menutrai -->
            </div><!-- end danhmuc -->
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 anh">
                <div id="carousel-id" class="carousel slide" data-ride="carousel">

                    <div class="carousel-inner">
                        <div class="item">
                            <img data-src="holder.js/900x500/auto/#777:#7a7a7a/text:First slide" alt="First slide" src="<c:url value="/template/webphukien/images/UgRrAD.jpg" />">
                        </div>
                        <div class="item">
                            <img data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide" src="<c:url value="/template/webphukien/images/4-af4eaa19-6f65-471b-9901-e5bd8f892482.jpg"/>">
                        </div>
                        <div class="item active">
                            <img data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" alt="Third slide" src="<c:url value="/template/webphukien/images/Hb7fdf18dca374cb5a8d665f8f62d0af5w.jpg_q50.jpg"/>">
                        </div>
                    </div>
                    <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="fa fa-angle-left truoc"><span class="fa fa-angle-left sau"></span></span></a>
                    <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="fa fa-angle-right truoc"><span class="fa fa-angle-right sau"></span></span></a>
                </div>
            </div><!-- end anh -->
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 quangcao">
                <div class="anhqc">
                    <img src="<c:url value="/template/webphukien/images/images.jpg"/>">
                </div>
                <div class="anhqc">
                    <img src="<c:url value="/template/webphukien/images/f40f772d9aa8bc4b0b9d1bdfdb2559e1.jpg"/>"  height="380px"  width="280px" alt="">
                </div>
            </div><!-- end quangcao -->
        </div><!-- end row -->
    </div><!-- end container -->
</div>