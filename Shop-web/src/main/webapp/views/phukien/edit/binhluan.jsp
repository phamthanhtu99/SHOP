<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/5/2020
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
<c:url value="/ajax-comment.html" var="binhluan">
    <c:param name="idsanpham" value="${chitietsanpham.id}"/>
    <c:param name="idkhachhang" value="${Idkhachhang}"/>
</c:url>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<c:if test="${not empty name}">

    <div role="tabpanel" class="tab-pane" id="profile">
        <div class="">
            <form  action="${binhluan}" method="post" id="formBl">
                <textarea name="pojo.chitietbinhluan" id="binhluan" cols="100"></textarea>
                <button  onclick="binhluan1()" class="binhluan">Bình Luận</button>
            </form>
        </div>
    </div>
</c:if>
    <div class="row khungbinhluan">
        <c:forEach var="item" items="${chitietbinhluan}">
            <div class="row cssbinhluan">
                <div class="row k">
                    <h4 class="fa fa-user"> ${item.khachHangEntity.tenKhachhang}</h4><br>
                    <p>${item.ngay}</p>
                </div>
                <c:choose>
                    <c:when test="${item.khachHangEntity.id == Idkhachhang}">
                            <c:url var="xoabinhluan" value="/ajax-comment.html">
                                <c:param name="urlType" value="xoabl"/>
                                <c:param name="pojo.id" value="${item.id}"/>
                                <c:param name="idsanpham" value="${chitietsanpham.id}"/>
                            </c:url>
                        <p><i class="fa fa-comment"></i>${item.chitietbinhluan}</p>
                                <p><button  sc-url="${xoabinhluan}" onclick="xoabl(this)" class="ml-3">Xóa</button></p>
                    </c:when>
                    <c:otherwise>
                        <p><i class="fa fa-comment"></i>${item.chitietbinhluan} </p>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>

    </div>

<c:if test="${empty name}">
    <div role="tabpanel" class="tab-pane" id="profile">
        Vui Lòng đăng nhập để binh luận
    </div>
</c:if>

<script>
    CKEDITOR.replace('binhluan');
    function xoabl(i) {
        var url=$(i).attr('sc-url');
        console.log(url);
        $('#messages').load(url);
    }
    function binhluan1() {
            $('#formBl').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'post',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    datatype: 'html',
                    success: function (res) {
                        $('#messages').html(res);
                    },
                    error: function (res) {
                        console.log(res);
                    }
                });
            })
    }
</script>