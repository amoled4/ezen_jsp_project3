<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<img alt="never" src="/ROOT/image/네버로고.png">

	<c:if test="${ses.id ne null }">
		${ses.name } 님이 로그인하셨습니다. <br>
		<a href=""><button type="button">로그아웃</button></a>
		<a href=""><button type="button">회원정보수정</button></a>
		<a href=""><button type="button">회원탈퇴</button></a>
	</c:if>

	<c:if test="${ses.id eq null }">
		<form action="/mem/login" method="post">
			<table>
				<tr>
					<td><input type="text" name="id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><input type="password" name="pw" placeholder="비밀번호"></td>
				</tr>
			</table>
			<button type="submit">로그인</button>
		</form>
		<a href="/mem/sign"><button type="button">회원가입</button></a>
	</c:if>
	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		if(msg_login === '0'){
			alert('로그인 정보가 올바르지 않습니다.');
		}
	</script>
</body>
</html>