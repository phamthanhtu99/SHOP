<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="<c:url value="/template/paging/jquery.twbsPagination.js"/> "></script>
<c:url value="/ajax-quanlysanpham.html" var="phantrang">
    <c:param name="urlType" value="phantrang"/>
</c:url>
<div id="thaydoi">
    <h2 class="h2-t">Quản lý sản phẩm</h2>
    <c:if test="${not empty thongbao}">
        <div class="alert alert-${ketqua} ">
            <button type="button" class="close" data-dismiss="alert">
                <i class="ace-icon fa fa-times"></i>
            </button>
                ${thongbao}
        </div>
    </c:if>
    <c:url value="/ajax-quanlysanpham.html" var="timkiem">
        <c:param name="urlType" value="timkiemsanpham"/>
    </c:url>
    <div class=" blockquote">
        <form id="formtkiem" method="post" action="${timkiem}">
            <lable><input type="text" class="form-control col-lg-2 float-left " list="ide" name="pojo.id"
                          placeholder="Chọn mã  sản phẩm "/></lable>
            <datalist id="ide">
                <c:forEach items="${listItem.listResult}" var="item">
                    <option value="${item.id}">${item.tensp}</option>
                </c:forEach>
                <option>Lịch sử Tìm Kiếm</option>
            </datalist>
            <lable><input type="text" class="form-control col-lg-2 float-left " list="ide1" name="pojo.tensp"
                          placeholder="Chọn tên sản phẩm"/></lable>
            <datalist id="ide1">
                <c:forEach items="${listItem.listResult}" var="item">
                    <option value="${item.tensp}">${item.tensp}</option>
                </c:forEach>
                <option>Lịch sử Tìm Kiếm</option>
            </datalist>
            <button onclick="timkiem()" id="btntk" class="btn-skype">Tìm Kiếm</button>
        </form>
        <table class="table table-cell">
            <thead>
            <tr>
                <th scope="col">MSP</th>
                <th scope="col">Tên Sản Phẩm</th>
                <th scope="col">Số luọng</th>
                <th scope="col">Nhà Cung cấp</th>
                <th scope="col">Thao tác</th>
            </tr>
            <tbody>
            <c:forEach items="${sanpham.sanphamDTOList}" var="item">

            <c:url value="/ajax-quanlysanpham.html" var="xoasp">
                <c:param name="urlType" value="xoasp"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <c:url value="/admin-quanlysanpham.jsp" var="update">
                <c:param name="urlType" value="capnhat"/>
                <c:param name="pojo.id" value="${item.id}"/>
            </c:url>
            <tr>

                <th scope="row">${item.id}</th>
                <td>${item.tensp}</td>
                <td>${item.soluong}</td>

                <td>${item.nhacungcapdto.nhacungcap}</td>
                <td>
                    <button class="bg-purple"><a class="btn-facebook" href="${update}" onclick="updatesp(this)">Cập
                        nhật</a></button>
                    <button class="bg-danger"><a sc-url="${xoasp}" onclick="xoasp(this)">xóa sản phẩm</a></button>
                </td>
            </tr>
            </tbody>
            </c:forEach>
            </thead>
        </table>
    </div>
<div class="container phantrang">
    <ul id="pagination-demo" class="pagination-sm"></ul>
</div>


    <div class="modal fade" id="myModal" role="dialog">

    </div>
</div>
    <script type="text/javascript">
        var vitri=${sanpham.page};
        $('#pagination-demo').twbsPagination({
            totalPages: ${sanpham.totalPage},
            visiblePages: ${sanpham.maxPageItems},
            startPage:vitri,
            next: 'Next',
            prev: 'Prev',
            onPageClick: function (event, page) {
                //fetch content and render here
                $('#page-content').text('Page ' + page) + ' content here';
               if (page != vitri){
                       var url ='${phantrang}&page='+page+'';
                     $('#thaydoi').load(url);
               }else {
                   console.log("không thực hiên");
               }
            }
        });
        function timkiem() {
            $('#formtkiem').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    datatype: 'html',
                    success: function (res) {
                        $('#thaydoi').html(res);
                    },
                    function(res) {
                        console.log(res);
                    },
                });
            })

        }

        function xoasp(i) {
            var url = $(i).attr('sc-url');
            $.post(url, function (data) {
                $('#thaydoi').html(data);
            })
        }

        function savesp() {
            $('#formupdate1').submit(function (e) {
                e.preventDefault();
                $.ajax({
                    type: 'POST',
                    url: $(this).attr('action'),
                    data: $(this).serialize(),
                    datatype: 'html',
                    success: function (res) {
                        $('#thaydoi').html(res);
                    },
                    function(res) {
                        console.log(res);
                    },
                });
            })
        }


    </script>