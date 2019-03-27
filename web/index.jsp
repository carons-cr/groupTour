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

</head>
<body>
  <nav>
    <ul>
      <li>
        <a class="on" href="./index.jsp" target="_blank">首页</a>
      </li>
      <li>
        <a href="./html/footer.html">系统拼团</a>
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
        <a href="#register" onclick="showRegister()">注册</a>
        <a href="#login" onclick="showLogin()">| 登录</a>
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
      <form>
        <div class="form-header">
          <h4>注册</h4>
          <button onclick="hideRegister()">X</button>
        </div>
        <div class="form-group">
          <input type="text" class="username" name="username" placeholder="输入用户名">
        </div>
        <div class="form-group">
          <input type="password" class="password" name="password" placeholder="输入密码">
        </div>
        <div class="form-group">
          <input type="password" class="passwordConfirm" name="passwordConfirm" placeholder="再次输入密码">
        </div>
        <div class="form-group">
          <a href="#login" onclick="showLogin()">已有帐号?前往登录</a>
        </div>
        <div class="form-group">
          <button type="submit" name="register">注册</button>
        </div>
      </form>
    </div>
    <div class="login" id = "login">
      <form>
        <div class="form-header">
          <h4>登录</h4>
          <button onclick="hideLogin()">X</button>
        </div>
        <div class="form-group">
          <input type="text" class="username" name="username" placeholder="输入用户名">
        </div>
        <div class="form-group">
          <input type="password" class="password" name="password" placeholder="输入密码">
        </div>
        <div class="form-group">
          <a href="#register" onclick="showRegister()">未注册?点击前往</a>
        </div>
        <div class="form-group">
          <button type="submit" name="login">登录</button>
        </div>
      </form>
    </div>
  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/index.js"></script>
</body>
</html>
