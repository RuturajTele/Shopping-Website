<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="DeleteProductController">
        Enter Registration number<input type="text" name="prodId"><br>
		<input type="submit" value="delete">
		


</form>

<%
    if (!session.isNew()) {
        session.getAttribute("data");
        out.print("<p>Delete Record</p>");
        session.invalidate();
    }
%>

</br>
<a href="Home.html">Home Page</a>

</body>
</html>