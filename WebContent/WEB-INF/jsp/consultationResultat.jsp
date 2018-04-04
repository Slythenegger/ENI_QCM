<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
	<title>QCM - Consultation des résultats</title>
	<c:import url="head.jsp"></c:import>
</head>

<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		
	<c:if test="${empty tests}">
		<h2>Aucun tests trouvés !</h2>
	</c:if>
	
	<c:if test="${!empty tests}">
		<h2>Liste des tests</h2>
		
		<ul class="list-inline">
			<c:forEach var="test" items="${tests}">
				<li class="list-inline-item"><a href="<c:out value="${pageContext.servletContext.contextPath}/resultats?test=${test.idTest}"/>">${test.libelle}</a></li>
				
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