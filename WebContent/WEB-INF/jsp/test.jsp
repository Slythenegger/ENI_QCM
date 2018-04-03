<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>QCM</title>
<c:import url="head.jsp"></c:import>
</head>
<body>
	<c:import url="topBar.jsp"></c:import>
	<div class="container">
		<c:if test="${! empty exception}">
			<p class="alert alert-danger">${exception}</p>
		</c:if>
		<c:if test="${! empty question}">
			<div class="margetop margeleft">
				<h4>${question}</h4>
				<c:choose>
					<c:when test="${question.estMulti}">
						<c:forEach items="${reponses}" var="rep">
							<input id="${rep.idReponse}" type="checkbox"
								value="${rep.idReponse}" name="rep${rep.idReponse}]">&nbsp;${rep}<br>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach items="${reponses}" var="rep">
							<input name="reponse" type="radio" value="${rep.idReponse}">&nbsp;${rep}<br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>
	</div>
</body>
</html>