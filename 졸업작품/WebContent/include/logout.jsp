<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <div class="intro-text">
   <form action="logout" method="get" onsubmit="current_url.value=window.location.href">
    <div class="sidebar">
      <ul class="nav sidebar-menu">
      <li><a href="/mvc2/codeIndivList?pageNo=1&regid=${sessionScope.sessionId}"><i class="fa fa-circle-o"> 내가 작성한 코드 보기</i></a></li>
      <li><a href="/mvc2/quizResult?pageNo=1&regid=${sessionScope.sessionId}"><i class="fa fa-circle-o"> 내가 풀어본 문제 보기</i></a></li>
      <li><button type="submit" class="btn btn-warning">로그아웃</button></li>
      </ul>
    </div>
    <input type="hidden" name="current_url"/>
    </form>
  </div> 
</body>
</html>