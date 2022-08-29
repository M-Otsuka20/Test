<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.*"%>
<%@page import="model.entity.Cosme"%>
<%
	List<Cosme> cosmelist = (List<Cosme>) session.getAttribute("cosmelist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>romand</title>
</head>
<body>
	<h1>Romand</h1>

	<%--
	変数i、jを用意
	それぞれにcodeとアンカータグをあてはめ、+1しながらfor文でDB(cosmedata)を一覧表示する
	 --%>

	<%
		int i = 1;
		int j = 1;
		for (Cosme cosme : cosmelist) {
	%>
	<form action="Item_RomandServlet?code=<%=i%>" method="post"
		name="formR<%=j%>">
		<a href="javascript:formR<%=j%>.submit()"><%=cosme.getName()%> </a>
	</form>
	<br>
	<%
		i++;
			j++;
		}
	%>
	<form>
		<input type="button" value="戻る" onClick="history.back()">
	</form>
</body>
</html>
