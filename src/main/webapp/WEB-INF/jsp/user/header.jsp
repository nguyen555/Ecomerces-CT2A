<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Electro Store Ecommerce Category Bootstrap Responsive Web Template | Home :: w3layouts</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="UTF-8" />
        <meta name="keywords" content="Electro Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
              />
        <script>
            addEventListener("load", function () {
                setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
                window.scrollTo(0, 1);
            }
        </script>
        <!-- //Meta tag Keywords -->

        <!-- Custom-Files -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Bootstrap css -->
        <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Main css -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <!-- Font-Awesome-Icons-CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
        <!-- pop-up-box -->
        <link href="${pageContext.request.contextPath}/resources/css/menu.css" rel="stylesheet" type="text/css" media="all" />
        <!-- menu style -->
        <!-- //Custom-Files -->

        <!-- web fonts -->
        <link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
              rel="stylesheet">
        <!-- //web fonts -->

    </head>

    <body>
        <!-- top-header -->
        <div class="agile-main-top">
            <div class="container-fluid">
                <div class="row main-top-w3l py-2">
                    <div class="col-lg-4 header-most-top">
                        <p class="text-white text-lg-left text-center">

                        </p>
                    </div>
                    <div class="col-lg-8 header-right mt-lg-0 mt-2" style="text-align: right">
                        <!-- header lists -->
                        <ul>
                            <li class="text-center border-right text-white">
                                <i class="fas fa-map-marker mr-2"></i>92, Quang Trung, Đà Nẵng</a>
                            </li>
                            <li class="text-center border-right text-white">
                                <i class="fas fa-truck mr-2"></i>Giao hàng 24h</a>
                            </li>
                            <li class="text-center border-right text-white">
                                <i class="fas fa-phone mr-2"></i> 0382859851
                            </li>
                        </ul>
                        <!-- //header lists -->
                    </div>
                </div>
            </div>
        </div>

        <!-- Button trigger modal(select-location) -->
        <div id="small-dialog1" class="mfp-hide">
            <div class="select-city">

                <div class="clearfix"></div>
            </div>
        </div>
        <!-- header-bottom-->
        <div class="header-bot">
            <div class="container">
                <div class="row header-bot_inner_wthreeinfo_header_mid">
                    <!-- logo -->
                    <div class="col-md-3 logo_agile">
                        <h1 class="text-center">
                            <a href="${pageContext.request.contextPath}/" class="font-weight-bold font-italic">
                                <img src="${pageContext.request.contextPath}/resources/images/logo2.png" alt=" " class="img-fluid">Electro Store
                            </a>
                        </h1>
                    </div>
                    <!-- //logo -->
                    <!-- header-bot -->
                    <div class="col-md-9 header mt-4 mb-md-0 mb-4">
                        <div class="row">
                            <!-- search -->
                            <div class="col-10 agileits_search">
                                <mvc:form class="form-inline" action="${pageContext.request.contextPath}/searchProduct" method="post">
                                    <input class="form-control mr-sm-2" type="search" placeholder="Search" name="name" value="${name}" aria-label="Search" required="true">
                                    <button class="btn my-2 my-sm-0" type="submit">Search</button>
                                </mvc:form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- shop locator (popup) -->
        <!-- //header-bottom -->
        <!-- navigation -->
        <div class="navbar-inner">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ml-auto text-center mr-xl-5">
                            <li class="nav-item mr-lg-2 mb-lg-0 mb-2">
                                <a class="nav-link" href="${pageContext.request.contextPath}/">Trang chủ
                                </a>
                            </li>
                            <li class="nav-item mr-lg-2 mb-lg-0 mb-2">
                                <a class="nav-link" href="${pageContext.request.contextPath}/admin/home.jsp">Admin
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/product">Sản Phẩm</a>
                            </li>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/logout">
                                    <i class="fas fa-sign-out-alt">Logout</i>
                                </a>
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/" >
                                    <i class="fas fa-user ">${users.userName}</i>                        
                                </a>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <a class="text-dark login_btn align-self-center mx-3" href="${pageContext.request.contextPath}/user/user.jsp" >
                                    <i class="far fa-user">Đăng Nhập</i>
                                </a>
                                <li class="nav-item mr-lg-2 mb-lg-0 mb-2">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <!-- //navigation -->

        <!-- banner -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <!-- Indicators-->
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item item1 active">
                    <div class="container">
                        <div class="w3l-space-banner">
                            <div class="carousel-caption p-lg-5 p-sm-4 p-3">
                                <p>Get flat
                                    <span>10%</span> Cashback</p>
                                <h3 class="font-weight-bold pt-2 pb-lg-5 pb-4">The
                                    <span>Big</span>
                                    Sale
                                </h3>
                                <a class="button2" href="product.html">Shop Now </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item item2">
                    <div class="container">
                        <div class="w3l-space-banner">
                            <div class="carousel-caption p-lg-5 p-sm-4 p-3">
                                <p>advanced
                                    <span>Wireless</span> earbuds</p>
                                <h3 class="font-weight-bold pt-2 pb-lg-5 pb-4">Best
                                    <span>Headphone</span>
                                </h3>
                                <a class="button2" href="product.html">Shop Now </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item item3">
                    <div class="container">
                        <div class="w3l-space-banner">
                            <div class="carousel-caption p-lg-5 p-sm-4 p-3">
                                <p>Get flat
                                    <span>10%</span> Cashback</p>
                                <h3 class="font-weight-bold pt-2 pb-lg-5 pb-4">New
                                    <span>Standard</span>
                                </h3>
                                <a class="button2" href="product.html">Shop Now </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item item4">
                    <div class="container">
                        <div class="w3l-space-banner">
                            <div class="carousel-caption p-lg-5 p-sm-4 p-3">
                                <p>Get Now
                                    <span>40%</span> Discount</p>
                                <h3 class="font-weight-bold pt-2 pb-lg-5 pb-4">Today
                                    <span>Discount</span>
                                </h3>
                                <a class="button2" href="product.html">Shop Now </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- //banner -->
    </body>
</html>