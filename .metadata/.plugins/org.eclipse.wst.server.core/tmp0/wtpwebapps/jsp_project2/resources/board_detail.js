// 화면에서 등록한 댓글 내용을 컨트롤러로 전송 -> DB 저장
async function postCommentToServer(cmtData){
	try{
		const url = "/cmt/post";
		const config = {
			method : 'post',
			headers : {
				'content-Type' : 'application/json; charset=utf-8'
			},
			body : JSON.stringify(cmtData)
		};
		const resp = await fetch(url, config);
		const result = await resp.text();       // isOk - controller에서 보내는 결과
		return result;  // 프로미스 객체로 리턴
	}catch(error){
		console.log(error);
	}
}

// 미리 보낼 데이터를 만들어서 함수로 전달 cmtData
document.getElementById('cmtAddBtn').addEventListener('click',()=>{
	const cmtText = document.getElementById('cmtText').value;
	console.log(cmtText);
	if(cmtText == null || cmtText == ""){
		alert('댓글을 입력해주세요.');
		return false;
	} else{
		let cmtData = {
			bno : bnoVal,
			writer : document.getElementById('cmtWriter').value,
			content : cmtText
		};
		postCommentToServer(cmtData).then(result =>{
			if(result>0){
				alert('댓글 등록 성공');
				document.getElementById('cmtText').value = "";
			}
			// 댓글 표시
			
		})
	}
})

// 댓글 가져오기
// 컨트롤러에 가서 리스트 달라고 요청
async function getCommentListFromServer(bno){
	try{
	const resp = await fetch('/cmt/list/'+bno);   // cmt/list/1
	const cmtList = await resp.json();           // 댓글 객체가 리턴
	return cmtList;
		
	} catch(error){
		console.log(error);
	}
}
getCommentListFromServer(bnoVal).then(result=>{
	console.log(result);
})

function spreadCommentList(result){   // 댓글 List
	
}