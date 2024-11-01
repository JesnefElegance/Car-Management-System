<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Management System</title>
<!-- <link rel="stylesheet" href="./style.css" /> -->
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	background-color: rgb(128, 128, 128);
}

.container {
	width: 40%;
	height: 500px;
	margin: -200px 0 0 0;
	border: 5px solid black;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.container #heading {
	margin-bottom: 20px;
	width: 100%;
	text-align: center;
	background-color: mediumpurple;
	border: 3px solid black;
	border-radius: 10px;
	transition: .5s;
}

.container #heading:hover {
	color: black;
	background-color: hotpink;
	scale: 1.02;
}

.container .button {
	padding: 10px 20px;
	width: 95%;
	border: 3px solid black;
	text-align: center;
	text-decoration: none;
	color: white;
	border-radius: 6px;
	transition: .8s;
}

.container .buttons {
	display: flex;
	width: 100%;
	justify-content: space-around;
	gap: 5px;
}

.container .button:hover {
	scale: 1.02;
	background-color: mintcream;
	color: blue;
}
</style>
</head>
<body>
	<div class="container">
		<h1 id="heading">Welcome to Car Dashboard</h1>
		<div class="buttons">
			<a class="button" href="add.jsp">ADD NEW CAR</a><br> <a
				class="button" href="display">DISPLAY ALL CARS</a>
		</div>
	</div>
</body>
</html>