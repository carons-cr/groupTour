<%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-12
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>写游记</title>
  <link rel="stylesheet" type="text/css" href="./css/writeNote.css" charset="UTF-8">
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
    <form name="writeNote" onsubmit="return checkTitle()">
      <div class="completeNote">
        <input name="title" class="title" placeholder="输入游记标题" onfocus="hideTitleWarn()"/>
        <button type="submit">完成</button>
        <p class="titleWarn">标题不能为空!</p>
      </div>
      <div class="note">
        <span class="article">
          <textarea name="article" placeholder="记录下旅行途中的美好经历..."></textarea>
        </span>
        <span id="images" class="images">
          <div class="addImg">添加图片</div>
          <input type="file" class="selectSrc" accept="image/*" onchange="addImg(this)"/>
        </span>
      </div>
    </form>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/writeNote.js"></script>
</body>
</html>
