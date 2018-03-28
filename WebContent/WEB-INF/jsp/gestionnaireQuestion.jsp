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
	
		<c:if test="${empty test}">
	
		<h2>Liste des tests</h2>
		<ul class="list-group col-12">
			<c:forEach var="test" items="${tests}">
	            <li class="list-group-item d-flex justify-content-between align-items-center">${test.libelle}
	                <div>
	                	<a href="${pageContext.request.contextPath}/gestionnaire-question?test=${test.idTest}" class="badge" title="Editer la liste"><i class="material-icons">create</i></a>
	                </div>
	            </li>			        		
			</c:forEach>
		</ul>
		
		</c:if>
		
	</div>

</body>
</html>