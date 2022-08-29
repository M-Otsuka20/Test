<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.*"%>
<%@ page import="model.entity.User"%>
<%
	//セッションスコープに保存されたユーザ情報を取得
	User user = (User) session.getAttribute("useraccount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン完了</title>
</head>
<body>

	<p>ログインに成功しました！</p>
	<p>
		ようこそ<%=user.getName()%>さん！
	</p>

	<p>ショッピングをお楽しみください</p>


	<form method="post" name="form1" action="MenuServlet?key=1">
		<input type="hidden" name="brand" value="ブランド"> <a
			href="javascript:form1.submit()">ブランドから探す</a>
	</form>
	<form method="post" name="form2" action="MenuServlet?key=2">
		<input type="hidden" name="category" value="カテゴリ"> <a
			href="javascript:form2.submit()">カテゴリから探す</a>
	</form>
</body>
</html>