const imgDivToShow = document.querySelector(".img_div");
const selectedPicturesDiv = document.querySelector(".img_div");
const selectedImgInput = document.getElementById("pictures");

imgDivToShow.classList.add("hidden");

selectedImgInput.onchange = evt => {
    const [file] = selectedImgInput.files;
    if (imgDivToShow.classList.contains("hidden")) {
        imgDivToShow.classList.add("visible");
    }
    if (file) {
        selectedPicturesDiv.innerHTML += "<img src='" + URL.createObjectURL(file) + "' alt='" + file.name + "'>";
    }
}