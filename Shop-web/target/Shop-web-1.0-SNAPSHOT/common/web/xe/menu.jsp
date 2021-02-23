<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/web-xemay.html" var="timkiemsanpham">

</c:url>
<div class="header_bg">
    <div class="container">
        <div class="header">
            <div class="head-t">
                <div class="logo">
                    <a href="index.html"><img src="<c:url value="/template/webxe/Renault.png"/>" width="100px"
                                              height="100px" class="img-responsive" alt=""/> </a>
                </div>
                <!-- start header_right -->
                <div class="header_right">
                    <div class="rgt-bottom">
                        <div class="log">
                            <div class="login">

                            </div>
                        </div>


                    </div>
                    <div class="search">
                        <form action="${timkiemsanpham}" method="post">
                            <input type="text" name="pojo.tensp" value="" placeholder="search...">
                            <input type="submit" value="">
                        </form>
                    </div>

                </div>

            </div>
            <!-- start header menu -->
            <ul class="megamenu skyblue">
                <li class="active grid"><a class="color1" href="/web-xemay.html">Home</a></li>
                <li><a class="color5" href="#">Loại Xe</a>
                    <div class="megapanel">
                        <div class="row">
                            <div class="col1">
                                <div class="h_nav">
                                    <h4>Sản Phẩm</h4>
                                    <ul>
                                        <c:forEach var="item" items="${loaisanpham.listResult}">
                                            <c:url var="timtheosanphamlsp" value="/ajax-xemmay.html">
                                                <c:param name="urlType" value="timkiemtheoid"/>
                                                <c:param name="crudaction" value="${item.id}"/>
                                            </c:url>
                                            <li><a sc-url="${timtheosanphamlsp}" onclick="timkiem(this)" <%--href="${timtheosanphamlsp}"--%>>${item.tenSp}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>

                <li><a class="color7" href="#">Sản Phẩm Yêu Thích</a>

                </li>

                <li><a class="color8" href="/phukien-home.css">Mua Phụ Kiện</a>

                </li>
                <li><a class="color9" href="/login-user.html">Login</a>

                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    function timkiem(i) {
            var url=$(i).attr('sc-url');
            $('.arriv').load(url);
    }
</script>