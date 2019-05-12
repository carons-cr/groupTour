<%@ page import="model.SystemGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.GroupComment" %><%--
  Created by IntelliJ IDEA.
  User: caron
  Date: 19-4-9
  Time: 下午5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>拼团游详情</title>
  <link rel="stylesheet" type="text/css" href="./css/groupDetail.css" charset="UTF-8">
  <%
    SystemGroup systemGroup = (SystemGroup) session.getAttribute("systemGroup");
    String end = request.getParameter("end");
    List<User> userList = (ArrayList<User>)session.getAttribute("userList");
  %>
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
  <%
    if (systemGroup != null) {
  %>
    <div class="groupInfo">
      <p class="groupName"><%=systemGroup.getName()%></p>
      <div class="characteristic">
        <p class="subTitle">[旅行特色]</p>
        <p class="description"><%=systemGroup.getCharacteristic()%></p>
      </div>
      <div class="detail">
        <img class="detailImg" src="<%=systemGroup.getDetailImgUrl()%>"/>
      </div>
      <div class="route">
        <img class="routeImg" src="<%=systemGroup.getDetailRouteUrl()%>"/>
      </div>
    </div>
  <%
        if (end.equals("false")) {
  %>
    <div class="signUp">
      <form onsubmit="return checkAll()" method="post" action="signUp?id=<%=systemGroup.getId()%>">
        <div class="row">
          <div class="column">
            <label for="userName" class="info-label">用户名</label>
            <input type="text" id="userName" class="userInfo" name="userName" readonly="readonly" onblur="checkAll()">
          </div>
          <div class="column">
            <label for="realName" class="info-label">姓名</label>
            <input type="text" id="realName" class="userInfo" name="realName" onblur="checkAll()">
          </div>
          <div class="column">
            <label for="sex" class="info-label">性别</label>
            <input type="text" id="sex" class="userInfo" name="sex" onblur="checkAll()">
        </div>
          </div>
        <div class="row">
          <div class="column">
            <label for="age" class="info-label">年龄</label>
            <input type="text" id="age" class="userInfo" name="age" onblur="checkAll()">
          </div>
          <div class="column">
            <label for="address" class="info-label">所在地</label>
            <input type="text" id="address" class="userInfo" name="address" onblur="checkAll()">
          </div>
          <div class="column">
            <label for="mobileNumber" class="info-label">手机号</label>
            <input type="text" id="mobileNumber" class="userInfo" name="mobileNumber" onblur="checkAll()">
          </div>
        </div>
        <div class="row">
          <div class="column">
            <label for="identificationNumber" class="info-label">身份证号</label>
            <input type="text" id="identificationNumber" class="userInfo" name="identificationNumber" onblur="checkAll()">
          </div>
        </div>
        <div class="row">
          <div class="column">
  <%
            if (userList != null) {
                if (userList.size() > 5) {
  %>
            <button type="submit" class="submit" disabled="disabled">人数已满</button>
  <%
                }else {
  %>
            <button type="submit" class="submit">报名</button>
  <%
                }
            }else {
  %>
            <button type="submit" class="submit" onclick="checkUser()">报名</button>
  <%
            }
  %>
          </div>
        </div>
      </form>
    </div>
  <%
        }else if(end.equals("true")) {
  %>
    <div class="comment">
      <form onsubmit="return checkText()" method="post" action="comment?id=<%=systemGroup.getId()%>">
        <p class="subTitle">[用户评价]</p>
  <%
            List<GroupComment> groupCommentList = (ArrayList<GroupComment>)session.getAttribute("groupCommentList");
            if (groupCommentList != null) {
                for (GroupComment groupComment : groupCommentList) {

  %>
        <div class="show">
          <p class="head">
  <%
                    int userId = groupComment.getUserId();
                    String userName = null;
                    if (userList != null) {
                        for (User user : userList) {
                            if (userId == user.getId())
                                userName = user.getUserName();
                        }
                    }
  %>
  <%
                    if (userName != null) {
  %>
            <span class="user"><%=userName%></span>
  <%
                    }
  %>
            <span class="time"><%=groupComment.getTime()%></span>
          </p>
          <p class="body"><%=groupComment.getContent()%></p>
        </div>
  <%
                }
            }else {
  %>
        <div class="show">
          <p class="body">暂时还没有用户写下评价哦~</p>
        </div>
  <%
            }
  %>
        <div class="write">
          <p class="authorizedUsers">可评论用户:
  <%
            if (userList != null) {
                for (User user : userList) {
  %>
            <span class="authorizedUser"><%=user.getUserName()%></span>
  <%
                }
            }
  %>
          </p>
          <textarea class="text" name="comment" placeholder="输入200字以内评价.."></textarea>
          <button type="submit" class="submit">发布评价</button>
          <input type="text" name="author" class="author" readonly="readonly">
        </div>
      </form>
    </div>
  <%
        }
    }
  %>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
  <script type="text/javascript" src="./js/groupDetail.js"></script>
</body>
</html>
