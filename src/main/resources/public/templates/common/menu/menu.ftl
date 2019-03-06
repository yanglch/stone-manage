<script type="text/javascript">
    $(function(){
        // 点击切换页面
        $("#product-type-set").click(function() {
            window.location = "/stone/type/view.htm";
        });
        $("#product-set").click(function() {
            window.location = "/stone/view.htm";
        });
        $("#user-set").click(function() {
            $("#frame-id").attr("src", "customerManager.html");
        });
        $("#manager-set").click(function() {
            window.location.href = "/user/view.htm";
        });
    });
</script>
<div class="col-xs-2 user-wrap">
    <ul class="list-group">
        <li class="list-group-item ${(formView == "/stone/type/view.htm")?string('active','')}" name="userSet" id="product-type-set">
            <i class="glyphicon glyphicon-lock"></i> &nbsp;石材类型管理
        </li>
        <li class="list-group-item ${(formView == "/stone/view.htm")?string('active','')}" name="userPic" id="product-set">
            <i class="glyphicon glyphicon-facetime-video"></i> &nbsp;石材管理
        </li>
        <li class="list-group-item" name="userInfo" id="user-set">
            <i class="glyphicon glyphicon-user"></i> &nbsp;客户管理
        </li>
        <li class="list-group-item ${(formView == "/user/view.htm")?string('active','')}" name="adminSet" id="manager-set">
            <i class="glyphicon glyphicon-globe"></i> &nbsp;系统用户管理
        </li>
    </ul>
</div>