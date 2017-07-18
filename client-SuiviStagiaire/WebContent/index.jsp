<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Accueil - Suivi de stagiaire</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/import-boostrap.jsp"%>
<link href="<s:url namespace="" action="index-css" />" rel="stylesheet" type="text/css">
</head>
<%@ include file="/WEB-INF/jsp/bandeau.jsp"%>
<body>
	<%@ include file="/WEB-INF/jsp/menu.jsp"%>
	<div id="contenu" class="container-fluid center-block">
		<section id="accueil" class="center-block">
		<h2>Les dernières news</h2>
		<div class="panel panel-info" id="info-1">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="#info-1" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		<div class="panel panel-info" id="info-2">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="#info-2" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		<div class="panel panel-info" id="info-3">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="#info-3" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		<div class="panel panel-info" id="info-4">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="info-4" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		<div class="panel panel-info" id="info-5">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="info-5" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		<div class="panel panel-info" id="info-6">
			<div class="panel-heading">
				<h3 class="panel-title">Titre 1</h3>
				<button type="button" class="close" data-target="info-6" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</div>
			<div class="panel-body">
				<span>news 1</span>
			</div>
		</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>