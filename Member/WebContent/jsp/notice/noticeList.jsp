<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"?>
	<div><h1>공지사항 목록</h1></div>
	<div>
		<table border="1">
			<tr>
				<th width="100">순번</th>
				<th width="300">제목</th>
				<th width="100">작성일자</th>
				<th width="100">작성자</th>
				<th width="100">조회수</th>
				<th width="100">첨부파일</th>
			<tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.noticeId }</td>
					<td>${vo.noticeTitle }</td>
					<td>${vo.noticeDate }</td>
					<td>${vo.noticeWriter }</td>
					<td>${vo.noticeHit }</td>
					<c:if test="${vo.noticeAttach ne null }">
						<td>Y</td>
					</c:if>
					<c:if test="${co.noticeAttach eq null }">
						<td>N</td>
					</c:if>
				</tr>
			</c:forEach>	
		</table>
		<br/>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<input type="hidden" id="no" name="no">
				<c:if test="${auth eq 'admin' }">
					<button type ="button" onclick="Location.href='jsp/notice/noticeForm.jsp'">글쓰기</button>
				</c:if>
			</form>
			
		</div>
		
	</div>
</div>

</body>
</html>