<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp"%>
<style>
#test_editor {
  height: 300px;
}
#frame_editor {
  height: 200px;
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
          문제 만들기 <small></small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
        <div class="col-lg-12">
          <form class="form-horizontal" name="joinForm" method="post" id="form1" action="quizMake">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">작성</h3>
              </div>
              <div class="box-body">
                <c:set var="sessionId" value="${sessionScope.sessionId}" />
                <input type="hidden" name="codeno" id="codeno" value="${List.codeno}">
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="title">제 목</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" id="title" name="title" value="${List.title}" placeholder="ex) 덧셈만들기">
                  </div>
                </div>
                <div class="form-group">
                  <label for="content" class="col-sm-2 control-label">내 용</label>
                  <div class="col-sm-8">
                    <textarea class="form-control" rows="5" style="resize: none" id="content" name="content" placeholder="ex) 정수형 자료 2개를 입력 받아 더해주는 클래스를 작성하세요!!"></textarea>
                  </div>
                </div>
              </div>
             
             <div class="box-body">
              <label class="col-sm-12">테스트 코드 작성 (JAVA - Junit)</label>
              <div class="col-sm-8">
                <input type="text" class="form-control" id="test_className" name="test_className" placeholder="만든 클래스의 이름으로 만드세요 ex) CalculatorTest"><br/>
              </div>
              <div class="col-sm-12" id="test_editor"> import static org.junit.Assert.*;
 import org.junit.Test;
 
 public class CalculatorTest{
     @Test
     public void testAdd(){
         Calculator cal = new Calculator();
         assertEquals(3, cal.add(1,2));
         assertEquals(4, cal.add(2,2));
     }
 }</div>
             </div>
             
             <div class="box-body">
             <label class="col-sm-12">시작 코드 작성 (사용자에게 보여지는 시작틀입니다)</label>
             <div class="col-sm-8">
                <input type="text" class="form-control" id="answer_className" name="answer_className" placeholder="만든 클래스의 이름으로 만드세요 ex) Calculator"><br/>
              </div>
              <div class="col-sm-12" id="frame_editor">public class Calculator{
    public int add(int a, int b){
        return 0;
    }
}</div>
             </div>
             <input type="hidden" name="test_code" id="test_code">
             <input type="hidden" name="frame_code" id="frame_code">
             
              <div class="box-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='quizList?pageNo=1'">
                  <i class="fa fa-list"></i>목록
                </button>
                <div class="pull-right">
                  <button type="submit" class="btn btn-success modBtn">
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
	var test_code = document.getElementById('test_code');
	var frame_code = document.getElementById('frame_code');
    
    // 테스트 코드 만들기 부분
    var test_editor = ace.edit("test_editor");
    test_editor.setTheme("ace/theme/monokai");
    test_editor.getSession().setMode("ace/mode/java");
    test_editor.getSession().on('change', function () {
      test_code.value = test_editor.getSession().getValue();
    });
    test_code.value = test_editor.getSession().getValue();
    
    // 프레임 코드 만들기 부분
    var frame_editor = ace.edit("frame_editor");
    frame_editor.setTheme("ace/theme/monokai");
    frame_editor.getSession().setMode("ace/mode/java");
    frame_editor.getSession().on('change', function () {
    	frame_code.value = frame_editor.getSession().getValue();
    });
    frame_code.value = frame_editor.getSession().getValue();
</script>
  <%@ include file="include/plugin.jsp"%>
</body>
</html>

