<%@ page import="model.TravelNote" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
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
    <%
      List<TravelNote> travelNoteList = (ArrayList<TravelNote>)session.getAttribute("travelNoteList");
      if (travelNoteList == null) {
    %>
        window.location.href="travelNote";
    <%
      }
    %>
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
    <div class="createNote">
        <button onclick="createNote()">+创建</button>
    </div>
    <div class="noteList">
    <%
        if (travelNoteList != null) {
            for (int i = 0; i < travelNoteList.size(); i++) {
                TravelNote travelNote = travelNoteList.get(i);
                if (i == 0 || i % 5 == 0) {
    %>
        <div id="page<%=i/5 + 1%>" class="page">
    <%
                }
    %>
            <div class="note">
                <div class="noteCover">
                    <a class="imageA" href="noteDetail?id=<%=travelNote.getId()%>" onclick="addUserNameToHref(this)">
    <%
                if (travelNote.getCoverImgUrl() != null) {
    %>
                        <img class="image" src="<%=travelNote.getCoverImgUrl()%>"/>
    <%
                } else {
    %>
                        <img class="image" src="./img/defaultNoteCover.jpg"/>
    <%
                }
    %>
                    </a>
                </div>
                <div class="font">
                    <a class="title" href="noteDetail?id=<%=travelNote.getId()%>" onclick="addUserNameToHref(this)"><%=travelNote.getTitle()%></a>
                    <p class="description"><%=travelNote.getArticle()%></p>
                </div>
            </div>
    <%
                if ((i + 1) % 5 == 0 || i == travelNoteList.size() - 1) {
    %>
        </div>
    <%
                }
            }
    %>
        <div class="pageNumberRow">
    <%
            int pageTotal = (travelNoteList.size() - 1)/5 + 1;
            for (int i = 1; i <= pageTotal; i++) {
    %>
            <a id="page<%=i%>Number" class="pageNumberColumn" href="#page<%=i%>"
               onclick="showPage(<%=i%>, <%=pageTotal%>)"><%=i%></a>
    <%
            }
    %>
        </div>
    <%
        }
    %>
    </div>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
<script type="text/javascript" src="./js/travelNote.js"></script>
</html>
