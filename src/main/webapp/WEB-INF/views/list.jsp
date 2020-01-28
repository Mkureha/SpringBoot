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
	<p>
		<select name="searchType" id="select_searchType">
			<option value="tosyo_num" selected="selected">図書番号</option>
			<option value="tosyo_name">図書名</option>
			<option value="tosyo_daibunrui">大分類</option>
			<option value="tosyo_cyubunrui">中分類</option>
		</select> <input type="text" name="searchWord" id="searchWord"> <a
			href="javascript:fn-searchlist()" class="btn">検索</a>
	</p>

	<button class="btn btn-primary" onclick="location.href='/insert'">ADD
		BOOK</button>
	<input type="button" value="logout" class="btn btn-primary"
		onclick="location.href='/login'">
	<br>

	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>図書番号</th>
				<th>図書名</th>
				<th>大分類</th>
				<th>中分類</th>
			</tr>
			<c:forEach var="tosyo" items="${list}">
				<tr onclick="location.href='/detail/${tosyo.tosyo_number }'">
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