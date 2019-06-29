<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp"%>
<style>
#editor {
    /** Setting height is also important, otherwise editor wont showup**/
    height: 500px;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
    <%@ include file="include/main_header.jsp"%>
    <%@ include file="include/left_column.jsp"%>
    <div class="content-wrapper">
      <div class="container-fluid">
        <section class="content-header">
        <h1>
          문제보기 <small>뷰 페이지</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
        <div class="col-lg-12">
          <form class="form-horizontal" name="joinForm" method="post" id="form1" action="quizTesting">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">${List.title}</h3>
              </div>
              <div class="box-body">
                <label class="col-sm-12 control-label">${List.content}</label>
              </div>
              <div class="box-body">
                <div id="editor">${List.codeframe}</div>
              </div>
              <div class="box-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='quizList?pageNo=1'">
                  <i class="fa fa-list"></i> 목록
                </button>
                <div class="pull-right">
                  <button type="reset" class="btn btn-waring cancelBtn">
                    <i class="fa fa-trash"></i> 다시쓰기
                  </button>
                  <button type="submit" class="btn btn-success modBtn">
                    <i class="fa fa-save"></i> 제출
                  </button>
                  <c:set var="sessionId" value="${sessionScope.sessionId}" />
                  <input type="hidden" name="codeno" id="codeno" value="${List.codeno}">
                  <input type="hidden" name="executeId" id="executeId" value="${sessionScope.sessionId}">
                  <input type="hidden" name="testclassname" id="testclassname" value="${List.testClassName}">
                  <input type="hidden" name="answerclassname" id="answerclassname" value="${List.answerClassName}">
                  <input type="hidden" name="title" id="title" value="${List.title}">
                  
                  <input type="hidden" name="code" id="code">
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
<script>
	var code = document.getElementById('code');

      //ace editor 부분
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/java");

    editor.getSession().on('change', function () {
      code.value = editor.getSession().getValue();
    });
      
    code.value = editor.getSession().getValue();
</script>
  <%@ include file="include/plugin.jsp"%>
</body>
</html>

