<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
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
        <h1>게시판 <small>목록 페이지</small></h1>
        <ol class="breadcrumb">
          <li><a href="#"><i class="fa fa-dashboard"></i>Level</a></li>
          <li class="active">Here</li>
        </ol>
        </section>
        <div class="col-lg-12 col-sm-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">게시글 목록</h3>
            </div>
            <div class="box-body">
              <table class="table table-hover">
                <tr>
                  <th width="10%">번호</th>
                  <th width="30%">제목</th>
                  <th width="10%">성공 / 실패</th>
                </tr>
                <c:forEach var="item" items="${List}">
                  <tr>
                    <td>${item.codeno}</td>
                    <td><a href="/mvc2/quizSelect?codeno=${item.codeno}">${item.title}</a></td>
                    <td>${item.success} / ${item.fail}</td>
                  </tr>
                </c:forEach>
              </table>
            </div>
            <div class="box-footer">
              <div class="text-center">
                <ul class="pagination">
                  <c:if test="${Page.pageNo ne '1'}">
                    <li><a href="/mvc2/quizList?pageNo=${Page.prevPageNo}">이전</a></li>
                  </c:if>
                  <c:forEach var="i" begin="${(Page.startPageNo*5)+1}" end="${Page.endPageNo}">
                    <li><a href="/mvc2/quizist?pageNo=${i}">${i}</a></li>
                  </c:forEach>
                  <c:if test="${Page.pageNo ne Page.finalPageNo}">
                    <li><a href="/mvc2/quizList?pageNo=${Page.nextPageNo}">다음</a></li>
                  </c:if>
                </ul>
              </div>
            </div>
            <div class="box-footer">
              <div class="pull-right">
                <c:if test="${sessionScope.sessionId != null}">
                  <button type="button" class="btn btn-success btn-flat" onclick="location='quizMaker.jsp'">
                    <i class="fa fa-pencil"></i>퀴즈만들기
                  </button>
                </c:if>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="include/plugin.jsp"%>
</body>
</html>
