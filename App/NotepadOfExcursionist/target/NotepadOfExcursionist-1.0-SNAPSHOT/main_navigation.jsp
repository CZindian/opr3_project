<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <c:if test="<%=LoggedInUserManager.isSetProfilePicture()%>">
        <img src="<%=LoggedInUserManager.getProfilePicture()%>"
             alt="profilový obrázek od <%=LoggedInUserManager.getNameAndSurname()%>">
    </c:if>

    <c:if test="<%=!LoggedInUserManager.isSetProfilePicture()%>">
        <img src="<%=Constants.DEFAULT_USER_PICTURE_BASE64_STRING%>"
             alt="přednastavený obrázek od <%=LoggedInUserManager.getNameAndSurname()%>">
    </c:if>

    <span><%=LoggedInUserManager.getNameAndSurname()%></span>

    <form action="LogOutServlet" method="post">
        <input type="submit" value="Odhlásit">
    </form>

</div>