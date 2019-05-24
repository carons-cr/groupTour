<%@ page import="model.SystemGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.TravelNote" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-5-13
  Time: 下午1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>个人中心</title>
  <link rel="stylesheet" type="text/css" href="./css/user.css" charset="UTF-8">
  <%
    List<SystemGroup> systemGroupList = (ArrayList<SystemGroup>)session.getAttribute("systemGroupList");
    List<TravelNote> travelNoteList = (ArrayList<TravelNote>)session.getAttribute("travelNoteList");
    List<TravelNote> viewNoteList = (ArrayList<TravelNote>)session.getAttribute("viewNoteList");
    List<User> groupMemberList = (ArrayList<User>)session.getAttribute("groupMemberList");
  %>
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
    <div class="myGroup">
      <p class="subTitle">我的拼团游</p>
      <%
        if (systemGroupList != null) {
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
        <div class="time">出发时间  <%=systemGroup.getStartTime()%></div>
      <%
                if (groupMemberList != null && groupMemberList.size() > 0) {
      %>
        <div class="users">拼团成员
      <%
                    for (User groupMember : groupMemberList) {
      %>
          <span class="user"><%=groupMember.getUserName()%></span>
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
        }else {
      %>
      <div class="noRecord">您还没有报名参加任何拼团游哦~</div>
      <%
        }
      %>
    </div>
    <div class="myNote">
      <p class="subTitle">我的游记</p>
      <%
        if (travelNoteList != null) {
            for (TravelNote travelNote : travelNoteList) {
      %>
      <div class="note">
        <a class="cover" href="noteDetail?id=<%=travelNote.getId()%>" onclick="addUserNameToHref(this)">
      <%
                if (travelNote.getCoverImgUrl() != null) {
      %>
          <img class="image" src="<%=travelNote.getCoverImgUrl()%>"/>
      <%
                }else {
      %>
          <img class="image" src="./img/defaultNoteCover.jpg"/>
      <%
                }
      %>
        </a>
        <a class="title" href="noteDetail?id=<%=travelNote.getId()%>" onclick="addUserNameToHref(this)">
          <%=travelNote.getTitle()%>
        </a>
        <p class="description"><%=travelNote.getArticle()%></p>
      </div>
      <%
            }
        }else {
      %>
      <div class="noRecord">您还没有写过游记，试试写篇来记录旅程吧~</div>
      <%
        }
      %>
    </div>
    <div class="noteViewed">
      <p class="subTitle">最近浏览游记</p>
      <%
        if (viewNoteList != null) {
            for (TravelNote viewNote : viewNoteList) {
      %>
      <div class="note">
        <a class="cover" href="noteDetail?id=<%=viewNote.getId()%>" onclick="addUserNameToHref(this)">
      <%
                if (viewNote.getCoverImgUrl() != null) {
      %>
          <img class="image" src="<%=viewNote.getCoverImgUrl()%>"/>
      <%
                }else {
      %>
          <img class="image" src="./img/defaultNoteCover.jpg"/>
      <%
                }
      %>
        </a>
        <a class="title" href="noteDetail?id=<%=viewNote.getId()%>" onclick="addUserNameToHref(this)">
          <%=viewNote.getTitle()%>
        </a>
        <p class="description"><%=viewNote.getArticle()%></p>
      </div>
      <%
            }
        }else {
      %>
      <div class="noRecord">暂无浏览记录~</div>
      <%
        }
      %>
    </div>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
<script type="text/javascript" src="./js/user.js"></script>
</html>
