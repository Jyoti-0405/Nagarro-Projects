<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.nagarro.dto.Tshirt" %>
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			.result {
			width: 100%;
			border-collapse: collapse;
			background-color: #f2f2f2;
		}
		.result td {
			text-align: center;
			height: 25px;
			border: 1px solid black;
		}
		th {
			text-align: center;
			height: 50px;
			border: 1px solid black;
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
				
		
		</style>
		<meta charset="UTF-8">
		<title>result</title>
	</head>
	<body>
		
		<c:if test="${searchResult.size() != 0}">
			<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>
								<c:out value="${searchResult.size()}"></c:out> Matching tshirt found!
							</h2>
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
			<table class = "result">
			<tr>
				<th> ID </th>
				<th> NAME </th>
				<th> COLOR </th>
				<th> GENDER_RECOMMENDATION </th>
				<th> SIZE </th>
				<th> PRICE </th>
				<th> RATING </th>
				<th> AVAILABILITY </th>
			</tr>
			<c:forEach items="${searchResult}" var = "tshirt">
				<tr >
  					<td>${tshirt.getTshirtNumber()}</td>
  					<td>${tshirt.getTshirtName()}</td>
  					<td>${tshirt.getTshirtColor()}</td>
  					<td>${tshirt.getTshirtGen_recomm()}</td>
  					<td>${tshirt.getTshirtSize()}</td>
  					<td>${tshirt.getTshirtPrice()}</td>
  					<td>${tshirt.getTshirtRating()}</td>
  					<td>${tshirt.getTshirtAvailability()}</td>
				</tr>
  			</c:forEach>
		
		</table>
		</c:if>
		<c:if test="${searchResult.size() == 0}">
			<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>
								Sorry! No matching tshirts found!
							</h2>
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
		</c:if>
		<br>
	</body>
</html>