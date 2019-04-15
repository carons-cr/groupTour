<%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-11
  Time: 下午8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>精彩游记</title>
    <link rel="stylesheet" type="text/css" href="./css/travelNote.css" charset="UTF-8">
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
    <div class="createNote">
        <button onclick="createNote()">+创建</button>
    </div>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
<script type="text/javascript" src="./js/travelNote.js"></script>
</html>
