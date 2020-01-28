<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>図書情報修正</title>
</head>
<body>

	<h2>図書情報修正</h2>

	<div class="container">
		<form action="/updateProc" method="post">
			<div class="form-group">
				<label for="tosyo_num">図書番号</label> <input type="text"
					class="form-control" id="tosyo_num" name="tosyo_num"
					value="${detail.tosyo_num }">
			</div>
			<div class="form-group">
				<label for="tosyo_name">図書名</label> <input type="text"
					class="form-control" id="tosyo_name" name="tosyo_name"
					value="${detail.tosyo_name }">
			</div>
			<div class="form-group">
				<label for="tosyo_daibunrui">大分類</label> <input type="text"
					class="form-control" id="tosyo_daibunrui" name="tosyo_daibunrui"
					value="${detail.tosyo_daibunrui }">
			</div>
			<div class="form-group">
				<label for="tosyo_cyubunrui">中分類</label> <input type="text"
					class="form-control" id="tosyo_cyubunrui" name="tosyo_cyubunrui"
					value="${detail.tosyo_cyubunrui }">
			</div>
			<input type="hidden" name="tosyo_num" value="${tosyo_num }"/>
			<button type="submit" class="btn btn-primary">修正</button>
		</form>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>