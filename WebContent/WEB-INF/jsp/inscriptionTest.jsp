<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script>
function changement(param)
{
var tab = ["prom","stag","candidat"];
var tag = document.getElementById(tab[param]);

 
 if(tag.style.display=="none")
 {
	 
   tag.style.display="block";
   
 }
 else
 {
  tag.style.display="none";
 }
 
 
}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription au test</title>
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="asset/js/app.js"></script>

</head>
<body>

<c:import url="topBar.jsp"></c:import>
<div class="container">
<h1>Inscription test</h1>

<form method="POST" action="${pageContext.request.contextPath}/ServletTraitementInscriptionTest">  


<fieldset>
<legend> Selection du test</legend>
<label for="idTest">Nom  du test : </label>
<select name="idTest">
<option value=""></option>
	
		<c:forEach var="tests" items="${tests}">
			<option value=${tests.idTest }>${tests.libelle}</option>
		</c:forEach>
	
</select>
<br>
<label for="testDateDebut"> Date de passage du test : </label>
<input type="date" name="testDateDebut">
<input type="time" name="testHeureDebut"><br>

<label for="tesDateFin">Date de fin</label>
	<input type="date" name="testDateFin">
	<input type="time" name="testHeureFin">
</fieldset>

<fieldset>
<legend> Selection du ou des candidats</legend>

Type de candidats: 
<div>
 
<label ><input type="checkbox" name="usertype" value="PROM" onchange="changement(0);" /> Promotion</label> <br>

<label ><input type="checkbox" name="usertype"  value="CAN" onchange="changement(1);"/> Stagiaire</label><br>

<label ><input type="checkbox" name="usertype" value="STA" onchange="changement(2)"> Candidat</label> <br>
</div>
<div id="candidat" style="display:none;">
Nom du candidat : <input type="text" id="candiname" name="candiname" ><br>
<div id="liste"></div>

</div>
<div id="stag" style="display:none;">
Nom du Stagiaire : <input type="text" id="stagname" name="stagname"><br>
<div id="liste2"></div>



</div>
<div id="prom" style="display:none;">
Promotion des stagiaires: 
<select name="codePromo" id="codePromo">
<option value=""></option>
	<c:forEach var="promos" items="${promos}">			
			<option value=${promos.codePromo }>${promos.libelle}</option>
	</c:forEach>

</select><br>
</div>
</fieldset>
<input type="submit" value="inscrire" class="btn btn-primary">

</form>
</div>
<span id="nb"></span>

</body>
</html>