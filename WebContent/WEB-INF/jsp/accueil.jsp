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
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		<h1>Bienvenue ${user.prenom}</h1>
		<div>
			<p>Vous êtes sur l'application en ligne de l'ENI ecole
				informatique.</p>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom du test</th>
					<th>Résulat</th>
					<th>Note</th>
					<th>Etat</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${epreuves}" var="epr">
					<tr>
						<td>${epr.libelleTest}</td>
						<td>${epr.niveauObtenu}</td>
						<td>${epr.noteObtenue}/20</td>
						<td>${epr.etat}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>