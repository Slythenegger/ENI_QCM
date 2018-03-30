<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title>QCM - gestionnaire de tests</title>
	<c:import url="head.jsp"></c:import>
</head>

<body>
	<c:import url="topBar.jsp"></c:import>
	
	<div class="container">
		<form action="gestionnaire-test" method="POST">
		    <select onchange="this.form.submit()">
		        <c:if test="${empty test}">
		        	<option>Choisir un test</option>
		        </c:if>
		        
				<c:forEach var="test" items="${tests}">
					<option value="${test.idTest}">${test.libelle}</option>
				</c:forEach>
		    </select>
		</form>
	</div>

</body>
</html>