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
        <h1>�Խ��� <small>�� ������</small></h1>
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
                  <button type="button" class="btn btn-primary listBtn" onclick="location.href='boardList?pageNo=1'"><i class="fa fa-list"></i>���</button>
                  <div class="pull-right">
                    <c:if test="${sessionScope.sessionId == List.regid}">
                      <button type="button" class="btn btn-warning modBtn" id="modify"><i class="fa fa-edit"></i>����</button>
                      <button type="button" class="btn btn-danger delBtn" id="remove"><i class="fa fa-trash"></i>����</button>
                    </c:if>
                  </div>
                </form>
              </div>
          </div>
          
          <div class="box box-waring">
            <div class="box-header with-border">
              <a class="link-black text-lg"><i class="fa fa-pencil"></i>����ۼ�</a>
            </div>
            <div class="box-body">
              <form class="form-horizontal">
                <div class="form-group margin">
                  <div class="col-sm-10">
                    <textarea class="form-control" id="newReplyText" rows="3" placeholder="��۳���" style="resize: none"></textarea>
                  </div>
                  <div class="col-sm-2">
                    <input class="form-control" id="newReplyWriter" type="text" placeholder="����ۼ���" value="${sessionScope.sessionId}">
                  </div>
                  <hr/>
                  <div class="col-sm-2">
                    <button type="button" class="btn btn-primary btn-block replyAddBtn"><i class="fa fa-save"></i>����</button>
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
                    <h4 class="modal-title">��ۼ���</h4>
                </div>
                <div class="modal-body" data-ron>
                  <input type="hidden" class="replyNo"/>
                  <textarea class="form-control" id="replyText" rows="3" style="resize:none"></textarea>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default pull-left" data-dismiss="modal">�ݱ�</button>
                  <button type="button" class="btn btn-primary modalModBtn">����</button>
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
                    <h4 class="modal-title">��� ����</h4>
                    <input type="hidden" class="rno"/>
                </div>
                <div class="modal-body" data-rno">
                  <p>����� �����Ͻðڽ��ϱ�?</p>
                  <input type="hidden" class="rno">
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default pull-left" data-dismiss="modal">�ƴϿ�</button>
                  <button type="button" class="btn btn-primary modalDelBtn">��</button>
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
  //���� �� ���� ��ư
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
	//��¥���߱�			
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
					<a href="#" class="pull-right btn-box-tool replyDelBtn" data-toggle="modal" data-target="#delModal"><i class="fa fa-times">����</i></a>
					<a href="#" class="pull-right btn-box-tool replyModBtn" data-toggle="modal" data-target="#modModal"><i class="fa fa-edit">����</i></a>
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
  		var bseq = $("#bseq").val(); //���� �Խñ� ��ȣ
  		var replyPageNum = 1;  // ��� ������ ��ȣ �ʱ�ȭ
  		
  		// ��� ���� : �ٹٲ�, ����ó��
  		Handlebars.registerHelper("escape", function (replyText){
  			var text = Handlebars.Utils.escapeExpression(replyText);
  			text = text.replace(/(\r\n|\n|\r)/gm, "<br/>");
  			text = text.replace(/( )/gm, "&nbsp;");
  			return new Handlebars.SafeString(text);
  		});
  		
  		// ��� ������� : ��¥/�ð� 2�ڸ��� ���߱�
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
  		
  		// ��� ��� �Լ� ȣ��
  		getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
  		
  		// ��� ��� �Լ�
  		function getReplies(repliesUri){
  			$.getJSON(repliesUri, function (data) {
  				console.log(data);
  				printReplyCount(data.pageMaker.totalCount);
  				printReplies(data.replies, $(".repliesDiv"), $("#replyTemplate"));
  				printReplyPaging(data.pageMaker, $(".pagination"));
  			});
  		}
  		
  		// ��� ���� ��� �Լ�
  		function printReplyCount(totalCount){
  			var replyCount = $(".replyCount");
  			var collapsedBox = $(".collapsed-box");
  			
  			// ����� ������
  			if(totalCount === 0){
  				replyCount.html("����� �����ϴ�. �ǰ��� �����ּ���");
  				collapsedBox.find(".btn-box-tool").remove();
  				return;
  			}
  			
  			// ����� ������
  			replyCount.html(" ��� ��� (" + totalCount + ")");
  			collapsedBox.find(".box-tools").html(
  					"<button type='buttn' class='btn btn-box-tool' data-widget='collapsed'>"
  					+ "<i class='fa fa-plus'</i></button>");
  		}
  		
  		// ��� ��� ��� �Լ�
  		function printReplies(replyArr, targetArea, templateObj){
  			var replyTemplate = Handlebars.compile(templateObj.html());
  			var html = replyTemplate(replyArr);
  			$(".replyDiv").remove();
  			targetArea.html(html);
  		}
  		
  		// ��� ����¡ ��� �Լ�
  		function printReplyPaging(pageMaker, targetArea){
  			var str = "";
  			var len = pageMaker.endPageNo;
  			if(pageMaker.totalCount != 0){
  				if(pageMaker.pageNo != 1){
  					str += "<li><a href='" + pageMaker.prevPageNo + "'>����</a></li>";
  				}
  				for(var i=(pageMaker.startPageNo*5)+1; i<=len; i++){
	  				str += "<li><a href='" + i + "'>" + i + "</a></li>";
  				}
  				if(pageMaker.pageNo != pageMaker.finalPageNo){
  					str += "<li><a href='" + pageMaker.nextPageNo + "'>����</a></li>";
  				}
  				targetArea.html(str);
  			}
  		}
  		
  		// ��� ������ ��ȣ Ŭ�� �̺�Ʈ
  		$(".pagination").on("click", "li a", function (event){
  			event.preventDefault();
  			replyPageNum = $(this).attr("href");
  			getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=" + replyPageNum);
  			});
  		  		
  		// ��� ���� ��ư Ŭ�� �̺�Ʈ
  		$(".replyAddBtn").on("click", function(){
  			// �Է� form ����
  			var replyWriterObj = $("#newReplyWriter");
  			var replyTextObj = $("#newReplyText");
  			var replyWriter = replyWriterObj.val();
  			var replyText = replyTextObj.val();

  			// ��� �Է�ó�� ����
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
    					alert("��۵���� �Ϸ�Ǿ����ϴ�");
    					getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
    					replyTextObj.val("");
    					replyWriterObj.val("");
    				}
    			}
    		});
  		});
  		
  		// ��� ���� modal â�� ������ ��� �� ����
  		$(".repliesDiv").on("click", ".replyDiv", function(event){
  			var reply = $(this);
  			$(".replyNo").val(reply.attr("data-replyNo"));
  			$("#replyText").val(reply.find(".oldReplyText").text());
  		});
  		
  		// ��� ���� modal ���� �� ��Ŀ��
  		$('#modModal').on('shown.bs.modal', function() {
  		  $('#replyText').focus();
  		});
  		
  		// modal â�� ��� ���� �̺�Ʈ
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
  						alert("����� �����Ǿ����ϴ�");
  						getReplies("/mvc2/replyList?bseq=" + bseq + "&replyPageNum=1");
  						$("#modModal").modal("hide");
  					}
  				}
  			});
  		});
  		
  		// modal â�� ��� ���� �̺�Ʈ
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
  						alert("����� �����Ǿ����ϴ�");
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
