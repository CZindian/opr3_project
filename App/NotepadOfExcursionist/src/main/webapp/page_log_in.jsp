<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content="Dominik Sliwka"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <title>Přihlášení</title>
</head>
<body>
<div class="centralizing_div">

    <div class="log_in_div">
        <span>
            <h1>Přihlášení</h1>
        </span>
        <form action="LogInServlet" method="post">
            <span>
                <label for="email">Email</label>
                <input type="text" id="email" name="email">
            </span>
            <span>
                <label for="password">Heslo</label>
                <input type="password" id="password" name="password">
            </span>
            <input type="submit" value="Přihlásit se">
        </form>
    </div>

</div>
</body>
</html>
