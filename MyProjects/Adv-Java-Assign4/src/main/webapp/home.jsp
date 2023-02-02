<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
	<style type="text/css">
	.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	}
	input[type=submit] {
		background-color: #1E90FF;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	input[type=submit]:hover {
	  background-color: #4169E1;
	}
	input[type=date], select {
	   width: 100%; 
	  padding: 12px; /* Some padding */ 
	  border: 1px solid #ccc; /* Gray border */
	  border-radius: 4px; /* Rounded borders */
	  margin-top: 3px; /* Add a top margin */
	  margin-bottom: 3px; /* Bottom margin */
	}
</style>
	
	<title>Home</title>
	</head>
	<body>
		<c:if test = "${uId != null}">
		<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>Welcome <c:out value = "${uId}"/> ! You can search for Tshirts here.</h2>
						</td>
						<td align = "right">
							<form action="SignOut">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		<div align = "center" class = "container">
  			<form action = "search" method = "get">
  				<table >
					<tr>
						<td>
							Color : 
						</td>
						<td>
							<select name="color">
  									<c:forEach items = "${userColors}" var="userColors">
  								    <option value="${userColors}">${userColors}</option>
  								</c:forEach>
							</select>  
						</td>
					</tr>
					<tr>
						<td>
							Size : 
						</td>
						<td>
							<select name="size">
							<c:forEach items = "${userSizes}" var="userSizes">
  									<option value="${userSizes}">${userSizes}</option>	
  								</c:forEach>
							</select>  
						</td>
					</tr>
					
					<tr>
						<td>
							Gender : 
						</td>
						<td>
							<select name="gender">
  								<option value="M">Male</option>
  								<option value="F">Female</option>
  								<option value="U">Unisex</option>
							</select> 
						</td>
					</tr> 
					<tr>
						<td>
							Sort by : 
						</td>
						<td>
							<select name="sortBy">
  								<option value="1">Rating</option>
  								<option value="2">Price</option>
  								<option value="3">Both</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							
						</td>
						<td align = "right">
							<input type = "submit" value = "Seach" /> 
						</td>
					</tr>  				
	  			</table>
  			</form>
		</div>
		</c:if>
		<c:if test="${uId == null}">
			<c:redirect url = "index.jsp"/>
		</c:if>
	</body>
</html>