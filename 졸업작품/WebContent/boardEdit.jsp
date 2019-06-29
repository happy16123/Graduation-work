<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <h1>
          게시판 <small>수정 페이지</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
        <div class="col-lg-12">
          <form class="form-horizontal" name="joinForm" method="post" id="form1">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">게시글 수정</h3>
              </div>
              <div class="box-body">
                <c:set var="sessionId" value="${sessionScope.sessionId}" />
                <input type="hidden" name="bseq" id="bseq" value="${List.bseq}"> <input type="hidden" name="regid" id="regid" value="${List.regid}">
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="title">제 목</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" id="title" name="title" value="${List.title}">
                  </div>
                </div>
                <div class="form-group">
                  <label for="content" class="col-sm-2 control-label">내 용</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" rows="5" style="resize: none" id="content" name="content">${List.content}</textarea>
                  </div>
                </div>
                <div class="form-group">
                  <label for="regid" class="col-sm-2 control-label">작성자</label>
                  <div class="col-sm-8">
                    <input class="form-control" id="regid" name="regid" value="${List.regid}" readonly>
                  </div>
                </div>
              </div>
              <div class="box-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='boardList?pageNo=1'">
                  <i class="fa fa-list"></i>목록
                </button>
                <div class="pull-right">
                  <button type="reset" class="btn btn-waring cancelBtn">
                    <i class="fa fa-trash"></i>다시쓰기
                  </button>
                  <button type="button" class="btn btn-success modBtn" id="modify">
                    <i class="fa fa-save"></i>완료
                  </button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script>
			$(function($) {
				var bseq = $("#bseq").val();
				$("#modify").click(
						function() {
							$("#form1").attr("action",
									"/mvc2/boardUpdate?bseq=" + bseq);
							$("#form1").submit();
						});
			});
		</script>
  <%@ include file="include/plugin.jsp"%>
</body>
</html>
