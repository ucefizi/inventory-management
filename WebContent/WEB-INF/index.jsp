<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of products -- Inventory management</title>
</head>
<body>
	<h1>Product list:</h1>
	<a href="./add">Add Product</a>
	<table border="1px solid black">
		<tr>
			<th>Id</th>
			<th>Price</th>
			<th>Description</th>
			<th>Last modified</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>$${p.price}</td>
				<td>${p.description}</td>
				<td>${p.creationDate}</td>
				<td><a href="./delete/id/${p.id}"
					onclick="return confirm('Are you sure?')">Delete</a> <a
					href="./edit/id/${p.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
