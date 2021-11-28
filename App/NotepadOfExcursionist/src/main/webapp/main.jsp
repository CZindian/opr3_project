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
    <title>Hlavní stránka</title>
</head>
<body>

<nav>
    <jsp:include page="add_trip_btn.jsp"/>
    <jsp:include page="main_navigation.jsp"/>
</nav>

<main>
    <jsp:include page="main_notes_view.jsp"/>
</main>


<footer>
<jsp:include page="main_footer.jsp"/>
</footer>

</body>

</html>
