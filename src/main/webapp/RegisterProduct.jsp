<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterProductController">
<table>

	<tr>
		<td>Enter Product id</td>
		<td><input type="text" name="prodId" required></td>
	</tr>
	<tr>
		<td>Enter Product name</td>
		<td><input type="text" name="prodName" required></td>
	</tr>
	<tr>
		<td>Enter product description</td>
		<td><input type="text" name="prodDesc"></td>
	</tr>
	<tr>
		<td>Enter Price</td>
		<td><input type="number" name="prodPrice" required></td>
	</tr>
	<tr>
		<td>Select product Image</td>
		<td><input type="text" name="prodImg" required></td>
	</tr>
	
	<tr>
		<td><input type="submit" value="RegisterHere"></td>
	</tr>

</table>

</form>
</body>
</html>