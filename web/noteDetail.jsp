<%@ page import="model.TravelNote" %>
<%@ page import="java.util.List" %>
<%@ page import="model.TravelNoteImg" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-20
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>游记详情</title>
  <link rel="stylesheet" type="text/css" href="./css/noteDetail.css" charset="UTF-8">
  <%
    TravelNote travelNote = (TravelNote) session.getAttribute("travelNote");
    String authorName = (String) session.getAttribute("authorName");
    int viewNum = (Integer)session.getAttribute("viewNum");
    List<TravelNoteImg> travelNoteImgList = (ArrayList<TravelNoteImg>)session.getAttribute("travelNoteImgList");
  %>
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
  <%
      if (travelNote != null) {
  %>
    <div class="note">
        <p class="title"><%=travelNote.getTitle()%></p>
        <p class="noteInfo">

            <span class="time"><%=travelNote.getTime()%></span>
  <%
          if (authorName != null) {
  %>
            <span class="author">作者: <%=authorName%></span>
  <%
          }
  %>
  <%
          if (viewNum != 0) {
  %>
            <span class="view">阅读数: <%=viewNum%></span>
  <%
          }
  %>
        </p>
        <div class="article">
          <textarea class="text" placeholder="" disabled="disabled"><%=travelNote.getArticle()%></textarea>
        </div>
  <%
          if (travelNoteImgList != null) {
  %>
        <div class="images">
  <%
              for (TravelNoteImg travelNoteImg : travelNoteImgList) {
  %>
          <img class="image" src="<%=travelNoteImg.getImgUrl()%>"/>
  <%
              }
  %>
        </div>
  <%
          }
  %>
    </div>
  <%
    }
  %>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/noteDetail.js"></script>
</body>
</html>
