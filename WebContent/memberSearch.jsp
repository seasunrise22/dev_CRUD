<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>

<h3>회원정보 검색</h3>

${error}

<form action="memberSearch.do" method="post">
	ID : <input type="text" name="id" />
	<input type="hidden" name="job" value="search" /> <!-- job = search면 검색 작업을 의미한다고 약속 -->
	<input type="submit" value="검색" />
</form>

</body>
</html>