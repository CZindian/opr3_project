const carousel = document.getElementById("img_div");
const selectedImgInput = document.getElementById("picture");

selectedImgInput.onchange = evt => {
    carousel.innerHTML = "";
    const [file] = selectedImgInput.files;
    if (file) {
        carousel.innerHTML += "<img id='trip_img' src='" + URL.createObjectURL(file) + "' alt='" + file.name + "'>";
    }
}