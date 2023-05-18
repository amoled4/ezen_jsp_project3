<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
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
	font-size: 14px;
}

textarea{
	font-size: 16px;
	width: 330px;
	height: 300px;
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
<form action="/brd/insert">
<div>
<img alt="never" src="/image/네버로고.png"> <br>
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${ses.id }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content"></textarea></td>
		</tr>
	</table>
	<button type="submit">작성완료</button>
	<a href="/brd/list"><button type="button">취소</button></a>
	</form>
	</div>
</body>
</html>