<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new | Gestion de produits</title>
<%@ include file="/WEB-INF/web-libraries.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/nav.jsp"%>
	<div class="container">
		<div class="card my-2">
			<div class="card-header">Ajout des Produits</div>
			<div class="card-body">
				<form action="save.do" method="post">
					<div class="form-group my-2">
						<label class="control-Label">Nom Produit :</label> <input
							type="text" name="nom" class="form-control" required />
					</div>
					<div class="form-group my-2">
						<label class="control-label">Prix:</label> <input type="text"
							name="prix" class="form-control" required />
					</div>
					<div class="form-group my-2">
						<label class="control-label">Quantite: </label> <input type="text"
							name="quantite" class="form-control" required />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
s
