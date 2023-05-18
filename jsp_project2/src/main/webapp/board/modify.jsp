<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
<form action="/brd/edit">
<table>
		<tr>
			<th>번호</th>
			<td><input type="text" name="bno" value="${bvo.bno }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${bvo.title }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${bvo.writer }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><input type="text" name="readcount" value="${bvo.readcount }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><input type="text" name="regdate" value="${bvo.regdate }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="30" name="content">${bvo.content }</textarea></td>
		</tr>
	</table>
	<button type="submit">수정완료</button>
	<a href="/brd/detail?bno=${bvo.bno }"><button>취소</button></a>
	</form>
</body>
</html>