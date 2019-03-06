<!-- header start -->
<div class="clear-bottom head">
    <div class="container head-cc">
        <p>XXX石材<span>后台管理系统</span></p>
        <div class="welcome">
            <div class="left">欢迎您：&nbsp;&nbsp;</div>
            <div class="right">${Session.SPRING_SECURITY_CONTEXT.authentication.principal.realName!}</div>
            <div class="exit">&nbsp;&nbsp;<a style="color: #ffffff;cursor:pointer ;" onclick="logout()">退出</a>
                <form id="logoutFrom" action="/logout" method="post"></form>
            </div>
        </div>
    </div>
</div>
<script>
    function logout(){
        $("#logoutFrom").submit();
    }
</script>