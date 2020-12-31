<%-- 
    Document   : listAirCraft
    Created on : 29 thg 9, 2020, 08:57:03
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AdminLTE | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- Bootstrap 3.3.2 -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />    
        <!-- FontAwesome 4.3.0 -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons 2.0.0 -->
        <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
        <!-- AdminLTE Skins. Choose a skin from the css/skins 
             folder instead of downloading all of them to reduce the load. -->
        <link href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
        <!-- iCheck -->
        <link href="${pageContext.request.contextPath}/plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${pageContext.request.contextPath}/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->


    </head>
    <body class="skin-blue">
        <%@include file="homeHeader.jsp" %>
        <%@include file="homeMain.jsp"%>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    List Order
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>List</a></li>
                    <li class="active">List Order</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            
                            <br>
                            <div class="col-xs-6">
                                <form action="search" method="get"> 
                                    <input type="text" name="searchText" id="searchText" value="${searchText}" style="width: 30em">
                                    <input type="submit" value="Search">
                                </form>
                            </div><br><br>
                            <div class="box-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                         
                                            <th>Number Of Oder</th>
                                            <th>Product</th>
                                            <th>Price</th>
                                            <th>Date</th>
                                            <th>Payment Method</th>
                                            <th>Quantity</th>
                                           
                                            
                                         
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="ordersdetails" items="${OrderDetailsList}">
                                            <tr>
                                              
                                                <td>${ordersdetails.numberOfOrders}</td>
                                                <td>${ordersdetails.product.name}</td>
                                                <td>${ordersdetails.totalFormatted}</td>
                                                <td>${ordersdetails.date}</td>
                                                <td>${ordersdetails.paymentMethod}</td>
                                                <td>${ordersdetails.quantity}</td>
                                        
                                               
                                                
                                                <td><a href="${pageContext.request.contextPath}/deleteOderdetails/${ordersdetails.id}">Delete</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.box-body -->
                        </div>
                        <div class="col-xs-6">
                            <div class="dataTables_paginate paging_bootstrap">
                                <ul class="pagination">
                                    <li>
                                        <a href="#">← Previous</a>
                                    </li>
                                    <li class="active">
                                        <a href="#">1</a>
                                    </li>
                                    <li>
                                        <a href="#">2</a>
                                    </li>
                                    <li>
                                        <a href="#">3</a>
                                    </li>
                                    <li>
                                        <a href="#">4</a>
                                    </li>
                                    <li>
                                        <a href="#">5</a>
                                    </li>
                                    <li>
                                        <a href="#">6</a>
                                    </li>
                                    <li>
                                        <a href="#">7</a>
                                    </li>

                                    <li class="next">
                                        <a href="#">Next → </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                        </section>
                    </div> 
                

                <%@include file="homeFooterJquery.jsp" %>
                
                <script type="text/javascript">
                    $(function () {
                        $("#example1").dataTable();
                        $('#example2').dataTable({
                            "bPaginate": true,
                            "bLengthChange": false,
                            "bFilter": false,
                            "bSort": true,
                            "bInfo": true,
                            "bAutoWidth": false
                        });
                    });
                </script>
                </body>
                </html>

