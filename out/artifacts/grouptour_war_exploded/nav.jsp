<%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-10
  Time: 下午8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>导航栏</title>
    <link rel="stylesheet" type="text/css" href="css/nav.css" charset="UTF-8">
</head>
<body>
  <nav>
    <ul>
      <li>
        <a id="index" href="./index.jsp" target="_parent">首页</a>
      </li>
      <li>
        <a id="systemGroup" href="systemGroup" target="_parent">系统拼团</a>
      </li>
      <li>
        <a id="travelNote" href="travelNote" target="_parent">精彩游记</a>
      </li>
      <li>
        <a id="aboutUs" href="./html/aboutUs.html" target="_parent">关于我们</a>
      </li>
      <li>
        <a id="registerOrUserName" href="./registerALogin.jsp?name=register" target="_parent">注册</a>
        <a id="loginOrExit" href="./registerALogin.jsp?name=login" target="_parent">| 登录</a>
      </li>
    </ul>
  </nav>
  <script type="text/javascript" src="js/nav.js" charset="UTF-8"></script>
  <script type="text/javascript">
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        document.getElementById("loginOrExit").onclick = function () {
        <%
            session.removeAttribute("userName");
            session.removeAttribute("reRegisterUserName");
            session.removeAttribute("loginFailUserName");
        %>
            sessionStorage.removeItem("userName");
            sessionStorage.removeItem("reRegisterUserName");
            sessionStorage.removeItem("loginFailUserName");
        }
    }
  </script>
</body>
</html>
