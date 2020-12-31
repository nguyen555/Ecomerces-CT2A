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
        <script>
            // Open the Modal
            function openModal() {
                document.getElementById("myModal").style.display = "block";
            }

            // Close the Modal
            function closeModal() {
                document.getElementById("myModal").style.display = "none";
            }

            var slideIndex = 1;
            showSlides(slideIndex);

            // Next/previous controls
            function plusSlides(n) {
                showSlides(slideIndex += n);
            }

            // Thumbnail image controls
            function currentSlide(n) {
                showSlides(slideIndex = n);
            }

            function showSlides(n) {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("demo");
                var captionText = document.getElementById("caption");
                if (n > slides.length) {
                    slideIndex = 1
                }
                if (n < 1) {
                    slideIndex = slides.length
                }
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " active";
                captionText.innerHTML = dots[slideIndex - 1].alt;
            }
        </script>
        <style>
            .row > .column {
                padding: 0 8px;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Create four equal columns that floats next to eachother */
            .column {
                float: left;
                width: 25%;
            }

            /* The Modal (background) */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                padding-top: 100px;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: black;
            }

            /* Modal Content */
            .modal-content {
                position: relative;
                background-color: #fefefe;
                margin: auto;
                padding: 0;
                width: 90%;
                max-width: 1200px;
            }

            /* The Close Button */
            .close {
                color: white;
                position: absolute;
                top: 10px;
                right: 25px;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #999;
                text-decoration: none;
                cursor: pointer;
            }

            /* Hide the slides by default */
            .mySlides {
                display: none;
            }

            /* Next & previous buttons */
            .prev,
            .next {
                cursor: pointer;
                position: absolute;
                top: 50%;
                width: auto;
                padding: 16px;
                margin-top: -50px;
                color: white;
                font-weight: bold;
                font-size: 20px;
                transition: 0.6s ease;
                border-radius: 0 3px 3px 0;
                user-select: none;
                -webkit-user-select: none;
            }

            /* Position the "next button" to the right */
            .next {
                right: 0;
                border-radius: 3px 0 0 3px;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev:hover,
            .next:hover {
                background-color: rgba(0, 0, 0, 0.8);
            }

            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            /* Caption text */
            .caption-container {
                text-align: center;
                background-color: black;
                padding: 2px 16px;
                color: white;
            }

            img.demo {
                opacity: 0.6;
            }

            .active,
            .demo:hover {
                opacity: 1;
            }

            img.hover-shadow {
                transition: 0.3s;
            }

            .hover-shadow:hover {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }
        </style>
        <style>
            .accordion {
                background-color: #eee;
                color: #444;
                cursor: pointer;
                padding: 18px;
                width: 100%;
                border: none;
                text-align: left;
                outline: none;
                font-size: 15px;
                transition: 0.4s;
            }

            .active, .accordion:hover {
                background-color: #ccc;
            }

            .accordion:after {
                content: '\002B';
                color: #777;
                font-weight: bold;
                float: right;
                margin-left: 5px;
            }

            .active:after {
                content: "\2212";
            }

            .panel {
                padding: 0 18px;
                background-color: white;
                max-height: 0;
                overflow: hidden;
                transition: max-height 0.2s ease-out;
            }
        </style>
    </head>

    <body>
        <div><jsp:include page="header.jsp" /></div>
        <div class="banner-bootom-w3-agileits py-5">
            <div class="container py-xl-4 py-lg-2">
                <!-- tittle heading -->
                <h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
                    <span>S</span>ản 
                    <span>P</span>hẩm</h3>
                <!-- //tittle heading -->
                <div class="row">
                    <div class="col-lg-5 col-md-8 single-right-left ">
                        <div class="grid images_3_of_2">
                            <div class="flexslider">
                                <c:forEach var = "product" items="${productDetailsList}">
                                    <ul class="slides">
                                        <li data-thumb="${pageContext.request.contextPath}/resources/images/${product.image1}">
                                            <div class="thumb-image">
                                                <img src="${pageContext.request.contextPath}/resources/images/${product.image1}" data-imagezoom="true" class="img-fluid" alt=""> </div>
                                        </li>
                                        <li data-thumb="${pageContext.request.contextPath}/resources/images/${product.image2}">
                                            <div class="thumb-image">
                                                <img src="${pageContext.request.contextPath}/resources/images/${product.image2}" data-imagezoom="true" class="img-fluid" alt=""> </div>
                                        </li>
                                        <li data-thumb="${pageContext.request.contextPath}/resources/images/${product.image3}">
                                            <div class="thumb-image">
                                                <img src="${pageContext.request.contextPath}/resources/images/${product.image3}" data-imagezoom="true" class="img-fluid" alt=""> </div>
                                        </li>
                                    </ul>
                                </c:forEach>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7 single-right-left simpleCart_shelfItem">
                        <c:forEach var = "product" items="${productDetailsList}">
                            <h3 class="mb-3">${product.name}</h3>
                            <p class="mb-3">
                                <span class="item_price">${product.priceFormatted}</span>
                            </p>
                            <div class="single-infoagile">
                                <ul>
                                    <li class="mb-3">
                                        Giao Hàng nhanh chóng
                                    </li>
                                    <li class="mb-3">
                                        Miễn phí đổi trả trong 7 ngày đầu
                                    </li>
                                    <li class="mb-3">
                                        Bảo hành 3 năm
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>
                        <c:forEach var = "product" items="${productDetailsList}">
                            <button class="accordion">Chi Tiết</button>
                            <div class="panel">
                                <div class="product-single-w3l">
                                    <ul>
                                        <p class="my-sm-4 my-3">
                                            <i class=" mr-3"></i>Thông tin chung
                                        </p>
                                        <li class="mb-1">
                                            Mã sản phẩm : ${product.numberProduct}
                                        </li>
                                        <li class="mb-1">
                                            Nhà sản xuất : ${product.manufacturer.name}
                                        </li>
                                        <li class="mb-1">
                                            Bộ nhớ Trong: ${product.internal_memory.memory_type}
                                        </li>
                                        <li class="mb-1">
                                            Ngày Nhập hàng : ${product.date}
                                        </li>
                                        <p class="my-sm-4 my-3">
                                            <i class=" mr-3"></i>Thông tin chi tiết
                                        </p>
                                        <p>Cấu Tạo</p>
                                        <li class="mb-1">
                                            Chiều dài : ${product.productdetails.chieuDai}
                                        </li>
                                        <li class="mb-1">
                                            Chiều rộng : ${product.productdetails.chieuRong}
                                        </li>
                                        <li class="mb-1">
                                            Chiều cao: ${product.productdetails.chieuCao}
                                        </li>
                                        <li class="mb-1">
                                            Cân nặng: ${product.productdetails.canNang}
                                        </li>
                                        <li class="mb-1">
                                            Kiểu Dáng: ${product.productdetails.kieuDang}
                                        </li>
                                        <p>Cấu tạo chi tiết</p>
                                        <li class="mb-1">
                                            Sim: ${product.productdetails.sim}
                                        </li>
                                        <li class="mb-1">
                                            Hỗ trợ 3g: ${product.productdetails.hoTro3g}
                                        </li>
                                        <li class="mb-1">
                                            Các tính năng khác: ${product.productdetails.cacTinhNangKhac}
                                        </li>
                                        <li class="mb-1">
                                            Quay Phim: ${product.productdetails.quayPhim}
                                        </li>
                                        <li class="mb-1">
                                            Máy ảnh: ${product.productdetails.mayAnh}
                                        </li>
                                        <li class="mb-1">
                                            Thẻ Nhớ: ${product.productdetails.theNho}
                                        </li>
                                        <li class="mb-1">
                                            Hệ Điều hành: ${product.productdetails.heDieuHanh}
                                        </li>
                                        <li class="mb-1">
                                            CPU: ${product.productdetails.cpu}
                                        </li>
                                        <li class="mb-1">
                                            Ram: ${product.productdetails.ram}
                                        </li>
                                        <li class="mb-1">
                                            PIN: ${product.productdetails.pin}
                                        </li>
                                        <li class="mb-1">
                                            Ngày Nhập Hàng: ${product.productdetails.time_of_launch}
                                        </li>
                                    </ul>
                                </div>
                            </div><br><br><br>
                        </c:forEach>
                        <script>
                            var acc = document.getElementsByClassName("accordion");
                            var i;

                            for (i = 0; i < acc.length; i++) {
                                acc[i].addEventListener("click", function () {
                                    this.classList.toggle("active");
                                    var panel = this.nextElementSibling;
                                    if (panel.style.maxHeight) {
                                        panel.style.maxHeight = null;
                                    } else {
                                        panel.style.maxHeight = panel.scrollHeight + "px";
                                    }
                                });
                            }
                        </script>

                        <div class="occasion-cart">
                            <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out">
                                <a href="${pageContext.request.contextPath}/addToCart/${id}" class=""  style="background-color: white; color: black; border: 2px solid green; padding: 10px 20px; text-align: center; text-decoration: none; display: inline-block;">
                                    ADD to CART
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

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
        <script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.3.min.js"></script>
        <!-- //jquery -->

        <!-- nav smooth scroll -->
        <script>
                            $(document).ready(function () {
                                $(".dropdown").hover(
                                        function () {
                                            $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                                            $(this).toggleClass('open');
                                        },
                                        function () {
                                            $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                                            $(this).toggleClass('open');
                                        }
                                );
                            });
        </script>
        <!-- //nav smooth scroll -->

        <!-- popup modal (for location)-->
        <script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.js"></script>
        <script>
                            $(document).ready(function () {
                                $('.popup-with-zoom-anim').magnificPopup({
                                    type: 'inline',
                                    fixedContentPos: false,
                                    fixedBgPos: true,
                                    overflowY: 'auto',
                                    closeBtnInside: true,
                                    preloader: false,
                                    midClick: true,
                                    removalDelay: 300,
                                    mainClass: 'my-mfp-zoom-in'
                                });

                            });
        </script>
        <!-- //popup modal (for location)-->

        <!-- cart-js -->
        <script src="${pageContext.request.contextPath}/resources/js/minicart.js"></script>
        <script>
                            paypals.minicarts.render(); //use only unique class names other than paypals.minicarts.Also Replace same class name in css and minicart.min.js

                            paypals.minicarts.cart.on('checkout', function (evt) {
                                var items = this.items(),
                                        len = items.length,
                                        total = 0,
                                        i;

                                // Count the number of each item in the cart
                                for (i = 0; i < len; i++) {
                                    total += items[i].get('quantity');
                                }

                                if (total < 3) {
                                    alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
                                    evt.preventDefault();
                                }
                            });
        </script>
        <!-- //password-script -->

        <!-- imagezoom -->
        <script src="${pageContext.request.contextPath}/resources/js/imagezoom.js"></script>
        <!-- //imagezoom -->

        <!-- flexslider -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flexslider.css" type="text/css" media="screen" />

        <script src="${pageContext.request.contextPath}/resources/js/jquery.flexslider.js"></script>
        <script>
                            // Can also be used with $(document).ready()
                            $(window).load(function () {
                                $('.flexslider').flexslider({
                                    animation: "slide",
                                    controlNav: "thumbnails"
                                });
                            });
        </script>
        <!-- //FlexSlider-->

        <!-- smoothscroll -->
        <script src="${pageContext.request.contextPath}/resources/js/SmoothScroll.min.js"></script>
        <!-- //smoothscroll -->

        <!-- start-smooth-scrolling -->
        <script src="${pageContext.request.contextPath}/resources/js/move-top.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/easing.js"></script>
        <script>
                            jQuery(document).ready(function ($) {
                                $(".scroll").click(function (event) {
                                    event.preventDefault();

                                    $('html,body').animate({
                                        scrollTop: $(this.hash).offset().top
                                    }, 1000);
                                });
                            });
        </script>
        <!-- //end-smooth-scrolling -->

        <!-- smooth-scrolling-of-move-up -->
        <script>
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */
                $().UItoTop({
                    easingType: 'easeOutQuart'
                });

            });
        </script>
        <!-- //smooth-scrolling-of-move-up -->

        <!-- for bootstrap working -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    </body>
</html>