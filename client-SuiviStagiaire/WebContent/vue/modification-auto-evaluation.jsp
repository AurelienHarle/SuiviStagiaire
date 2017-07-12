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
<body>
	<%@ include file="/WEB-INF/jsp/menu.jsp"%>
	<div class="container-fluid center-block">
		<s:if test="autoEvaluation.identifiant!=0">
			<section class="center-block" id="explication-creation-auto-evaluation">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Explication</h3>
				</div>
				<div class="panel-body">
					<span>Vous pouvez modifier votre niveau d'acquisition, ainsi que votre ressenti.</span>
				</div>
			</div>
			</section>
			<section id="modification-auto-evaluation" class="center-block">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Formulaire de création :</h3>
				</div>
				<div class="panel-body">
					<form class="form-horizontal center-block" action="auto-evaluation-modifier" method="post" onsubmit="return validateFormCreation(this)">
						<div class="form-group">
							<label for="competence" class="col-sm-3 col-sm-offset-0 control-label">Compétence </label>
							<div id="competence" class="col-sm-9 col-sm-offset-0">
								<select title="Compétence" name="stringCompetence" class="form-control">
									<option selected="selected" value="<s:property value="autoEvaluation.competence.sequence.module.identifiant" />,<s:property value="autoEvaluation.competence.sequence.identifiant" />,<s:property value="autoEvaluation.competence.identifiant" />"><s:property value="autoEvaluation.competence.identifiant" /> -
										<s:property value="autoEvaluation.competence.nomCourt" /></option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="identifiantNiveauAcquisition" class="col-sm-3 col-sm-offset-0 control-label">Niveau d'acquisition </label>
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
							<label for="ressenti" class="col-sm-3 col-sm-offset-0 control-label">Ressenti </label>
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
						</div>
					</form>
				</div>
			</div>
			</section>
		</s:if>
		<s:elseif test="!autoEvaluations.isEmpty()">
			<div class="container-fluid">
				<section id="liste-auto-evaluation">
				<table class="table-striped table-bordered table-condensed">
					<tr>
						<th>Identifiant</th>
						<th colspan="3">Compétence</th>
						<th>Ressenti</th>
						<th>Niveau d'acquisition</th>
						<th>Date</th>
						<th>Éditer</th>
						<th>Supprimer</th>
					</tr>
					<tr>
						<th></th>
						<th>identifiant</th>
						<th>nom long</th>
						<th>nom court</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<s:iterator value="autoEvaluations">
						<tr>
							<td><s:property value="identifiant" /></td>
							<td><s:property value="competence.sequence.module.identifiant" /> - <s:property value="competence.sequence.identifiant" /> - <s:property value="competence.identifiant" /></td>
							<td><s:property value="competence.nomLong" /></td>
							<td><s:property value="competence.nomCourt" /></td>
							<td><s:property value="ressenti" /></td>
							<td><s:property value="niveauAcquisition.libelle" /></td>
							<td><s:property value="dateAutoEvaluation" /></td>
							<td><s:if test="dateAutoEvaluation.equals(dateJour)">
									<form method="get" action="modification-auto-evaluation">
										<button name="identifiantAutoEvaluation" value="<s:property value='identifiant' />" type="submit" class="btn btn-default" aria-label="Left Align">
											<span class="glyphicon glyphicon-pencil" aria-hidden="true">Editer</span>
										</button>
									</form>
								</s:if> <s:else>Edition impossible : Vous pouvez éditer seulement les auto-évaluations réaliser le jour même.</s:else></td>
							<td>
								<form method="post" action="auto-evaluation-supprimer" onsubmit="return validationSuppression()">
									<button name="identifiantAutoEvaluation" value="<s:property value='identifiant' />" type="submit" class="btn btn-default" aria-label="Left Align">
										<span class="glyphicon glyphicon-trash" aria-hidden="true">Supprimer</span>
									</button>
								</form>
							</td>
						</tr>
					</s:iterator>
				</table>
				</section>
			</div>
		</s:elseif>
		<s:else>
			<section id="information-aucune-auto-evaluation" class="center-block">
			<div id="info-auto-evaluation" class="alert alert-info" role="alert">
				<span>Information : Vous n'avez aucune auto-évaluations, réalisée à ce jour.</span>
			</div>
			</section>
		</s:else>
		<section id="information-modification-auto-evaluation" class="center-block">
		<div id="info-competence" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement sélectionner une compétence.</span>
		</div>
		<div id="info-niveau-acquisition" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement sélectionner un niveau de competence.</span>
		</div>
		</section>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</html>