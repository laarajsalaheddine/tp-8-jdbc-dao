<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new | Gestion de produits</title>
<%@ include file="/WEB-INF/web-libraries.jsp"%>

<style type="text/css">
#idProduit {
	cursor: not-allowed;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="container my-2">
		<div class="card">
			<div class="card-header">Modification des Produits</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div class="form-group my-2">
						<label class="control-label">ID Produit : </label> <input
							type="text" name="id" class="form-control" id="idProduit"
							value="${produit.idProduit}" />
					</div>
					<div class="form-group my-2">
						<label class="control-label">Nom Produit : </label> <input
							type="text" name="nom" class="form-control"
							value="${produit.nomProduit}" />
					</div>
					<div class="form-group my-2">
						<label class="control-label">Prix :</label> <input type="text"
							name="prix" class="form-control" value="${produit.prix}" />
					</div>
					<div class="form-group my-2">
						<label class="control-label">Quantite :</label> <input type="text"
							name="quantite" class="form-control" value="${produit.quantite}" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
