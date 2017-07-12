<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/import-boostrap.jsp"%>
<link href="<s:url namespace="" action="index-css" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<s:url namespace="" action="auto-evaluation-js" />"></script>
</head>
<%@ include file="/WEB-INF/jsp/bandeau.jsp"%>
<body onload="redirectSuccessPage()">
	<%@ include file="/WEB-INF/jsp/menu.jsp"%>
	<div class="container-fluid center-block">
		<section>
		<div id="information-success" class="alert alert-success" role="alert">
			<span>Félicitation : Votre auto-évaluation a bien était enregistrer par le système</span>
		</div>
		<div id="information-redirection" class="alert alert-info" role="alert">
			<span>Redirection dans : </span><span id="seconde">5</span><span> seconde</span>
		</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>