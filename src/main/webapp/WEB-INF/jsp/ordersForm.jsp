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

        <div class="privacy py-sm-5 py-4">
            <div class="container py-xl-4 py-lg-2">
                <!-- tittle heading -->
                <!-- //tittle heading -->
                <div class="checkout-right">
                    <div class="table-responsive">
                        <table class="timetable_sub">
                            <thead>
                                <tr>
                                    <th>ID.</th>
                                    <th>images</th>
                                    <th>Quantity</th>
                                    <th>Product Name</th>

                                    <th>Price</th>
                                    <th>Total</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="totalCart" value="${0}"></c:set>
                                <c:forEach var="cart" items="${cart.ordersDetailsList}">
                                    <c:set var="totalCart" value="${totalCart + cart.totalAmount}"></c:set>

                                        <tr class="rem1">
                                            <td class="invert">${cart.product.id}</td>
                                        <td class="invert-image">
                                            <img src="<c:url value="/resources/images/${cart.product.image}"/>" alt=" " class="img-responsive">
                                        </td>
                                        <td class="invert">${cart.quantity}</td>
                                        <td class="invert">${cart.product.name}</td>
                                        <td class="invert">${cart.product.priceFormatted}</td>
                                        <td class="invert">${cart.totalFormatted}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                            <tr>
                                <td class="text-black font-weight-bold"><strong>Orders Total</strong></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="text-black font-weight-bold"><strong>${cart.totalFormatted}</strong></td> 
                            </tr>
                        </table>
                    
                       <div class="col-md-7">
                            <!-- check booking-->
                            <!-- price details-->
                            <!-- infor-->
                            <h2 class="h3 mb-3 text-black">Information of customer:</h2>
                            <div class="p-3 p-lg-5 border">
                                <mvc:form modelAttribute="orders" action="paymentProduct" method="post" style="width: 100%;" >
                                    <div class="form-group row">
                                        <div class="col-md-12">
                                            <label for="customerName" class="text-black">Customer Name: <span
                                                    class="text-danger">*</span></label>
                                                <mvc:input type="text" path="customerName" required="true" class="form-control"/>
                                        </div>
                                        <div class="col-md-12">
                                            <label for="" class="text-black">Address: <span
                                                    class="text-danger">*</span></label>
                                                <mvc:input type="text" path="customerAddress" required="true" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-md-6">
                                            <label for="phone" class="text-black">Phone: <span class="text-danger">*</span></label>
                                            <mvc:input type="text" path="phone" required="true" class="form-control"/>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="email" class="text-black">Email: <span class="text-danger">*</span></label>
                                            <mvc:input type="text" class="form-control" path="email" required="true"/>
                                        </div>
                                    </div>

                                    <div class="col-md-5 mb-5 mb-md-0">
                                        <div class="p-3 p-lg-5 border" style="width: 30em">
                                            Phương thức thanh toán 
                                                <button class="accordion" type="button">Thẻ Tín Dụng / Thẻ Ghi Nợ</button>
                                                <div class="panel">
                                                    <div class="form-group row">
                                                        <div class="col-md-12">
                                                            <label class="text-black">Tên trên thẻ <span
                                                                    class="text-danger">*</span></label>
                                                            <input type="text" name="name" class="form-control" value="${creditCart.name}"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-md-12">
                                                            <label class="text-black">Số thẻ tín dụng/thẻ ghi nợ <span
                                                                    class="text-danger">*</span></label>
                                                            <input type="text" name="card_Number"  class="form-control" value="${creditCart.card_Number}"/>
                                                        </div>
                                                    </div>
                                                    

                                                </div>
                                                <div style="color: red;">${erroMessage}</div>
                                                <div class="checkbox">
                                                    <label><input type="checkbox" value="">Thanh toán tại khách sạn</label>
                                                </div>
                                        </div>
                                    </div><br><br><br> 
                                    <input class="btn btn-primary btn-lg py-3 btn-block" type="submit" value="Continue">

                                </mvc:form>
                            </div><br>
                        </div>
                                    
                    </div>
                </div><br><br><br><br><br>
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
