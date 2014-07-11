<%-- 
    Document   : view.jsp
    Created on : Jul 9, 2014, 7:54:29 PM
    Author     : rakateja
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/navbar-fixed.css"/>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a href="person.jspa?action=list" class="navbar-brand">Penduduk</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="person.jspa?action=list">Semua penduduk</a>
                    <li><a href="person.jspa?action=create">Create New</a></li>
                </ul>
            </div>
        </nav>
        <div class="container" style="text-align: center;">
            <h4>${person.nama}</h4>
            <p>Email: ${person.email}</p>
            <p>Jenis Kelamin: <c:if test="${person.sex == 0}">Perempuan</c:if>
                                        <c:if test="${person.sex == 1}">Laki-laki</c:if></p>
            <p>Phone: ${person.phone}</p>
            <p>Bio: ${person.bio}</p>
        </div>
    </body>
</html>
