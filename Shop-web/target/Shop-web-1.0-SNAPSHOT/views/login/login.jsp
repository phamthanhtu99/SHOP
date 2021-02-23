<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/login-user.html" var="dangky">
    <c:param name="urlType" value="logout"/>
</c:url>
<c:url value="/login-user.html" var="dangnhap">
    <c:param name="urlType" value="login"/>
</c:url>
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v7.0" nonce="RbrnftX5"></script>
<div class="container">
    <section id="content">
        <form   action="${dangnhap}" method="post"  id="btndangnhap" >
            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Username" required=""  name="pojo.email" id="username" />
            </div>
            <div>
                <input type="password" placeholder="Password" required="" name="pojo.passWord" id="password" />
            </div>
            <div>
                <input type="submit" value="Log in" />
                <a href="${dangky}">Register</a>
            </div>
        </form><!-- form -->
        <div class="fb-login-button" data-size="medium" data-button-type="login_with" data-layout="rounded" data-auto-logout-link="true" data-use-continue-as="false" data-width=""></div>
    </section><!-- content -->
</div><!-- container -->