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
		<section id="recherche-auto-evaluation" class="center-block">
		<div class="panel">
			<span>Vous pouvez recherche comme ceci cela</span>
		</div>
		<form class="form-horizontal center-block" action="auto-evaluation-rechercher" method="get" onsubmit="return validateFormCreation(this)">
			<div class="form-group">
				<label for="date" class="col-sm-3 col-sm-offset-0 control-label">Date :</label>
				<div class="col-sm-9 col-sm-offset-0">
					<input type='text' class="form-control" data-format="DD/MM/YYYY" id='datetimepicker4' />
					<script type="text/javascript">
						$(function() {
							$('#datetimepicker4').datetimepicker({
								format : 'DD/MM/YYYY'
							});
						});
					</script>
				</div>
			</div>
			<div class="form-group">
				<label for="module" class="col-sm-3 col-sm-offset-0 control-label">Module :</label>
				<div id="module" class="col-sm-9 col-sm-offset-0">
					<select title="Module" name="stringModule" class="form-control" onchange="moduleSelected(this)">
						<option value="-1">Module...</option>
						<s:iterator value="Modules">
							<option value="<s:property value="identifiant" />"><s:property value="identifiant" /> -
								<s:property value="nomCourt" /></option>
						</s:iterator>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="sequence" class="col-sm-3 col-sm-offset-0 control-label">Séquence :</label>
				<div id="sequence" class="col-sm-9 col-sm-offset-0">
					<select title="Séquence" name="stringSequence" class="form-control">
						<option value="-1">Séquence...</option>
						<s:iterator value="Sequences">
							<option value="<s:property value="module.identifiant" />,<s:property value="identifiant" />"><s:property value="identifiant" /> -
								<s:property value="nomCourt" /></option>
						</s:iterator>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="competence" class="col-sm-3 col-sm-offset-0 control-label">Compétence :</label>
				<div id="competence" class="col-sm-9 col-sm-offset-0">
					<select title="Compétence" name="stringCompetence" class="form-control">
						<option value="-1">Compétence...</option>
						<s:iterator value="Competences">
							<option value="<s:property value="sequence.module.identifiant" />,<s:property value="sequence.identifiant" />,<s:property value="identifiant" />"><s:property value="identifiant" /> -
								<s:property value="nomCourt" /></option>
						</s:iterator>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="identifiantNiveauAcquisition" class="col-sm-3 col-sm-offset-0 control-label">Niveau d'acquisition :</label>
				<s:iterator value="NiveauAcquisitions">
					<div class="col-sm-3 col-sm-offset-0 radio">
						<label class="radio-inline"> <input type="radio" name="stringNiveauAcquisition" value="<s:property value="identifiant" />"> <s:property value="libelle" />
						</label>
					</div>
				</s:iterator>
			</div>
			<div class="form-group">
				<div class="col-sm-2 col-sm-offset-8">
					<button type="reset" class="btn btn-default">Annuler</button>
				</div>
				<div class="col-sm-2 col-sm-offset-0">
					<button type="submit" class="btn btn-default">Valider</button>
				</div>
			</div>
		</form>
		</section>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</html>