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
			<h3>Question ${numQuestion + 1}</h3>
			<c:if test="${! empty reponsesUser}">
				<c:forEach items="${reponsesUser}" var="rep">
					<p>${rep.idReponse}</p>
					<p>${rep.idQuestion}</p>
					<p>${rep.idEpreuve}</p>
				</c:forEach>
			</c:if>
			
		
			<form action="test" method="post">
			<c:choose>
			<c:when test="${questionTir.estMarquee == false }">
			<input type="submit" value="Marquer la question-${question.idQuestion}-${idEpreuveEnCours}" name="coche"  class="btn btn-info">
			</c:when>
			<c:when test="${questionTir.estMarquee == true}">
			<input type="submit" value="Retirer la marque-${question.idQuestion}-${idEpreuveEnCours}" name="coche"  class="btn btn-info">
			</c:when>
			</c:choose>
			
			
			
			
			
				<div class="margetop margeleft">
					<h4>${question}</h4>
					
					<c:choose>
						<c:when test="${question.estMulti}">
							<c:forEach items="${reponses}" var="rep">
								<input id="${rep.idReponse}" type="checkbox"
									value="${rep.idReponse}" name="reponseBox"
									onchange="this.form.submit()">&nbsp;${rep}<br>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach items="${reponses}" var="rep">
								<c:choose>
									<c:when test="${reponseUser.idReponse == rep.idReponse}">
										<input name="reponseRadio" type="radio"
											value="${rep.idReponse}-${question.idQuestion}-${idEpreuveEnCours}"
											onchange="this.form.submit()" checked="checked">&nbsp;${rep}<br>
									</c:when>
									<c:otherwise>
										<input name="reponseRadio" type="radio"
											value="${rep.idReponse}-${question.idQuestion}-${idEpreuveEnCours}"
											onchange="this.form.submit()">&nbsp;${rep}<br>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</form>
		</c:if>
		<div class="margetop margeleft">
			<c:if test="${numQuestion != 0}">
				<a href="test?id=${idTest}&numQuestion=${numQuestion - 1}"><button>Précédente</button></a>
			</c:if>
			<c:if test="${numQuestion != nbQuestions-1}">
				<a href="test?id=${idTest}&numQuestion=${numQuestion + 1}"><button>Suivante</button></a>
			</c:if>
		</div>
	</div>
</body>
</html>