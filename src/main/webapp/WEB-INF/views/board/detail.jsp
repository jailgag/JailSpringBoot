<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 상세조회!</title>
</head>
<body>
	<main>
		<section>
			<h1>게시판 - 상세조회</h1>
			<h1>${board.boardTitle }</h1>
			<input type="hidden" id="boardNo" value="${board.boardNo }">
			<div>
				<p><span>작성일</span>${board.boardCreateDate }</p>
			</div>
			<div>${board.boardContent }</div>
			<div>
				<c:forEach items="${board.imgList }" var="boardImg">
					<img alt="board-img" src="${boardImg.imgPath }">
				</c:forEach>
			</div>
		</section>
		<!-- 댓글목록 -->
		<div class="comment-list-area">
			<ul id="commentList">
				<c:forEach items="${board.commentList }" var="comment">
					<li class="comment-row">
						<p>
							<span>닉네임</span>
							<span>${comment.commentCreateDate }</span>
						</p>
						<p>${comment.commentContent }</p>
						<div>
							<button>답글</button>
							<button>수정</button>
							<button>삭제</button>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="comment-write-area">
			<textarea id="commentContent"></textarea>
			<button id="addComment">댓글등록</button>
		</div>
	</main>
	<script>
		//아래 코드작성후 Commentcontroller 로 감!!
		const boardNo = "${board.boardNo}";
		
		function getCommentList(){
			//get방식이라 생략??~~boardNo="+boardNo, {} <--{}이거 생략!!
			//.then(cmList => console.log(cmList)) <--콘솔로 출력하는방법코드인데 지워지니 남겨둠!!아래
			//코드 변경되는코드 참고!!
			fetch("/comment/list?boardNo="+boardNo)
			.then(response => response.json())
			.then(cmList => {
				//console.log(cmList);//for문으로 돌리기!(#commentListdp C대문자 에러!!)
				const cmListTag = document.querySelector("#commentList");
				cmListTag.innerHTML ="";
				for(let comment of cmList) {
					//li태그 생성
					const commentRow = document.createElement("li");
					commentRow.classList.add("commetn-row");
					//p 태그생성
					const commentPtag = document.createElement("p");
					commentPtag.classList.add("comment-writer")
					//span 태그 생성
					//닉네임
					const nickNameTag = document.createElement("span");
					nickNameTag.innerText = "닉네임";
					const writeDateTag = document.createElement("span");
					//적성일
					writeDateTag.innerText = comment.commentCreateDate;
					//내용
					const contentTag = document.createElement("p");
					// comment 데이터 껴 넣기
					contentTag.innerText = comment.commentContent;
					//버튼영역
					const buttonArea = document.createElement("div");
					//아래코드는 css코드??!!
					buttonArea.classList.add("comment-btn-area");
					const replyBtn = document.createElement("button");
					replyBtn.innerText = "답글";
					const modifyBtn = document.createElement("button");
					modifyBtn.innerText = "수정";
					const deleteBtn = document.createElement("button");
					deleteBtn.innerText = "삭제;"
					buttonArea.append(replyBtn, modifyBtn, deleteBtn);
					//list 붙여넣기!
					commentPtag.append(nickNameTag,writeDateTag);
					commentRow.append(commentPtag, contentTag, buttonArea);
					//댓글 목록(ul) 에 댓글(li) 추가
					cmListTag.append(commentRow);
				}
			})
			.catch(error => alert("error :" +error))
			
		}
		//등록깜빡이는거 5번째등록하고 위코드작성!!
		//아래 location.href="/board/"+boardNo대신에 위코드 작성후 {getCommentList()}넣어줌!
		document.querySelector("#addComment").addEventListener("click", function() {
			// boardNo는 어떤 게시글인지
			// commentContent는 어떤 내용인지!!
			//아래코드는 1가지 방법이고 그또다른 방법이 주석다음코드!
			//const boardNo = document.qeurySelector("#boardNo").value;
			//자바스크립트안에서도 for:each문 사용가능(지도에서 사용??)
			//익숙하지않아 복습이 필요함! 작성후 controller에가서 @RequestBody적어줌!!
			//아래 cosnt boardNo~~~는 주석처리하고 위에다가 적어줌!!
			//const boardNo = "${board.boardNo}";
			const commentContent = document.querySelector("#commentContent").value;
			//아래코드는 ???/????서버로 제출할 데이터를 모아둔 JS객체!!!
			const data = { "boardNo": boardNo, "commentContent": commentContent};
			fetch("/comment/insert",{
				method:"POST"
				,headers: {"Content-type": "application/json"}
				, body:JSON.stringify(data)})
			.then(response => response.text())
			.then(result => {
				if(result > 0) {
					alert("댓글이 등록되었습니다");
					getCommentList()
				}else {
					alert("댓글 등록이 완료되지 않았습니다");
				}
				})
			.catch(error => alert("error :" , error));
		});
	</script>
	</body>
</html>