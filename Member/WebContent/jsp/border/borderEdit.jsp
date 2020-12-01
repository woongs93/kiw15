<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판수정</title>
</head>
<body>
<div align = "center">
   <div><h1>글 쓰 기</h1></div>
   <div>
      <form id = "frm" name = "frm" action="/Member/BorderEdit.do" method="post">
      <table border="1">
         <tr>
            <th width="150">작 성 자</th>
            <td width="300">
               ${vo.borderWriter}
            </td>
         </tr>
            <tr>
            <th width="150">작 성 일</th>
            <td width="300">
               <input type = "date" id="date" name ="date" value="${vo.borderDate}">
            </td>
         </tr>
            <tr>
            <th width="150">제목</th>
            <td width="300">
               ${vo.borderTitle}
            </td>
         </tr>
            <tr>
            <th width="150">내용</th>
            <td width="300">
               <textarea id="content" name="content" rows="5" cols="100">${vo.borderContent}</textarea>
            </td>
         </tr>
      </table>
      <br/>
      <input type="hidden" id="id" name="id" value="${vo.borderId }">
      <button type = "button" onclick="location.href='/Member/BorderList.do'"> 목록 </button> &nbsp;&nbsp;&nbsp;
      <button type = "reset"> 취소</button> &nbsp;&nbsp;&nbsp;
      <button type = "submit"> 수 정</button> &nbsp;&nbsp;&nbsp;
      </form>
   </div>
</div>
</body>
</html>