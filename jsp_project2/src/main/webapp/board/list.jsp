<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
div {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}

img {
	width: 300px;
	margin-bottom: 50px;
}

table {
	border-collapse: collapse;
	width: 800px;
	padding: 10px 20px;
	text-align: center;
}

th {
	color: #03c75a;
	border-bottom: 2px solid #03c75a;
	padding: 10px;
}

td {
	color: #669;
	border-bottom: 1px solid #ddd;
	padding: 10px;
}

tr:hover td {
	color: #004;
}

button {
	border: none;
	padding: 10px 20px;
	margin-top: 30px;
	background-color: #03c75a;
	color: white;
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
		<img alt="never" src="/image/네버로고.png"> <br>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list }" var="bvo">
				<tr>
					<td>${bvo.bno }</td>
					<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
					<td>${bvo.writer }</td>
					<td>${bvo.regdate }</td>
					<td>${bvo.readcount }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/brd/register"><button type="button">글작성</button></a> <a
			href="/"><button type="button">메인</button></a>
	</div>
</body>
</html>