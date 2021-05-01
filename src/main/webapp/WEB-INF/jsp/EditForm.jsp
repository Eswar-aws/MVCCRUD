<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Edit Book</title>
</head>
<body>
<h2> Edit Book Details</h2>
<form:form action="/Spring-MVC-CRUD-SEARCH/editsave" method="post" modelAttribute="book">

<table border="2">

<form:hidden path="sno" />
<form:hidden path="id" />
<tr><td>CountryName</td><td><form:input path="title" /></td></tr>
<tr><td>Population</td><td><form:input path="author" /></td></tr>
<tr><td>Population</td><td><form:input path="publishdate" /></td></tr>
<tr><td>Population</td><td><form:input path="price" /></td></tr>
<input type="submit" value="Udpate">
</table>
</form:form>
</body>
</html>
