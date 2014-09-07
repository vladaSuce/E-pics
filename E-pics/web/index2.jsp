<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->


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
        <script src="js/galleria/galleria-1.3.5.min.js"></script>
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
                        
                        <li><a id="signOut" href="SignOutServlet">Sign out</a></li>
                        <li><a id="search" href="search.jsp">Serch E-pics</a></li>
                        <li><a href="IndexController?autor=${user.id}">${user.emailAdress}</a></li>
                    </ul>
                </nav>
            </header>
        </div>

<c:if test="${user!=null}">
        <div class="main-container">
            <div class="main wrapper clearfix">
                <div class="nav3">
                    <ul>
                        <li><a id="addAlbum" href ="addAlbum.jsp">Add album</a></li>
                        <li><a id="manageUploads" href="#">Manage own uploads</a></li>
                        <li><a id="uploadPhoto" href="addPhoto.jsp">Upload a photo</a></li>
                        <li><a href="atpController?autor=${autor.id}">Authors top pics</a></li>
                        <li><a id="changePersonal" href="updatePersonalData.jsp">Change personal data</a></li>
                        <li><a id="changePassword" href="updatePassword.jsp">Change password</a></li>
                        <li><a id="RSS" href="#">RSS</a></li>
                        <li>Authors mail: </li>
                        <li>${autor.emailAdress} </li>
                        <li>Authors name: </li>
                        <li>${autor.firstName} ${autor.lastName}</li>
                        <li><a id="recentAcitvity" href="./recentAcitvityController?autor_id=${autor.id}">Recent Activity</a></li>
                        <li><input type="hidden" value="${autor.id}" name="autor_id"></li>
                    </ul>
                </div>

</c:if>
                <div class="galleria">
                	<c:forEach items="${photos}" var="grupa">
							<img src="<%=request.getContextPath()%>${grupa.location}" data-link="<%=request.getContextPath()%>/PictureController?id=${grupa.id}"/>
					</c:forEach>
                
<!--                     <img src="img/zemska1.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<!--                     <img src="img/zemska2.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<!--                     <img src="img/zemska3.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<!--                     <img src="img/zemska4.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<!--                     <img src="img/zemska5.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<!--                     <img src="img/zemska6.jpg" data-title="My Å½emska" data-description="ima sise i dupe"> -->
<%--                     <img src="img/pic2.jpg" data-title="Another title" data-description="My <em>HTML</em> description"> --%>
                </div>  
            </div> <!-- #main -->
        </div> <!-- #main-container -->


      

        
        <script src="js/main.js"></script>
    </body>
</html>
