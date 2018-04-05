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

<body id="page-gt">
	<c:import url="topBar.jsp"></c:import>
	
	<div class="wrapper">
		<div class="left-panel wrapper column">
		<div class="left-panel-title font-weight-bold">Tests</div>
		<div class="left-panel-lb">
			<c:forEach var="varTest" items="${tests}">
				<a 	class="left-panel-lb-item <c:if test="${varTest.idTest == test.idTest}">selected</c:if>"
					href="${pageContext.servletContext.contextPath}/resultats?test=${varTest.idTest}"
				>${varTest.libelle}</a>
			</c:forEach>			
		</div>
	</div>
	
	<div class="wrapper column"> 
		<div id="action-container">
			<c:if test="${empty test}">
				<h2>Choisissez un test</h2>
			</c:if>
			
			<c:if test="${!empty test && empty resultats}">
				<h2>Aucun résultats pour ${test.libelle}</h2>
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
	</div>
	
	
	</div>

</body>
</html>