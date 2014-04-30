<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>E-pics</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/jquery-1.10.1.js"></script>
        <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script type="text/javascript" src="js/jquery.easyModal.js"></script>
        <script src="js/galleria/galleria-1.3.5.min.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title">E-pics</h1>
                <nav>
                    <ul>
                        <li><a id="login" href="login.jsp">login</a></li>
                        <li><a id="register" href="register.jsp">register</a></li>
                        <li><a id="search" href="search.jsp">Serch E-pics</a></li>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container" id="mainCont">
            <div class="main wrapper clearfix">

                <div class="galleria">
                	<c:if test="${user!=null}">
						
					    <c:forEach items = "${allPics}" var="grupa">
							<img src="<%=request.getContextPath()%>${grupa.location}" data-link="<%=request.getContextPath()%>/PictureController?id=${grupa.id}"/>
					</c:forEach>
					</c:if>
					 	<c:if test="${user==null}">
						
					    <c:forEach items = "${public_photosNo_user}" var="grupa">
							<img src="<%=request.getContextPath()%>${grupa.location}" data-link="<%=request.getContextPath()%>/PictureController?id=${grupa.id}"/>
					</c:forEach>
					</c:if>
                </div>  
            </div> <!-- #main -->
        </div> <!-- #main-container -->
        
       
        
    </body>
</html>
