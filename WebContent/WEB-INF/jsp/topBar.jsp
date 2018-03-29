<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="accueil"><img alt="logo-eni"
		src="asset/img/logo-eni.png"></a>
	<div class="navbar-nav">
		<c:if test="${user != null}">
			<a class="nav-item nav-link" href="accueil">Accueil</a>
			
			<c:if test="${user.role == responsable}">
				
				<div class="nav-item dropdown">
					<a 	class="nav-link dropdown-toggle" href="#" 
						id="navbarDropdownCandidat" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"
					>Candidat</a>
					
					<div class="dropdown-menu" aria-labelledby="navbarDropdownCandidat">
						<a 	class="dropdown-item" 
							href="${pageContext.servletContext.contextPath}/nouveau-candidat"
						>Créer candidat</a>
						<a 	class="dropdown-item" 
							href="${pageContext.servletContext.contextPath}/inscriptionTest"
						>Inscrire à un test</a>
						
						<div class="dropdown-divider"></div>
						
						<a 	class="dropdown-item" 
							href="${pageContext.servletContext.contextPath}/resultats"
						>Résultats</a>	
					</div>
				</div>
				
				<div class="nav-item dropdown">
					<a 	class="nav-link dropdown-toggle" href="#" 
						id="navbarDropdownQCM" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"
					>QCM</a>
					
					<div class="dropdown-menu" aria-labelledby="navbarDropdownQCM">
						<a 	class="dropdown-item" 
							href="${pageContext.servletContext.contextPath}/gestionnaire-question"
						>Gestionnaire de test</a>
						<a 	class="dropdown-item" 
							href="${pageContext.servletContext.contextPath}/gestionnaire-question"
						>Gestionnaire de thème</a>				
					</div>
				</div>
			</c:if>
			
			<a class="nav-item nav-link" href="login">Se déconnecter</a>
		</c:if>
	</div>
</nav>
<c:if test="${! empty info}">
	<div class="alert alert-info text-center" role="alert">${info}</div>
</c:if>