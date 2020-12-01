<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/jsp/menu/menu.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
<script type="text/javascript">
	function formSumit(str){
		var f=document.frm;
		if(str=="edit"){
			f.action="/Member/BorderSearch.do";
		} else {
			f.action="/Member/BorderDelete.do";
		}
		f.submit();
	}
</script>

</head>
<body>
   <div align="center">
      <div><h1>글 상세 보기</h1></div>
      <div>
         <table border="1">
            <tr>
               <th width="100">작성자</th>
               <td width="100" align="center">${vo.borderWriter}</td>
               <th width="100">작성일자</th>
               <td width="100" align="center">${vo.borderDate}</td>
               <th width="100">조회수</th>
               <td width="100" align="center">${vo.borderHit}</td>
            </tr>
            <tr>
               <th width="100">제목</th>
               <td colspan="5">${vo.borderTitle }</td>
            </tr>
            <tr>
               <th width="100">내용</th>
               <td colspan="5">
                  <textarea rows="7" cols="40" style="margin: 0px; width: 520px; height: 200px;"> ${vo.borderContent } </textarea>
               </td>
            </tr>
         </table>
      </div>
      <br />
      <form action="/Member/BorderSearch.do" method="post" id="frm" name="frm">
         <input type="hidden" id = "id" name="id" value="${vo.borderId }">
      	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <button type="button" onclick="formSumit('edit');">글수정</button>
         <button type="button" onclick="formSumit(2);">글삭제</button>
         <button type="button" onclick="location.href='/Member/BorderList.do'">목록보기</button>
      </form>
   </div>
</body>
</html>