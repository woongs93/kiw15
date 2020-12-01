<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div align="center">
	<div><h1>로 그 인</h1></div>
	<div>
		<form id="frm" name="frm" action="/Member/Login.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="200">
						<input type="text" id="mid" name="mid" size="20">
					</td>
				</tr>
				<tr>
					<th width="100">패스워드</th>
					<td width="200">
						<input type="text" id="password" name="password" size="20">
						
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>
	
</div>
</body>
</html>