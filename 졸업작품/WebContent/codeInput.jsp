<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="include/head.jsp" %>
<style>
#editor {
    /** Setting height is also important, otherwise editor wont showup**/
    height: 500px;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
    <%@ include file="include/main_header.jsp"%>
    <%@ include file="include/left_column.jsp"%>
    <div class="content-wrapper">
      <script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.2.3/ace.js"></script>
      <div class="container-fluid">
        <section class="content-header">
        <h1>
          Edit<small>code</small>
        </h1>
        </section>
        <div class="col-lg-12">
          <form action="codeInput" method="post" id="form" name="form">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">코딩</h3>
              </div>
              <div class="box-body">
                <div class="dropdown">
                  <button class="btn btn-default dropdown-toggle" id="lang" type="button" data-toggle="dropdown">선택<span class="caret"></span></button>
                  <ul class="dropdown-menu" id="type">
                    <li role="presentation"><a href="#" id="java" value="java">java</a></li>
                    <li><a href="#" id="cpp" value="c_cpp">c++</a></li>
                  </ul>
                </div>
              </div>
              <div class="box-body">
                <div id="editor">${Code}</div>
                </div>
              </div>
                  <input type="hidden" name="code" id="code">
                  <input type="hidden" name="language" id="language">
            <button type="submit">실행</button>
          </form>
         </div>
       </div>
     </div>
      
<script>
      var code = document.getElementById('code');
      var language = document.getElementById('language');

      //ace editor 부분
      var editor = ace.edit("editor");
	  editor.setTheme("ace/theme/monokai");
      editor.getSession().setMode("ace/mode/java");

      editor.getSession().on('change', function () {
    	  code.value = editor.getSession().getValue();
      });
      
      code.value = editor.getSession().getValue();
      
      $('#type li > a').on('click', function() {
    	    // 버튼에 선택된 항목 텍스트 넣기 
    	    $('#lang').text($(this).text());
    	    // 선택한 값 가져오기
    	    editor.getSession().setMode("ace/mode/"+$(this).attr('value'));
    	    language.value = $(this).attr('id');

    	});
      
</script>

    </div>
  <%@ include file="include/plugin.jsp"%>
  </body>
</html>

      