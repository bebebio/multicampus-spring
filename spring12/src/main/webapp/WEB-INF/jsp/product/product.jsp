<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<label>Code :</label> <input type="text" value="${productVo.code}"><br>
		<label>Name :</label> <input type="text" value="${productVo.name}"><br>
		<label>Price :</label> <input type="text" value="${productVo.price}"><br>
		<label>Pictureurl : </label> <input type="text" value="${productVo.pictureurl}"><br>
		<label>Description : </label> <input type="text" value="${productVo.description}">
	</div>
</body>
</html>