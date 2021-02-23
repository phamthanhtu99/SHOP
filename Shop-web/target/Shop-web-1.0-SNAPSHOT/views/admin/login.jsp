<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/LoginAdmin.py" var="dangnhap">
    <c:param name="urlType" value="login"/>
</c:url>
<div class="card container-fluid text-center mt mt-5 bg-transparent" style="width: 25rem ">
    <h2 class="">Đăng nhập hệ thống</h2>
    <form   action="${dangnhap}" method="post"  id="btndangnhap" >
        <div class="form-group">
            <label >Username:</label>
            <input type="text" class="form-control"  placeholder="Enter username" name="pojo.email" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label >Password:</label>
            <input type="password" class="form-control"  placeholder="Enter password" name="pojo.passWord" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <button type="submit" id="dangnhap1" class="btn btn-primary">Submit</button>
    </form>

</div>



<%--<script>
 $(document).ready(function () {
     addorEditUser();
 });
    function addorEditUser() {
        $('#dangnhap1').click(function () {
            $('#btndangnhap').submit();
        });
        $('#btndangnhap').submit(function (e) {
            e.preventDefault();
            $.ajax({
                type:'POST',
                url: $(this).attr('action'),
                data: $(this).serialize(),
                datatype: 'html',
                success:function (res) {
                    if(res =="sussces"){
                        $('#ajaxGetUserServletResponse').html(res);
                    }else {
                        $('#ajaxGetUserServletResponse').html(res);
                    }
                },
                error:function (res) {
                    console.log(res);
                }
            });
        })
    }


</script>--%>
