<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

	<form action="UserLoginServlet" method="post">
		ユーザーID:<input type="text" name="id"> <br> パスワード:<input
			type="password" name="password"> <input type="submit"
			value="enter" class="button">
	</form>

</body>
</html>