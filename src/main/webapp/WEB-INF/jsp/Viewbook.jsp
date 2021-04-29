<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>View Book</title>
</head>
<body>
<form action="search" method="post" align="center" >
<input type="text" name="keyword">&nbsp;&nbsp;<input type="submit" value="search">
</form>

<p align="center"><a href="home">AddBook</a></p>
<h2 align="center"> Book List</h2>
<table border="2" align="center">
<tr><th>BookID</th><th style="width:100px">Title</th><th style="width:100px">Author</th><th>PublishedDate</th><th style="width:70px">price</th><th>Action</th></tr>
<c:forEach items="${list}" var="b">
<tr><td>${b.id}</td><td>${b.title}</td><td>${b.author}</td><td>${b.publishdate}</td><td>${b.price}</td><td><p><a href="edit/${b.sno}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete/${b.sno}">Delete</a></p></td></tr>
</c:forEach>
</table>
<p align="center"><a href="excel">Excel</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="email">Support</a></p>
</body>
</html>
