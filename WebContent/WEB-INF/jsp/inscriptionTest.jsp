<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription au test</title>
</head>
<body>

<h1>Inscription test</h1>

<form>
<fieldset>
<legend> Selection du test</legend>
<label for="testname">Nom  du test : </label><select name="testname"></select><br>
<label for="testdate"> Date de passage du test : </label><input type="date" name="testdate">
<label for="tesdatefin">Date de fin</label><input type="date" name="testDateFin">
</fieldset>

<fieldset>
<legend> Selection du ou des candidats</legend>

Type de candidats: 
<div><input type="radio" name="usertype" value="STA" /> <label for="usertype1">Stagiaire</label> <br>
<input type="radio" name="usertype" value="CAN" /> <label for="usertype2">Candidat</label> <br>
</div>

Nom du candidat : <input type="text" name="username"><br>

Promotion des stagiaires: <select></select><br>
</fieldset>
<input type="submit" value="inscrire">
</form>

</body>
</html>