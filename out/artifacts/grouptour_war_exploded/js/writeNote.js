var id = 0;
var imgHeight = 120;

window.onload=function () {
    var userName = sessionStorage.getItem("userName");
    if (userName != null) {
        var authorNode = document.createElement("input");
        authorNode.className = "author";
        authorNode.name = "author";
        authorNode.value = userName;
        authorNode.readOnly = true;
        var timeNode = document.createElement("span");
        timeNode.className = "time";
        var date = new Date();
        timeNode.innerText = date.toLocaleDateString();
        var completeNoteNode = document.getElementsByClassName("completeNote")[0];
        completeNoteNode.appendChild(authorNode);
        completeNoteNode.appendChild(timeNode);
    }
};

function autoTextAreaHeight() {
    var textAreaNode = document.getElementsByName("article")[0];
    var textAreaScrollHeight = textAreaNode.scrollHeight;
    var textAreaHeight = textAreaNode.offsetHeight;

    if (textAreaScrollHeight > textAreaHeight) {
        textAreaNode.style.height = textAreaScrollHeight + "px";
        document.getElementsByClassName("article")[0].style.height = textAreaScrollHeight + "px";
    }

}

function addImg(selectFileNode) {
    var imgFile = selectFileNode.files[0];
    if (window.FileReader) {
        var reader = new FileReader();
        reader.readAsDataURL(imgFile);
        reader.onload = function (ev) {
            id += 1;
            var imgUrl = ev.target.result;
            var imgNode = document.createElement("img");
            imgNode.id = "img" + id;
            imgNode.className = "img";
            imgNode.src = imgUrl;
            var imgInputNode = document.createElement("input");
            imgInputNode.name = "img";
            imgInputNode.value = imgUrl;
            imgInputNode.type = "hidden";
            var deleteImgNode = document.createElement("button");
            deleteImgNode.className = "deleteImg";
            deleteImgNode.onclick = function () {
                imgInputNode.name = "deleteImg";
                imgHeight -= imagesNode.children[2].clientHeight;
                imgNode.style.display="none";
                deleteImgNode.style.display="none";
                imgInputNode.style.display="none";
                return false;
            };
            deleteImgNode.innerHTML = "x";
            var imagesNode = document.getElementById("images");
            imagesNode.appendChild(imgNode);
            imagesNode.appendChild(imgInputNode);
            imagesNode.appendChild(deleteImgNode);
            imgHeight += imagesNode.children[2].clientHeight;
            if (imgHeight > imagesNode.offsetHeight)
                imagesNode.style.height = imgHeight + "px";
        };
    }
}

function hideTitleWarn() {
    document.getElementsByClassName("titleWarn")[0].style.display="none";
}

function checkTitle() {
    var title = document.getElementsByName("title")[0].value;
    if (title == null || title.replace(/\s+/g, "") === "") {
        document.getElementsByClassName("titleWarn")[0].style.display="block";
        return false;
    }
}