<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
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
.log{
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

		<c:if test="${ses.id ne null }">
		<strong>${ses.name }</strong> 님이 로그인하셨습니다. <br>
		마지막 접속일 : ${ses.last_login } <br>
			<br>
			<a href="/brd/page"><button type="button">게시판</button></a>
			<a href="/mem/logout"><button type="button">로그아웃</button></a>
			<a href="/mem/detail?id=${ses.id }"><button type="button">회원정보수정</button></a>
			<a href="/mem/remove?id=${ses.id }"><button type="button">회원탈퇴</button></a>
		</c:if>

		<c:if test="${ses.id eq null }">
			<form action="/mem/login" method="post">
				<table>
					<tr>
						<td><input class="log" type="text" name="id" placeholder="아이디"></td>
					</tr>
					<tr>
						<td><input class="log" type="password" name="pw" placeholder="비밀번호"></td>
					</tr>
				</table>
				<button type="submit">로그인</button>
			<a href="/mem/sign"><button type="button">회원가입</button></a>
			</form>
		</c:if>

		<c:if test="${ses.auth eq '1' }">
			<a href="/mem/list"><button>관리자 페이지</button></a>
		</c:if>
	</div>

	<script type="text/javascript">
		const msg_login = `<c:out value="${msg_login}"/>`;
		if (msg_login === '0') {
			alert('로그인 정보가 올바르지 않습니다.');
		}

		const msg_remove = `<c:out value="${msg_remove}"/>`;
		if (msg_remove === '0') {
			confirm('정말로 탈퇴하시겠습니까?');
		}

		const msg_join = `<c:out value="${msg_join}"/>`;
		if (msg_join === '0') {
			alert('가입완료. 로그인해 주세요.');
		}
		
		const msg_modify = `<c:out value="${msg_modify}"/>`;
		if(msg_modify === '0'){
			alert('수정완료.');
		}
	</script>
</body>
</html>