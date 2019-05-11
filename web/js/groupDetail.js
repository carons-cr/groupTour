window.onload=function () {
    var userName = sessionStorage.getItem("userName");
    var currentUrl = parent.location.href;
    var end = currentUrl.split("=")[1];
    if (end !== "false") {
        var userNameNode = document.getElementById("userName");
        if (userName != null) {
            userNameNode.value = userName;
        }else {
            userNameNode.readOnly = false;
        }
    }else if (end === "false") {
        var writeNode = document.getElementsByClassName("write")[0];
        if (userName != null) {
            var authorNode = document.getElementsByClassName("author")[0];
            authorNode.value = userName;
            var userNodes = document.getElementsByClassName("user");
            var authorizedUserNodes = document.getElementsByClassName("authorizedUser");
            for (var i = 0; i < userNodes.length; i++) {
                if (userName === userNodes[i].innerText) {
                    writeNode.style.display = "none";
                }
            }
            for (var j = 0; j < authorizedUserNodes.length; j++) {
                if (userName === authorizedUserNodes[j].innerText)
                    break;
                else if (j === authorizedUserNodes.length - 1) {
                    writeNode.style.display = "none";
                }
            }
        }else {
            writeNode.style.display = "none";
        }
    }
};

function trim(str) {
    return str.replace(/\s+/g, "");
}

function checkAll() {
    var userInfoNodes = document.getElementsByClassName("userInfo");
    for (var i = 0; i < userInfoNodes.length; i++) {
        var userInfoNode = userInfoNodes[i];
        if (userInfoNode.value == null || trim(userInfoNode.value) === "") {
            userInfoNode.style.border = "1px red solid";
            return false;
        }else {
            userInfoNode.style.border = "0";
        }
    }
    return true;
}

function checkText() {
    var textNode = document.getElementsByClassName("text")[0];
    if (textNode.value == null || trim(textNode.value) === "") {
        textNode.style.border = "1px red solid";
        return false;
    }
    return true;
}
