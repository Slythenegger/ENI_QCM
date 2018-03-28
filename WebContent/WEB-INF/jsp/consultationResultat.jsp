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
</head>
<body>
	<div class="container">
		
	<c:if test="${empty tests}">
		<h2>Aucun tests trouvés !</h2>
	</c:if>
	
	<c:if test="${!empty tests}">
		<h2>Liste des tests</h2>
		
		<ul class="list-inline">
			<c:forEach var="test" items="${tests}">
				<li class="list-inline-item"><a href="<c:out value="${pageContext.servletContext.contextPath}/ServletConsultationResultat?test=${test.idTest}"/>">${test.libelle}</a></li>
				
			</c:forEach>
		</ul>
	</c:if>
	
	<c:if test="${!empty test && !empty resultats}">
		<h2>Résultat pour ${test.libelle}</h2>
		
			<table class="table table-striped">
				<thead>
				<tr>
					<th>Nom, prénom</th>
					<th>Acquis</th>
					<th>Résultat</th>					
				</tr>
				</thead>
				
				<tbody>
				<c:forEach var="resultat" items="${resultats}">
					<tr>
						<td>${resultat.nom} ${resultat.prenom}</td>
						<td>${resultat.acquis}</td>
						<td>${resultat.noteObtenue}/20</td>						
					</tr>
				</c:forEach>
				</tbody>
			</table>		
	</c:if>
	
	</div>

</body>
</html>