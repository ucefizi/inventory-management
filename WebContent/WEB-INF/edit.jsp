<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit product -- Inventory management</title>
</head>
<body>
	<h1>Edit product:</h1>
	<form action="./${product.id}" method="post">
    	Price: <br><input type="text" name="price" value="${product.price}"/><br>        
    	Description: <br><input type="text" name="description" value="${product.description}"/><br>
    	<input type="submit" value="submit">            
	</form>
</body>
</html>
