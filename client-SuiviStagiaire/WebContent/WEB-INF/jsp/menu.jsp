<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<s:url namespace="" action="menu-css" />" rel="stylesheet" type="text/css">
</head>
	<nav id="menu" class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="../client-SuiviStagiaire/accueil">Accueil</a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Auto-Evaluation <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="../client-SuiviStagiaire/rechercher-auto-evaluation">Rechercher</a></li>
	            <li><a href="../client-SuiviStagiaire/creation-auto-evaluation">Creation</a></li>
	            <li><a href="../client-SuiviStagiaire/modification-auto-evaluation">Modification</a></li>
	            <li><a href="../client-SuiviStagiaire/suppression-auto-evaluation">Suppression</a></li>
	            <li><a href="../client-SuiviStagiaire/lister-auto-evaluation">Lister</a></li>
	          </ul>
	        </li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mon compte <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">action</a></li>
	            <li><a href="#">action</a></li>
	            <li><a href="#">here</a></li>
	            <li role="separator" class="divider"></li>
	            <li id="deconnexion"><a href="#">Déconnexion</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</html>