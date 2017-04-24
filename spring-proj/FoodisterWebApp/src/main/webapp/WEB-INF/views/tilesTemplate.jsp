<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<tiles:insertAttribute name="title"></tiles:insertAttribute>
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

	 <div><tiles:insertAttribute name="navbar" /></div>

		<!-- home section -->

	<!-- gallery section -->





	<!-- contact section -->
	<tiles:insertAttribute name="contact" />
	
	<!-- Footer Page -->
       <tiles:insertAttribute name="footer" />
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
