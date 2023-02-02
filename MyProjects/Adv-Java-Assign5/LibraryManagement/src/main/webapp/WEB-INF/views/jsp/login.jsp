<%@page import="com.nagarro.entity.User"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href=<c:url value="/css/login_style.css" />
	rel="stylesheet">
</head>

<body>

	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
	%>


	<section class="container-fluid">
		<!-- row and justify-content-center class is used to place the form in center -->

		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-4">
				<form action="UserAuthentication" class="form-container"
					method="post">

					<div class="form-group">

						<c:if test="${empty authentication}">
							<div class="alert alert-warning">
								<strong> Login Failed. Please try again. </strong>
							</div>
							<%session.setAttribute("authentication", "."); %>
						</c:if>


						<h4 class="text-center font-weight-bold">Login</h4>
						<label for="InputEmail1">Username</label> <input type="text"
							class="form-control" id="InputEmail1" name="username"
							aria-describeby="emailHelp" placeholder="Username" required>
					</div>
					<div class="form-group">
						<label for="InputPassword1">Password</label> <input
							type="password" class="form-control" id="InputPassword1"
							name="password" placeholder="Password" required>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Login</button>
				</form>
			</section>
		</section>
	</section>
	<!-- Login form creation ends -->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<!-- Login form creation starts-->
</body>
</html>