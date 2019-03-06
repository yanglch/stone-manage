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
<script>
    $(function () {

        //表单校验
        $('#frmAddStone').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: '石材名称不能为空'
                        }
                    }
                },
                file:{
                    validators: {
                        notEmpty: {
                            message: '请选择照片'
                        }
                    }
                },
                stoneTypeId:{
                    validators: {
                        notEmpty: {
                            message: '请选择石材类型'
                        }
                    }
                }
            }
        });

    });
    
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
                        <td>${stone.stoneTypeDo.name}</td>
                        <td>
                            <#if stone.stoneTypeDo.status==1>
                                有效石材
                            <#else >
                                无效石材
                            </#if>
                        </td>
                        <td class="text-center">
                            <input type="button" class="btn btn-warning btn-sm doProModify" value="修改">
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
        <form action="/stone/add" method="post" enctype="multipart/form-data" class="form-horizontal" id="frmAddStone">
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
                                    <option>--请选择--</option>
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
                    <button class="btn btn-primary updatePro">修改</button>
                    <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>