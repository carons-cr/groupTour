var id = 0;
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
            console.log(imgNode.id);
            imgNode.name = "img";
            imgNode.className = "img";
            imgNode.src = imgUrl;
            var deleteImgNode = document.createElement("button");
            deleteImgNode.className = "deleteImg";
            deleteImgNode.onclick = function () {deleteImgNode.style.display="none";return deleteImg(imgNode.id)};
            deleteImgNode.innerHTML = "x";
            var imagesNode = document.getElementById("images");
            imagesNode.appendChild(imgNode);

            imagesNode.appendChild(deleteImgNode);
        }
    }
}

function deleteImg(imgId) {
    var imgNode = document.getElementById(imgId);
    imgNode.name="imgHide";
    imgNode.style.display="none";
    return false;
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