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
      <p class="groupName">呼伦贝尔6日拼团游</p>
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
      <form>
        <div class="row">
          <div class="column">
            <label for="userName" class="info-label">用户名</label>
            <input type="text" id="userName" class="userInfo" name="userName" readonly="readonly">
          </div>
          <div class="column">
            <label for="realName" class="info-label">姓名</label>
            <input type="text" id="realName" class="userInfo" name="realName">
          </div>
          <div class="column">
            <label for="sex" class="info-label">性别</label>
            <input type="text" id="sex" class="userInfo" name="sex">
        </div>
          </div>
        <div class="row">
          <div class="column">
            <label for="age" class="info-label">年龄</label>
            <input type="text" id="age" class="userInfo" name="age">
          </div>
          <div class="column">
            <label for="address" class="info-label">所在地</label>
            <input type="text" id="address" class="userInfo" name="address">
          </div>
          <div class="column">
            <label for="mobileNumber" class="info-label">手机号</label>
            <input type="text" id="mobileNumber" class="userInfo" name="mobileNumber">
          </div>
        </div>
        <div class="row">
          <div class="column">
            <label for="identificationNumber" class="info-label">身份证号</label>
            <input type="text" id="identificationNumber" class="userInfo" name="identificationNumber">
          </div>
        </div>
        <div class="row">
          <div class="column">
            <button type="submit" class="submit">报名</button>
          </div>
        </div>
      </form>
    </div>
    <div class="comment">
      <form>
        <p class="subTitle">[用户评价]</p>
        <div class="show">
          <p class="head">
            <span class="user">caron</span>
            <span class="time">2019-03-23</span>
          </p>
          <p class="body">总体满意，这次主要想体验北部的冰天雪地的感觉，因为我们这里基本每年都能看到雪的，但
            很不幸的是有史以来降雪最少，气温最高的暖冬被我赶上，中大奖了！不过旅行社安排的住宿和车辆还是不错的，
            司机小于人很不错，热心，踏实，也很热情。对于冬天的这条线路自然风景是看点，娱乐项目很少，网页上宣传的
            活动有不少因是淡季都没有了，在雪少的年份不推荐此线路。
          </p>
        </div>
        <div class="show">
          <p class="head">
            <span class="user">caron</span>
            <span class="time">2019-03-23</span>
          </p>
          <p class="body">总体满意，这次主要想体验北部的冰天雪地的感觉，因为我们这里基本每年都能看到雪的，但
            很不幸的是有史以来降雪最少，气温最高的暖冬被我赶上，中大奖了！不过旅行社安排的住宿和车辆还是不错的，
            司机小于人很不错，热心，踏实，也很热情。对于冬天的这条线路自然风景是看点，娱乐项目很少，网页上宣传的
            活动有不少因是淡季都没有了，在雪少的年份不推荐此线路。
          </p>
        </div>
        <div class="write">
          <textarea class="text" name="comment" placeholder="输入200字以内评价.."></textarea>
          <button type="submit" class="submit">发布评价</button>
        </div>
      </form>
    </div>
  </div>
  <footer>
    <iframe src="./html/footer.html" name="footer" scrolling="no"></iframe>
  </footer>
</body>
</html>
