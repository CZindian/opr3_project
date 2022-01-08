<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@ page import="cz.osu.opr3.project.notepadofexcursionist.utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <ul class="navbar-nav center_align">
        <li class="nav-item dropdown">
            <button
                    type="button"
                    class="btn dropdown-toggle d-flex align-items-center"
                    id="navbarDropdownMenuLink"
                    role="button"
                    data-toggle="dropdown"
                    aria-expanded="false">
                <c:if test="<%=LoggedInUserManager.isSetProfilePicture()%>">
                    <img src="<%=LoggedInUserManager.getProfilePicture()%>"
                         alt="profilový obrázek od <%=LoggedInUserManager.getNameAndSurname()%>"
                         class="rounded-circle"
                         height="22"
                         loading="lazy">
                </c:if>
                <c:if test="<%=!LoggedInUserManager.isSetProfilePicture()%>">
                    <img src="<%=Constants.DEFAULT_USER_PICTURE_BASE64_STRING%>"
                         alt="přednastavený obrázek od <%=LoggedInUserManager.getNameAndSurname()%>"
                         class="rounded-circle"
                         height="75"
                         loading="lazy">
                </c:if>
            </button>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <li class="text-center">
                    <form action="LogOutServlet" method="post">
                        <button type="submit" class="btn btn-sm btn-danger">
                            <i class="fas fa-sign-out-alt"></i> Odhlásit se
                        </button>
                    </form>
                </li>
            </ul>
        </li>
        <li class="text-center">
            <%=LoggedInUserManager.getNameAndSurname()%>
        </li>
        <li class="text-center p-2">
            <jsp:include page="new_note_add_btn.jsp"/>
        </li>
    </ul>
</div>
