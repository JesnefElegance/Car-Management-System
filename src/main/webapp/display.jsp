<%@page import="com.carsystem.Car"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Car> cList = (List) request.getAttribute("cList");
	%>
	<table border="auto">
		<tr>
			<th>Car Id</th>
			<th>Car Model</th>
			<th>Car Brand</th>
			<th>Car Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
		for (Car car : cList) {
		%>
		<tr>
			<td><%=car.getCarId()%></td>
			<td><%=car.getCarModel()%></td>
			<td><%=car.getCarBrand()%></td>
			<td><%=car.getCarPrice()%></td>
			<td><a href="updateCar?carId=<%=car.getCarId()%>">update</a></td>
			<td><a href="deleteCar?carId=<%=car.getCarId()%>">delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>