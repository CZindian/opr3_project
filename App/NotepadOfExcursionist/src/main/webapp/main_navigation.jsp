<%@ page import="cz.osu.opr3.project.notepadofexcursionist.Constants" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.CurrentUserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>

    <c:if test="<%=CurrentUserManager.isSetProfilePicture()%>">
        <img src="<%=CurrentUserManager.getProfilePicture()%>"
             alt="profilový obrázek od <%=CurrentUserManager.getNameAndSurname()%>">
    </c:if>

    <c:if test="<%=!CurrentUserManager.isSetProfilePicture()%>">
        <img src="<%=Constants.DEFAULT_USER_PICTURE_BASE64_STRING%>"
             alt="přednastavený obrázek od <%=CurrentUserManager.getNameAndSurname()%>">
    </c:if>

    <span><%=CurrentUserManager.getNameAndSurname()%></span>

    <form action="LogOutServlet" method="post">
        <input type="submit" value="Odhlásit">
    </form>

</div>