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
</head>
<body>

	<c:if test="${empty tests}">
		<h2>Aucun tests trouvés !</h2>
	</c:if>
	
	<c:if test="${!empty tests}">
		<h2>Liste des tests</h2>
		<c:forEach var="test" items="${tests}">
			<a href="<c:out value="${pageContext.servletContext.contextPath}/ServletConsultationResultat?test=${test.idTest}"/>">
			<div class="test">
				<div class="nom">${test.libelle}</div>
				<div class="description">${test.description}</div>
			</div>
			</a>
		</c:forEach>
	</c:if>
	
	<c:if test="${!empty test && !empty resultats}">
		<h2>Résultat pour ${test.libelle}</h2>
		
			<table>
				<tr>
					<th>Nom, prénom</th>
					<th>Résultat</th>
				</tr>
				
				<c:forEach var="resultat" items="${resultats}">
					<tr>
						<td>${resultat.nom} ${resultat.prenom}</td>
						<td>${resultat.noteObtenue}/20</td>
					</tr>
				</c:forEach>
				
			</table>		
	</c:if>
</body>
</html>