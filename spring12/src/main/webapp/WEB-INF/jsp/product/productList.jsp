<%@page import="java.util.Iterator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ProductList</title>
</head>
<body>
	<label>Total : ${productListVo.pageTotalCount}</label><br>
	<label>Page : ${productListVo.pageIndex} / ${productListVo.pageLast}</label>
	<table border="1">
		<thead>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
				<th>Pictureurl</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productListVo.productList}" var="product">
				<tr>
					<td><a href="<c:url value='/selectProduct.do?code=${product.code}'/>">${product.code}</a></td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.pictureurl}</td>
					<td>${product.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach begin="${productListVo.pageBegin}" end="${productListVo.pageEnd}" step="1" varStatus="num">
		<c:choose>
			<c:when test="${num.count == productListVo.pageIndex}">
				<a href="<c:url value='/selectProductList.do?pageIndex=${num.count}'/>"><b>${num.count}</b></a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/selectProductList.do?pageIndex=${num.count}'/>">${num.count}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>