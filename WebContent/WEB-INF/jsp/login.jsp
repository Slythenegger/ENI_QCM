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
</head>
<body>
	<div>
		<div>
			<c:if test="${! empty exception }">
				<p style="color: red">${exception}</p>
			</c:if>
		</div>
		<form action="login" method="post">
			<div>
				<label>Email : </label><input type="email"
					placeholder="Votre email..." name="email" required="required">
			</div>
			<div>
				<label>Mot de passe : </label><input type="password"
					placeholder="Votre mot de passe..." name="password"
					required="required">
			</div>
			<div>
				<input type="submit" value="Se connecter">
			</div>

		</form>
	</div>

</body>
</html>