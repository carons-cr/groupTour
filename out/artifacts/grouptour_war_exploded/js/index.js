/*window.onload=function (userName) {
    if(userName != null) {
        document.getElementById("registerOrUserName").value=userName;
        document.getElementById("registerOrUserName").href="index.jsp";
        document.getElementById("loginOrExit").value="| 退出";
        document.getElementById("loginOrExit").onclick=clearSession();
        document.getElementById("loginOrExit").href="index.jsp";
    }
};*/
function showRegister() {
    document.getElementById("login").style.display="none";
    document.getElementById("register").style.display="block";
}
function showLogin() {
    document.getElementById("register").style.display="none";
    document.getElementById("login").style.display="block";
}
function hideRegister() {
    document.getElementById("register").style.display="none";
}
function hideLogin() {
    document.getElementById("login").style.display="none";
}
function trim(str) {
    return str.replace(/\s+/g, "");
}
function checkUserName(formName) {
    var index = formName == "register" ? 0 : 1;
    var userName = document.getElementsByName("userName")[index].value;
    if (userName == null || trim(userName) == "") {
        document.getElementsByClassName("userNameWarn")[index].style.display="block";
        return false;
    }else {
        document.getElementsByClassName("userNameWarn")[index].style.display="none";
        return true;
    }
}
function checkPassword(formName) {
    var index = formName == "register" ? 0 : 1;
    var password = document.getElementsByName("password")[index].value;
    if (password == null || trim(password) == "") {
        document.getElementsByClassName("passwordWarn")[index].style.display="block";
        return false;
    }else {
        document.getElementsByClassName("passwordWarn")[index].style.display="none";
        return true;
    }
}
function checkRePassword() {
    var password = document.getElementsByName("password")[0].value;
    var rePassword = document.getElementsByName("rePassword")[0].value;
    if (rePassword != password) {
        document.getElementsByClassName("rePasswordWarn")[0].style.display="block";
        return false;
    }else {
        document.getElementsByClassName("rePasswordWarn")[0].style.display="none";
        return true;
    }
}
function checkAll(formName) {
    var isSubmit = checkUserName(formName) && checkPassword(formName);
    if (formName == 'register')
    {
        isSubmit = isSubmit && checkRePassword();
    }
    return isSubmit;
}
/*function registerOrLoginResult(sessionStorage) {
    var userName = sessionStorage.getItem("userName");
    var reRegisterUserName = sessionStorage.getItem("reRegisterUserName");
    if (userName !== "null") {
        document.getElementById("registerOrUserName").innerHTML=userName;
        document.getElementById("registerOrUserName").onclick=function () {};
        document.getElementById("registerOrUserName").href="index.jsp";
        document.getElementById("loginOrExit").innerHTML="| 退出";
        document.getElementById("loginOrExit").onclick=function () {sessionStorage.clear()};
        document.getElementById("loginOrExit").href="index.jsp";
    }else if (reRegisterUserName !== "null") {
        document.getElementById("register").style.display="block";
        document.getElementsByClassName("userName")[0].value=reRegisterUserName;
        document.getElementsByClassName("userNameWarn")[0].innerHTML="该用户名已被注册";
        document.getElementsByClassName("userNameWarn")[0].style.display="block";
    }
}*/