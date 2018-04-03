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
	
	<div class="wrapper column">
	
	<div class="left-panel wrapper column bg-secondary">
		<div class="left-panel-lb">
			<c:forEach var="test" items="${tests}">
				<div class="left-panel-lb-item">
					<div class="left-panel-lb-item-name">${test.libelle}</div>
				</div>
			</c:forEach>			
		</div>
		<div class="left-panel-action">
			<button class="btn btn-primary">Nouveau Test</button>
		</div>	
	</div>

	</div>
	


</body>
</html>