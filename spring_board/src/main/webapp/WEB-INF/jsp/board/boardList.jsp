
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>BoardList</title>
</head>
<body>
	<label>Total : ${boardListVo.pageTotalCount}</label><br>
	<label>Page : ${boardListVo.pageIndex} / ${boardListVo.pageLast}</label>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Writedate</th>
				<th>Readcount</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardListVo.boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td>${board.title}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.writedate}"/></td>
					<td>${board.readcount}</td>
					<td>${board.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:forEach begin="${boardListVo.pageBegin}" end="${boardListVo.pageEnd}" step="1" varStatus="num">
		<c:choose>
			<c:when test="${num.count == boardListVo.pageIndex}">
				<a href="<c:url value='/selectBoardList.do?pageIndex=${num.count}'/>"><b>${num.count}</b></a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/selectBoardList.do?pageIndex=${num.count}'/>">${num.count}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>