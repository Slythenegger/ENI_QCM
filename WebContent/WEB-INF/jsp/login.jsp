<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QCM</title>
<link rel="stylesheet" href="asset/css/login.css">
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container centre">
		<div class="row">
			<div class="col-12">
				<div class="main">
					<div class="col-12">
						<h3>Connexion</h3>
						<c:if test="${! empty exception}">
							<p class="exception">${exception}</p>
						</c:if>
					</div>
					<div class="row">
						<div class="col-12 col-sm-6 col-sm-offset-1">

							<form action="login" method="post">
								<div class="form-group">
									<div class="col-md-8">
										<input type="email" placeholder="Votre email..." name="email"
											required="required" value="">
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-8">
										<input type="password" placeholder="Votre mot de passe..."
											name="password" required="required" value="">
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-0 col-md-8">
										<input class="btn btn-success btn btn-success" type="submit"
											value="Se connecter" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>