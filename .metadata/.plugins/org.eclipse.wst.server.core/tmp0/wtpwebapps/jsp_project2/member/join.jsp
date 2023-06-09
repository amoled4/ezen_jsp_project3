<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
div {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}
img{
	width: 300px;
	margin-bottom: 50px;
}
input{
	width: 300px;
	height: 20px;
	padding: 15px;
}
button{
	border: none;
	padding: 10px 20px;
	margin-top: 10px;
	background-color: #03c75a;
	color: white;
}
</style>
</head>
<body>
	<div>
		<a href="/"><img alt="never" src="/image/네버로고.png"></a> <br>
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
			<br>
			<strong>* 표시는 필수 입력입니다.</strong> <br>
			<button type="submit">가입완료</button>
		<a href="/"><button type="button">취소</button></a>
		</form>
	</div>
</body>
</html>