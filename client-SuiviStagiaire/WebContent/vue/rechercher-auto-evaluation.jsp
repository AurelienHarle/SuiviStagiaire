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
	<div id="contenu" class="container-fluid center-block">
		<s:if test="!autoEvaluations.isEmpty()">
			<section id="rechercher-auto-evaluation">
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
							</s:if> <s:else>Edition impossible, vous pouvez éditer seulement votre dernière auto-évaluation.</s:else></td>
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
		</s:if>
		<s:else>
			<section id="information-rechercher-auto-evaluation" class="center-block">
			<div id="info-autoEvaluations" class="alert alert-warning" role="alert">
				<span>Information : Votre recherche n'a donné aucun résultat.</span>
			</div>
			<div id="information-redirection" class="alert alert-info" role="alert">
				<span>Redirection dans : </span><span id="seconde">5</span><span> secondes.</span>
			</div>
			<script language="javascript" type="text/javascript">
				redirectSuccessPage();
			</script> </section>
		</s:else>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>