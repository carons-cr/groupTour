window.onload=function () {
    var currentUrl = parent.location.href;
    var currentAId = (currentUrl.split("/")[currentUrl.split("/").length-1]).split(".")[0];
    var currentA = document.getElementById(currentAId);
    if (currentA != null) {
        currentA.style.fontSize = "20px";
        currentA.style.color = "white";
    }
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        document.getElementById("registerOrUserName").innerHTML=userName;
        document.getElementById("registerOrUserName").href=currentUrl;
        document.getElementById("loginOrExit").innerHTML="| 退出";
        document.getElementById("loginOrExit").href=currentUrl;
    }
};
