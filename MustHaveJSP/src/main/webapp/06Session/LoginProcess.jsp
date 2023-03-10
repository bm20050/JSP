<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("user_id");
	String userPwd = request.getParameter("user_pw");
	
	String mysqlDriver = application.getInitParameter("MySqlDriver");
	String mysqlURL = application.getInitParameter("MySqlURL");
	String mysqlId = application.getInitParameter("MySqlId");
	String mysqlPwd = application.getInitParameter("MySqlPwd");
	
	MemberDAO dao = new MemberDAO(mysqlDriver, mysqlURL, mysqlId, mysqlPwd);
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
	dao.close();
	System.out.println(memberDTO);
	if (memberDTO.getId() != null) {
		session.setAttribute("UserId", memberDTO.getId());
		session.setAttribute("UserName", memberDTO.getName());
		response.sendRedirect("LoginForm.jsp");
	}
	else {
		request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
	/* 	
	if (userId.equals("musthave") && userPwd.equals("1234")) {
		session.setAttribute("UserId", "musthave");
		session.setAttribute("UserName", "홍길동");
		response.sendRedirect("LoginForm.jsp");
	}
	else {
		request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	} */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
</body>
</html>