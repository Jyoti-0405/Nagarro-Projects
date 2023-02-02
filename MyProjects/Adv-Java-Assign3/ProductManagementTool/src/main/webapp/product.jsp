<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.nagarro.model.User"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nagarro.model.Product"%>
<%@page import="com.nagarro.dao.ProductDao"%>
<%@page import="java.util.List"%>


<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("index.jsp");
	}
	
	ProductDao productDao = new ProductDao();
	List<Product> productList = productDao.getProduct();
	
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/c311625606.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="./productstyle.css"/>

	<script>
		if ( window.history.replaceState ) {
 		 window.history.replaceState( null, null, window.location.href );
		}
	</script>
  

  <title>Product</title>
</head>

<body>
  <nav class="navbar navbar-light">
    <div class="container-fluid">
      <span class="navbar-text"> Product Management Tool </span>
      <span id="user-show"> Hi <%= session.getAttribute("username").toString()%></span>
      <form class="d-flex" action="Logout" method="post">
        <input class="btn-logout" type="submit" value="Logout">
      </form>
    </div>
  </nav>
  <div class="row mb-4 input-details">
    <span id="input-detail-text">
      Please enter product details to add to stock
    </span>
    
    <form action="ProductController" method="post" enctype="multipart/form-data">
      <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Title</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="inputEmail3" name="title" placeholder="" />
        </div>
      </div>
      <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Quantity</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="inputPassword3" name="quantity" placeholder="" />
        </div>
      </div>
      <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Size</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="inputEmail3" name="size" placeholder="" />
        </div>
      </div>
      <div class="row mb-3">
        <label class="col-sm-2 col-form-label">Image</label>
        <div class="col-sm-10">
          <input type="file" class="form-control" id="inputEmail3" name="image" placeholder="Browse" />
        </div>
      </div>
      <div class="d-grid gap-2 d-md-block">
        <button class="browse-btn btn btn-primary" type="submit">
          Enter
        </button>
      </div>
    </form>
  </div>
  <div class="container-fluid">
  <table class="table table-striped">
  
  		<thead>
  			<th class="table-heading" style="text-align: center;">SNo</th>
        	<th class="table-heading" style="text-align: center;">Title</th>
            <th class="table-heading" style="text-align: center;">Quantity</th>
            <th class="table-heading" style="text-align: center;">Size</th>
            <th class="table-heading" style="text-align: center;">Image</th>
            <th class="table-heading" style="text-align: center;">Action</th>
         </thead>
         
         <tbody>
			<%
				int i=0;
				for(Product iter:productList){ 
					i++;
			%>
      		<tr>
      			<td class="table-data" style="text-align: center; vertical-align: middle;"><%= i %></td>
				<td class="table-data" style="text-align: center; vertical-align: middle;"><%= iter.getTitle()%> </td>
				<td class="table-data" style="text-align: center; vertical-align: middle;"><%= iter.getQuantity() %> </td>
				<td class="table-data" style="text-align: center; vertical-align: middle;"><%= iter.getSize() %> </td>
				<td class="table-data" style="text-align: center; vertical-align: middle;"><img src="Images/<%=iter.getImage().toString()%>" width="100" height="100"></td>
				<td style="vertical-align: middle;">
				
				<ul class="action-list">
					<li class="action-list-item">
						<form action="Edit" method="post">
							<button type="submit" name="submit" value="<%=iter.getProductId()%>">
								<i class="fa-sharp fa-solid fa-pen"></i>
							</button>
							
						</form>
					</li>
					<li class="action-list-item">
						<form action="Delete" method="post">
							<button type="submit" name="submit" value="<%=iter.getProductId()%>">
								<i class="fa-solid fa-square-xmark"></i>
							</button>
						</form>
					</li>
				</ul>



        		
				</td>
      		</tr>
      		<%} %>
         </tbody>
  </table>
  </div>

  <!-- Optional JavaScript; choose one of the two! -->

  <!-- Option 1: Bootstrap Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>
</body>

</html>