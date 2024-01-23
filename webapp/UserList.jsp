
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
</head>
<body>
<center><h1><strong>USER MANAGEMENT SYSTEM</strong></h1></center>

<hr>
<div>
<a href="add"><button type="button" class="btn btn-primary">Add User</button></a>
</div>
<hr>
<div>
<table class="table table-striped">
 <thead>
 <tr>
 <th>ID</th>
 <th>NAME</th>
 <th>MOBILE</th>
 <th>CITY</th>
  <th>ACTIONS</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach var="user" items="${display}">
 <tr>
	<td><c:out value="${user.id}"/></td>
	<td><c:out value="${user.name}"/></td>
	<td><c:out value="${user.mobile}"/></td>
	<td><c:out value="${user.city}"/></td>
	<td>
		<a href="edit?id=${user.id}">Edit</a>&nbsp; &nbsp;
		<a href="delete?id=${user.id}">Delete</a>
	</td>
 </tr>
 </c:forEach>
 
 </tbody>
</table>
</div>
</body>
</html>