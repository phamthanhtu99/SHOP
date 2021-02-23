<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/login-user.html" var="dangky">
    <c:param name="urlType" value="dangky"/>
</c:url>
<%--
<div class="modal-dialog">

    <div class="modal-content">
        <div class="modal-header">
            <h2 class="">Đăng nhập Ký</h2>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form   action="${dangky}" method="post"  id="btndangnhap" >
                <div class="form-group">
                    <label >Username:</label>
                    <input type="text" class="form-control"  placeholder="Name" name="pojo.tenKhachhang" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group">
                    <label >Email:</label>
                    <input type="text" class="form-control"  placeholder="Enter username" name="pojo.email" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group">
                    <label >SĐT:</label>
                    <input type="text" class="form-control"  placeholder="Enter Số điện thoại" name="pojo.sdt" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group">
                    <label >Password:</label>
                    <input type="password" class="form-control"  placeholder="Enter password" name="pojo.passWord" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <button type="submit" id="dangnhap1" class="btn btn-primary">Đăng ký</button>

            </form>
        </div>
    </div>

</div>
--%>

<div class="container">
    <section id="content">
        <form   action="${dangky}" method="post" >
            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Username" required=""  name="pojo.tenKhachhang"  />
            </div>
            <div>
                <input type="text" placeholder="Email" required="" name="pojo.email"  />
            </div>
            <div>
                <input type="text" placeholder="Số Điện Thoại" required="" name="pojo.sdt"  />
            </div>
            <div>
                <input type="password" placeholder="****" required="" name="pojo.passWord"  />
            </div>
            <div>
                <input type="submit" value="Log in" />
                <a href="#">Register</a>
            </div>
        </form><!-- form -->
        <div class="button">
            <a href="#">Download source file</a>
        </div><!-- button -->
    </section><!-- content -->
</div><!-- container -->