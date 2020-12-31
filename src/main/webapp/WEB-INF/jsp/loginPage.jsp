<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <!-- VENDOR CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/bootstrap.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/vendor/font-awesome/css/font-awesome.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/vendor/linearicons/style.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/main.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/css/demo.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/img/apple-icon.png" />">
        <link rel="stylesheet" href="<c:url value="/resources/admin/assets/img/favicon.png" />">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <style>
            body { 
                background-repeat: no-repeat;
                background-attachment: fixed; 
                background-size: 100% 100%;
            }
        </style>
    </head>
    <body style="background-image: url('<c:url value="/resources/admin/assets/img/city2.jpg" />');">
        <div id="wrapper">
            <div class="vertical-align-wrap">
                <div class="vertical-align-middle">
                    <div class="auth-box ">
                        <div class="left" style="background-color: threedhighlight;">
                            <div class="content">
                                <div class="header">
                                    <div class="logo text-center"><h2>Ecomerce</h2></div>
                                    <p class="lead">Login to admin account</p>
                                </div>
                                <form action="${pageContext.request.contextPath}/login" method="POST" class="form-auth-small">
                                    <div class="form-group">
                                        <label for="signin-email" class="control-label sr-only">Email</label>
                                        <input type="text" name="email" class="form-control" id="signin-email" placeholder="Email" required=""/>
                                    </div>
                                    <div class="form-group">
                                        <label for="signin-password" class="control-label sr-only">Password</label>
                                        <input type="password" name="noopPassword" class="form-control" id="signin-password" placeholder="Password(Please use the US Keyboar)" required=""/>
                                    </div>
                                    <button type="submit" class="form-submit">LOGIN</button>
                                </form>
                            </div>
                        </div>
                        <div class="right" style="background-image: url('<c:url value="/resources/admin/assets/img/city3.png" />');">
                            
                            <div class="content text">
                                <h1 class="heading" style="text-align: center; color: silver; font-size: 40px; padding-top: 20%;"><strong>Welcome to Admin Page</strong></h1>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
