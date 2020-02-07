<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detail</title>
</head>
<body>
	<div class="container centered text-center">
		<h2>図書詳細ページ</h2>
	</div>
	<div class="box-footer">
		<form role="form" method="post">
			<input type="hidden" id="pagenum" name="pagenum"
				value="${page.pagenum}" /> <input type="hidden" id="contentnum"
				name="contentnum" value="${page.contentnum}" /> <input
				type="hidden" id="searchtype" name="searchtype"
				value="${page.searchtype}" /> <input type="hidden" id="keyword"
				name="keyword" value="${page.keyword}" />
		</form>
		<div class="inputArea">
			<input type="button" value="リスト" class="btn btn-primary"
				OnClick="/GS/list?pagenum=1&contentnum=10&searchtyp=tosyo_num&keyword=">
			<button class="btn btn-warning"
				onclick="location.href='/GS/update/${detail.tosyo_number}'">修正</button>
			<button class="btn btn-danger"
				onclick="location.href='/GS/delete/${detail.tosyo_number}'">削除</button>
		</div>
	</div>
	<div class="container">
		<form action="GS/detail/${detail.tosyo_number }" method="get">
			<div class="inputArea">
				<label for="tosyo_num">図書番号</label>
				<p>${detail.tosyo_num }</p>
			</div>
			<div class="inputArea">
				<label for="tosyo_name">図書名</label>
				<p>${detail.tosyo_name }</p>
			</div>
			<div class="inputArea">
				<label for="tosyo_daibunrui">大分類</label>
				<p>${detail.tosyo_daibunrui }</p>
			</div>
			<div class="inputArea">
				<label for="tosyo_cyubunrui">中分類</label>
				<p>${detail.tosyo_cyubunrui }</p>
			</div>
			<div class="inputArea">
				<label for="tosyo_count">在庫有無</label>
				<p>${detail.tosyo_count }</p>
			</div>
			<div class="inputArea">
				<label for="tosyo_image">本イメージ</label>
				<p>
					<img src="${detail.tosyo_image }" width="180px" height="auto;" />
				</p>
			</div>
		</form>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>