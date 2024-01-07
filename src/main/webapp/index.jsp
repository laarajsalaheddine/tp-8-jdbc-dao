<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home | Gestion de produits</title>
<%@ include file="/WEB-INF/web-libraries.jsp"%>
<style type="text/css">
.img-container {
	max-height: 90vh;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="container">
		<h1 class="text-center my-5">
			Welcome to <i>Gestion des produits</i>
		</h1>
	</div>
	<div class="container img-container my-5 text-center">
		<img alt="img" src="<c:url value='/images/stock.svg' />">
	</div>
</body>
</html>