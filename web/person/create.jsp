<%-- 
    Document   : create
    Created on : Jul 9, 2014, 10:13:00 AM
    Author     : rakateja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <div class="col-lg-12 col-md-12 col-sm-12">
                    
                    <form action="person.jspa?action=create" method="POST" class="form-horizontal">
                        
                        <input name="id" value="${person.id}" type="hidden">
                        
                        <div class="form-group">
                            <label>No KTP</label>
                            <input type="text" name="no_ktp" value="${person.noKtp}" class="form-control" placeholder="No KTP Penduduk">
                        </div>
                        <div class="form-group">
                            <label>Nama Penduduk</label>
                            <input type="text" name="nama" value="${person.nama}" class="form-control" placeholder="Nama Penduduk"/>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="text" name="email" value="${person.email}" class="form-control" placeholder="Ketik Email">
                        </div>
                        <div class="form-group">
                            <label>Jenis Kelamin</label>
                            <input type="radio" name="sex" value="1" selected="selected">&nbsp;Laki-laki
                            <input type="radio" name="sex" value="0">&nbsp;Perempuan
                        </div>
                        <div class="form-group">
                            <label>Phone No.</label>
                            <input type="text" name="phone" value="${person.phone}" class="form-control" placeholder="Phone No.">
                        </div>
                        <div class="form-group">
                            <label>Kota</label>
                            <input type="text" name="kota" value="${person.city}" class="form-control" placeholder="Kota" />
                        </div>
                        <div class="form-group">
                            <label>Bio</label>
                            <textarea name="bio" class="form-control" value ="" placeholder="Tentang anda...">${person.bio}</textarea>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="Simpan" class="btn btn-sm btn-primary"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
