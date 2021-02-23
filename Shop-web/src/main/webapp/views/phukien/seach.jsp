<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/2/2020
  Time: 7:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<div class="top4"id="thay" >
    <div class="container">
        <div class="box3" >
            <div class="de">

                <h2><b>PHỤ KIEN XE MÁY</b></h2>
            </div><!-<!-- end de2 -->

            <div class="row">
                <c:forEach items="${sanpham.sanphamDTOList}" var="item">
                    <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 spnb ">
                        <div class="thumbnail hang">
                            <img class="anhsp responsive" src="<c:url value="/template/anh/sanpham/${item.hinhanh}"/> " height="150px" width="150px" alt="">
                            <div class="caption xam">
                                <div class="giaca">
                                    <b>${item.tensp}</b>
                                    <p  sc-url="" id="${item.id}"><fmt:formatNumber value="${item.giatien}" type="number"/> VNĐ</p>

                                </div>
                                <c:url value="/phukien-chitietsanpham.js" var="chitietsanpham">
                                    <c:param name="urlType" value="chitietsanpham"/>
                                    <c:param name="pojo.id" value="${item.id}"/>

                                </c:url>
                                <p>
                                    <a href="${chitietsanpham}" class="btn btn-primary muangay">Chi Tiết sản phẩm</a>
                                </p>
                            </div><!-- end xam -->
                        </div><!-- end hang -->
                    </div><!-- end spnb -->
                </c:forEach>
            </div><!-- end spnb -->


        </div><!-- end row -->
        <!-- end box3 -->
    </div><!-- end container -->
    <a onclick="viewsSp(this)" sc-url="${hienthisanpham}" class="th1" >Tất cả sản phẩm</a>
</div>n