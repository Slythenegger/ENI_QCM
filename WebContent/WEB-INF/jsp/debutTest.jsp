<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>QCM</title>
<link rel="stylesheet" href="asset/css/accueil.css">
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		<div class="debutTest">
			<h2>${test.libelle}</h2>
			<p>Description : ${test.description}</p>
			<p>Durée du test : ${test.duree} minutes</p>			
			<a href="test?id=${test.idTest}"><input type="button" value="Commencer le test"></a>
		</div>
	</div>
</body>
</html>