<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보상세 수정</title>
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

input {
	width: 300px;
	height: 20px;
	padding: 15px;
}

button {
	border: none;
	padding: 10px 20px;
	margin-top: 20px;
	background-color: #03c75a;
	color: white;
}
</style>
</head>
<body>
	<div>
		<a href="/"><img alt="never" src="/image/네버로고.png"></a> <br>
		<form action="/mem/modify?id=${mvo.id }" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="${mvo.id }"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="pw" value="${mvo.pw }"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${mvo.name }"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" value="${mvo.phone }"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" value="${mvo.email }"></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><input type="text" name="regdate" value="${mvo.regdate }" readonly="readonly"></td>
				</tr>
				<tr>
					<th>마지막 접속일</th>
					<td><input type="text" name="last_login" value="${mvo.last_login }" readonly="readonly"></td>
				</tr>
				<c:if test="${ses.auth eq '1' }">
					<tr>
						<th>권한</th>
						<td><input type="text" name="auth" value="${mvo.auth }"></td>
					</tr>
				</c:if>
			</table>
			<button type="submit">수정완료</button>
		<a href="/"><button type="button">취소</button></a> 
		<a href="/mem/remove?id=${mvo.id }"><button type="button">회원탈퇴</button></a>
		</form>
	</div>
</body>
</html>