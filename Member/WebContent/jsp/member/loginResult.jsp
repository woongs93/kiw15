<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/jsp/menu/menu.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	$().Ajax
</script>
</head>
<body>
<div align="center">

${auth}
	<c:if test= "${auth ne null }">
		<h1>${vo.memberName }님 환영합니다.</h1>
	</c:if>
	<c:if test= "${auth eq null }">
		<h1>${vo.memberId }가 존재하지 않거나 패스워드가 일치하지 않습니다.</h1>
	</c:if>		
</div>

</body>
</html>