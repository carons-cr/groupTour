<%@ page import="java.util.List" %>
<%@ page import="model.SystemGroup" %>
<%@ page import="java.util.ArrayList" %><%--
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
  <script type="text/javascript">
    if (sessionStorage.getItem("userName") == null) {
    <%
      String userName = (String) session.getAttribute("userName");
      if (userName != null) {
    %>
        sessionStorage.setItem("userName", "<%=session.getAttribute("userName")%>");
    <%
      }
    %>
    }
  </script>
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
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
    <div class="recommend">
      <%
        List<SystemGroup> systemGroupList = (ArrayList<SystemGroup>)session.getAttribute("recommendGroupList");
        if (systemGroupList == null) {
      %>
      <script type="text/javascript">
        var userName = sessionStorage.getItem("userName");
        if (userName != null) {
            window.location.href = "recommend?userName=" + userName;
        }
      </script>
      <%
        }else {
      %>
      <p class="subTitle">为您推荐</p>
      <%
          for (SystemGroup systemGroup : systemGroupList) {
      %>
      <div class="group">
        <a class="cover" href="groupDetail?id=<%=systemGroup.getId()%>">
          <img class="image" src="<%=systemGroup.getImgUrl()%>"/>
        </a>
        <a class="title" href="groupDetail?id=<%=systemGroup.getId()%>"><%=systemGroup.getName()%></a>
        <div class="priceANumber">
          <span class="price">￥<%=systemGroup.getPrice()%></span>
          <span class="number"><%=systemGroup.getNumber()%>人团</span>
        </div>
        <div class="time">出发时间 <%=systemGroup.getStartTime()%></div>
      </div>
      <%
          }
        }
      %>
    </div>
  </div>
  <footer>
      <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
</html>
