<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<s:url namespace="" action="menu-css" />" rel="stylesheet" type="text/css">
</head>
<nav id="menu" class="navbar navbar-default">
<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="http://localhost:8080/client-SuiviStagiaire/accueil">Accueil</a>
	</div>
	<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Auto-Évaluation <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="http://localhost:8080/client-SuiviStagiaire/auto-evaluation/recherche-auto-evaluation">Rechercher</a></li>
					<li><a href="http://localhost:8080/client-SuiviStagiaire/auto-evaluation/creation-auto-evaluation">Création</a></li>
					<li><a href="http://localhost:8080/client-SuiviStagiaire/auto-evaluation/modification-auto-evaluation">Modification</a></li>
					<li><a href="http://localhost:8080/client-SuiviStagiaire/auto-evaluation/suppression-auto-evaluation">Supression</a></li>
					<li><a href="http://localhost:8080/client-SuiviStagiaire/auto-evaluation/listage-auto-evaluation">Lister</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mon compte <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Lien 1</a></li>
					<li><a href="#">Lien 2</a></li>
					<li><a href="#">Lien 3</a></li>
					<li role="separator" class="divider"></li>
					<li id="deconnexion"><a href="#">Déconnexion</a></li>
				</ul></li>
		</ul>
	</div>
</div>
</nav>
</html>