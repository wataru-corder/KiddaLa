<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客検索</title>
</head>
<body>
	<h1>顧客検索画面</h1>
	<form action="KiddaLaController" method="POST">
		<input type="hidden" name="command" value="CustomerSearch">
		電話番号：<input type="text" name="tel"> 氏名カナ<input type="text"
			name="kana"> <input type="submit" value="検索">
	</form>

	<%-- メッセージ表示（E011/W012/E013） --%>
	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>

	<%-- 検索結果一覧 --%>
	<c:if test="${not empty result}">
		<table border="1">
			<tr>
				<th>顧客ID</th>
				<th>氏名</th>
				<th>カナ</th>
				<th>住所</th>
			</tr>
			<c:forEach var="row" items="${result }">
				<tr>
					<c:forEach var="col" items="${row}">
						<td>${col}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>