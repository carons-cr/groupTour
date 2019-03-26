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
        <a href="./index.jsp" target="_blank">首页</a>
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
        <a href="./html/footer.html">注册</a>
        <a href="./html/footer.html">| 登录</a>
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
        <input type="text" name="username" placeholder="enter username..">
        <input type="password" name="password" placeholder="enter password..">
        <a href="#login">已有帐号?前往登录</a>
        <button type="submit" name="login"></button>
      </form>
    </div>
    <div class="login" id = "login"></div>
  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
</html>
