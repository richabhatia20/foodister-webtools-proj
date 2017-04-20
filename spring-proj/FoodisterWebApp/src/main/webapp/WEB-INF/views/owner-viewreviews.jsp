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
                            <li>
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
                    </li>                   </ul>
            </div>

<!-- start content -->
  <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Forms
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> Forms
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form role="form">

                            <div class="form-group">
                                <label>Text Input</label>
                                <input class="form-control">
                                <p class="help-block">Example block-level help text here.</p>
                            </div>

                            <div class="form-group">
                                <label>Text Input with Placeholder</label>
                                <input class="form-control" placeholder="Enter text">
                            </div>

                            <div class="form-group">
                                <label>Static Control</label>
                                <p class="form-control-static">email@example.com</p>
                            </div>

                            <div class="form-group">
                                <label>File input</label>
                                <input type="file">
                            </div>

                            <div class="form-group">
                                <label>Text area</label>
                                <textarea class="form-control" rows="3"></textarea>
                            </div>

                            <div class="form-group">
                                <label>Checkboxes</label>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">Checkbox 1
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">Checkbox 2
                                    </label>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">Checkbox 3
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Inline Checkboxes</label>
                                <label class="checkbox-inline">
                                    <input type="checkbox">1
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox">2
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox">3
                                </label>
                            </div>

                            <div class="form-group">
                                <label>Radio Buttons</label>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio 1
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Radio 2
                                    </label>
                                </div>
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">Radio 3
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Inline Radio Buttons</label>
                                <label class="radio-inline">
                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked>1
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">2
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="option3">3
                                </label>
                            </div>

                            <div class="form-group">
                                <label>Selects</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Multiple Selects</label>
                                <select multiple class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-default">Submit Button</button>
                            <button type="reset" class="btn btn-default">Reset Button</button>

                        </form>

                    </div>
                    <div class="col-lg-6">
                        <h1>Disabled Form States</h1>

                        <form role="form">

                            <fieldset disabled>

                                <div class="form-group">
                                    <label for="disabledSelect">Disabled input</label>
                                    <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                                </div>

                                <div class="form-group">
                                    <label for="disabledSelect">Disabled select menu</label>
                                    <select id="disabledSelect" class="form-control">
                                        <option>Disabled select</option>
                                    </select>
                                </div>

                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">Disabled Checkbox
                                    </label>
                                </div>

                                <button type="submit" class="btn btn-primary">Disabled Button</button>

                            </fieldset>

                        </form>

                        <h1>Form Validation</h1>

                        <form role="form">

                            <div class="form-group has-success">
                                <label class="control-label" for="inputSuccess">Input with success</label>
                                <input type="text" class="form-control" id="inputSuccess">
                            </div>

                            <div class="form-group has-warning">
                                <label class="control-label" for="inputWarning">Input with warning</label>
                                <input type="text" class="form-control" id="inputWarning">
                            </div>

                            <div class="form-group has-error">
                                <label class="control-label" for="inputError">Input with error</label>
                                <input type="text" class="form-control" id="inputError">
                            </div>

                        </form>

                        <h1>Input Groups</h1>

                        <form role="form">

                            <div class="form-group input-group">
                                <span class="input-group-addon">@</span>
                                <input type="text" class="form-control" placeholder="Username">
                            </div>

                            <div class="form-group input-group">
                                <input type="text" class="form-control">
                                <span class="input-group-addon">.00</span>
                            </div>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-eur"></i></span>
                                <input type="text" class="form-control" placeholder="Font Awesome Icon">
                            </div>

                            <div class="form-group input-group">
                                <span class="input-group-addon">$</span>
                                <input type="text" class="form-control">
                                <span class="input-group-addon">.00</span>
                            </div>

                            <div class="form-group input-group">
                                <input type="text" class="form-control">
                                <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search"></i></button></span>
                            </div>

                        </form>

                        <p>For complete documentation, please visit <a href="http://getbootstrap.com/css/#forms">Bootstrap's Form Documentation</a>.</p>

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