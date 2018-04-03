<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>QCM</title>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		
		<form action="creation-test" method="post">
		<fieldset>
		<legend>Créer un test</legend>
			
			<div class="form-group row">
				<label class="col-2 col-form-label" for="libelle">Nom : </label>
				<input type="text" name="libelle" class="form-control col-10" required="required" value="${test.libelle}">									
			</div>
						
			<div class="form-group row">
				<label class="col-2 col-form-label" for="description">Description : </label>
				<textarea rows="5" name="description" class="form-control col-10" required="required" value="${test.description}"></textarea>								
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label" for="duree">Durée (en minutes) : </label>
				<input type="number" name="duree" class="form-control col-10" required="required" value="${test.duree}">
			</div>
			
			<div class="form-group row">
				<label class="col-2 col-form-label" for="duree">Seuil haut : </label>
				<input type="number" name="seuilhaut" class="form-control col-2" required="required" value="${test.seuilHaut}">
				<label class="col-2 col-form-label" for="seuilbas">Seuil bas : </label>
				<input type="number" name="seuilbas" class="form-control col-2" required="required" value="${test.seuilBas}">										
			</div>
			
			<a class="btn btn-warning" href="${pageContext.servletContext.contextPath}/gestionnaire-question">Annuler</a>
			<input type="submit" class="btn btn-success" value="Créer">
		</fieldset>
		</form>
	</div>

</body>
</html>