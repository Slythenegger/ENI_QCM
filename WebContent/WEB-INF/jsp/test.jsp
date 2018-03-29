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
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		<c:if test="${! empty exception}">
			<p>${exception}</p>
		</c:if>
		<c:if test="${! empty liste }">
			<c:forEach items="liste" var="li">
				<p>${li.question.enonce}</p>
				<c:forEach items="${li.reponses}" var="rep">
					<p>${rep.enonce }</p>
				</c:forEach>
			</c:forEach>
		</c:if>
		<c:if test="${empty liste }">
		<p>y a rien Michel !!</p>
		</c:if>
	</div>
</body>
</html>