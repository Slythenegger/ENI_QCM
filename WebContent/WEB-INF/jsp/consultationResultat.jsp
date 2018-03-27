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
			<div class="test">
				<div class="nom">${test.libelle}</div>
				<div class="description">${test.description}</div>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>