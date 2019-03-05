<script type="text/javascript">
    $(function(){
        // 点击切换页面
        $("#product-type-set").click(function() {
            $("#frame-id").attr("src", "productTypeManager.html");
        });
        $("#product-set").click(function() {
            window.location = "/stone/view.html";
        });
        $("#user-set").click(function() {
            $("#frame-id").attr("src", "customerManager.html");
        });
        $("#manager-set").click(function() {
            $("#frame-id").attr("src", "sysuserManager.html");
        });
    });
</script>
<div class="col-xs-2 user-wrap">
    <ul class="list-group">
        <li class="list-group-item active" name="userSet" id="product-type-set">
            <i class="glyphicon glyphicon-lock"></i> &nbsp;商品类型管理
        </li>
        <li class="list-group-item" name="userPic" id="product-set">
            <i class="glyphicon glyphicon-facetime-video"></i> &nbsp;商品管理
        </li>
        <li class="list-group-item" name="userInfo" id="user-set">
            <i class="glyphicon glyphicon-user"></i> &nbsp;客户管理
        </li>
        <li class="list-group-item" name="adminSet" id="manager-set">
            <i class="glyphicon glyphicon-globe"></i> &nbsp;系统用户管理
        </li>
    </ul>
</div>