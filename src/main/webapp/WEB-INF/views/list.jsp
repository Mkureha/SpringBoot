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

	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>NUM</th>
				<th>NAME</th>
				<th>COLOR1</th>
				<th>COLOR2</th>
			</tr>
			<c:forEach var="1" items="${tosyo_master}">
				<tr>
					<td>${1.ts_numbers}</td>
					<td>${1.tosyo_num}</td>
					<td>${1.tosyo_name}</td>
					<td>${1.tosyo_daibunrui}</td>
					<td>${1.tosyo_cyubunrui}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>