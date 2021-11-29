const imgDiv = document.querySelector(".img_div");
const picturesDiv = document.querySelector(".img_div");
const imgInp = document.getElementById("pictures");

imgDiv.classList.add("hidden");

imgInp.onchange = evt => {
    const [file] = imgInp.files;
    if (imgDiv.classList.contains("hidden")){
        imgDiv.classList.add("visible");
    }
    if (file) {
        picturesDiv.innerHTML += "<img src='" + URL.createObjectURL(file) + "' alt='" + file.name + "'>";
    }
}