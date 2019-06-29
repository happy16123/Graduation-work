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
<body>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
    <%@ include file="include/main_header.jsp"%>
    <%@ include file="include/left_column.jsp"%>
    <div class="content-wrapper">
      <script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
      <div class="container-fluid">
        <section class="content-header">
        <h1>
          Result<small>code</small>
        </h1>
        </section>
        <div class="col-lg-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">결과</h3>
            </div>
            
            <div class="box-body">  
              <div id="editor">${Code}</div>
            </div>
            <div class="box-body">
                          실행결과<br/>
            <c:forEach items="${Compile}" var="com">
              ${com}<br/>
            </c:forEach>
            <c:forEach items="${Result}" var="res">
              ${res}<br/>
            </c:forEach>
            </div>
            
            
            <div class="box-footer">
              <div class="row-fluid">
                <button type="button" class="btn pull-left btn-primary" onclick="location.href='codeInput.jsp'">돌아가기</button>
                <c:if test="${sessionScope.sessionId != null}">
                  <form action="codeSave" method="post" id="form" name="form">          
                    <input type="hidden" name="id" value="${sessionScope.sessionId}">
                    <input type="hidden" name="code" id="code" value="${Code}">
                    <input type="hidden" name="language" value="${Language}">
                    <input type="hidden" name="result" value="${Result}">
                    <input type="hidden" name="compile" value="${Compile}">
                    <button class="btn pull-right btn-primary"><i class="fa fa-save"></i>저장하기</button>
                    <input type="text" name="title" style="width:150px;" class="pull-right form-control" placeholder="저장할 이름">
                 </form>
                </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
  <script>
  		$(function($){
			var editor = ace.edit("editor");
			editor.setTheme("ace/theme/twilight");
			editor.getSession().setMode("ace/mode/java");
			editor.setReadOnly(true);
  		});
		</script>

  <%@ include file="include/plugin.jsp"%>
</body>
</html>