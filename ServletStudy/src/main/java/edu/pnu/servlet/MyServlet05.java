package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet05")
public class MyServlet05 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet05 - service" + req.getMethod());
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(
				"<table border='1'>"
				+ "<tr align='center'>"
				+ "<td>번호</td>"
				+ "<td>나라</td>"
				+ "<td>수도</td>"
				+ "<td>인구</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>1</td>"
				+ "<td>대한민국</td>"
				+ "<td>서울</td>"
				+ "<td>1000만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>2</td>"
				+ "<td>미국</td>"
				+ "<td>워싱턴</td>"
				+ "<td>70만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>3</td>"
				+ "<td>일본</td>"
				+ "<td>도쿄</td>"
				+ "<td>1400만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>4</td>"
				+ "<td>중국</td>"
				+ "<td>베이징</td>"
				+ "<td>2100만</td>"
				+ "</tr>"
				+ "</table>");
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet05 - doGet" + req.getMethod());
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(
				"<table border='1'>"
				+ "<tr align='center'>"
				+ "<td>번호</td>"
				+ "<td>나라</td>"
				+ "<td>수도</td>"
				+ "<td>인구</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>1</td>"
				+ "<td>대한민국</td>"
				+ "<td>서울</td>"
				+ "<td>1000만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>2</td>"
				+ "<td>미국</td>"
				+ "<td>워싱턴</td>"
				+ "<td>70만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>3</td>"
				+ "<td>일본</td>"
				+ "<td>도쿄</td>"
				+ "<td>1400만</td>"
				+ "</tr>"
				+ "<tr align='center'>"
				+ "<td>4</td>"
				+ "<td>중국</td>"
				+ "<td>베이징</td>"
				+ "<td>2100만</td>"
				+ "</tr>"
				+ "</table>");
	}
}
