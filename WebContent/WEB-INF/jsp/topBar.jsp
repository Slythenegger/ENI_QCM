<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="accueil"><img alt="logo-eni" src="asset/img/logo-eni.png"></a>
	<div class="navbar-nav">
		<a class="nav-item nav-link" href="accueil">Accueil</a>
		<c:if test="${user.role == responsable}">
			<a class="nav-item nav-link" href="nouveau-candidat">Créer candidat</a>
		</c:if>		
		<c:if test="${user.role == responsable}">
			<a class="nav-item nav-link"
				href="<c:out value="${pageContext.servletContext.contextPath}/resultats"/>">Résultat</a>
		</c:if>
		<a class="nav-item nav-link" href="login">Se déconnecter</a>
		<a class="nav-item nav-link" href="#">Home</a> <a
			class="nav-item nav-link" href="#">Features</a>
			<a class="nav-item nav-link" href="<c:out value="${pageContext.servletContext.contextPath}/gestionnaire-question"/>">Gestionnaire de questions</a>
			<a class="nav-item nav-link" href="<c:out value="${pageContext.servletContext.contextPath}/resultats"/>">Résultat</a>
	</div>
</nav>
<c:if test="${! empty info}">
	<div class="alert alert-info text-center" role="alert">${info}</div>
</c:if>