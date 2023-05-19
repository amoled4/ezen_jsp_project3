<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style type="text/css">
.box {
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
	width: 600px;
	padding: 10px 20px;
	border-collapse: collapse;
	border: 1px solid black;
	text-align: left;
}

.btnDe {
	display: inline-block;
	float: right; border : none;
	padding: 5px 15px;
	margin: 10px 5px;
	background-color: #03c75a;
	color: white;
	border: none;
}

.commentWrite {
	margin-top: 50px;
}


</style>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<div class="box">
		<img alt="never" src="/image/네버로고.png"> <br>
		<c:if test="${bvo.writer eq ses.id }">
			<a href="/brd/modify?bno=${bvo.bno }"><button class="btnDe">수정</button></a>
			<a href="/brd/remove?bno=${bvo.bno }"><button class="btnDe">삭제</button></a>
		</c:if>
		<a href="/brd/list"><button class="btnDe">글목록</button></a>
		<table>
			<tr>
				<td><strong>번호</strong> ${bvo.bno }</td>
				
			</tr>
			<tr>
				<td><strong>작성자</strong> ${bvo.writer }</td>
			</tr>
			<tr>
				<td><strong>조회수</strong> ${bvo.readcount }</td>
			</tr>
			<tr>
				<td><strong>작성일</strong> ${bvo.regdate }</td>
			</tr>
			<tr>
				<td><strong>제목</strong> ${bvo.title }</td>
			</tr>
			<tr>
				<td height="300">${bvo.content }</td>
			</tr>
		</table>


		<div class="commentWrite">
			<!-- 댓글 작성 라인 -->
			<input type="text" id="cmtWriter" value="${ses.id }"
				readonly="readonly"> <input type="text" id="cmtText"
				placeholder="Add Comment">
			<button type="button" id="cmtAddBtn">등록</button>
		</div>
		<br>
		<!-- 댓글 표시 라인 -->
		<div class="accordion accordion-flush" id="accordionFlushExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="flush-headingOne">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
						aria-expanded="false" aria-controls="flush-collapseOne">
						cno, writer</button>
				</h2>
				<div id="flush-collapseOne" class="accordion-collapse collapse"
					aria-labelledby="flush-headingOne"
					data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">content, regdate</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}"/>`;
	</script>
	<script src="/resources/board_detail.js">
		
	</script>
</body>
</html>