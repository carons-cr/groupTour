window.onload=function () {
    var textAreaNode = document.getElementsByClassName("text")[0];
    var textAreaScrollHeight = textAreaNode.scrollHeight;
    var textAreaHeight = textAreaNode.offsetHeight;
    if (textAreaScrollHeight > textAreaHeight) {
        textAreaNode.style.height = textAreaScrollHeight + "px";
    }
};