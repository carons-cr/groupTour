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
        <a href="./html/footer.html">攻略&日记</a>
      </li>
      <li>
        <a href="./html/aboutUs.html">关于我们</a>
      </li>
      <li>
        <a id="registerOrUserName" href="./registerALogin.jsp?name=register">注册</a>
        <a id="loginOrExit" href="./registerALogin.jsp?name=login">| 登录</a>
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

  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript">
    if (sessionStorage.getItem("userName") == null || sessionStorage.getItem("userName") === "null") {
        sessionStorage.setItem("userName", "<%=session.getAttribute("userName")%>");
    }
    var userName = sessionStorage.getItem("userName");
    if (userName !== "null") {
        document.getElementById("registerOrUserName").innerHTML=userName;
        document.getElementById("registerOrUserName").href="index.jsp";
        document.getElementById("loginOrExit").innerHTML="| 退出";
        document.getElementById("loginOrExit").onclick=function () {sessionStorage.clear();<%session.invalidate();%>};
        document.getElementById("loginOrExit").href="index.jsp";
    }
  </script>
</body>
</html>
