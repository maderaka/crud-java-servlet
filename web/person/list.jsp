<%-- 
    Document   : list
    Created on : Jul 9, 2014, 5:44:46 PM
    Author     : rakateja
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIM Desa</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-theme.mini.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/navbar-fixed.css"/>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a href="person.jspa?action=list" class="navbar-brand">Penduduk</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="person.jspa?action=list">View all customers</a></li>
                    <li><a href="person.jspa?action=create">Create New</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-12 col-md-12">
                    <div class="pull-right">
                        <c:forEach var="i" begin="1" end="${totalPage+2}">
                            <c:if test="${i== current_page}">
                                <span><a class="btn btn-xs btn-primary" href="person.jspa?action=list&page=${i}">&nbsp;${i}&nbsp;</a></span>&nbsp;
                            </c:if>
                            <c:if test="${i!= current_page}">
                                <span><a class="btn btn-xs btn-default" href="person.jspa?action=list&page=${i}">&nbsp;${i}&nbsp;</a></span>&nbsp;
                            </c:if>
                        </c:forEach>
                    </div>
                    <br><br>
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>No. KTP</th>
                                <th>Nama</th>
                                <th>Email</th>
                                <th>Sex</th>
                                <th>Phone</th>
                                <th>Kota</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="person" items="${list}">
                                <tr>
                                    <td>${person.id}</td>
                                    <td>${person.noKtp}</td>
                                    <td>${person.nama}</td>
                                    <td>${person.email}</td>
                                    <td>
                                        <c:if test="${person.sex == 0}">Perempuan</c:if>
                                        <c:if test="${person.sex == 1}">Laki-laki</c:if>
                                    </td>
                                    <td>${person.phone}</td>
                                    <td>${person.city}</td>
                                    <td>
                                        <a href="person.jspa?action=view&id=${person.id}" class="btn btn-sm btn-success">View</a>
                                        <a href="person.jspa?action=edit&id=${person.id}" class="btn btn-sm btn-warning">Edit</a>
                                        <a href="person.jspa?action=delete&id=${person.id}" class="btn btn-sm btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="pull-right">
                        <c:forEach var="i" begin="1" end="${totalPage+2}">
                            <c:if test="${i== current_page}">
                                <span><a class="btn btn-xs btn-primary" href="person.jspa?action=list&page=${i}">&nbsp;${i}&nbsp;</a></span>&nbsp;
                            </c:if>
                            <c:if test="${i!= current_page}">
                                <span><a class="btn btn-xs btn-default" href="person.jspa?action=list&page=${i}">&nbsp;${i}&nbsp;</a></span>&nbsp;
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
