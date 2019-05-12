window.onload = function () {
    var currentUrl = window.location.href;
    if (currentUrl.indexOf("#") === -1) {
        document.getElementById("page1").style.display = "block";
        document.getElementById("page1Number").style.color = "black";
    }
};
function createNote() {
    var userName = sessionStorage.getItem("userName");
    if (userName == null) {
        window.location.href="/registerALogin.jsp?name=login";
    }else {
        window.location.href="/writeNote.jsp";
    }
}
function showPage(pageNum, pageTotal) {

    for (var i = 1; i <= pageTotal; i++)
    {
        var pageId = "page" + i;
        var pageNumberId = "page" + i + "Number";
        if (i !== pageNum) {
            document.getElementById(pageId).style.display = "none";
            document.getElementById(pageNumberId).style.color = "gray";
        }else {
            document.getElementById(pageId).style.display = "block";
            document.getElementById(pageNumberId).style.color = "black";
        }
    }
}
function addUserNameToHref(aNode) {
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        aNode.href = aNode.href + "&name=" + userName;
    }
}