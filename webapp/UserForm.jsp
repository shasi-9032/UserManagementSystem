<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
<style type="text/css">
body {
	text-align:center;
	font-family:sans-serif;
}
.mb-3 {
	width:300px; 
	left:39%;
	position:relative;
	
} 
.container {
	top:150px;
	left:40%;
	/* border:2px solid grey; */
	padding:10px;
}  

.add {
	color:white;
	background-color:Black;
	width:100px;
	padding:10px;
	border-radius:8px;
}
</style>
</head>
<body>

<a:if test="${list1 == null }">
 <form action="insert" method="post">
 <h1 align="center">ADD USER</h1><hr>
</a:if>
 
<a:if test="${list1 != null }">
	<form action="update" method="post">
	<h1 align="center">EDIT USER</h1><hr>
</a:if>
 


<div class="container">

<form action="insert" method="post">
<div class="inner">
	
<!-- ID -->
	 <div class="mb-3">	
  		<input type="hidden" class="form-control"  value="${list1.id}" name ="id" >
	</div>
	
<!-- Name -->
 	<div class="mb-3">
  		<label for="exampleFormControlInput1" class="form-label">Name</label>
  		<input type="text" class="form-control" id="exampleFormControlInput1" value="${list1.name}" name ="name" style="width:300px">
	</div>
	
<!-- Mobile -->
 	<div class="mb-3">
  		<label for="exampleFormControlInput2" class="form-label">Mobile</label>
  		<input type="tel" class="form-control" id="exampleFormControlInput2" value="${list1.mobile }"  name ="mobile" style="width:300px">
	</div>
	
<!-- City -->
 	<div class="mb-3">
  		<label for="exampleFormControlInput3" class="form-label">City</label>
  		<input type="text" class="form-control" id="exampleFormControlInput3" value="${list1.city}"  name ="city" style="width:300px">
	</div>
	
	<div class="mb-3">
		<input type="submit" class="add" value="Save">
	</div>
</div>


</form></div>
</body>
</html>