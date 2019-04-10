window.onload=function () {
    var userName = sessionStorage.getItem("userName");
    if (userName !== "null") {
        document.getElementById("registerOrUserName").innerHTML=userName;
        document.getElementById("registerOrUserName").href="index.jsp";
        document.getElementById("loginOrExit").innerHTML="| 退出";
        document.getElementById("loginOrExit").onclick=function () {sessionStorage.clear();};
        document.getElementById("loginOrExit").href="index.jsp";
    }
};