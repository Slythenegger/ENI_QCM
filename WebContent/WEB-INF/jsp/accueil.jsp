<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QCM</title>
<link rel="stylesheet" href="asset/css/accueil.css">
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		<div class="col-md-12">
			<h1>Bienvenue ${user.prenom}</h1>
			<div>
				<p>Vous êtes sur l'application en ligne de l'ENI ecole
					informatique.</p>
			</div>
			<c:if test="${! empty exception }">
				<p class="text-danger">${exception}</p>
			</c:if>
			<c:if test="${user.role == stagiaire or user.role == candidat}">
				<div class="row">
					<div class="col-md-6">
						<h4>ECF à passer</h4>
						<c:forEach items="${epreuves}" var="epr">
							<c:if test="${epr.etat == plannifie}">
								<p>
									<a href="demarrer-test?idTest=${epr.idTest}">${epr.libelleTest}</a>
								</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<h4>ECF en cours</h4>
						<c:forEach items="${epreuves}" var="epr">
							<c:if test="${epr.etat == enCours}">
								<p>
									<a href="#">${epr.libelleTest}</a>
								</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="margetop">
					<h4>Historique</h4>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Nom du test</th>
								<th>Résulat</th>
								<th>Note</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${epreuves}" var="epr">
								<c:if test="${epr.etat != plannifie and epr.etat != enCours}">
									<tr>
										<td>${epr.libelleTest}</td>
										<td>${epr.niveauObtenu}</td>
										<td>${epr.noteObtenue}/20</td>
										<td><fmt:formatDate value="${epr.debutDate}" type="date" /></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>