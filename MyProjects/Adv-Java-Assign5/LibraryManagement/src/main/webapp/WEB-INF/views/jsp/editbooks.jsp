<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Books</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
	%>
	<header class="bg-primary blog-header lh-1 py-3">
		<div
			class="row flex-nowrap justify-content-between align-items-center">

			<c:if test="${empty authentication.getUsername()}">
				<%
				response.sendRedirect("redirect:/");
				%>
			</c:if>

			<div class="col-12 d-flex justify-content-end align-items-center">
				<h4 class="fw-bolder">Welcome ${authentication.getUsername()}</h4>
				<div class="mx-3">
					<a href="logout"><button type="button"
							class="btn btn-outline-danger">Logout</button></a>
				</div>
			</div>
		</div>
	</header>

	<section class="my-4 border border-dark">
		<div class="text-center my-4">
			<h2>
				<b>Edit Books Details</b>
			</h2>
		</div>
		<div class="mx-5">
			<c:if test="${isCodeUnique==true}">
				<div class="alert alert-warning col-sm-5" role="alert">Book
					Code Should be Unique</div>
				<%
				session.setAttribute("isCodeUnique", false);
				%>
			</c:if>
			<form action="editbookdetail" method="post">
				<div class="form-group row">
					<label for="bookcode" class="col-sm-2 col-form-label">Book
						Code</label>
					<div class="col-sm-3">
						<input type="number" readonly class="form-control-plaintext"
							id="addedon" name="bookcode" value="${book.getBookCode()}">
					</div>
				</div>
				<div class="form-group row mt-3">
					<label for="bookname" class="col-sm-2 col-form-label">Book
						Name</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" id="bookname"
							name="bookname" value="${book.getBookName()}">
					</div>
				</div>
				<div class="form-group row mt-3">
					<label for="author" class="col-sm-2 col-form-label">Author</label>
					<div class="col-sm-3">
						<select id="author" class="form-control" name="author">
							<option selected>
								<c:out value="${book.getAuthor()}" /></option>
							<c:forEach items="${authors}" var="author">
								<c:if test="${author.getName() ne book.getAuthor()}">
									<option><c:out value="${author.getName()}" /></option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group row mt-3">
					<label for="addedon" class="col-sm-2 col-form-label">Added
						On</label>
					<div class="col-sm-3">
						<input type="text" readonly class="form-control-plaintext"
							id="addedon" value="${book.getDate()}" name="date">
					</div>
				</div>
				<div class="my-4">
					<button class="btn btn-primary px-4" type="submit">Submit</button>
					<a href="booksList"><button class="btn btn-danger ms-4 px-4"
							type="button">Cancel</button></a>
				</div>
			</form>
		</div>
	</section>
	<footer class="footer fixed-bottom bg-primary blog-footer lh-1 py-3">
		<div class="container align-items-center">
			<div class="justify-content-end align-items-center text-center text-white">
				<h3>© 2022-2023 Java Fresher Training</h3>
			</div>
		</div>
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>