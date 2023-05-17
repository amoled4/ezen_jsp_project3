<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	로고
	<form action="/mem/join" method="post">
		<table>
			<tr>
				<th>*아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<th>*이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
		</table>
		<button type="submit">회원가입</button>
	</form>
		<a href="/"><button type="button">취소</button></a>
</body>
</html>