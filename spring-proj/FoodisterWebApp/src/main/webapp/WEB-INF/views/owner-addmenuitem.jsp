<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Foodister</title>

	<!-- Bootstrap Core CSS -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin.css" />" rel="stylesheet">
    
    <!-- Morris Charts CSS -->
    <link href="<c:url value="/resources/css/plugins/morris.css" />" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    
    <!-- css files from home.jsp -->
	
	<link href="<c:url value="/resources/css/animate.min.css" />" rel="stylesheet">

	<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">

	<link href="<c:url value="/resources/css/nivo-lightbox.css" />" rel="stylesheet">

	<link href="<c:url value="/resources/css/nivo_themes/default/default.css" />" rel="stylesheet">

	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
	<!-- end of css files from home.jsp-->
</head>
<body>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<!-- preloader section -->
<section class="preloader">
	<div class="sk-spinner sk-spinner-pulse"></div>
</section>


<div id="wrapper">

<!-- navigation section -->
<section class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">FOODISTER</a>
		</div>
		
		<!-- search bar -->
		<div class="col-sm-6 col-md-6">
        <form class="navbar-form" role="search" action="${contextPath}/search" method ="post">
        <div class="input-group col-lg-12 col-md-12 col-sm-6">
            <input type="text" class="form-control" placeholder="Search" name="searchtext">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit" style="width: 50px; height: 34px;">
                <span class="glyphicon glyphicon-search"></span>
                </button>
            </div>
        </div>
        </form>
    </div>
		
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" class="smoothScroll">HOME</a></li>
				
				<% if (session.getAttribute("User")!= null) { %>
				
				<li><a href="${contextPath}/logout" class="smoothScroll">LOGOUT</a></li>
				<%} else { %>
				
				
				
				<li><a href="${contextPath}/login" class="smoothScroll">LOGIN</a></li>
				<%} %>
				
			</ul>
		</div>
	</div>
</section>

<!-- end of top nav bar -->

	<div class="collapse navbar-collapse navbar-ex1-collapse">
                 <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="${contextPath}/ownerhome" style="color: #fff;"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="${contextPath}/ownerprofile" style="color: #fff;"><i class="fa fa-fw fa-bar-chart-o"></i> My Profile</a>
                    </li>
                    
                     <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" style="color: #fff;"><i class="fa fa-fw fa-arrows-v"></i> Add a Restaurant  <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li class="active">
                                <a href="${contextPath}/addmenuitem">Create Menu Item</a>
                            </li>
                            <li>
                                <a href="${contextPath}/addmenu">Create Menu</a>
                            </li>
                            <li>
                                <a href="${contextPath}/addrestuarant">Create Restaurant</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="${contextPath}/viewreviews" style="color: #fff;"><i class="fa fa-fw fa-wrench"></i>View Reviews</a>
                    </li>
                    </ul>
            </div>

<!-- start content -->
  <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Menu Item
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${contextPath}/ownerhome">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Add Menu Item
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

            <%--             <form role="form" action="${contextPath}/addmenuitem.htm"
							method="post"> --%>
				<form:form commandName="menuitem" method="post" enctype="multipart/form-data" action="${contextPath}/addmenuitem.htm">
                            <div class="form-group">
								<label>Item Name</label> <form:input class="form-control"
									name="itemName" path="itemName" placeholder="Enter text" />
							</div>

							<div class="form-group">
								<label>Item Price</label> <form:input type="number" class="form-control"
									name="itemPrice" path="itemPrice" placeholder="Enter price" />
							</div>
							
							<div class="form-group">
								<label>Item Description</label> <form:input class="form-control"
									name="itemDescription" path="itemDescription" placeholder="Enter text" />
							</div>
							<div class="form-group">
                                <label>Item Picture Name</label>
                                
                                <input type="text" name="filename" />
                            </div>
							
                            <div class="form-group">
                                <label>Item Picture Upload</label>
                                <form:input type="file" name="itemPhoto" path="photo"/>
                            </div>

                            <input type="submit" class="btn btn-default" value="Add Menu Item">
                            <div class="form-group">
                            <c:if test="${ not empty requestScope.addStatus}">
                            	<label id="status"> 
                            	
                            	<c:out value="${requestScope.addStatus}" />
                            	</label>
                            </c:if>
                            </div>
                            
						<%-- </form> --%>
                        </form:form>

                    </div>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

<!-- copyright section -->
<section id="copyright">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<h3>FOODISTER</h3>
				<p>Copyright 2017 © 
                
                | Design: <a rel="nofollow" href="http://www.bhatiaricha.com" target="_parent">Richa Bhatia</a></p>
			</div>
		</div>
	</div>
</section>




    </div>
    <!-- /#wrapper -->





	<!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />" ></script>	
	
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>

    <!-- Morris Charts JavaScript -->
    <script src="<c:url value="/resources/js/plugins/morris/raphael.min.js" />" ></script>
   
    <script src="<c:url value="/resources/js/plugins/morris/morris.min.js" />" ></script>
    
    <script src="<c:url value="/resources/js/plugins/morris/morris-data.js" />" ></script>
    
    <!-- js files from home.jsp -->
    <script src="<c:url value="/resources/js/jquery.parallax.js" />" ></script>
	<script src="<c:url value="/resources/js/smoothscroll.js" />" ></script>
	<script src="<c:url value="/resources/js/nivo-lightbox.min.js" />" ></script>
	<script src="<c:url value="/resources/js/wow.min.js" />" ></script>
	<script src="<c:url value="/resources/js/custom.js" />" ></script>
    
</body>
</html>