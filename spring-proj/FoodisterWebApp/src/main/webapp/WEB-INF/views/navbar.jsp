<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
					<li><a href="#home" class="smoothScroll">HOME</a></li>
					<li><a href="#gallery" class="smoothScroll">RESTAURANT
							GALLERY</a></li>
					<li><a href="#contact" class="smoothScroll">CONTACT US</a></li>
					<%
						if (session.getAttribute("User") != null) {
					%>

					<li><a href="${contextPath}/logout" class="smoothScroll">LOGOUT</a></li>
					<%
						} else {
					%>


					<li><a href="${contextPath}/register" class="smoothScroll">SIGN
							UP</a></li>
					<li><a href="${contextPath}/login" class="smoothScroll">LOGIN</a></li>
					<%
						}
					%>

				</ul>
			</div>
		</div>
	</section>
	
</body>
</html>