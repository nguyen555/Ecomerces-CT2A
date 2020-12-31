<%-- 
    Document   : main
    Created on : 1 thg 10, 2020, 10:30:55
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
                    </div>
                    <div class="pull-left info">
                        <p>Alexander Pierce</p>

                        <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                    </div>
                </div>
                <!-- search form -->
                <form action="search" method="get" class="sidebar-form">
                    <div class="input-group">
                        <input type="text" name="searchText" class="form-control" placeholder="Search..."/>
                        <span class="input-group-btn">
                            <button type='submit' name='searchText' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                </form>
                <!-- /.search form -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">MAIN NAVIGATION</li>
                    <li class="active treeview">
                        <a href="./">
                            <i class="fa fa-dashboard"></i> <span>Home</span> 
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="${pageContext.request.contextPath}/listProduct1">
                            <i class="fa fa-table"></i> <span>Product ManageMent</span>
                        </a>
                    </li>
                    
                    <li class="treeview">
                        <a href="${pageContext.request.contextPath}/listCustomer">
                            <i class="fa fa-table"></i> <span>Customer Management</span>
                        </a>
                    </li>
                    
                    <li class="treeview">
                        <a href="${pageContext.request.contextPath}/listOrder">
                            <i class="fa fa-table"></i> <span>Oder Management</span>
                        </a>
                    </li>
                   
                    <li>
                        <a href="${pageContext.request.contextPath}/listColor">
                            <i class="fa fa-table"></i> <span>Color</span>
                            
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/listManufacture">
                            <i class="fa fa-table"></i> <span>Manufacturer</span>
                            
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/listUser">
                            <i class="fa fa-table"></i> <span>USer</span>
                            
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/logout">
                            <i class="fa fa-envelope"></i> <span>Logout</span>
                           
                        </a>
                    </li>

            </section>
            <!-- /.sidebar -->
        </aside>
    </body>
</html>
