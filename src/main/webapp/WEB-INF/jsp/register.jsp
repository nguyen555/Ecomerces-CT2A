<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Đăng ký</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style1.css">
    </head>
    <body>

        <div class="main">

            <section class="signup">
                <!-- <img src="images/signup-bg.jpg" alt=""> -->
                <div class="container">
                    <div class="signup-content">
                        <mvc:form modelAttribute="customer" action="addnew" method="post" id="signup-form" class="signup-form">
                            <h2 class="form-title">Đăng ký</h2>
                            <div class="form-group">
                                <input type="text" class="form-input" name="userName" id="name" placeholder="Tài khoản"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-input" name="password" id="password" placeholder="Password"/>
                                <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>
                            <div class="form-group">
                                <mvc:input type="text" class="form-input" path="name" id="name" placeholder="Họ và tên" required="true"/>
                            </div>
                             <div class="form-group">
                                <mvc:input type="text" class="form-input" path="email" id="email" placeholder="Email" required="true" autofocus="true"/>
                            </div>
                             <div class="form-group">
                                <mvc:input type="text" class="form-input" path="address" id="address" placeholder="Địa chỉ" required="true" autofocus="true"/>
                            </div>
                             <div class="form-group">
                                <mvc:input type="text" class="form-input" path="phone" id="phone" placeholder="Số điện thoại" required="true" autofocus="true"/>
                            </div>
                             <div class="form-group">
                                <mvc:select type="text" class="form-input" path="sex" items="${sex}" id="sex" placeholder="Giới tính" required="true" autofocus="true"/>
                            </div>
                             <div class="form-group">
                                <mvc:input type="date" class="form-input" path="birthDate" id="email" placeholder="Ngày sinh" required="true" autofocus="true"/>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Đăng ký"/>
                            </div>
                        </mvc:form>
                        <p class="loginhere">
                            <a href="${pageContext.request.contextPath}/" class="loginhere-link">Quay Lại Trang Chủ</a>
                        </p>
                        <input type="hidden" name="${_csrf.parameterName}" 
                               value="${_csrf.token}"/>
                        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                            <p style="color:red;">Error:
                                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
                            </c:if>    
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    </body>
