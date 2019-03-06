<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<div class="panel panel-default" id="userPic">
    <div class="panel-heading">
        <h3 class="panel-title">用户管理</h3>
    </div>
    <div class="panel-body">
        <input type="button" value="添加用户" class="btn btn-primary" id="doAddPro">
        <br>
        <br>
        <div class="show-list">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">id</th>
                    <th class="text-center">姓名</th>
                    <th class="text-center">登录名</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <#list userList as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.realName}</td>
                        <td>${user.loginName}</td>
                        <td class="text-center">
                            <input type="button" class="btn btn-warning btn-sm" onclick="deleteUser('${user.id}')" value="删除">
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- 添加商品 start -->
<div class="modal fade" tabindex="-1" id="Product">
    <div class="modal-dialog modal-lg">
        <form action="" class="form-horizontal">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">添加用户</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="product-name" class="col-sm-4 control-label">用户姓名：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="realName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-price" class="col-sm-4 control-label">登录名：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="loginName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-type" class="col-sm-4 control-label">密码：</label>
                            <div class="col-sm-8">
                                <input type="password" class="form-control" id="passWord">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input class="btn btn-primary" type="button" onclick="addUser()" value="添加">
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- 添加商品 end -->

<!-- 修改商品 start -->
<div class="modal fade" tabindex="-1" id="myProduct">
    <!-- 窗口声明 -->
    <div class="modal-dialog modal-lg">
        <!-- 内容声明 -->
        <form action="" class="form-horizontal">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">修改商品</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="pro-num" class="col-sm-4 control-label">商品编号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="pro-num" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">商品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="pro-name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-price" class="col-sm-4 control-label">商品价格：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="pro-price">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-image" class="col-sm-4 control-label">商品图片：</label>
                            <div class="col-sm-8">
                                <a class="file">
                                    选择文件 <input type="file" name="file" id="pro-image">
                                </a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-type" class="col-sm-4 control-label">商品类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control">
                                    <option>请选择</option>
                                    <option>电子产品</option>
                                    <option>化妆品</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- 显示图像预览 -->
                        <img style="width: 160px;height: 180px;" id="img2">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary updatePro">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/layer/layer.js"></script>
<script>
    function addUser(){
        var realName = $("#realName").val();
        var loginName = $("#loginName").val();
        var passWord = $("#passWord").val();

        var params = {
            realName: realName,
            loginName: loginName,
            passWord: passWord
        };

        $.post("/user/insert", params, function(result){
            if(result && result.success){
                $("#Product").modal("hide");
                layer.msg("添加成功", {
                    time: 1300
                }, function(){
                    window.location.href="/user/view.htm"
                })
            }else{
                layer.msg("添加失败:" + result.msg, {
                    time: 1300
                })
            }
        });
    }

    function deleteUser(userId){
        $.post("/user/delete", {userId: userId}, function(result){
            if(result && result.success){
                layer.msg("删除成功", {
                    time: 1300
                }, function(){
                    window.location.href="/user/view.htm"
                })
            }else{
                layer.msg("删除失败", {
                    time: 1300
                })
            }
        });
    }

</script>