<%-- 
    Document   : header
    Created on : May 14, 2017, 12:04:59 PM
    Author     : Niru
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lan="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${SITE_URL}/static/js/jquery.min.js" type="text/javascript"></script>
        
        <title>Show Hide Dropdown Using CSS</title>

        <style type="text/css">

            ul{

                padding: 0;

                list-style: none;

                background:  #5bc0de;

            }

            ul li{

                display: inline-block;

                position: relative;

                line-height: 30px;

                text-align: left;

            }

            ul li a{

                display: block;

                padding: 8px 25px;

                color:white;

                font-weight: bold;

                text-decoration: none;

            }

            ul li a:hover{

                color:  #5bc0de;
                text-decoration: none;
                background: white;

            }

            ul li ul.dropdown{

                min-width: 150%; /* Set width of the dropdown */

                background: #5bc0de;


                display: none;

                position: absolute;

                z-index: 999;

                left: 0;

            }

            ul li:hover ul.dropdown{

                display: block; /* Display the dropdown */

            }

            ul li ul.dropdown li{

                display: block;

            }

        </style>

    </head>

    <body class="container" ng-app="myapp">

        <ul>

            <li><a href="${SITE_URL}/admin" id="home">Home</a></li>

            <li><a href="#">Loan</a></li>

            <li>

                <a href="#">Account &#9662;</a>

                <ul class="dropdown">

                    <li><a href="${SITE_URL}/account/openaccount/" id="openaccount">Open Account</a></li>

                    <li><a href="${SITE_URL}/account/searchaccount/" id="searchaccount">Search Account</a></li>

                    <li><a href="${SITE_URL}/account/closeaccount/">Account Closure</a></li>

                </ul>

            </li>

            <li>
                <a href="#">Transaction &#9662;</a>
                <ul class="dropdown">
                    <li><a href="${SITE_URL}/balance/deposit/"  id="deposit">Deposit</a></li>

                    <li><a href="${SITE_URL}/balance/withdraw/" id="withdraw">Withdraw</a></li>

                </ul>

            </li>

        </ul>

