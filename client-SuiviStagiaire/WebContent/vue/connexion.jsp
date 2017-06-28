<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ taglib prefix="s" uri="/struts-tags" %>
 
<!-- <jsp:include page="/WEB-INF/jsp/import-boostrap.jsp"></jsp:include> -->

<link href="<s:url namespace="" action="bootstrap-css" />" rel="stylesheet" type="text/css">
<link href="<s:url namespace="" action="bootstrap-theme" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<s:url namespace="" action="bootstrap-js" />"></script>

<title>Accueil - Suivi de stagiaire</title>
</head>

	<jsp:include page="/WEB-INF/jsp/bandeau.jsp"></jsp:include>
	
	<div id="connexion" class="center-block">
		<form class="form-horizontal">
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">Numéro osia : </label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputEmail3" placeholder="Numéro osia">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">Mot de passe :  </label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword3" placeholder="Mot de passe">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox">Se souvenir de moi
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Connexion</button>
		    </div>
		  </div>
		</form>
	</div>
	
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</html>