<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="context-path" th:content="@{/list}" />
<title>LIBRARY LOGIN</title>

</head>
<body>
	<form class="form-signin" method="POST" th:action="@{/login}">
		<h1 class="h3 mb-3 font-weight-normal">${login_message}</h1>
		<div class="container">
			<label for="user_name" class="sr-only">ID</label> <input type="text"
				id="user_name" name="user_name" class="form-control"
				placeholder="IDを入力してください" required="" autofocus=""> <label
				for="password" class="sr-only">Password</label> <input
				type="password" id="password" name="password" class="form-control"
				placeholder="Passwordを入力してください" required="">
		</div>
		<button class="btn btn-primary btn-block" type="submit">ログイン</button>
		<%@ include file="bootstrap.jsp"%>
	</form>
</body>
</html>