<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Accueil - Suivi de stagiaire</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file = "/WEB-INF/jsp/import-boostrap.jsp" %>
<link href="<s:url namespace="" action="index-css" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<s:url namespace="" action="creation-auto-evaluation-js" />"></script>
</head>

<%@ include file = "/WEB-INF/jsp/bandeau.jsp" %>

<body>
<%@ include file = "/WEB-INF/jsp/menu.jsp" %>
	<div class="container center-block">
		<section id="creation-auto-evaluation" class="center-block">
			<form class="form-horizontal center-block" action="auto-evaluation-creer" method="post" onsubmit="return validateFormCreation(this)">
				<div class="form-groupe">
					<label for="competence" class="col-sm-3 col-sm-offset-0 control-label">Compétence :</label>
					<div id="competence" class="col-sm-9 col-sm-offset-0">
			   			<select title="Compétence" name="stringCompetence" class="form-control">
			   				<s:iterator value="Competences">
							 <option value="<s:property value="sequence.module.identifiant" />,<s:property value="sequence.identifiant" />,<s:property value="identifiant" />"><s:property value="identifiant"/> - <s:property value="nomCourt"/></option>
							</s:iterator>
			   			</select>
		   			</div>
				</div>
				<div class="form-group">
					<label for="identifiantNiveauAcquisition" class="col-sm-3 col-sm-offset-0 control-label">Niveau d'acquisition :</label>
					<s:iterator value="NiveauAcquisitions" >
						<div class="col-sm-3 col-sm-offset-0 radio">
							<label  class="radio-inline">
							<input type="radio" name="stringNiveauAcquisition" value="<s:property value="identifiant" />" > <s:property value="libelle"/>
							</label>
						</div>
					</s:iterator>
				</div>
				<div class="form-group">
					<label for="ressenti" class="col-sm-3 col-sm-offset-0 control-label">Ressenti :</label>
					<div class="col-sm-9 col-sm-offset-0">
						<div id="caractere-restant">
							<label class="control-label" id="label-nombre-caractere-restant">Nombre de caractère restant : </label><p id="nombre-caractere-restant">4000</p>
						</div>
						<textarea class="form-control" name="ressenti" rows="3" onclick="cleanRessenti(this)" onkeyup="calculCaractereRestant(this)">Votre ressenti....</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-8">
						<button type="reset" class="btn btn-default">Annuler</button>
					</div>
					<div class="col-sm-2 col-sm-offset-0">
						<button type="submit" class="btn btn-default">Valider</button>
					</div>
			</form>
		</section >
		<section id="information-creation-auto-evaluation" class="center-block">
			<div id="info-competence" class="alert alert-danger" role="alert"><span>Attention : Vous devez obligatoirement sélectionner une compétence</span></div>
			<div id="info-niveau-acquisition" class="alert alert-danger" role="alert"><span>Attention : Vous devez obligatoirement sélectionner un niveau de competence</span></div>
		</section>
	</div>
	<%@ include file = "/WEB-INF/jsp/footer.jsp" %>
</body>
</html>