<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/WEB-INF/jsp/import-boostrap.jsp"%>
<link href="<s:url namespace="" action="index-css" />" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<s:url namespace="" action="creation-auto-evaluation-js" />"></script>
</head>
<%@ include file="/WEB-INF/jsp/bandeau.jsp"%>
<body>
	<%@ include file="/WEB-INF/jsp/menu.jsp"%>
	<div class="container center-block">
		<s:if test="autoEvaluation!=null">
			<section id="modification-auto-evaluation" class="center-block">
			<form class="form-horizontal center-block" action="auto-evaluation-modifier" method="post" onsubmit="return validateFormCreation(this)">
				<div class="form-group">
					<label for="competence" class="col-sm-3 col-sm-offset-0 control-label">Compétence :</label>
					<div id="competence" class="col-sm-9 col-sm-offset-0">
						<select title="Compétence" name="stringCompetence" class="form-control">
							<option selected="selected" value="<s:property value="autoEvaluation.competence.sequence.module.identifiant" />,<s:property value="autoEvaluation.competence.sequence.identifiant" />,<s:property value="autoEvaluation.competence.identifiant" />"><s:property value="autoEvaluation.competence.identifiant" /> -
								<s:property value="autoEvaluation.competence.nomCourt" /></option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="identifiantNiveauAcquisition" class="col-sm-3 col-sm-offset-0 control-label">Niveau d'acquisition :</label>
					<s:iterator value="NiveauAcquisitions">
						<div class="col-sm-3 col-sm-offset-0 radio">
							<label class="radio-inline"> <s:if test="autoEvaluation.niveauAcquisition.identifiant.equals(identifiant)">
									<input checked="checked" type="radio" name="stringNiveauAcquisition" value="<s:property value="identifiant" />">
									<s:property value="libelle" />
								</s:if> <s:else>
									<input type="radio" name="stringNiveauAcquisition" value="<s:property value="identifiant" />">
									<s:property value="libelle" />
								</s:else>
							</label>
						</div>
					</s:iterator>
				</div>
				<div class="form-group">
					<label for="ressenti" class="col-sm-3 col-sm-offset-0 control-label">Ressenti :</label>
					<div class="col-sm-9 col-sm-offset-0">
						<div id="caractere-restant">
							<label class="control-label" id="label-nombre-caractere-restant">Nombre de caractère restant : </label>
							<p id="nombre-caractere-restant">4000</p>
						</div>
						<textarea class="form-control" name="ressenti" rows="3" onkeyup="calculCaractereRestant(this)"><s:property value="autoEvaluation.ressenti" /></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-8">
						<button type="reset" class="btn btn-default">Annuler</button>
					</div>
					<div class="col-sm-2 col-sm-offset-0">
						<button name="identifiantAutoEvaluation" value="<s:property value="autoEvaluation.identifiant" />" type="submit" class="btn btn-default">Valider</button>
					</div>
			</form>
			</section>
		</s:if>
		<s:else>
			<section>
			<form>ajax magique qui fait que bon c'est genial et tout</form>
			</section>
		</s:else>
		<section id="information-modification-auto-evaluation" class="center-block">
		<div id="info-competence" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement sélectionner une compétence</span>
		</div>
		<div id="info-niveau-acquisition" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement sélectionner un niveau de competence</span>
		</div>
		</section>
		</section>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</html>