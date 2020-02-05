<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>図書情報入力 - 簡単</title>
</head>
<body>
	<div class="container centered text-center">
		<h2>書籍 登録</h2>
	</div>

	<form role="form" action="/insertProc" method="post"
		enctype="multipart/form-data" autocomplete="off">
		<div class="inputArea" style="margin: 10px;">
			<div class="form-group">
				<label for="tosyo_num" style="width: 70px; padding: 5px;">図書番号</label>
				<input type="text" class="form-control" id="tosyo_num"
					name="tosyo_num" placeholder="図書番号を入力してください" style="width: 250px;">
			</div>
			<div class="form-group">
				<label for="tosyo_name" style="width: 70px; padding: 5px;">図書名</label>
				<input type="text" class="form-control" id="tosyo_name"
					name="tosyo_name" placeholder="図書名を入力してください" style="width: 250px;">
			</div>
			<div class="form-group">
				<label for="tosyo_name" style="width: 70px; padding: 5px;">大分類</label>
				<input type="text" class="form-control" id="tosyo_daibunrui"
					name="tosyo_daibunrui" placeholder="大分類を入力してください"
					style="width: 250px;">
			</div>
			<div class="form-group">
				<label for="tosyo_name" style="width: 70px; padding: 5px;">中分類</label>
				<input type="text" class="form-control" id="tosyo_cyubunrui"
					name="tosyo_cyubunrui" placeholder="中分類を入力してください"
					style="width: 250px;">
			</div>
			<div class="inputArea">
				<label for="tosyo_name" style="width: 70px; padding: 5px;">本数</label>
				<input type="text" class="form-control" id="tosyo_count"
					name="tosyo_count" placeholder="本数を入力してください" style="width: 150px;">
			</div>
			<button type="submit" class="btn btn-primary">登録</button>
			<input type="reset" class="btn btn-primary" value="reset" />
		</div>
	</form>

	<style>
</style>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>