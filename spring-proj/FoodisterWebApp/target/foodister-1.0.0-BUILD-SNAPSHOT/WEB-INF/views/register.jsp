<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Foodister</title>

<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/animate.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/nivo-lightbox.css" />"
	rel="stylesheet">

<link
	href="<c:url value="/resources/css/nivo_themes/default/default.css" />"
	rel="stylesheet">


<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


<link href='https://fonts.googleapis.com/css?family=Roboto:400,500'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<!-- preloader section -->
	<section class="preloader">
		<div class="sk-spinner sk-spinner-pulse"></div>
	</section>

	<!-- navigation section -->
	<section class="navbar navbar-default navbar-fixed-top"
		role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon icon-bar"></span> <span class="icon icon-bar"></span>
					<span class="icon icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">FOODISTER</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${contextPath}/" class="smoothScroll">HOME</a></li>
					<li><a href="${contextPath}/login" class="smoothScroll">LOGIN</a></li>
				</ul>
			</div>
		</div>
	</section>

	<!-- login section -->
	<section id="contact" class="parallax-section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 col-sm-12 text-center">
					<h1 class="heading">Register</h1>
					<hr>
				</div>
				<div class="col-md-offset-1 col-md-10 col-sm-12 wow fadeIn"
					data-wow-delay="0.9s">
					<form action="${contextPath}/register.htm" method="post">
						<div>
							<c:if test="${ not empty requestScope.registerError}">
								<p class="form-control" style="color: red;">
									<c:out value="${requestScope.registerError}" />
								</p>
							</c:if>
						</div>
						<div class="col-md-6 col-sm-6">
							<input name="firstName" type="text" class="form-control"
								id="firstName" placeholder="First Name" required />
						</div>

						<div class="col-md-6 col-sm-6">
							<input name="lastName" type="text" class="form-control"
								id="lastName" placeholder="Last Name" required />
						</div>

						<div class="col-md-12 col-sm-12">

							<select name="accountType" class="form-control" required>
								<option value="customer">Customer</option>
								<option value="owner">Owner</option>

							</select>
						</div>

						<div class="col-md-6 col-sm-6">
							<input name="userName" type="text" class="form-control"
								id="userName" placeholder="User Name" required />
						</div>

						<div class="col-md-6 col-sm-6">
							<input name="password" type="password" class="form-control"
								id="password" placeholder="Password" required />
						</div>
						<div class="col-md-12 col-sm-12">
							<input name="emailId" type="email" class="form-control"
								id="emailId" placeholder="Email" required />
						</div>

						<div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
							<input name="submit" type="submit" class="form-control"
								id="submit" value="Register">
						</div>
					</form>
				</div>
				<div class="col-md-2 col-sm-1"></div>
			</div>
		</div>
	</section>


	<!-- footer section -->
	<footer class="parallax-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
					<h2 class="heading">Contact Info.</h2>
					<div class="ph">
						<p>
							<i class="fa fa-phone"></i> Phone
						</p>
						<h4>090-080-0760</h4>
					</div>
					<div class="address">
						<p>
							<i class="fa fa-map-marker"></i> Our Location
						</p>
						<h4>360 Huntington Ave, Boston, MA</h4>
					</div>
				</div>

				<div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
					<h2 class="heading">Follow Us</h2>
					<ul class="social-icon">
						<li><a href="#" class="fa fa-facebook wow bounceIn"
							data-wow-delay="0.3s"></a></li>
						<li><a href="#" class="fa fa-twitter wow bounceIn"
							data-wow-delay="0.6s"></a></li>
						<li><a href="#" class="fa fa-behance wow bounceIn"
							data-wow-delay="0.9s"></a></li>
						<li><a href="#" class="fa fa-dribbble wow bounceIn"
							data-wow-delay="0.9s"></a></li>
						<li><a href="#" class="fa fa-github wow bounceIn"
							data-wow-delay="0.9s"></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>


	<!-- copyright section -->
	<section id="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<h3>FOODISTER</h3>
					<p>
						Copyright 2017 © | Design: <a rel="nofollow"
							href="http://www.bhatiaricha.com" target="_parent">Richa
							Bhatia</a>
					</p>
				</div>
			</div>
		</div>
	</section>

	<!-- JAVASCRIPT JS FILES -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.parallax.js" />"></script>
	<script src="<c:url value="/resources/js/smoothscroll.js" />"></script>
	<script src="<c:url value="/resources/js/nivo-lightbox.min.js" />"></script>
	<script src="<c:url value="/resources/js/wow.min.js" />"></script>
	<script src="<c:url value="/resources/js/custom.js" />"></script>


</body>
</html>