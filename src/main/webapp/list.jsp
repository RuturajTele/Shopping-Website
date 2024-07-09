<%@page import="java.util.List"%>
<%@page import="shop.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Product Description</th>
            <th>Product Price</th>
            <th>Product Image</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.prodName}</td>
                <td>${product.product_description}</td>
                <td>${product.product_price}</td>
                <td><img src="${product.product_image}" alt="Product Image" width="100" height="100"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>