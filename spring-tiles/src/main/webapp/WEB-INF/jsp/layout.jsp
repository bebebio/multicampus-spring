<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div style="position: absolute; width: 100%; height: 20%; background-color: blue;">
		<!-- HEADER -->
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div style="position: absolute; top: 20%; width: 20%; height: 60%; background-color: red;">
		<!-- MENU -->
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	</div>
	<div style="position: absolute; top: 20%; left: 20%; width: 80%; height: 60%; background-color: skyblue;">
		<!-- BODY -->
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>
	<div style="position: absolute; bottom: 0%; height: 20%; width: 100%; background-color: pink;">
		<!-- FOOTER -->
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>