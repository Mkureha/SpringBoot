<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIBRARY LOGIN</title>
</head>
<body>
	<h1>図書管理ログイン</h1>

	<div class="container">
		<form action="/loginProc" method="post">
			<div class="form-group">
				<label for="user_name">USER ID</label> <input type="text"
					class="form-control" id="user_name" name="user_name"
					placeholder="IDを入力してください">
			</div>
			<div class="form-group">
				<label for="password">PASSWORD</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="PASSWORDを入力してください">
			</div>

			<button class="btn btn-primary" onclick="location.href='/list'">ログイン</button>
		</form>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>