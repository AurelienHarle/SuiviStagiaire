<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<title>Connexion - Suivi de stagiaire</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file = "/WEB-INF/jsp/import-boostrap.jsp" %>
<link href="<s:url namespace="" action="index-css" />" rel="stylesheet" type="text/css">
</head>

<%@ include file = "/WEB-INF/jsp/bandeau.jsp" %>

<body>
	<div class="container">
		<section id="connexion" class="center-block">
			<form class="form-horizontal" action="../accueil" method="get">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="Login">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-offset-0 col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-0 col-sm-5">
						<div class="checkbox">
							<label>
							<input type="checkbox"> Se souvenir de moi
							</label>
						</div>
					</div>
					<div class="col-sm-offset-4 col-sm-2">
						<button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>  
			</form>
		</section>
		<section id="information" class="center-block">
			<div id="info-login" class="alert alert-danger" role="alert"><span>Attention : Vous avez rentré un login incorrect</span></div>
			<div id="info-password" class="alert alert-danger" role="alert"><span>Attention : Vous avez rentré un mot de passe incorrect</span></div>
		</section>
	</div>
</body>
<%@ include file = "/WEB-INF/jsp/footer.jsp" %>
</html>