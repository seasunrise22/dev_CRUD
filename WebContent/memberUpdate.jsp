<%@ page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<h3>수정 정보 검색</h3>
	
	${error}
	
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id" /> 
		<input type="hidden" name="job" value="update" /> 
		<input type="submit" value="검색" />
	</form>
	
	<% MemberVO member = (MemberVO)request.getAttribute("member"); // MemberSearchController에서 검색되어 받아둔 member
		if(member != null)  { %> <!-- member 객체에 뭔가가 담겨져 있다면 = 무언가가 검색되었다면 -->
		
	<h3>회원정보 수정</h3>
	<form action="memberUpdate.do" method="post">
		<!-- 다시한번 프론트 컨트롤러 거쳐서 작업 진행 -->
		ID : <input type="text" name="id" readonly value="${member.id}"> <br> 
		비밀번호 : <input type="password" name="passwd" value="${member.passwd}"> <br> 
		이름 : <input type="text" name="name" value="${member.name}"> <br> 
		E-Mail : <input type="text" name="mail" value="${member.mail}"> <br> 		
		<input type="submit" value="수정">
	</form>
	<%} else { %>
	${result} <p>
	<%} %>
</body>
</html>