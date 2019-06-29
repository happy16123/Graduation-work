<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
          회원가입 <small>입력 페이지</small>
        </h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
        <div class="col-lg-12">
          <form class="form-horizontal" method="post" action="memberInsert">
            <div class="box box-primary">
              <div class="box-header with-border">
                <h3 class="box-title">정보입력</h3>
              </div>
              <div class="box-body">
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="idInput" >아이디</label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control" id="idInput" name="idInput" placeholder="아이디 입력">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="passwordInput">비밀번호</label>
                  <div class="col-sm-8">
                    <input type="password" class="form-control" id="passwordInput" name="passwordInput" placeholder="비밀번호 입력">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label" for="passwrodCheck">비밀번호 확인</label>
                  <div class="col-sm-8">
                    <input type="password" class="form-control" id="passwordCheck" name="passwordCheck" placeholder="비밀번호 확인">
                  </div>
                </div>
              </div>
              <div class="box-footer">
                <div class="form-group text-center">
                  <button type="submit" class="btn btn-primary">회원가입</button>
                  <button type="button" class="btn btn-warning" onclick="location.href='history(-1)'">취소</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="include/plugin.jsp"%>
</body>
</html>