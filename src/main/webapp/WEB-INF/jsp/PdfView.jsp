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
                    List Product
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>List</a></li>
                    <li class="active">List Product</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary"><a href="${pageContext.request.contextPath}/export" style="color: black">DownLoad Excel</a></button>
                            </div>
                           
                            </div><br><br>
                            <div class="box-body">
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                         
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Images</th>
<!--                                            <th>Chiều Dài</th>
                                            <th>Chiều Rộng</th>
                                            <th>Chiều Cao</th>
-->                                            <th>Trọng Lượng</th>
                                            <th>Kiểu Màn Hình </th>
                                            <th>Độ Phân Giải</th>
                                            <th>Các Tính Năng Khác</th>
                                            <th>Jack Cắm Audio</th>
                                            <th>Bộ Nhớ Trong</th>
                                            <th>Thẻ Nhớ</th>
                                            <th>Hỗ Trợ 3G</th>
                                            <th>Camera</th>
                                            <th>Hệ Điều Hành</th>
                                            <th>CPU</th>
                                            <th>RAM</th>
                                            <th>PIN</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="product" items="${productList}">
                                            <tr>
                                              
                                                <td>${product.name}</td>
                                                <td>${product.price}</td>
                                                <td><img src="<c:url value="./img/${product.image}"/>" alt=""></td>
<!--                                                <td>${product.productdetails.chieuDai}</td>
                                                <td>${product.productdetails.chieuRong}</td>
                                                <td>${product.productdetails.chieuCao}</td>
-->                                                <td>${product.productdetails.canNang}</td>
                                                <td>${product.productdetails.kieuManHinh}</td>
                                                <td>${product.productdetails.doPhanGiai}</td>
                                                <td>${product.productdetails.cacTinhNangKhac}</td>
                                                <td>${product.productdetails.jackCamAudio}</td>
                                                <td>${product.productdetails.boNhoTrong}</td>
                                                <td>${product.productdetails.theNho}</td>
                                                <td>${product.productdetails.hoTro3g}</td>
                                                <td>${product.productdetails.mayAnh}</td>
                                                <td>${product.productdetails.heDieuHanh}</td>
                                                <td>${product.productdetails.cpu}</td>
                                                <td>${product.productdetails.ram}</td>
                                                <td>${product.productdetails.pin}</td>
                                                </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.box-body -->
                        </div>
                      
                        </div></div></div>
                        </section>
                    </div> 
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

