<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title>QCM - gestionnaire de tests</title>
	<c:import url="head.jsp"></c:import>
</head>

<body id="page-gt">
	<c:import url="topBar.jsp"></c:import>
	
	<div class="wrapper">
	
	<div class="left-panel wrapper column bg-secondary">
		<div class="left-panel-title font-weight-bold">Tests</div>
		<div class="left-panel-lb">
			<c:forEach var="test" items="${tests}">
				<a 	class="left-panel-lb-item <c:if test="${test.idTest == selected.idTest}">selected</c:if>"
					href="${pageContext.servletContext.contextPath}/gestionnaire-test?mode=update&testID=${test.idTest}"
				>${test.libelle}</a>
			</c:forEach>			
		</div>
		<div class="left-panel-action">
			<a 
				class="btn btn-primary"
				href="${pageContext.servletContext.contextPath}/gestionnaire-test?mode=create"
			>Nouveau Test</a>
		</div>	
	</div>
	
	<div class="wrapper column">
	<c:if test="${!empty mode}">
	<div id="action-container">
		
			<form action="gestionnaire-test" method="post">
			<fieldset>
			<c:if test="${mode == 'create'}"><legend>Créer un test</legend></c:if>
			<c:if test="${mode == 'update'}"><legend>Modifier ce test</legend></c:if>
				<div class="form-group">
					<label class="col-form-label col-9" for="libelle">Nom</label>
					<input type="text" name="libelle" class="form-control col-9" required="required" value="${selected.libelle}">									
				</div>
							
				<div class="form-group">
					<label class="col-form-label col-9" for="description">Description</label>
					<textarea rows="2" name="description" class="form-control col-9" required="required">${selected.description}</textarea>								
				</div>
				
				<div class="form-group row">
					<div class="form-group col-5">
						<label class="col-form-label" for="duree">Durée (en minutes)</label>
						<input type="number" name="duree" class="form-control" required="required" value="${selected.duree}">
					</div>
				
					<div class="form-group col-2">
						<label class="col-form-label" for="duree">Seuil haut</label>
						<input type="number" name="seuilhaut" class="form-control" required="required" value="${selected.seuilHaut}">
					</div>
					<div class="form-group col-2">
						<label class="col-form-label" for="seuilbas">Seuil bas</label>
						<input type="number" name="seuilbas" class="form-control" required="required" value="${selected.seuilBas}">										
					</div>
				</div>
						
				<a class="btn btn-danger" href="${pageContext.servletContext.contextPath}/gestionnaire-test">Annuler</a>
			
				<input 
					type="submit" 
					class="btn btn-success" 
					<c:if test="${mode == 'create'}">value="Créer"</c:if>
					<c:if test="${mode == 'update'}">value="Sauvegarder"</c:if>
				>
				

			</fieldset>
			</form>
		
	</div>
	</c:if>
	
	</div>
	
	</div>

</body>
</html>