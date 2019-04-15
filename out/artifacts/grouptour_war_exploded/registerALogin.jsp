<%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-10
  Time: 下午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册|登录</title>
    <link rel="stylesheet" type="text/css" href="./css/registerALogin.css" charset="UTF-8">
</head>
<body>
<div class="content">
    <img src="./img/background.jpg"/>
    <div class="register" id = "register">
      <form name="register" onsubmit="return checkAll('register')" method="post" action="register">
        <div class="form-header">
          <h4>注册</h4>
        </div>
        <div class="form-group">
          <input type="text" class="userName" name="userName" placeholder="输入用户名" onblur="checkUserName('register')">
          <p class="userNameWarn">用户名不能为空</p>
        </div>
        <div class="form-group">
          <input type="password" class="password" name="password" placeholder="输入密码" onblur="checkPassword('register')" autocomplete="off">
          <p class="passwordWarn">密码不能为空</p>
        </div>
        <div class="form-group">
          <input type="password" class="rePassword" name="rePassword" placeholder="再次输入密码" onblur="checkRePassword()" autocomplete="off">
          <p class="rePasswordWarn">两次密码输入不一致</p>
        </div>
        <div class="form-group">
          <a href="#login" onclick="showLoginHideRegister()">已有帐号?前往登录</a>
        </div>
        <div class="form-group">
          <button type="submit" name="register" class="submit">注册</button>
        </div>
      </form>
    </div>
    <div class="login" id = "login">
      <form name="login" onsubmit="return checkAll('login')" method="post" action="login">
        <div class="form-header">
          <h4>登录</h4>
        </div>
        <div class="form-group">
          <input type="text" class="userName" name="userName" placeholder="输入用户名" onblur="checkUserName('login')">
          <p class="userNameWarn">用户名不能为空</p>
        </div>
        <div class="form-group">
          <input type="password" class="password" name="password" placeholder="输入密码" onblur="checkPassword('login')" autocomplete="off">
          <p class="passwordWarn">密码不能为空</p>
        </div>
        <div class="form-group">
          <a href="#register" onclick="showRegisterHideLogin()">未注册?点击前往</a>
        </div>
        <div class="form-group">
          <button type="submit" name="login" class="submit">登录</button>
        </div>
      </form>
    </div>
</div>
<script type="text/javascript">
  if (sessionStorage.getItem("reRegisterUserName") == null) {
  <%
    String reRegisterUserName = (String) session.getAttribute("reRegisterUserName");
    if (reRegisterUserName != null) {
  %>
       sessionStorage.setItem("reRegisterUserName", "<%=session.getAttribute("reRegisterUserName")%>");
  <%
    }
  %>
  }
  if (sessionStorage.getItem("loginFailUserName") == null) {
  <%
    String loginFailUserName = (String) session.getAttribute("loginFailUserName");
    if (loginFailUserName != null) {
  %>
       sessionStorage.setItem("loginFailUserName", "<%=session.getAttribute("loginFailUserName")%>");
  <%
    }
  %>
  }
</script>
<script type="text/javascript" src="./js/registerALogin.js"></script>
</body>
</html>
