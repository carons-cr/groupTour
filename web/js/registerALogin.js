function showRegisterHideLogin() {
    document.getElementById("login").style.display="none";
    document.getElementById("register").style.display="block";
}
function showLoginHideRegister() {
    document.getElementById("register").style.display="none";
    document.getElementById("login").style.display="block";
}
function trim(str) {
    return str.replace(/\s+/g, "");
}
function checkUserName(formName) {
    var index = formName === "register" ? 0 : 1;
    var userName = document.getElementsByName("userName")[index].value;
    if (userName == null || trim(userName) === "") {
        document.getElementsByClassName("userNameWarn")[index].style.display="block";
        return false;
    }else {
        document.getElementsByClassName("userNameWarn")[index].style.display="none";
        return true;
    }
}
function checkPassword(formName) {
    var index = formName === "register" ? 0 : 1;
    var password = document.getElementsByName("password")[index].value;
    if (password == null || trim(password) === "") {
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
    if (rePassword !== password) {
        document.getElementsByClassName("rePasswordWarn")[0].style.display="block";
        return false;
    }else {
        document.getElementsByClassName("rePasswordWarn")[0].style.display="none";
        return true;
    }
}
function checkAll(formName) {
    var isSubmit = checkUserName(formName) && checkPassword(formName);
    if (formName === 'register')
    {
        isSubmit = isSubmit && checkRePassword();
    }
    return isSubmit;
}
