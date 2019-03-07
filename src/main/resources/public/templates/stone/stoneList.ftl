<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet"  href="/css/bootstrap.css" />
<link rel="stylesheet"  href="/css/index.css" />
<link rel="stylesheet"  href="/css/bootstrapValidator.min.css" />
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/userSetting.js"></script>
<script src="/js/bootstrapValidator.min.js"></script>
<script src="/layer/layer.js"></script>
<script>
    $(function () {

        //表单校验
        $('#frmAddProduct').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields:{
                name:{
                    validators:{
                        notEmpty:{
                            message:'商品名称不能为空'
                        },
                        remote:{
                            type:'post',
                            url:'/stone/checkName'
                        }
                    }
                },
              /*  file:{
                    validators:{
                        notEmpty:{
                            message:'请选择商品图片'
                        }
                    }
                },*/
                stoneTypeId:{
                    validators:{
                        notEmpty:{
                            message:'请选择石材类型'
                        }
                    }
                }
            }
        });

    });

    function showStone(id) {
        $.post(
            '/stone/findById',
            {'id':id},
            function (result) {
                if (result.status==1){
                    $('#pro-num').val(result.data.id);
                    $('#pro-name').val(result.data.name);
                    $('#pro-TypeId').val(result.data.typeId)
                }
            }
        );
    }
    
    /*function addStone() {
        var bootstrapValidator = $("#frmAddProduct").data('bootstrapValidator');
        bootstrapValidator.validate();
        if(!bootstrapValidator.isValid()){
            return
        }

        var params = $('.form-horizontal').serialize();
        params.file =  new FormData($('#product-image')[0]);

        $.ajax({
            url: '/stone/add',
            data: params,
            processData: false,
            contentType: false,
            type: "post",
            cache: false,
            success: function (result) {
                if (result.status == 1) {
                    layer.msg('添加成功', {
                        time: 2000
                    }, function () {
                        window.location.href = "/stone/view.htm"
                    })
                } else {
                    layer.msg('添加失败', {
                        time: 2000
                    })
                }
            }
        });
}*/
    
</script>
<div class="panel panel-default" id="userPic">
    <div class="panel-heading">
        <h3 class="panel-title">石材管理</h3>
    </div>
    <div class="panel-body">
        <input type="button" value="添加石材" class="btn btn-primary" id="doAddPro">
        <br>
        <br>
        <div class="show-list">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">编号</th>
                    <th class="text-center">商品</th>
                    <th class="text-center">产品类型</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <#list stoneVoList as stone>
                    <tr>
                        <td>${stone.id}</td>
                        <td>${stone.name}</td>
                       <#-- <td>${stone.stoneTypeDo.name}</td>-->
                        <td>
                            有效
                        </td>
                        <td class="text-center">
                            <input type="button" class="btn btn-warning btn-sm doProModify" value="修改" onclick="showStone(${stone.id})">
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
    <!-- 窗口声明 -->
    <div class="modal-dialog modal-lg">
        <!-- 内容声明 -->
        <form action="/stone/add" method="post" class="form-horizontal" enctype="multipart/form-data" id="frmAddProduct">
            <div class="modal-content">
                <!-- 头部、主体、脚注 -->
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">添加石材</h4>
                </div>
                <div class="modal-body text-center row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <label for="product-name" class="col-sm-4 control-label">石材名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="product-name" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-image" class="col-sm-4 control-label">石材图片：</label>
                            <div class="col-sm-8">
                                <a href="javascript:;" class="file">选择文件
                                    <input type="file" name="file" id="product-image">
                                </a>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product-type" class="col-sm-4 control-label">石材类型：</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="stoneTypeId">
                                    <option value="">--请选择--</option>
                                    <#list StoneTypeDos as stoneTypeDo>
                                        <option value="${stoneTypeDo.id}">${stoneTypeDo.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- 显示图像预览 -->
                        <img style="width: 160px;height: 180px;" id="img">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">添加</button>
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
        <form action="/stone/modify" method="post"enctype="multipart/form-data" class="form-horizontal">
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
                                <input type="text" class="form-control" id="pro-num" name="id" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pro-name" class="col-sm-4 control-label">商品名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" id="pro-name" name="name">
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
                                <select class="form-control" id="pro-TypeId" name="stoneTypeId">
                                    <option value="">--请选择--</option>
                                    <#list StoneTypeDos as stoneTypeDo>
                                        <option value="${stoneTypeDo.id}">${stoneTypeDo.name}</option>
                                    </#list>
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
                    <button class="btn btn-primary updatePro" type="submit">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>