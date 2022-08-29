<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー新規作成</title>
</head>
<body>
	<h1>ユーザー新規作成</h1>

	<form action="UserCreateServlet" method="post">
		<p>
			氏名:<input type="text" name="name">※スペースを開けずに
		</p>
		<p>
			ユーザーID:<input type="text" name="id">※10文字以内
		</p>
		<p>
			パスワード:<input type="password" name="password">※8文字以内
		</p>
		<p>
			メールアドレス:<input type="text" name="mail">
		</p>
		<p>
			<input type="submit" value="新規作成" class="button">
		</p>
	</form>

</body>
</html>