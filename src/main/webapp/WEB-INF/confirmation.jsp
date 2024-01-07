<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation | Gestion de produits</title>
<%@ include file="/WEB-INF/web-libraries.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="container my-2">
		<div class="card">
			<div class="card-header">Confirmation Ajout Produit</div>
			<div class="card-body">
				<div class="form-group my-2">
					<label class="text-uppercase">ID:</label>
					<div class="bg-secondary text-white d-inline-block py-1 px-4 rounded">${produit.idProduit}</div>
				</div>
				<div class="form-group my-2">
					<label class="text-uppercase">Nom / Référence:</label>
					<div class="bg-secondary text-white d-inline-block py-1 px-4 rounded">${produit.nomProduit}</div>
				</div>
				<div class="form-group my-2">
					<label class="text-uppercase">Prix :</label>
					<div class="bg-secondary text-white d-inline-block py-1 px-4 rounded">${produit.prix}</div>
				</div>
				<div class="form-group my-2">
					<label class="text-uppercase">quantite :</label>
					<div class="bg-secondary text-white d-inline-block py-1 px-4 rounded">${produit.quantite}</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
