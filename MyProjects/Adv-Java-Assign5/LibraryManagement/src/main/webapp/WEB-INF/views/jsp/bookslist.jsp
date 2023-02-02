<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Books List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript">
	function showAlert() {
		alert("Book Deleted Successfully");
	}
</script>
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
		<!-- 		<div class="text-center mt-3">
				<b class="fs-3">Books Listing</b>
			
		</div> -->
		<div class="d-flex mt-2">
			<div class="p-2 col-md-3 flex-fill text-end">
				<b class="fs-3">Books Listing</b>
			</div>
			<div class="p-2 ms-4 flex-fill text-center">
				<a href="addbook"><button type="addbook"
						class="btn btn-primary mx-2">Add a Book</button></a>
			</div>
		</div>

		<div class="mt-4 mx-5">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center align-middle" scope="col">Book Code</th>
						<th class="text-center align-middle" scope="col">Book Name</th>
						<th class="text-center align-middle" scope="col">Author</th>
						<th class="text-center align-middle" scope="col">Data Added</th>
						<th class="text-center align-middle" scope="col">Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${books}" var="book">
						<tr>
							<td class="text-center align-middle" scope="row"><c:out
									value="${book.getBookCode()}" /></td>
							<td class="text-center align-middle"><c:out
									value="${book.getBookName()}" /></td>
							<td class="text-center align-middle"><c:out
									value="${book.getAuthor()}" /></td>
							<td class="text-center align-middle"><c:out
									value="${book.getDate()}" /></td>
							<td class="text-center align-middle"><a
								href="editbook/${book.getBookCode()}"><button type="button"
										class="btn btn-outline-success px-4">Edit</button></a><a
								href="deletebook/${book.getBookCode()}"><button
										type="button" class="btn btn-outline-danger mx-2"
										onclick="showAlert()">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<footer class="footer bg-primary blog-footer lh-1 py-3">
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