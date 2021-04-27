<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<title>Search Result</title>
<body>
<button onclick="window.history.back()">Back</button>
<h3 align="center">Search Result</h3>
<table border="2" width="100" align="center">
<tr><th>BookID</th><th>Title</th><th>Author</th><th>PublishedDate</th><th>price</th><th>Action</th></tr>
<c:forEach items="${list1}" var="b">
<tr><td>${b.id}</td><td>${b.title}</td><td>${b.author}</td><td>${b.publishdate}</td><td>${b.price}</td><td><p><a href="edit/${b.sno}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete/${b.sno}">Delete</a></p></td></tr>
</c:forEach>
</table>
<p align="center"><a href="excel">Excel</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="pdf">Pdf</a></p>
</body>

</body>
</html>