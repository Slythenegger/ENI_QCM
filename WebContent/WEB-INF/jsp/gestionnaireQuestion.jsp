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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<c:import url="topBar.jsp"></c:import>

	<div class="container">
		
		<h4>Liste des tests</h4>
		<div class="row">
			<select class="col-6">
				<c:forEach var="test" items="${tests}">
				<option>${test.libelle}</option>
				</c:forEach>
			</select>
			<div class="col-4"></div>
			<a class="btn btn-success col-2" href="${pageContext.servletContext.contextPath}/creation-test">Créer un nouveau test</a>
		</div>
		
		
	</div>

</body>
</html>