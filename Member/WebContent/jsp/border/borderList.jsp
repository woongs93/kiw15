<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
  .fakeimg {
    height: 200px;
    background: #aaa;
  }
  </style>
</head>
<body>
	<div align = "center">
		<div><h1>게 시 판</h1></div>
		<div>
			<table border ="1">
					<tr>
						<th width="100">번호</th>
						<th width="250">제목</th>
						<th width="100">작성자</th>
						<th width="100">작성일</th>
						<th width="100">조회수</th>
					</tr>
				<c:forEach var= "vo" items= "${list }">
					<tr onclick ="location.href='/Member/BorderRead.do?id=${vo.borderId }'" >
						<td width="100" align="center">${vo.borderId }</td>
						<td width="100">${vo.borderTitle }</td>
						<td width="100" align="center">${vo.borderWriter }</td>
						<td width="100" align="center">${vo.borderDate }</td>
						<td width="100" align="center">${vo.borderHit }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						<button type="button" onclick ="location.href= 'jsp/border/borderInput.jsp'">글 쓰 기</button> 
					</td>	
				</tr>
			</table>
		</div>
	</div>
</body>
</html>