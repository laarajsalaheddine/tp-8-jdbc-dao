<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Gestion Produits</title>
<%@ include file="/WEB-INF/web-libraries.jsp"%>
<style type="text/css">
.form-control {
	width: 30% !important;
	display: inline-block;
}

#liste-card {
    max-height: 85vh;
    overflow: hidden;
    overflow-y: scroll;
}

</style>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="container">
		<div class="card my-2" id="liste-card">
			<div class="card-header">Recherche des Produits</div>
			<div class="card-body">
				<form action="chercher.do" method="get">
					<input type="text" name="motCle" placeholder="Mot clé"
						autocomplete="off" class="form-control" value="${model.motCle}" />
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<div class="my-2">
					<table class="table table-striped">
						<tr>
							<th>ID</th>
							<th>Nom Produit</th>
							<th>Prix</th>
							<th>Quantite</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach items="${model.produits}" var="p">
							<tr>
								<td>${p.idProduit}</td>
								<td>${p.nomProduit}</td>
								<td>${p.prix}</td>
								<td>${p.quantite}</td>
								<td class="text-center"><a
									onclick="return confirm('Etes-vous sûr ?')"
									href="supprimer.do?id=${p.idProduit}" class="btn btn-danger"
									title="Supprimer Produit"> Supprimer <i
										class="fa-solid fa-trash"></i>
								</a></td>
								<td class="text-center"><a
									href="editer.do?id=${p.idProduit}" class="btn btn-primary"
									title="Editer Information Produit"> Editer <i
										class="fa-solid fa-pen"></i>
								</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>