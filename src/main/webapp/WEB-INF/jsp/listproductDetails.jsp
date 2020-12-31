<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontawesome-all.css">
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
        <div><jsp:include page="header.jsp" /></div>
        <br>
        <div class ="row">
            <div class="manu manu15" style="text-align: center; padding-left: 12%; ">
                <c:forEach var="manufacturer" items="${manuList}">
                    <a href ="${pageContext.request.contextPath}/search/manufacturer/${manufacturer.id}" data-id="${manufacturer.id}" data-name="${manufacturer.name}"> <img src="<c:url value="/resources/images/${manufacturer.images}"/>" alt=""></a>
                    </c:forEach>
                </form>
            </div>
        </div>
        <div class="ads-grid py-sm-5 py-4">
            <div class="container py-xl-4 py-lg-2">
                <!-- tittle heading -->
                <h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
                    <span>Đ</span>iện
                    <span>T</span>hoại
                </h3>
                <!-- //tittle heading -->


                <div class="row">
                    <!-- product left -->
                    <div class="agileinfo-ads-display col-lg-9">
                        <div class="offers_sorting_container">
                            <ul class="offers_sorting">
                                <li>

                                    <ul>
                                        <c:catch var="productDetails">
                                            <li class="sort_btn fa fa-arrow-up" data-isotope-option='{ "sortBy": "name" }'><span><a href="${pageContext.request.contextPath}/sort-by-evaluate-low-to-high">Thấp đến Cao</a></span></li><br>
                                            <li class="sort_btn fa fa-arrow-down" data-isotope-option='{ "sortBy": "name" }'><span><a href="${pageContext.request.contextPath}/sort-by-evaluate-high-to-low">Cao đến Thấp</a></span></li>
                                                    </c:catch>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="wrapper">
                            <!-- first section -->
                            <div class="product-sec1 px-sm-4 px-3 py-sm-5  py-3 mb-4">

                                <div class="row">
                                    <c:forEach var="product" items="${productList}">
                                        <div class="col-md-4 product-men mt-5">
                                            <div class="men-pro-item simpleCart_shelfItem">
                                                <div class="men-thumb-item text-center">
                                                    <img src="<c:url value="/resources/images/${product.image}"/>" alt="" style="height: 10em;">
                                                    <div class="men-cart-pro">
                                                        <div class="inner-men-cart-pro">
                                                            <a href="${pageContext.request.contextPath}/viewProduct/${product.id}" class="link-product-add-cart">Quick View</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="item-info-product text-center border-top mt-4">
                                                    <h4 class="pt-1">
                                                        <a href="#">${product.name}</a>
                                                    </h4>
                                                    <div class="info-product-price my-2">
                                                        <span class="item_price">${product.priceFormatted}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                            <!-- //first section -->

                        </div>

                        <div class="container">
                            <ul class="pagination" style="padding-left: 35%">
                                <li class="page-item"><a class="page-link" href="#">Trước</a></li>
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view-all-Product/1">1</a></li>
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view-all-Product/2">2</a></li>
                                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view-all-Product/3">3</a></li>
                                 <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/view-all-Product/4">4</a></li>
                                <li class="page-item"><a class="page-link" href="#">Sau</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- //product left -->

                    <!-- product right -->
                    <div class="col-lg-3 mt-lg-0 mt-4 p-lg-0">
                        <div class="side-bar p-sm-4 p-3">



                            <!-- //discounts -->
                            <div class="fl price">
                                <label>Chọn mức giá: </label><br>
                                <a href="${pageContext.request.contextPath}/findByPrice/0/2000000" class=" " data-id="7">
                                    Dưới 2 triệu
                                </a><br>
                                <a href="${pageContext.request.contextPath}/findByPrice/2000000/4000000" class=" " data-id="9">
                                    Từ 2 - 4 triệu
                                </a><br>
                                <a href="${pageContext.request.contextPath}/findByPrice/4000000/7000000" class=" " data-id="289">
                                    Từ 4 - 7 triệu
                                </a><br>
                                <a href="${pageContext.request.contextPath}/findByPrice/7000000/13000000" class=" " data-id="562">
                                    Từ 7 - 13 triệu
                                </a><br>
                                <a href="${pageContext.request.contextPath}/findByPrice/13000000/100000000" class=" " data-name="7">
                                    Tr&#234;n 13 triệu
                                </a><br>

                            </div>
                            <br>


                            <div class="left-side border-bottom py-2">
                                <c:forEach var="product" items="${productDetailsNew}">
                                    <div class="col-md-4 product-men mt-5">
                                        <div class="men-pro-item simpleCart_shelfItem" style="width: 10em">
                                            <div class="men-thumb-item text-center">
                                                <img src="<c:url value="/resources/images/${product.image}"/>" alt="">
                                            </div>
                                            <div class="item-info-product text-center border-top mt-4">
                                                <h4 class="pt-1">
                                                    <a href="${pageContext.request.contextPath}/viewProduct/${product.id}">${product.name}</a>
                                                </h4>
                                                <div class="info-product-price my-2">
                                                    <span class="item_price">${product.priceFormatted}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!--                            <div class="search-hotel border-bottom py-2">
                            
                                                            <form action="" method="post">
                            
                                                                <input type="submit" value="">
                                                            </form>
                                                        </div>-->
                            <!-- //electronics -->

                            <div class="f-grid py-2">
                                <h3 class="agileits-sear-head mb-3">Best Seller</h3>

                                <div class="row">
                                    <c:forEach var="product" items="${productDetails}">
                                        <div class="col-lg-3 col-sm-2 col-3 left-mar">
                                            <img src="<c:url value="/resources/images/${product.image}"/>" alt="" class="img-fluid"><br>
                                        </div>
                                        <div class="col-lg-9 col-sm-10 col-9 w3_mvd">
                                            <a href="${pageContext.request.contextPath}/viewProduct/${product.id}">${product.name}</a><br>
                                            <span class="price-mar mt-2">${product.priceFormatted}</span><br><br><br>
                                        </div>
                                    </c:forEach>
                                </div>

                            </div>
                            <!-- //best seller -->
                        </div>
                        <!-- //product right -->
                    </div>
                </div>
            </div>
        </div>
        <!-- //top products -->

        <!-- middle section -->
        <div class="join-w3l1 py-sm-5 py-4">
            <div class="container py-xl-4 py-lg-2">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="join-agile text-left p-4">
                            <div class="row">
                                <div class="col-sm-7 offer-name">
                                    <h6>Smooth, Rich & Loud Audio</h6>
                                    <h4 class="mt-2 mb-3">Branded Headphones</h4>
                                    <p>Sale up to 25% off all in store</p>
                                </div>
                                <div class="col-sm-5 offerimg-w3l">
                                    <img src="${pageContext.request.contextPath}/resources/images/off1.png" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 mt-lg-0 mt-5">
                        <div class="join-agile text-left p-4">
                            <div class="row ">
                                <div class="col-sm-7 offer-name">
                                    <h6>A Bigger Phone</h6>
                                    <h4 class="mt-2 mb-3">Smart Phones 5</h4>
                                    <p>Free shipping order over $100</p>
                                </div>
                                <div class="col-sm-5 offerimg-w3l">
                                    <img src="${pageContext.request.contextPath}/resources/images/off2.png" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div><jsp:include page="footer.jsp" /></div>
    </body>
</html>
