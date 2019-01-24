<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardone.BoardDao" %>
<%@ page import="java.sql.Timestamp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="article" scope="page" class="boardone.BoardVo">
	<jsp:setProperty name="article" property="*"/>
</jsp:useBean>  
<%
	String pageNum = request.getParameter("pageNum");
	BoardDao dbPro = BoardDao.getInstance();
	int check = dbPro.updateArticle(article);
	if(check==1) {
%>
	<meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum %>">
<%	} else { %>
	<script language="JavaScript">
	<!--
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	-->
	</script>
<%	} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>