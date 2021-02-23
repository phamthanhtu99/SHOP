<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/19/2020
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<div class="arriv">
    <div class="container">
        <div class="row arriv-top th">
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
            <div class="col-sm-6">
                <h3><a>Tên XE :${chitietsanpham.tensp}</a></h3>
                <span class="brand">Giá Tiền: <a href="#"><fmt:formatNumber value="${chitietsanpham.giatien}"/>  VNĐ </a></span>
                <br>
                <div class="chinht">

                        ${chitietsanpham.mota}

                </div>



                </div>

        </div>
    </div>
</div>
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