<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <c:choose>
          <c:when test="${sessionScope.sessionId == null }">
            <%@ include file="login.jsp" %>
          </c:when>
          <c:otherwise>
            <%@ include file="logout.jsp" %>
          </c:otherwise>
        </c:choose>   <!-- search form (Optional) -->
        </div>
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">HEADER</li>
        <!-- Optionally, you can add icons to the links -->
        <li><a href="/mvc2/boardList?pageNo=1"><i class="fa fa-link"></i><span>게시판</span></a></li>
        <li><a href="/mvc2/codeInput.jsp"><i class="fa fa-link"></i> <span>코딩하기</span></a></li>
        <li><a href="/mvc2/codeAllList?pageNo=1"><i class="fa fa-link"></i> <span>최근 생성 코드</span></a></li>
        <li><a href="/mvc2/quizList?pageNo=1"><i class="fa fa-link"></i> <span>문제풀기</span></a></li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
</html>
