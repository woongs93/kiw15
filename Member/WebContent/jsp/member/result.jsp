<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div align="center">

${auth}
	<c:if test= "${auth ne null }">
		<h1>로그인 성공</h1>
	</c:if>
	<c:if test= "${auth eq null }">
		<h1>로그인 실패</h1>
	</c:if>		
</div>



</body>
</html>