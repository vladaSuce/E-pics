<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->


<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/normalize.min.css">
<link rel="stylesheet" href="css/main.css">

<script src="js/jquery-1.10.1.js"></script>
<script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script type="text/javascript" src="js/jquery.easyModal.js"></script>

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
					<c:if test="${user!=null}">
						<li><a id="signOut" href="SignOutServlet">Sign out</a></li>

						<li><a href="IndexController?autor=${user.id}">${user.emailAdress}</a></li>
					</c:if>
					<c:if test="${user==null }">
					<li><a href="./">E-pics</a> </li>
					</c:if>
					<li><a id="search" href="search.jsp">Serch E-pics</a></li>
				</ul>
			</nav>
		</header>
	</div>


	<div class="main-container">
		<div class="main wrapper clearfix">
			<ul>
				<c:forEach items="${greske}" var="greska">
					<li>${greska}</li>
				</c:forEach>
			</ul>
			<center>
				<c:if test="${foundPhotos!=null }">
					<table>
						<c:forEach var="photo" items="${foundPhotos}" >
						<tr>
						<td>Photo title: ${photo.title}</td>
						<td>Photo description: ${photo.description}</td>
						<td><a href="./PictureController?id=${photo.id}"><img src="<%=request.getContextPath()%>${photo.thumbnailLocation}" /></a></td>
						</tr>
						</c:forEach>
					</table>
				</c:if>
			</center>
		</div>
		<!-- #main -->
	</div>
	<!-- #main-container -->
	<script src="js/main.js"></script>
</body>
</html>
