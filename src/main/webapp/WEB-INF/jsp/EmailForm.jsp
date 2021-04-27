<%@ taglib uri='http://www.springframework.org/tags/form' prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<title>Service Request</title>
<body>
<button><a href="viewAll">Home</a></button>
<form action="mail" method="post" enctype="multipart/form-data">
<h3 align="center"><u>Send Request</u></h3>
<table align="center" border="0">
<tr><td>To:</td><td><input type="text" name="recipient" size="60"></td></tr>
<tr><td>Subject:</td><td><input type="text" name="subject" size="60"></td></tr>
<tr><td>Message:</td><td><textarea name="message" rows="10" cols="60" size=80"></textarea></td></tr>
<tr><td>Attachment:</td><td><input type="file" name="attachfile" size="60"></td></tr>
<tr><td cellpadding="2" align="center"><input type="submit" value="send"></td></tr>
</table>
</form>
</body>

</html>