<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/30/2020
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url value="/admin-themsanpham.html" var="themsanpham">
    <c:param name="urlType" value="themsanpham"></c:param>
</c:url>

<c:url value="/ajax-themsanpham.html" var="themnhacungcap1">
    <c:param name="urlType" value="nhacungcap1"></c:param>
</c:url>
<c:url value="/ajax-themsanpham.html" var="themnhacungcap">
    <c:param name="urlType" value="nhacungcap"></c:param>
</c:url>
<c:url value="/ajax-themsanpham.html" var="themloaisanpham">
    <c:param name="urlType" value="themloaisanpham"></c:param>
</c:url>
<div id="thaydoi">
    <c:if test="${not empty thongbao}">
        <div class="alert alert-${ketqua} " >
            <button type="button" class="close" data-dismiss="alert">
                <i class="ace-icon fa fa-times"></i>
            </button>
                ${thongbao}
        </div>
    </c:if>
    <h2 class="h2-t">Quản lý sản phẩm</h2>
    <div class="col-12">

        <form action="${themsanpham}" method="post" enctype="multipart/form-data" id="formaddsanpham">
            <div class="form-row">
                <div class="form-group col-sm-3">
                    <label>Mã Sản Phẩm</label>
                    <input type="text" class="form-control"
                           name="pojo.id" placeholder="Mã sản phẩm" required>
                </div>
                <div class="form-group col-sm-3">
                    <label>Tên Sản Phẩm</label>
                    <input type="text" class="form-control"
                           name="pojo.tensp" placeholder="Tên sản phẩm" required>
                </div>
                <div class="form-group col-sm-3">
                    <label>Giá tiền</label>
                    <input type="text" class="form-control"
                           name="pojo.giatien" placeholder="Giá tiền" required>
                </div>

            </div>

            <div class="form-row">
                <div class="form-group col-sm-3">
                    <label class="form">Hình ành </label>
                    <input type="file" id="uploadfile" multiple name="file" class="form-inline" required>
                </div>
                <div class="form-group col-sm-3">
                    <label class="form">Hình ành </label>

                    <img src="<c:url value=""/> " id="viewsImge"
                         height="150" width="200">
                </div>
            </div>


            <div class="form-group ">
                <label>Mô Tả</label>
                <textarea cols="70" id="mota" name="pojo.mota" class="form-control" required></textarea>

            </div>
            <div class="form-row">
                <div class="form-group col-sm-5">
                    <label>Nhà Cung cấp </label><p  onclick="themNNC()" class="themNCC btn-facebook">Thêm Nhà Cung Cấp</p>

                    <select class="form-control" name="pojo.nhacungcapdto">
                        <c:forEach var="item" items="${nhacungcap.nhacungcapDTOList}">
                            <option value="${item.id}">${item.nhacungcap}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="form-group col-sm-5">
                    <label>Loại Sản phẩm <p onclick="themlsp(this)" class="btn-facebook">Thêm Loại sản phẩm</p></label>
                    <select class="form-control" name="pojo.loaisanpham">
                        <c:forEach var="item" items="${loaisanpham.loaisanphamDTOList}">
                            <option value="${item.id}">${item.tenSp}</option>
                        </c:forEach>
                    </select>
                </div>

            </div>

            <button type="submit" onclick="themsanpham()" class="btn btn-primary">ADD</button>
        </form>
    </div>
    <!-- The Modal -->
</div>



    <div class="modal fade" id="myModal" role="dialog">

    </div>


<script>
    $(document).ready(function () {
        $(document.body).removeClass("modal-open");
        $(".modal-backdrop").remove();
    });
    CKEDITOR.replace('mota');
    $('#uploadfile').change(function () {
        readUrl(this, "viewsImge");
    });

    function readUrl(input, imageid) {
        if (input.files && input.files[0]) {
            var read = new FileReader();
            read.onload = function (e) {
                $('#' + imageid).attr('src', read.result);
            }
            read.readAsDataURL(input.files[0]);
        }
    }
        function themlsp(i) {
            var url='${themloaisanpham}';
            $('#myModal').load(url,'',function () {
                $('#myModal').modal();
            });
        }
    function themNNC() {
        var url='${themnhacungcap1}';
        $('#myModal').load(url,'',function () {
            $('#myModal').modal();
            addnhacungcap();
        });
        function addnhacungcap() {
            $('#btnadd').click(function () {
                $('#formNCC').submit();
            });
            $('#formNCC').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url:'${themnhacungcap}',
                    data: $(this).serialize(),
                    datatype: 'html',
                    success :  function (res) {
                        $('#thaydoi').html(res);
                        alert("thành công")
                    },
                    function (res) {
                        console.log(res);
                    },
                });
            });

        }




    }

    function updata(i) {
        var url = $(i).attr('sc-url');
        $.ajax({
            type: 'GET',
            url: url,
            data: $(this).serialize(),
            datatype: 'html',
            success :  function (res) {
                $('#thaydoi').html(res);
            },
            function (res) {
                console.log(res);
            },
        });
    }

</script>
