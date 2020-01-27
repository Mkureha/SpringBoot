<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIST</title>
</head>
<body>

	<h2>BOOK LIST</h2>

	<button class="btn btn-primary" onclick="location.href='/insert'">ADD
		BOOK</button>
	<input type="button" value="logout" onclick="location.href='/login'">
	<br>

	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>NUMBER1</th>
				<th>NUMBER2</th>
				<th>NAME</th>
				<th>COLOR1</th>
				<th>COLOR2</th>
			</tr>
			<c:forEach var="tosyo" items="${list}">
				<tr>
					<td>${tosyo.ts_numbers }</td>
					<td>${tosyo.tosyo_num }</td>
					<td>${tosyo.tosyo_name }</td>
					<td>${tosyo.tosyo_daibunrui }</td>
					<td>${tosyo.tosyo_cyubunrui }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>