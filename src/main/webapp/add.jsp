<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addCar" method="post">
		<input type="number" placeholder="Enter CarId" name="carId"><br><br>
		<input type="text" placeholder="Enter CarModel" name="carModel"><br><br>
		<input type="text" placeholder="Enter CarBrand" name="carBrand"><br><br>
		<input type="number" placeholder="Enter CarPrice" name="carPrice"><br><br>
		<input type="submit" value="Add">
	</form>
</body>
</html>