<%@ page import="cz.osu.opr3.project.notepadofexcursionist.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="currenUser"
             class="cz.osu.opr3.project.notepadofexcursionist.model.CurrentUser"
             scope="session"/>

<div>
    <c:if test="${currenUser.currentUserDada.userEmail != null && currenUser.currentUserDada.userEmail.length() > 0}">
        <img src="${currenUser.currentUserDada.userProfilePicture}"
             alt="profilový obrázek ${currenUser.currentUserDada.userName} ${currenUser.currentUserDada.userSurname}">
    </c:if>
    <c:if test="${currenUser.currentUserDada.userEmail == null || currenUser.currentUserDada.userEmail.length() == 0}">
        <img src="<%=Constants.DEFAULT_USER_PICTURE_BASE64_STRING%>"
             alt="přednastavený obrázek ${currenUser.currentUserDada.userName} ${currenUser.currentUserDada.userSurname}">
    </c:if>
    <span>${currenUser.currentUserDada.userName} ${currenUser.currentUserDada.userSurname}</span>
    <form action="LogOutServlet" method="post">
        <input type="submit" value="Odhlásit">
    </form>
</div>