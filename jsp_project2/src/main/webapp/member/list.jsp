<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
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

table, tr, th, td {
	width: 800px; border : 1px solid black;
	padding: 10px 20px;
	border-collapse: collapse;
	text-align: center;
	border: 1px solid black;
}

button {
	border: none;
	padding: 10px 20px;
	margin-top: 30px;
	background-color: #03c75a;
	color: white;
}
</style>
</head>
<body>
	<div>
		<a href="/"><img alt="never" src="/image/네버로고.png"></a> <br>
		<table>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입일</th>
			</tr>
			<c:forEach items="${list }" var="mvo">
				<tr>
					<td><a href="/mem/detail?id=${mvo.id }">${mvo.id }</a></td>
					<td>${mvo.name }</td>
					<td>${mvo.email }</td>
					<td>${mvo.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/"><button>메인페이지</button></a>
	</div>
</body>
</html>