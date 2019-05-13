function addUserNameToHref(aNode) {
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        aNode.href = aNode.href + "&name=" + userName;
    }
}