<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="UTF-8" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="context-path" th:content="@{GS/list}" />
<title>LIBRARY LOGIN</title>
</head>
<body>
	<div class="container centered text-center">
		<form class="form-signin" method="POST" action="GS/list?pagenum=1&contentnum=10"
			th:action="@{/login}">
			<h1 class="h3 mb-3 font-weight-normal">社内図書管理システム</h1>
			<div class="container">
				<label for="username" class="sr-only">ID</label> <input type="text"
					id="username" name="username" class="form-control"
					placeholder="IDを入力してください"> <label for="password"
					class="sr-only">Password</label> <input type="password"
					id="password" name="password" class="form-control"
					placeholder="Passwordを入力してください">
			</div>
			<div class="btn_area">
			<button type="submit" class="btn btn-primary">ログイン</button>
			<button type="reset"  class="btn btn-primary">Reset</button>
			</div>
			<%@ include file="bootstrap.jsp"%>
		</form>
	</div>
</body>
</html>