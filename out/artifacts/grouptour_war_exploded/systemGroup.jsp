<%@ page import="model.SystemGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-6
  Time: 下午8:41
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
  <title>拼团旅游</title>
  <link rel="stylesheet" type="text/css" href="./css/systemGroup.css" charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/nav.css" charset="UTF-8">
  <script type="text/javascript">
    <%
      List<SystemGroup> systemGroupList = (ArrayList<SystemGroup>)session.getAttribute("systemGroupList");
      if (systemGroupList == null) {
    %>
        window.location.href="systemGroup";
    <%
      }
    %>
  </script>
</head>
<body>
  <nav>
    <ul>
      <li>
        <a href="./index.jsp">首页</a>
      </li>
      <li>
        <a class="on" href="./systemGroup.jsp">系统拼团</a>
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
    <div class="groupList">
      <%
        if (systemGroupList != null)
        {
            for (int i = 0; i < systemGroupList.size(); i++) {
                if (i == 0 || i % 3 == 0) {
      %>
      <div class="row">

      <%
                }
                SystemGroup systemGroup = systemGroupList.get(i);
      %>
        <div class="column">
          <a href="./groupDetail.jsp" target="_blank">
            <img src=<%=systemGroup.getPicUrl()%>>
            <div class="info">
              <p class="name"><%=systemGroup.getName()%></p>
              <p class="description"><%=systemGroup.getDescription()%></p>
              <p class="numberAPrice">
                <span class="number"><%=systemGroup.getNumber()%>人团</span>
                <span class="price"><%=systemGroup.getPrice()%>元/人</span>
              </p>
            </div>
          </a>
        </div>

      <%
                if ((i + 1) % 3 == 0) {
      %>
      </div>
      <%
                }
            }
        }
      %>
    </div>
  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/systemGroup.js" charset="UTF-8"></script>
</body>
</html>