<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page session="false" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Foodister</title>

	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">


<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/animate.min.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/nivo-lightbox.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/nivo_themes/default/default.css" />" rel="stylesheet">


<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


	<link href='https://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- preloader section -->
<section class="preloader">
	<div class="sk-spinner sk-spinner-pulse"></div>
</section>

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
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#home" class="smoothScroll">HOME</a></li>
				<li><a href="#gallery" class="smoothScroll">RESTAURANT GALLERY</a></li>
				<li><a href="#menu" class="smoothScroll">SPECIAL MENU</a></li>
				<li><a href="#team" class="smoothScroll">SIGN UP</a></li>
				<li><a href="#contact" class="smoothScroll">LOGIN</a></li>
			</ul>
		</div>
	</div>
</section>



<!-- menu section -->
<section id="menu" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8 col-sm-12 text-center">
				<h1 class="heading">Special Menu</h1>
				<hr>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Vegetable ................ <span>$20.50</span></h4>
				<h5>Chicken / Rosemary / Lemon</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Meat ........................... <span>$30.50</span></h4>
				<h5>Meat / Rosemary / Lemon</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Pork ........................ <span>$40.75</span></h4>
				<h5>Pork / Test / Lemon</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Orange-Rosemary Salad .......................... <span>$55.00</span></h4>
				<h5>Salad / Rosemary / Orange</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Squid ...................... <span>$65.00</span></h4>
				<h5>Squid / Rosemary / Lemon</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Orange-Rosemary Shrimp ........................ <span>$70.50</span></h4>
				<h5>Shrimp / Rosemary / Orange</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Prawn ................... <span>$110.75</span></h4>
				<h5>Chicken / Rosemary / Lemon</h5>
			</div>
			<div class="col-md-6 col-sm-6">
				<h4>Lemon-Rosemary Seafood ..................... <span>$220.50</span></h4>
				<h5>Seafood / Rosemary / Lemon</h5>
			</div>
		</div>
	</div>
</section>		


<!-- team section -->
<section id="team" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-2 col-md-8 col-sm-12 text-center">
				<h1 class="heading">Meet Foodister chefs</h1>
				<hr>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.3s">
				<img src="<c:url value="/resources/images/chef.jpg" />" class="img-responsive center-block" alt="team img">
				
				<h4>Jamie Oliver</h4>
				<h3>Head Chef</h3>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.6s">
				<img src="<c:url value="/resources/images/chef2.jpg" />" class="img-responsive center-block" alt="team img">
				
				<h4>Gordon Ramsay</h4>
				<h3>Sous Chef</h3>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInUp" data-wow-delay="0.9s">
				<img src="<c:url value="/resources/images/chef3.jpg" />" class="img-responsive center-block" alt="team img">
				
				<h4>Jennifer Ronson</h4>
				<h3>Dessert Chef</h3>
				
			</div>
		</div>
	</div>
</section>


<!-- contact section -->
<section id="contact" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-1 col-md-10 col-sm-12 text-center">
				<h1 class="heading">Contact Us</h1>
				<hr>
			</div>
			<div class="col-md-offset-1 col-md-10 col-sm-12 wow fadeIn" data-wow-delay="0.9s">
				<form action="#" method="post">
					<div class="col-md-6 col-sm-6">
						<input name="name" type="text" class="form-control" id="name" placeholder="Name">
				  </div>
					<div class="col-md-6 col-sm-6">
						<input name="email" type="email" class="form-control" id="email" placeholder="Email">
				  </div>
					<div class="col-md-12 col-sm-12">
						<textarea name="message" rows="8" class="form-control" id="message" placeholder="Message"></textarea>
					</div>
					<div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
						<input name="submit" type="submit" class="form-control" id="submit" value="make a reservation">
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
					<p><i class="fa fa-phone"></i> Phone</p>
					<h4>090-080-0760</h4>
				</div>
				<div class="address">
					<p><i class="fa fa-map-marker"></i> Our Location</p>
					<h4>360 Huntington Ave, Boston, MA</h4>
				</div>
			</div>
			
			<div class="col-md-6 col-sm-6 wow fadeInUp" data-wow-delay="0.6s">
				<h2 class="heading">Follow Us</h2>
				<ul class="social-icon">
					<li><a href="#" class="fa fa-facebook wow bounceIn" data-wow-delay="0.3s"></a></li>
					<li><a href="#" class="fa fa-twitter wow bounceIn" data-wow-delay="0.6s"></a></li>
					<li><a href="#" class="fa fa-behance wow bounceIn" data-wow-delay="0.9s"></a></li>
					<li><a href="#" class="fa fa-dribbble wow bounceIn" data-wow-delay="0.9s"></a></li>
					<li><a href="#" class="fa fa-github wow bounceIn" data-wow-delay="0.9s"></a></li>
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
				<p>Copyright 2017 © 
                
                | Design: <a rel="nofollow" href="http://www.bhatiaricha.com" target="_parent">Richa Bhatia</a></p>
			</div>
		</div>
	</div>
</section>

<!-- JAVASCRIPT JS FILES -->
<script src="<c:url value="/resources/js/jquery.js" />" ></script>	
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>	
<script src="<c:url value="/resources/js/jquery.parallax.js" />" ></script>
<script src="<c:url value="/resources/js/smoothscroll.js" />" ></script>
<script src="<c:url value="/resources/js/nivo-lightbox.min.js" />" ></script>
<script src="<c:url value="/resources/js/wow.min.js" />" ></script>
<script src="<c:url value="/resources/js/custom.js" />" ></script>

</body>
</html>
