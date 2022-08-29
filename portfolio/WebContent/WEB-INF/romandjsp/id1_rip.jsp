<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.entity.Cosme"%>
<%
	Cosme cosme = (Cosme) session.getAttribute("pick_cosme");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rip</title>
</head>
<body>

	<%--
		stockが0の場合はout of stockと表示される
 	--%>

	<h1><%=cosme.getName()%></h1>
	<p><%=cosme.getPrice()%></p>

	<%
		if (cosme.getStock() == 0) {
	%>
	<p>out of stock</p>

	<%
		} else {
	%>


	<form action="CartServlet?code=1" method="post" name="formItem1">
		<a href="javascript:formItem1.submit()">カートに入れる</a>
	</form>
	<%
		}
	%>
</body>
</html>