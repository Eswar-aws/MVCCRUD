<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Add New Book</title>
</head>
<body>
<form action="save" method="post">
<table border="0" width="80" align="center">
<tr><td>BookID</td><td><input type="number" name="id" ></td></tr>
<tr><td>Title</td><td><input type="text" name="title"></td></tr>
<tr><td>Author</td><td><input type="text" name="author"></td></tr>
<tr><td>PublishedDate</td><td><input type="text" name="publishdate"></td></tr>
<tr><td>Price</td><td><input type="number" name="price"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Save">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="clear"></td></tr>
</table>
</form>
</body>
</html>