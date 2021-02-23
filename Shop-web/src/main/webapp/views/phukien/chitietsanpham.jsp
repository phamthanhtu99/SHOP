<%@ include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/phukien-order.html" var="giohang">
    <c:param name="command" value="themgiohang"></c:param>
</c:url>
<c:url value="/ajax-comment.html" var="danhgia">
    <c:param name="urlType" value="danhgia"/>
</c:url>
<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>

<div id="doibinhluan">
    <div class="container noidung">
        <div class="row ht1">
            <form action="${giohang}" method="post">
                <div class="col-lg-6 hinh" style="height: 300px">
                    <c:set var="tong" value="0"/>
                    <c:forEach var="item" items="${chitietsanpham.hinhanhDTOS}">
                        <c:set var="tong" value="${tong+1}"/>
                    </c:forEach>
                    <c:set var="so" value="0"/>
                    <c:forEach var="item" items="${chitietsanpham.hinhanhDTOS}">
                        <div class="mySlides">
                            <c:set var="so" value="${so+1}"/>
                            <div class="numbertext">${so}/ ${tong}</div>
                            <img height="370px" src="<c:url value="/repository/${item.tenhinh}" />" style="width:100%">
                        </div>
                    </c:forEach>

                    <a class="prev" onclick="plusSlides(-1)">❮</a>
                    <a class="next" onclick="plusSlides(1)">❯</a>
                    <div class="row sild">
                        <c:set value="0" var="th"/>
                        <c:forEach var="item" items="${chitietsanpham.hinhanhDTOS}">
                            <div class="column">
                                <c:set var="th" value="${th+1}"/>
                                <img class="demo cursor" src="<c:url value="/repository/${item.tenhinh}" />"
                                     style="width:100%" onclick="currentSlide(${th})" alt="The Woods">
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-6 chitiet">
                    <h2>CHiêt tiết sản phẩm</h2>
                    <p style="font-size: 15px">
                        Tên Sản Phẩm :${chitietsanpham.tensp}
                    </p>
                    <p style="font-size: 15px">
                        Giá tiền :<fmt:formatNumber value="${chitietsanpham.giatien}"/> VNĐ
                    </p>
                    <p style="font-size: 15px">

                        Số Lượng Còn :${chitietsanpham.soluong}
                    </p>
                    <p>
                        ? HÌNH THỨC VẬN CHUYỂN:</p>
                    <p>
                        ✔️ FREE SHIP HCM: ???? Áp dụng đơn hàng trên 200k
                    </p>
                    <p>
                        ✔️ FREE SHIP TOÀN QUỐC: ? Áp dụng đơn hàng trên 300k
                    </p>
                    <p>
                        ✔️ FREE SHIP TOÀN QUỐC: ? Áp dụng đơn hàng trên 300k
                    </p>
                    <input type="button" class="nutgiam" value="-">
                    <input type="hidden" name="pojo.id" value="${chitietsanpham.id}">
                    <input type="number" class="input-text so-sp qty text" step="1" min="1" max="9999" name="quantity"
                           value="1" title="SL" size="4" pattern="[0-9]*" inputmode="numeric">
                    <input type="button" class="nuttang" value="+">
                    <button class="btn-them-sp btn btn-danger" type="submit">Thêm sản phẩm</button>
                </div>
            </form>


        </div>
    </div>

    <div class="container thong-tin">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                          data-toggle="tab">MÔ
                    TẢ</a></li>
                <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">BÌNH
                    LUẬN</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active col-12" id="home">
                    ${chitietsanpham.mota}
                </div>
                <div role="tabpanel" class="tab-pane" id="messages">

                </div>
            </div>

        </div>
    </div>
</div>
<c:url value="/ajax-binhluan.html" var="hienthikhungbinhluan">
    <c:param name="urlType" value="hienthibinhluan"/>
    <c:param name="pojo.id" value="${chitietsanpham.id}"/>
</c:url>
<script>

    $(document).ready(function () {

        khungbinhluan();
    });

    function khungbinhluan() {
            var url='${hienthikhungbinhluan}';
            $('#messages').load(url);
    }


    var slideIndex = 1;
    showSlides(slideIndex);
    function chuyen(i) {
        var url = $(i).attr('sc-url');
    }

    $('.nutgiam').click(function () {
        var i = Number($('.so-sp').val()) - 1;
        if (i < 0) {
            i = 0;
        }
        $('.so-sp').val(i);
    });
    $('.so-sp').change(function () {
        var i = Number($('.so-sp').val());
        if (i < 0) {
            i = 0;
        }
        $('.so-sp').val(i);
    });
    $('.nuttang').click(function () {
        var sl = Number(${chitietsanpham.soluong});
        var i = Number($('.so-sp').val()) + 1;
        if (sl <= i) {
            i = ${chitietsanpham.soluong};
        }
        $('.so-sp').val(i);
    });

    CKEDITOR.replace('binhluan');


    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("demo");
        var captionText = document.getElementById("caption");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";

    }

</script>
