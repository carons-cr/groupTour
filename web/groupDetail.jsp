<%--
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
</head>
<body>
  <nav>
    <iframe src="./nav.jsp" name="nav" scrolling="no"></iframe>
  </nav>
  <div class="content">
    <div class="groupInfo">
      <p class="groupName">呼伦贝尔六日拼团游</p>
      <div class="characteristic">
        <p class="subTitle">[旅行特色]</p>
        <p class="description">
          1、体验草原民族文化，在草原放风筝;赠送蒙古族特色服饰体验，拍照留念，探访牧民家;<br/>
          2、我们尽量避开拥挤的人群，不走寻常路，带您去看呼伦贝尔大草原自然风景点;<br/>
          3、承诺100%纯玩，不进任何购物店，无任何强制性收费;<br/>
          4、当地经验丰富的师傅，车况好，八九成新车辆;<br/>
          5、深度自由行，景点游玩时间可自行掌控，边走边玩边拍，随叫随停，您做主;<br/>
          6、住宿体验特色俄罗斯民族木屋，加星级舒适酒店，给您留下一次美好的旅行体验。
        </p>
      </div>
      <div class="detail">
        <img class="detailImg" src="./img/groupDetail/detail1.png"/>
      </div>
      <div class="route">
        <img class="routeImg" src="./img/groupRoute/route1.png"/>
      </div>
    </div>
    <div class="signUp">
      <form name="signUp">
        <div class="form-group">
          <input type="text" class="userInfo" name="userName" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="userInfo" name="realName" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="userInfo" name="sex" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="userInfo" name="age" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="realInfo" name="address" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="userInfo" name="mobileNumber" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <input type="text" class="userInfo" name="identificationNumber" placeholder="caron" readonly="readonly">
        </div>
        <div class="form-group">
          <button type="submit" class="submit">报名</button>
        </div>
      </form>
    </div>
    <div class="comment"></div>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
</html>
