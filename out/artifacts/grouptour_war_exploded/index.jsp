<%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-3-23
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>首页</title>
  <link rel="stylesheet" type="text/css" href="./css/index.css" charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/nav.css" charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/registerALogin.css" charset="UTF-8">
</head>
<body>
  <nav>
    <ul>
      <li>
        <a class="on" href="./index.jsp">首页</a>
      </li>
      <li>
        <a href="./systemGroup.jsp">系统拼团</a>
      </li>
      <li>
        <a href="./html/footer.html">自主拼团</a>
      </li>
      <li>
        <a href="./html/footer.html">攻略&日记</a>
      </li>
      <li>
        <a href="./html/footer.html">关于我们</a>
      </li>
      <li>
        <a id="registerOrUserName" href="#register" onclick="showRegister()">注册</a>
        <a id="loginOrExit" href="#login" onclick="showLogin()">| 登录</a>
      </li>
    </ul>
  </nav>
  <div class="content">
    <div class="rotationPlay">
      <ul>
        <li><img src="./img/rotationPlay1.jpg"/></li>
        <li><img src="./img/rotationPlay2.jpg"/></li>
        <li><img src="./img/rotationPlay3.jpg"/></li>
        <li><img src="./img/rotationPlay4.jpg"/></li>
        <li><img src="./img/rotationPlay5.jpg"/></li>
      </ul>
    </div>
    <div class="register" id = "register">
      <form name="register" onsubmit="return checkAll('register')" method="post" action="register">
        <div class="form-header">
          <h4>注册</h4>
          <button onclick="hideRegister()">X</button>
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
          <a href="#login" onclick="showLogin()">已有帐号?前往登录</a>
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
          <button onclick="hideLogin()">X</button>
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
          <a href="#register" onclick="showRegister()">未注册?点击前往</a>
        </div>
        <div class="form-group">
          <button type="submit" name="login" class="submit">登录</button>
        </div>
      </form>
    </div>
  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/registerALogin.js"></script>
  <script type="text/javascript">
    if (sessionStorage.getItem("userName") == null || sessionStorage.getItem("userName") === "null") {
        sessionStorage.setItem("userName", "<%=session.getAttribute("userName")%>");
    }
    if (sessionStorage.getItem("reRegisterUserName") == null || sessionStorage.getItem("reRegisterUserName") === "null") {
        sessionStorage.setItem("reRegisterUserName", "<%=session.getAttribute("reRegisterUserName")%>");
    }
    if (sessionStorage.getItem("loginFailUserName") == null || sessionStorage.getItem("loginFailUserName") === "null") {
        sessionStorage.setItem("loginFailUserName", "<%=session.getAttribute("loginFailUserName")%>");
    }
    var userName = sessionStorage.getItem("userName");
    var reRegisterUserName = sessionStorage.getItem("reRegisterUserName");
    var loginFailUserName = sessionStorage.getItem("loginFailUserName");
    if (userName !== "null") {
        document.getElementById("registerOrUserName").innerHTML=userName;
        document.getElementById("registerOrUserName").onclick=function () {};
        document.getElementById("registerOrUserName").href="index.jsp";
        document.getElementById("loginOrExit").innerHTML="| 退出";
        document.getElementById("loginOrExit").onclick=function () {sessionStorage.clear();<%session.invalidate();%>};
        document.getElementById("loginOrExit").href="index.jsp";
    }else if (reRegisterUserName !== "null") {
        document.getElementById("register").style.display="block";
        document.getElementsByClassName("userName")[0].value=reRegisterUserName;
        document.getElementsByClassName("userNameWarn")[0].innerHTML="该用户名已被注册";
        document.getElementsByClassName("userNameWarn")[0].style.display="block";
    }else if (loginFailUserName !== "null") {
        document.getElementById("login").style.display="block";
        document.getElementsByClassName("userName")[1].value=loginFailUserName;
        document.getElementsByClassName("userNameWarn")[1].innerHTML="用户名或密码错误";
        document.getElementsByClassName("userNameWarn")[1].style.display="block";
    }
  </script>
</body>
</html>
