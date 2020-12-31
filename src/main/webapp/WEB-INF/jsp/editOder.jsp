<%-- 
    Document   : listAirCraft
    Created on : 29 thg 9, 2020, 08:57:03
    Author     : HP
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
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
        <link href="${pageContext.request.contextPath}/https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons 2.0.0 -->
        <link href="${pageContext.request.contextPath}/http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
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
                    Edit Product
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>Edit</a></li>
                    <li><a href="#"><i class="fa fa-dashboard"></i>Product</a></li>
                    <li class="active">Edit Product</li>
                </ol>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel-body">

                            <mvc:form modelAttribute="oderList" action="${pageContext.request.contextPath}/updateOder" class="form-horizontal form-bordered" method="post">
                                <mvc:input path="id" type="hidden"/>
                                <mvc:input path="id" type="hidden"/>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="inputDefault">Oder ID</label>
                                    <div class="col-md-6">

                                        <mvc:input path="id" readonly="true"  class="form-control" id="inputDefault" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="inputDefault">Amount</label>
                                    <div class="col-md-6">

                                        <mvc:input path="PriceFormatted" required="true" class="form-control" id="inputDefault" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="inputDisabled">Date</label>
                                    <div class="col-md-6">
                                        <mvc:input path="date" type="date" required="true" class="form-control" id="inputDefault" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="input">Customer Name</label>
                                    <div class="col-md-6">
                                        <mvc:input path="customerName" required="true" class="form-control" id="inputDefault"/>
                                    </div>
                                </div>
                                    <div class="form-group">
                                    <label class="col-md-3 control-label" for="input">Customer Address</label>
                                    <div class="col-md-6">
                                        <mvc:input path="customerAddress" required="true" class="form-control" id="inputDefault"/>
                                    </div>
                                </div>
                                    <div class="form-group">
                                    <label class="col-md-3 control-label" for="input">Phone</label>
                                    <div class="col-md-6">
                                        <mvc:input path="phone" required="true" class="form-control" id="inputDefault"/>
                                    </div>
                                </div>
                                    <div class="form-group">
                                    <label class="col-md-3 control-label" for="input">Email</label>
                                    <div class="col-md-6">
                                        <mvc:input path="email" required="true" class="form-control" id="inputDefault"/>
                                    </div>
                                </div>
                                    
                                                                    <div class="form-group">
                                    <label class="col-md-3 control-label"></label>
                                    <div class="col-md-6 col-xs-11">                                    
                                        <input type="submit" class="btn btn-sm btn-primary" data-plugin-colorpicker data-color-format="hex" data-color="rgb(255, 255, 255)" value="Save" />
                                    </div>
                                </div>
                            </mvc:form>
                        </div>
                    </div>
                </div>
            </section>
        </div>

    <%@include file="homeFooterJquery.jsp" %>
</body>
</html>

