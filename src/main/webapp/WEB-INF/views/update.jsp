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
	<div class="container centered text-center">
		<h2>図書情報修正</h2>
	</div>

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
			<div class="form-group">
				<label for="tosyo_count">本数</label> <input type="text"
					class="form-control" id="tosyo_count" name="tosyo_count"
					value="${detail.tosyo_count }">
			</div>
			<div class="inputArea">
				<label for="tosyo_image" style="width: 70px; padding: 5px;"
					value="${detail.tosyo_image}"></label> <input type="file"
					id="tosyo_image" name="file" style="width: 250px;" />
				<div class="select_img" style="margin: 20px 0;">
					<img src="" />
				</div>

				<script type="text/javascript">
					$("#tosyo_image").change(
							function() {
								if (this.files && this.files[0]) {
									var reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img img").attr("src",
												data.target.result).width(500);
									}
									reader.readAsDataURL(this.files[0]);
								}
							});
				</script>
				<%=request.getRealPath("/")%>
				<input type="hidden" name="tosyo_number" value="${tosyo_number }" />
				<button type="submit" class="btn btn-primary">修正</button>
				<input type="button" value="戻る" class="btn btn-primary"
					OnClick="javascript:history.back(-1)">
		</form>
	</div>
	<%@ include file="bootstrap.jsp"%>
</body>
</html>