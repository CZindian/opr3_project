<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.LoggedInUserManager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="<%=!LoggedInUserManager.isIsClientLoggedIn()%>">
    <jsp:include page="page_log_in.jsp"/>
</c:if>
<c:if test="<%=LoggedInUserManager.isIsClientLoggedIn()%>">
    <jsp:include page="page_main.jsp"/>
</c:if>
