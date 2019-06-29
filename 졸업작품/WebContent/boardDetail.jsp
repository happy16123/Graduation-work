<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
    <%@ include file="include/main_header.jsp"%>
    <%@ include file="include/left_column.jsp"%>
    <div class="content-wrapper">
      <div class="container-fluid">
       <section class="content-header">
        <h1>게시판 <small>상세 페이지</small></h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
          <div class="col-lg-12">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">${List.title}</h3>
              </div>
              <div class="box-body" style="height: 300px">${List.content}</div>
              <div class="box-footer">
                <div class="user-block">
                  <img class="img-circle img-bordered-sm" src="dist/img/user1-128x128.jpg">
                  <span class="username"> ${List.regid}</span>
                  <span class="description"><fmt:parseDate value="${List.regdate}" pattern="yyyy-MM-dd HH:mm" var="myDate"/><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${myDate}"/></span>
                </div>
              </div>
              <div class="box-footer">
                <form name="joinForm" method="post" id="form1">
                  <input type="hidden" name="bseq" id="bseq" value="${List.bseq}">
                  <button type="button" class="btn btn-primary listBtn" onclick="location.href='boardList?pageNo=1'"><i class="fa fa-list"></i>목록</button>
                  <div class="pull-right">
                    <c:if test="${sessionScope.sessionId == List.regid}">
                      <button type="button" class="btn btn-warning modBtn" id="modify"><i class="fa fa-edit"></i>수정</button>
                      <button type="button" class="btn btn-danger delBtn" id="remove"><i class="fa fa-trash"></i>삭제</button>
                    </c:if>
                  </div>
                </form>
              </div>
          </div>
          
          <div class="box box-waring">
            <div class="box-header with-border">
              <a class="link-black text-lg"><i class="fa fa-pencil"></i>댓글작성</a>
            </div>
            <div class="box-body">
              <form class="form-horizontal">
                <div class="form-group margin">
                  <div class="col-sm-10">
                    <textarea class="form-control" id="newReplyText" rows="3" placeholder="댓글내용" style="resize: none"></textarea>
                  </div>
                  <div class="col-sm-2">
                    <input class="form-control" id="newReplyWriter" type="text" placeholder="댓글작성자" value="${sessionScope.sessionId}">
                  </div>
                  <hr/>
                  <div class="col-sm-2">
                    <button type="button" class="btn btn-primary btn-block replyAddBtn"><i class="fa fa-save"></i>저장</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
          
          <div class="box box-success collapsed-box">
            <div class="box-header with-border">
              <a href="" class="link-black text-lg"><i class="fa fa-comments-o margin-r-5 replyCount"></i></a>
              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapsed"><i class="fa fa-plus"></i></button>
              </div>
            </div>          
          </div>
          
          <div class="box-body repliesDiv">       
          </div>
          
          <div class="box-footer">
            <div class="text-center">
              <ul class="pagination pagination-sm no-margin">
              </ul>
            </div>
          </div>
          
          <div class="modal fade" id="modModal" data-backdrop="false">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">댓글수정</h4>
                </div>
                <div class="modal-body" data-ron>
                  <input type="hidden" class="replyNo"/>
                  <textarea class="form-control" id="replyText" rows="3" style="resize:none"></textarea>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
                  <button type="button" class="btn btn-primary modalModBtn">수정</button>
                </div>
              </div>
            </div>
          </div>
                    
          <div class="modal fade" id="delModal" data-backdrop="false">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">댓글 삭제</h4>
                    <input type="hidden" class="rno"/>
                </div>
                <div class="modal-body" data-rno">
                  <p>댓글을 삭제하시겠습니까?</p>
                  <input type="hidden" class="rno">
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default pull-left" data-dismiss="modal">아니요</button>
                  <button type="button" class="btn btn-primary modalDelBtn">네</button>
                </div>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
  <%@ include file="include/plugin.jsp"%>
  <script>
  //수정 및 삭제 버튼
			$(function($) {
				var bseq = $("#bseq").val();
				$("#modify").click(function() {
					$("#form1").attr("action", "/mvc2/boardEdit?bseq=" + bseq);
					$("#form1").submit();
				});
				$("#remove").click(
						function() {
							$("#form1").attr("action",
									"/mvc2/boardRemove?bseq=" + bseq);
							$("#form1").submit();
						});
			});
	//날짜맞추기			
			function getFormatDate(date){
				var dateObj = new Date(date);
	  			var year = dateObj.getFullYear();
	  			var month = dateObj.getMonth() + 1;
	  			var date = dateObj.getDate();
	  			var hours = dateObj.getHours();
	  			var minutes = dateObj.getMinutes();
	  			
	  			month < 10 ? month = '0' + month : month;
	  			date < 10 ? date = '0' + date : date;
	  			hours < 10 ? hours = '0' + hours : hours;
	  			minutes < 10 ? minutes = '0' + minutes : minutes;
	  			return year + "-" + month + "-" + date + " " + hours + ":" + minutes;
			}
		</script>
  <script id="replyTemplate" type="text/x-handlebars-template">
	{{#each.}}
	<div class="post replyDiv" data-replyNo={{replyno}}>
		<div class="user-block">
			<img class="img-circle img-bordered-sm" src="dist/img/user1-128x128.jpg" alt="user image">
			<span class="username">
				<a href="#">{{replywriter}}</a>
					<a href="#" class="pull-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal"><i class="fa fa-times">삭제</i></a>
					<a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal"><i class="fa fa-edit">수정</i></a>
			</span>
			<span class="description">{{prettifyDate regdate}}</span>
		</div>
		<div class="oldReplyText">{{{escape replytext}}}</div>
		<br/>
	</div>
	{{/each}}
	</script>
  <script>
  	$(document).ready(function(){
  		var bseq = $("#bseq").val(); //현재 게시글 번호
  		var replyPageNum = 1;  // 댓글 페이지 번호 초기화
  		
  		// 댓글 내용 : 줄바꿈, 공백처리
  		Handlebars.registerHelper("escape", function (replyText){
  			var text = Handlebars.Utils.escapeExpression(replyText);
  			text = text.replace(/(\r\n|\n|\r)/gm, "<br/>");
  			text = text.replace(/( )/gm, "&nbsp;");
  			return new Handlebars.SafeString(text);
  		});
  		
  		// 댓글 등록일자 : 날짜/시간 2자리로 맞추기
  		Handlebars.registerHelper("prettifyDate", function (timeValue){
  			var dateObj = new Date(timeValue);
  			var year = dateObj.getFullYear();
  			var month = dateObj.getMonth() + 1;
  			var date = dateObj.getDate();
  			var hours = dateObj.getHours();
  			var minutes = dateObj.getMinutes();
  			
  			month < 10 ? month = '0' + month : month;
  			date < 10 ? date = '0' + date : date;
  			hours < 10 ? hours = '0' + hours : hours;
  			minutes < 10 ? minutes = '0' + minutes : minutes;
  			return year + "-" + month + "-" + date + " " + hours + ":" + minutes;
  		});
  		
  		// 댓글 목록 함수 호출
  		getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
  		
  		// 댓글 목록 함수
  		function getReplies(repliesUri){
  			$.getJSON(repliesUri, function (data) {
  				console.log(data);
  				printReplyCount(data.pageMaker.totalCount);
  				printReplies(data.replies, $(".repliesDiv"), $("#replyTemplate"));
  				printReplyPaging(data.pageMaker, $(".pagination"));
  			});
  		}
  		
  		// 댓글 갯수 출력 함수
  		function printReplyCount(totalCount){
  			var replyCount = $(".replyCount");
  			var collapsedBox = $(".collapsed-box");
  			
  			// 댓글이 없을때
  			if(totalCount === 0){
  				replyCount.html("댓글이 없습니다. 의견을 남겨주세요");
  				collapsedBox.find(".btn-box-tool").remove();
  				return;
  			}
  			
  			// 댓글이 있을때
  			replyCount.html(" 댓글 목록 (" + totalCount + ")");
  			collapsedBox.find(".box-tools").html(
  					"<button type='buttn' class='btn btn-box-tool' data-widget='collapsed'>"
  					+ "<i class='fa fa-plus'</i></button>");
  		}
  		
  		// 댓글 목록 출력 함수
  		function printReplies(replyArr, targetArea, templateObj){
  			var replyTemplate = Handlebars.compile(templateObj.html());
  			var html = replyTemplate(replyArr);
  			$(".replyDiv").remove();
  			targetArea.html(html);
  		}
  		
  		// 댓글 페이징 출력 함수
  		function printReplyPaging(pageMaker, targetArea){
  			var str = "";
  			var len = pageMaker.endPageNo;
  			if(pageMaker.totalCount != 0){
  				if(pageMaker.pageNo != 1){
  					str += "<li><a href='" + pageMaker.prevPageNo + "'>이전</a></li>";
  				}
  				for(var i=(pageMaker.startPageNo*5)+1; i<=len; i++){
	  				str += "<li><a href='" + i + "'>" + i + "</a></li>";
  				}
  				if(pageMaker.pageNo != pageMaker.finalPageNo){
  					str += "<li><a href='" + pageMaker.nextPageNo + "'>다음</a></li>";
  				}
  				targetArea.html(str);
  			}
  		}
  		
  		// 댓글 페이지 번호 클릭 이벤트
  		$(".pagination").on("click", "li a", function (event){
  			event.preventDefault();
  			replyPageNum = $(this).attr("href");
  			getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=" + replyPageNum);
  			});
  		  		
  		// 댓글 저장 버튼 클릭 이벤트
  		$(".replyAddBtn").on("click", function(){
  			// 입력 form 선택
  			var replyWriterObj = $("#newReplyWriter");
  			var replyTextObj = $("#newReplyText");
  			var replyWriter = replyWriterObj.val();
  			var replyText = replyTextObj.val();

  			// 댓글 입력처리 수행
    		$.ajax({
    			type : "POST",
    			url : "/mvc2/replyInsert",
    			header : {
    				"Content-Type" : "application/json",
    				"X-HTTP-Method-Override" : "POST"
    			},
    			dataType : "text",
    			data : {
    				bseq : bseq,
    				replyWriter : replyWriter,
    				replyText : replyText
    			},
    			success: function(result){
    				console.log("result : " + result);
    				obj = JSON.parse(result);
    				var mesg = obj.message;
    				if(mesg === "regSuccess"){
    					alert("댓글등록이 완료되었습니다");
    					getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
    					replyTextObj.val("");
    					replyWriterObj.val("");
    				}
    			}
    		});
  		});
  		
  		// 댓글 수정 modal 창에 선택한 댓글 값 세팅
  		$(".repliesDiv").on("click", ".replyDiv", function(event){
  			var reply = $(this);
  			$(".replyNo").val(reply.attr("data-replyNo"));
  			$("#replyText").val(reply.find(".oldReplyText").text());
  		});
  		
  		// 댓글 수정 modal 켰을 때 포커스
  		$('#modModal').on('shown.bs.modal', function() {
  		  $('#replyText').focus();
  		});
  		
  		// modal 창의 댓글 수정 이벤트
  		$(".modalModBtn").on("click", function(){		
  			var replyNo = $(".replyNo").val();
  			var replyText = $("#replyText").val();
  			$.ajax({
  				type : "POST",
  				url : "/mvc2/replyUpdate",
  				header : {
  					"Content-Type" : "application/json",
  					"X-HTTP-Method-Orverride" : "POST"
  				},
  				dataType : "text",
  				data : {
  					replyText : replyText,
  					replyNo : replyNo,
  					bseq : bseq
  				},
  				success: function(result){
  					console.log("result : " + result);
  					obj = JSON.parse(result);
  					var mesg = obj.message;
  					if(mesg === "modSuccess"){
  						alert("댓글이 수정되었습니다");
  						getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
  						$("#modModal").modal("hide");
  					}
  				}
  			});
  		});
  		
  		// modal 창의 댓글 삭제 이벤트
  		$(".modalDelBtn").on("click", function(){
  			var replyNo = $(".replyNo").val();
  			$.ajax({
  				type : "POST",
  				url : "/mvc2/replyRemove",
  				header : {
  					"Content-Type" : "application/json",
  					"X-HTTP-Method-Override" : "POST"
  				},
  				dataType : "text",
  				data : {
  					replyNo : replyNo,
  					bseq : bseq
  				},
  				success: function(result){
  					console.log("result : " + result);
  					obj = JSON.parse(result);
  					var mesg = obj.message;
  					if(mesg === "delSuccess"){
  						alert("댓글이 삭제되었습니다");
  						getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
  						$("#delModal").modal("hide");
  					}
  				}
  			});
  		});
  	});
  </script>
</body>
</html>
