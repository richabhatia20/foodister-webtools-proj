<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- contact section -->
	<section id="contact" class="parallax-section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 col-sm-12 text-center">
					<h1 class="heading">Contact Us</h1>
					<hr>
				</div>
				<div class="col-md-offset-1 col-md-10 col-sm-12 wow fadeIn"
					data-wow-delay="0.9s">

					<!-- action="${contextPath}/addMessage.htm" -->
					<form method="post">
						<div class="col-md-6 col-sm-6">
							<input name="name" type="text" class="form-control" id="name"
								placeholder="Name">
						</div>
						<div class="col-md-6 col-sm-6">
							<input name="email" type="email" class="form-control" id="email"
								placeholder="Email">
						</div>
						<div class="col-md-12 col-sm-12">
							<textarea name="message" rows="8" class="form-control"
								id="message" placeholder="Message"></textarea>
						</div>
						<div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6">
							<input name="submit" type="submit" class="form-control"
								id="submit" value="send message" data-toggle="modal"
								data-target="#successModal">
						</div>
						<div>
							<c:if test="${ not empty requestScope.messageStatus}">
								<span style="color: green;"> <c:out
										value="${requestScope.messageStatus}" />
								</span>
							</c:if>
						</div>
						<div class="modal fade" id="successModal" role="dialog">

							<div class="modal-dialog modal-sm">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Modal Header</h4>
									</div>
									<div class="modal-body">
										<p>Success!</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>

					</form>
				</div>
				<div class="col-md-2 col-sm-1"></div>
			</div>
		</div>
	</section>


</body>
</html>