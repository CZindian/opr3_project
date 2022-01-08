<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/error500_style.css">
    <title>Error 500</title>
</head>
<body>

<div class="error-500" data-text="Ajéje! Náš hloupý kód nefunguje! Chyba není na Vaší straně!">
    <spaguetti>
        <fork></fork>
        <meat></meat>
        <pasta></pasta>
        <plate></plate>
    </spaguetti>
</div>
<script>
    const error = document.querySelector(".error-500");
    let i = 0, data = "", text = error.getAttribute("data-text");

    let typing = setInterval(() => {
        if(i == text.length){
            clearInterval(typing);
        }else{
            data += text[i];
            document.querySelector(".error-500").setAttribute("data-text", data);
            i++;
        }
    }, 100);
</script>
</body>
</html>
