<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: 'Open Sans Condensed', sans-serif;
                font-size: 85pt;
                text-align: center;
                line-height: 1.2em;
            }

            .dashed-shadow {
                position: relative;
                top: -38px;
                left: 8px;
                display: inline-block;
                color: #ba9186;
            }

            .for{}
            .dashed-shadow:after {
                z-index: 2;
                content: attr(data-text);
                position: absolute;
                left: -8px;
                top: -8px;
                color: #b85b3f;
                text-shadow: 3px 3px #e8e3c7;
            }

            .hello {
                font-family: 'Cookie',cursive;
                font-size: 140pt;
                margin: 1em 0 0 2em;
            }

            .sorta-block {
                font-size: 50pt;
                line-height: 1.1em;
                -moz-transform: skew(0, -5deg);
                -ms-transform: skew(0, -5deg);
                -webkit-transform: skew(0, -5deg);
                transform: skew(0, -5deg);
                z-index: 3;
                position: relative;
                margin: -16px 0 76px 6.7em;
            }

            .sorta {
                border-top: 4px solid #b85b3f;
                border-bottom: 4px solid #b85b3f;
                text-transform: uppercase;
                z-index: 3;
                font-style: italic;
            }

            .hipsterish {
                font-family: 'Sancreek', cursive;
                font-size: 70pt;
            }

        </style>
    </head>
    <body>

        <span data-text="Thank You" class="dashed-shadow hello">Thank You</span>
        <br />
        
        <span data-text="For" class="dashed-shadow hello" style="    font-size: 70pt;
    margin: -1em 0 0 7em;">For</span>
        <div class="sorta-block">
            <div data-text="Your Booking"class="dashed-shadow sorta">Your Booking</div> 
        </div>

    </body>
</html>
