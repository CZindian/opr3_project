<%@ page import="cz.osu.opr3.project.notepadofexcursionist.service.CurrentUserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if (!CurrentUserManager.isIsClientLoggedIn()) {
%>
<jsp:include page="page_log_in.jsp"/>
<%
} else {
%>
<jsp:include page="page_main.jsp"/>
<%
    }
%>