<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" name="frm" action="/Member/Register.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="200">
						<input type="text" id="mid" name="mid" size="20">
					</td>
				</tr>
				<tr>
					<th width="100">이름</th>
					<td width="200">
						<input type="text" id="mname" name="mname" size="20">
						
					</td>
				</tr>
				<tr>
					<th width="100">패스워드</th>
					<td width="200">
						<input type="text" id="password" name="password" size="20">
					</td>
				</tr>
				<tr>
					<th width="100">패스워드확인</th>
					<td width="200">
						<input type="text" id="checkpw" name="checkpw" size="20">
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" onclick="check()" value="회원가입">
			</div>
		</form>
	</div>
</div>	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function check(){
		if($("#mid").val()==""||$("#mname").val()==""||$("#password").val()==""||$("#checkpw").val()==""){
		alert("모든 사항을 입력해주세요.");
		return false;
	}
		return true;
	}
</script>
</body>
</html>