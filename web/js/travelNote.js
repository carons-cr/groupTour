function createNote() {
    var userName = sessionStorage.getItem("userName");
    if (userName == null) {
        window.location.href="/registerALogin.jsp?name=login";
    }else {
        window.location.href="/writeNote.jsp";
    }
}