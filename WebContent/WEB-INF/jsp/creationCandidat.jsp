<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>QCM</title>
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-12">
			<form action="nouveau-candidat" method="post">
				<div class="form-group">
					<label for="nom">Nom : </label> <input type="text" name="nom"
						class="form-control">
				</div>
				<div class="form-group">
					<label for="prenom">Prénom : </label> <input type="text"
						name="prenom" class="form-control">
				</div>
				<div class="form-group">
					<label for="email">Email : </label> <input type="email"
						name="email" class="form-control">
				</div>
				<div class="form-group">
					<label for="password">Mot de passe : </label> <input
						type="password" name="password" class="form-control">
				</div>
				<div class="form-group">
					<label for="role">Rôle : </label> 
					<select name="role">
						<option>Test</option>
					</select>				
					<label for="promo">Promotion : </label> <select name="promo">
						<option>Test</option>
					</select>
				</div>
				<input type="submit" class="btn btn-info" value="Créer">
			</form>
		</div>
	</div>
</body>
</html>