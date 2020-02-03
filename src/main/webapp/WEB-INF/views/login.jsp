<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="UTF-8" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="context-path"
	th:content="@{GS/list?pagenum=1&contentnum=10}" />
<title>LIBRARY LOGIN</title>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginbtn").click(function() {
			if ($("#username").val() == "") {
				alert("IDを入力してください");
				$("#username").focus();
			} else if ($("#password").val() == "") {
				alert("Passwordを入力してください");
				$("#password").focus();
			} else {
				$("#loginfrm").attr("action", "<c:url value='/loginProc'/>");
				$("#loginfrm").submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="container centered text-center">
		<form id="loginfrm" name="loginfrm" method="POST"
			action="<c:url value='/loginProc'/>">
			<h1 class="h3 mb-3 font-weight-normal">社内図書管理システム</h1>
			<div class="container">
				<label for="username" class="sr-only">ID</label> <input type="text"
					id="username" name="username" value="${username}"
					class="form-control" placeholder="IDを入力してください" /> <label
					for="password" class="sr-only">Password</label> <input
					type="password" id="password" name="password" value="${password}"
					class="form-control" placeholder="Passwordを入力してください" />
			</div>
			<tr>
				<td><input type="button" id="loginbtn" class="btn btn-primary"
					value="login" /></td>
				<td><input type="reset" class="btn btn-primary" value="reset" />
				</td>
			</tr>
			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<font color="red">
					<p>
						ログインに失敗しました <br />
						Error Message : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</p> <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
				</font>
			</c:if>
			<%@ include file="bootstrap.jsp"%>
		</form>
	</div>
</body>
</html>