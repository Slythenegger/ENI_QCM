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
<script src="asset/js/createUser.js"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body onload="changeEvent()">

	<div class="container">
		<c:import url="topBar.jsp"></c:import>
		<div class="col-12">
			<form action="nouveau-candidat" method="post">
				<fieldset>
					<legend>Créer un candidat</legend>
					<c:if test="${! empty exception}">
						<p class="text-danger">${exception}</p>
					</c:if>
					<div class="form-group">
						<label for="nom">Nom : </label>
						<c:choose>
							<c:when test="${empty newUser}">
								<input type="text" name="nom" class="form-control"
									required="required">
							</c:when>
							<c:otherwise>
								<input type="text" name="nom" class="form-control"
									required="required" value="${newUser.nom}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<label for="prenom">Prénom : </label>
						<c:choose>
							<c:when test="${empty newUser}">
								<input type="text" name="prenom" class="form-control"
									required="required">
							</c:when>
							<c:otherwise>
								<input type="text" name="prenom" class="form-control"
									required="required" value="${newUser.prenom}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<label for="email">Email : </label>
						<c:choose>
							<c:when test="${empty newUser}">
								<input type="email" name="email" class="form-control"
									required="required">
							</c:when>
							<c:otherwise>
								<input type="email" name="email" class="form-control"
									required="required" value="${newUser.email}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<label for="password">Mot de passe : </label>
						<c:choose>
							<c:when test="${empty newUser}">
								<input type="password" name="password" class="form-control"
									required="required">
							</c:when>
							<c:otherwise>
								<input type="password" name="password" class="form-control"
									required="required" value="${newUser.password}">
							</c:otherwise>
						</c:choose>
					</div>
					<div class="form-group">
						<label for="role">Rôle : </label> <select name="role" id="role"
							onchange="changeEvent()">
							<c:forEach items="${roles}" var="role">
								<c:choose>
									<c:when test="${newUser.role == role.codeRole}">
										<option selected="selected" value="${role.codeRole}">${role.libelle}</option>
									</c:when>
									<c:otherwise>
										<option value="${role.codeRole}">${role.libelle}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> <label for="promo">Promotion : </label> <select name="promo"
							id="promo" disabled>
							<option class="text-muted">---------</option>
							<c:forEach items="${promos}" var="promo">
								<c:choose>
									<c:when test="${newUser.idPromo == promo.codePromo}">
										<option selected="selected" value="${promo.codePromo}">${promo.codePromo}</option>
									</c:when>
									<c:otherwise>
										<option value="${promo.codePromo}">${promo.codePromo}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<input type="submit" class="btn btn-info" value="Créer">
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>