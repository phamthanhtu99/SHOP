<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:if test="${not empty loaisanpham1}">
    <c:url value="/ajax-views.html" var="hienthisanpham">
        <c:param name="urlType" value="hienthithemsampham"/>
    </c:url>
</c:if>
<c:if test="${not loaisanpham1}">
    <c:url value="/ajax-views.html" var="hienthisanpham">
        <c:param name="urlType" value="hienthithemsampham"/>
        <c:param name="loaisanpham" value="${loaisanpham1}"/>
        <c:param name="limit" value="${sanpham.limit+4}"/>
    </c:url>
</c:if>
<div class="top4"id="thay" >
    <div class="container">
        <div class="box3" >
            <div class="de">

                <h2><b>Phụ kiện Xe Máy</b></h2>
            </div><!-<!-- end de2 -->

            <div class="row">
                <c:forEach items="${sanpham.sanphamDTOList}" var="item">
                    <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 spnb ">
                        <div class="thumbnail hang">
                            <c:set value="0" var="demo1 "/>
                            <c:forEach  items="${item.hinhanhDTOS}" var="hinh">
                                <c:set var="hinhanh" value="/repository/${hinh.tenhinh}"/>
                            </c:forEach>
                            <img class="anhsp responsive" src="<c:url value="${hinhanh}"/> " height="150px" width="150px" alt="">
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
            <a onclick="viewsSp(this)" sc-url="${hienthisanpham}" class="th1" >Xem Thêm sản phẩm</a>

            </div>
        <h2><b>Sản Phẩm Nổi Bậc</b></h2><!-- end row -->
        <div class="row">
            <c:forEach items="${listItem.sanphamnoibac}" var="item">
                <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3 spnb ">
                    <c:forEach var="ha" items="${item.hinhanhDTOS}">
                        <c:set var="ha1" value="/repository/${ha.tenhinh}"/>
                    </c:forEach>
                    <div class="thumbnail hang">
                        <img class="anhsp responsive" src="<c:url value="${ha1}"/> " height="150px" width="150px" alt="">
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


    </div>
        <!-- end box3 -->
    </div><!-- end container -->

</div>

</div>
<script>
    $(document).ready(function () {
    });
    function chuyentien(id,giatien) {
        const  formatter = new Intl.NumberFormat('en');
        giatien=formatter.format(giatien);
        $('#'+id).html(giatien+' VNĐ');

    }
    function viewsSp(i) {
        var url = $(i).attr('sc-url');
        $.ajax({
            type: 'GET',
            url: url,
            data: $(this).serialize(),
            datatype: 'html',
            success: function (res) {
                $('#thay').html(res);
            },
            error: function (res) {
                console.log(res);
            }
        });

    }

</script>