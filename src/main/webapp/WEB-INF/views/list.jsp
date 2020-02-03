<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIST</title>
<script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
<!-- Paging -->
<script type="text/javascript">
	function page(idx) {
		//Paging Add
		var pagenum = idx;
		var contentnum = 10;
		location.href = "${pageContext.request.contextPath}/GS/list?pagenum="
				+ pagenum + "&contentnum=" + contentnum + "&searchtype=" + $('#searchtype').val() + "&keyword=" + $('#keyword').val();
	};

<!-- Search -->
	$(document).on('click', '#btnSearch', function(e){
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/GS/list?pagenum=1&contentnum=10";
		url = url + "&searchtype=" + $('#searchtype').val();
		url = url + "&keyword=" + $('#keyword').val();
		location.href = url;
		console.log(url);
	});	
</script>

</head>
<body>
	<h2>BOOK LIST</h2>
	<p>
		<select class="form-control form-control-sm" name="searchtype"
			id="searchtype">
			<option value="tosyo_num" selected="selected">図書番号</option>
			<option value="tosyo_name">図書名</option>
			<option value="tosyo_daibunrui">大分類</option>
			<option value="tosyo_cyubunrui">中分類</option>
		</select>
	</p>
	<form action="search" method="get">
		<div>
			<input type="text" class="form-control form-control-sm"
				name="keyword" id="keyword" placeholder="Keywordを入力してください">
		</div>
		<button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">検索</button>
	</form>


	<button class="btn btn-primary" onclick="location.href='/insert'">ADD
		BOOK</button>
	<input type="button" value="logout" class="btn btn-primary"
		onclick="location.href='/login'">
	<br>

	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>図書番号</th>
					<th>図書名</th>
					<th>大分類</th>
					<th>中分類</th>
					<th>在庫有無</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tosyo" items="${list}">
					<tr onclick="location.href='/GS/detail/${tosyo.tosyo_number}'">
						<td>${tosyo.tosyo_num}</td>
						<td>${tosyo.tosyo_name}</td>
						<td>${tosyo.tosyo_daibunrui}</td>
						<td>${tosyo.tosyo_cyubunrui}</td>
						<td>${tosyo.tosyo_count}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><c:if test="${page.prev}">
							<a style="text-decoration: none;"
								href="javascript:page(${page.getstartpage()-1});">&laquo;</a>
						</c:if> <c:forEach begin="${page.getstartpage()}"
							end="${page.getendpage()}" var="idx">
							<a style="text-decoration: none;" href="javascript:page(${idx});">${idx}</a>
						</c:forEach> <c:if test="${page.next}">
							<a style="text-decoration: none;"
								href="javascript:page(${page.getendpage()+1});">&raquo;</a>
						</c:if></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>