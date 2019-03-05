<html>
<header>
    <meta http-equiv="charset" content="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <link rel="stylesheet" href="../css/file.css"/>
    <script src="../js/jquery.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/userSetting.js"></script>
</header>
<body>
<div class="wrapper-cc clearfix">
    <div class="content-cc">
        <#include "common/head/head.ftl"/>


        <div class="container-flude flude-cc" id="a">
            <div class="row user-setting">
                <#include "common/menu/menu.ftl"/>

                <div class="col-xs-10" id="userPanel">
                    <#include "${viewName}.ftl"/>
                </div>
            </div>
        </div>
    </div>
</div>

<#include "common/footer/footer.ftl"/>
</body>
</html>