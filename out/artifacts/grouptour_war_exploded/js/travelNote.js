function createNote() {
    var userName = sessionStorage.getItem("userName");
    if (userName == null) {
        window.location.href="/registerALogin.jsp?name=login";
    }else {
        window.location.href="/writeNote.jsp";
    }
}
function showPage(pageNum, pageTotal) {
    var pageId = "page" + pageNum;
    var pageNumberId = "page" + pageNum + "Number";
    for (var i = 1; i <= pageTotal; i++)
    {
        if (i === pageNum) {
            document.getElementById(pageId).style.display = "block";
            document.getElementById(pageNumberId).style.color = "black";
        }else {
            document.getElementById(pageId).style.display = "none";
            document.getElementById(pageNumberId).style.color = "gray";
        }
    }
}
function addUserNameToHref(aNode) {
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        aNode.href = aNode.href + "&name=" + userName;
    }
}