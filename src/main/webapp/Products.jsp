<%@page import="shop.Dao.RegisterDapImpl"%>
<%@page import="shop.Dao.RegisterDao"%>
<%@page import="shop.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="shop.model.Product" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
<title>Insert title here</title>
</head>
<body>


  
<!-- Header Section Begin -->
<header class="header" >
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>The clothing of confident men</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <a href="LoginView.jsp">Sign in</a>
                            <a href="Registration.jsp">New Customer</a>
                            <a href="#">FAQs</a>
                        </div>
                        <div class="header__top__hover">
                            <span>RS <i class="arrow_carrot-down"></i></span>
                            <ul>
                                <li>USD</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="./index.html"><img src="/Ekart.gif" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li class="active"><a href="Home.jsp">Home</a></li>
                        <li><a href="Productontroller">Shop</a></li>
                        <li><a href="Cart.jsp">Cart</a>
                            
                        </li>
                        <li><a href="./blog.html">About Us</a></li>
                        <li><a href="./contact.html">Contacts</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="CartController"><img src="cart.png" alt=""> <span></span></a>
                    <div class="price">Rs 0.00</div>
                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->



<%
    List<Product> lst = null;

    if (!session.isNew()) {
        lst = (List<Product>) session.getAttribute("true");

        if (lst != null && !lst.isEmpty()) {
%>
<div class="row" style="padding-left: 100px;">
    <% for (Product p : lst) { %>
    <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="product__item">
            <img class="product__item__pic" src="<%=p.getProdImg()%>" alt="<%=p.getProdName()%>">
            <div class="product__item__text">
                <h6><%= p.getProdName() %></h6>
                <a href="add-to-cart?prodId=<%=p.getProdId()%>" class="add-cart">+ Add To Cart</a>
                <h5><%= p.getProdPrice() %></h5>
                <div class="product__color__select">
                    <!-- Replace these labels and inputs with your actual color selection code -->
                    <label for="pc-4">
                        <input type="radio" id="pc-4">
                    </label>
                    <label class="active black" for="pc-5">
                        <input type="radio" id="pc-5">
                    </label>
                    <label class="grey" for="pc-6">
                        <input type="radio" id="pc-6">
                    </label>
                </div>
            </div>
        </div>
    </div>
    <% } %>
</div>
<%
        }
    }
%>




</body>
</html>


