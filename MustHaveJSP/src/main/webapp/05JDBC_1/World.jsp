<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBCMission"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	JDBCMission jdbc = new JDBCMission();
	String sql = "select continent, name "
			+ "from country, countrylanguage "
			+ "where country.code = countrylanguage.CountryCode and Language = 'English' and IsOfficial = 'T'";
	

	Statement stmt = jdbc.con.createStatement();

	ResultSet rs = stmt.executeQuery(sql);
	%>
	<table border=1>
		<tr align='center'>
			<td>continent</td>
			<td>name</td>
		</tr>
		<%
		while (rs.next()) {
			String name =  rs.getString("name");
			String continent = rs.getString("continent");
		%>
		<tr align='center'>
			<td><%=continent%></td>
			<td><%=name%></td>
			
		</tr>
		<%
		}
		jdbc.close();
		%>
	</table>
</body>
</html>