
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: sans-serif;
	text-align:center;
}
form {
    height: 150px;
    width: 200px; /* Set a fixed width for the form */
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border: 3px solid black;
    border-radius: 20px;
    padding: 25px;
}
.container {
	padding:10px;
}
#login {
	color:white;
	background-color:black;
	font-size:15px;
	cursor:pointer;
}
p {
color:red;
}
</style>
</head>
<body>
<h1> Login </h1>
<p>Enter the correct username/password</p>
<form action="login" method="post">
<div class="container">
Username <br><input type="text" name="username" placeholder="username"><br><br>
Password <br> <input type="password" name="password" placeholder="password"><br><br>
<input type="submit" value="Login" id="login">
</div>
</form>
</body>
</html>
