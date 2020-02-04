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
	<h2>図書詳細ページ</h2>
	<div class="box-footer">
		<form role="form" method="post">
			<input type="hidden" id="pagenum" name="pagenum"
				value="${page.pagenum}" /> <input type="hidden" id="contentnum"
				name="contentnum" value="${page.contentnum}" /> <input
				type="hidden" id="searchtype" name="searchtype"
				value="${page.searchtype}" /> <input type="hidden" id="keyword"
				name="keyword" value="${page.keyword}" />
		</form>
		<input type="button" value="Back" class="btn btn-primary"
			OnClick="javascript:history.back(-1)">
		<button class="btn btn-warning"
			onclick="location.href='/GS/update/${detail.tosyo_number }'">修正</button>
		<button class="btn btn-danger"
			onclick="location.href='/GS/delete/${detail.tosyo_number }'">削除</button>
	</div>
	<div class="container">
		<form action="/insertProc" method="post">
			<div class="form-group">
				<label>図書番号</label>
				<p>${detail.tosyo_num }</p>
			</div>
			<div class="form-group">
				<label>図書名</label>
				<p>${detail.tosyo_name }</p>
			</div>
			<div class="form-group">
				<label>大分類</label>
				<p>${detail.tosyo_daibunrui }</p>
			</div>
			<div class="form-group">
				<label>中分類</label>
				<p>${detail.tosyo_cyubunrui }</p>
			</div>
			<div class="form-group">
				<label>在庫有無</label>
				<p>${detail.tosyo_count }</p>
			</div>
		</form>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>