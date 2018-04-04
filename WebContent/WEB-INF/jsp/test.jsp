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

				<input type="submit"
					value="Marquer la question-${question.idQuestion}-${idEpreuveEnCours}"
					name="coche" class="btn btn-info"> <input type="submit"
					value="Retirer la marque-${question.idQuestion}-${idEpreuveEnCours}"
					name="coche" class="btn btn-info">
				<div class="margetop margeleft">
					<h4>${question}</h4>




					<c:if test="${question.estMulti}">
						<c:set var="cpt" value="0"></c:set>
						<c:forEach items="${reponses}" var="rep">
							<c:set var="cpt" value="${cpt +1}"></c:set>							
							${cpt}. <input id="${rep.idReponse}" type="checkbox"
								value="${rep.idReponse}-${question.idQuestion}-${idEpreuveEnCours}"
								name="reponseBox${cpt}" onchange="this.form.submit()"
								<c:if test="${rep.estRepondu}">
										checked="checked"
										</c:if>>&nbsp;${rep}<br>
						</c:forEach>
					</c:if>

					<c:if test="${! question.estMulti}">
						<c:forEach items="${reponses}" var="rep">
							<input name="reponseRadio" type="radio"
								value="${rep.idReponse}-${question.idQuestion}-${idEpreuveEnCours}"
								onchange="this.form.submit()"
								<c:if test="${rep.estRepondu}">
										checked="checked"
										</c:if>> &nbsp;${rep}<br>
						</c:forEach>
					</c:if>
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