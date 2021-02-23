

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/ajax-thanhtoanhoadon.html" var="thongtinthanhtoan">
    <c:param name="urlType" value="thongtinthanhtoan"/>
</c:url>
<c:url value="/phukien-thanhtoanhoadon.html" var="thanhtoan">
    <c:param name="urlType" value="thongtinthanhtoan"/>
</c:url>
<div id="thaydoi"  >
    <div class="container ">
        <div class="row">
            <div class="col-lg-9 chitietthanhtoan">
                <table>
                    <h2>Giỏ hàng</h2>
                    <p>Thông tin chi tiết giỏ hàng</p>



                    <table style="width:100%" class="tabe1">
                        <tr class="vien">
                            <th>sản phẩm</th>
                            <th>Giá tiền</th>
                            <th>Số lượng</th>
                            <th>Thành Tiền</th>
                            <th colspan="2">Thao Tác</th>
                        </tr>

                        <c:forEach items="${giohang}" var="enty">
                            <c:forEach items="${enty.key.hinhanhDTOS}" var="hinh">
                                    <c:set var="hinhanh"  value="${hinh.tenhinh}"/>
                            </c:forEach>
                            <c:url value="ajax-oder-tangsoluong.html" var="tangsoluonghang">
                                <c:param name="command" value="tangsoluonghang"/>
                                <c:param name="pojo.id" value="${enty.key.id}"/>
                            </c:url>
                            <c:url value="ajax-oder-tangsoluong.html" var="giamsoluong">
                                <c:param name="command" value="giamsoluonghang"/>
                                <c:param name="pojo.id" value="${enty.key.id}"/>
                            </c:url>
                            <c:url value="ajax-oder-tangsoluong.html" var="xoa">
                                <c:param name="command" value="xoasanphamtronggiohang"/>
                                <c:param name="pojo.id" value="${enty.key.id}"/>
                            </c:url>
                        <c:url value="/phukien-order.html" var="UpdateSP">
                            <c:param name="command" value="updateSP"/>
                            <c:param name="pojo.id" value="${enty.key.id}"/>
                        </c:url>
                        <form action="" method="post" id="formSubmit_${enty.key.id}">
                            <input type="hidden"  name="id" value="${enty.key.id}">
                            <tr class="trtable">
                                <td><img src="<c:url value="/repository/${hinhanh}"/> " alt=""
                                         width="150px"> <a>${enty.key.tensp}</a></td>
                                <td><fmt:formatNumber value="${enty.key.giatien}"/></td>
                                <td><input type="button" sc-url="${giamsoluong}"  onclick="update(this)" class="nutgiam"
                                           value="-">
                                    <input type="number" class="input-text so-sp qty text" step="1" min="1" max="9999"
                                           name="quantity" value="${enty.value}" title="SL" size="4" pattern="[0-9]*"
                                           inputmode="numeric">
                                    <input type="button" sc-url="${tangsoluonghang}" class="nuttang"
                                           onclick="update(this)" value="+">
                                </td>

                                <td><fmt:formatNumber value="${enty.key.giatien*enty.value}"/></td>
                                <td>
                                    <a sc-url="${xoa}" onclick="update(this)"><img src="<c:url value="/template/webphukien/images/remove.png"/>" height="50"></a>

                                </td>

                            </tr>
                        </form>
                        </c:forEach>


                    </table>
                </table>
            </div>
            <div class="col-lg-3 thongtinthanhtoan">

                <div class="form-group th">
                    <h4  class="h12">Thông Tin Thanh Toán</h4>

                    <div class="row mn ">
                        <label>Số Sản Phẩm Mua :</label><p class="t1">${soluongsanphamtronggiohang}</p>
                    </div>
                    <div class="row mn ">
                        <label>Tổng tiền :</label>   <p class="t1"><fmt:formatNumber value="${tongtien.tongtien}" /> VNĐ</p>
                    </div>
                    <form method="post" action="${thanhtoan}">
                    <div class="row mn ">
                        <label>Số điện Thoại:</label>  <input class="form-control" type="text" name="pojo.sdt" required placeholder="nhập số điện thoại">
                        <label>Phương Thức thanh toán</label>
                        <input type="hidden" name="pojo.tongtien" value="${tongtien.tongtien}" >
                        <input type="hidden" name="tenkhachhang" value="${Idkhachhang}">
                        <select class="form-control"  name="phuongthucgiaohang" required placeholder="nhập số điện thoại">
                                <c:forEach var="item" items="${phuongthucthanhtoan.phuongthucthanhtoanDTOS}">
                                    <option value="${item.id}">${item.tenphuongthuc}</option>
                                </c:forEach>
                        </select>
                        <label>Đỉa Chỉ Giao:</label>  <textarea class="form-control" type="text" name="pojo.diachigiaohang" required placeholder="Địa Chỉ Giao Hàng"></textarea>
                    </div>
                    <button class="btn-primary  thanhb" type="submit" onclick="thanhtoan()" >Tiến Hành Thanh Toán</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<script>

    function update(i) {
        var url = $(i).attr('sc-url');
        if (typeof url == 'undefined') {
            url = '${tangsoluonghang}';
        }

        $.ajax({
            type: 'POST',
            url: url,
            data: $(this).serialize(),
            datatype: 'html',
            success: function (res) {
                $('#thaydoi').html(res);
            },
            error: function (res) {
                console.log(res);
            }
        });


    }
</script>
