<%@page import="java.util.List"%>
<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO(application);
	// Board 데이터를 읽어서 aList에 저장한다.
	List<BoardDTO> aList = dao.selectList(null);
	// System.out.println(aList.get(0));
	pageContext.setAttribute("list", aList);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%	for (int i = 0; i < aList.size(); i++) { 
		pageContext.setAttribute("i", i);
%>
		<tr>
			<td> ${ list[i].num }</td>
			<td> ${ list[i].title }</td>
			<td> ${ list[i].content }</td>
			<td> ${ list[i].id }</td>
			<td> ${ list[i].postdate }</td>
			<td> ${ list[i].visitcount }</td>
			<td> ${ list[i].name }</td>	
		</tr>	
	<%	} %>
</table>
</body>
</html>