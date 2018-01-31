<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add product -- Inventory management</title>
</head>
<body>
	<h1>Add a new product:</h1>
	<form action="./add" method="post">
    	Price: <br><input type="text" name="price"/><br>        
    	Description: <br><input type="text" name="description"/><br>
    	<input type="submit" value="submit">            
	</form>
</body>
</html>
