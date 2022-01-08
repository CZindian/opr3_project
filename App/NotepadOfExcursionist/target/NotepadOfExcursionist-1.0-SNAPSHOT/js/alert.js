const alert = document.querySelector('.alert-danger');
const button = document.querySelector('.btn-outline-danger');

button.addEventListener("click", function (){
    alert.classList.add('visually-hidden');
});