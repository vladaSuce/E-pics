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
		<ul>
		<c:forEach items="${greske}" var="greska">
			<li>${greska}</li>
		</c:forEach>
		</ul>
	<div class="header-container">
		<header class="wrapper clearfix">
			<h1 class="title">E-pics</h1>
			<nav>
				<ul>
					<c:if test="${user!=null}">
					<li><a id="signOut" href="SignOutServlet">Sign out</a></li>
					
					<li><a href="${user.id}">${user.emailAdress}</a></li>
					</c:if>
					<li><a id="search" href="search.jsp">Serch E-pics</a></li>
				</ul>
			</nav>
		</header>
	</div>


	<div class="main-container">
		<div class="main wrapper clearfix">
				<center>
			<img src="<%=request.getContextPath()%>${slika.location}" /> 
			<table>
			<tr><td>${vlasnikSlike.firstName }</td>
				<td>${vlasnikSlike.lastName }</td>
				<td><a href="<%=request.getContextPath()%>/IndexController?autor=${vlasnikSlike.id }">
				${vlasnikSlike.emailAdress }</a></td>
				</tr>
				
			</table>
			
			<br/>
	
			Tags :

			<br/><c:forEach var="tag" items="${slika.tagsPhotos}">
				<table >
					<tr>
						<td>${tag.text}</td>
						<c:if test="${user.id==autor.id && user!=null}">
						<td><a href="./DeleteTagController?tagId=${tag.id}">delete tag</a></td>
						</c:if>
					</tr>
				</table>
			</c:forEach>
			
			<c:forEach var="komentar" items="${slika.photoComments}">
				<table > Comments:
					<tr>
						<td>${komentar.contents}</td>
						<c:if test="${user.id==autor.id && user!=null}">
						<td><a href="./DeleteCommentController?tagId=${komentar.id}">delete comment</a></td>
						</c:if>
						<td><a href="<%=request.getContextPath()%>/IndexController?autor=${komentar.userComments.id}">${komentar.userComments.emailAdress}</a></td>
					</tr>
				</table>
			</c:forEach>
			</center>
		</div>
		<!-- #main -->
	</div>
	<!-- #main-container -->
<c:if test="${user!=null}">
	<div class="footer-container">
		<footer class="wrapper">
			<h1 class="title"></h1>
			<div class="nav2">
				<ul>

					<li><a id="tag" href="PreTagController?id=${slika.id}">Tag</a></li>
					<li><a id="note" href="">Note</a></li>
					<li><a id="comment" href="PreCommentController?id=${slika.id}">Comment</a></li>
					<li><a id="addToFav" href="">Add to favorites</a></li>
					<li><a id="follow" href="">Follow</a></li>
					<c:if test="${user.id==autor.id}">
						<li><a id="settings" href="SettingsController?id=${slika.id}">Tag</a></li>
					</c:if>
					<li><a id="rate" href="CheckRateController?id=${slika.id}">Rate</a></li>
				</ul>
			</div>
		</footer>
	</div>
</c:if>
<input type="hidden" name="slikaId" value="${slika.id}">



	<script src="js/main.js"></script>
</body>
</html>
