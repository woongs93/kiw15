<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<div align="center">
		<h1>글 쓰 기 </h1>
		<form id="frm" name="frm" action="/Member/BorderInput.do" method="post">
			<table border="1">
				<tr>
					<th width="100">작성자</th>
					<td width="300"><input type="text" id="writer" name="writer"></td>
				</tr>
				<tr>
					<th width="100">작성일</th>
					<td width="300"><input type="date" id="date" name="date"></td>
				</tr>
				<tr>
					<th width="100">제목</th>
					<td width="300"><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th width="100">내용</th>
					<td width="300"><textarea id="content" name="content" rows="8"></textarea></td>
				</tr>
			</table>	
			<br/>
			<input type="hidden" id="id" name="id" value="${vo.borderId }">
			<button type="button" onclick="location.href='/Board/BorderList.do'">목록</button>
			<button type="reset">취소</button> &nbsp;&nbsp;&nbsp;
			<button type="submit">등록</button>&nbsp;&nbsp;&nbsp;
		</form>
	
	</div>
</body>
</html>