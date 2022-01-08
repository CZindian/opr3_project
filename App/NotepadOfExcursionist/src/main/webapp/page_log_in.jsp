<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8"/>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content="Dominik Sliwka"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>Přihlášení</title>
</head>
<body id="log_in_body">

<div id="log_in_div">
    <c:if test="<%=LoggedInUserManager.isIsErrorRaised()%>">
        <div class="alert alert-danger" role="alert">
            <div class="row">
                <div class="col text-center">
                    <i class="fas fa-exclamation-triangle text-warning"></i>
                    Přihlášení se nezdařilo! Zadejte správné přihlašovací údaje.
                    <button type="button" class="btn btn-outline-danger btn-sm fas fa-times-circle"></button>
                </div>
            </div>
        </div>
        <%LoggedInUserManager.setIsErrorRaised(false);%>
        <script src="js/alert.js"></script>
    </c:if>
    <div id="logreg-forms">
        <form class="form-signin" action="LogInServlet" method="post">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Přihlášení</h1>
            <input type="email" id="email" name="email" class="form-control" placeholder="Email"
                   required="<%=Constants.VALID_EMAIL_PATTERN%>>" value="${sessionScope["user_email"]}" autofocus="">
            <input type="password" id="password" name="password" class="form-control" placeholder="Heslo"
                   required="<%=Constants.VALID_PASSWORD_PATTERN%>">

            <div class="row align-items-center">
                <div class="col-md-6 col-sm-6">
                    <button class="btn btn-outline-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i>
                        Přihlásit se
                    </button>
                </div>
                <div class="col-md-6 col-sm-6 text-end">
                    <a href="#" id="forgot_password">Zapoměli jste heslo?</a>
                </div>
            </div>
            <hr>
            <button class="btn btn-outline-primary btn-block" type="button" id="btn-signup"><i
                    class="fas fa-user-plus"></i>
                Vytvořte si nový účet
            </button>
        </form>
    </div>
</div>
</body>
</html>
