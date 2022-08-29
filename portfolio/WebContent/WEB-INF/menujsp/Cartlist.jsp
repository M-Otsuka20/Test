<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.entity.Cosme"%>
<%@page import="model.entity.Cart"%>
<%
	List<Cosme> list_cart = (List<Cosme>) session.getAttribute("list_cart");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
</head>
<body>

	<%
		for (Cosme cosme : list_cart) {
	%><a> <%=cosme.getName()%> <%=cosme.getPrice()%>
	</a>
	<br>
	<%
		}
	%>

	<form>
		<input type="button" value="戻る" onClick="history.back()">
	</form>
	<form>
		<input type="button" value="購入する" onClick="">
	</form>

</body>
</html>