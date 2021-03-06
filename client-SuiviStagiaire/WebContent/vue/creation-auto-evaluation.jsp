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
		<section class="center-block" id="explication-creation-auto-evaluation">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Explication</h3>
			</div>
			<div class="panel-body">
				<span>Pour creer votre auto-�valuation, vous devez obligatoirement s�lectionner une comp�tence sur la quel vous d�sirez vous �valu�, ainsi que sp�cifiez le niveau d'acquisition que vous pensez avoir atteins. Vous pouvez aussi �crire votre ressenti sur cette comp�tence m�me si cela n'est pas obligatoire.</span>
			</div>
		</div>
		</section>
		<section id="creation-auto-evaluation" class="center-block">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Formulaire de cr�ation :</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal center-block" action="auto-evaluation-creer" method="post" onsubmit="return validateFormCreation(this)">
					<div class="form-group">
						<label for="competence" class="col-sm-3 col-sm-offset-0 control-label text-left">Comp�tence </label>
						<div id="competence" class="col-sm-9 col-sm-offset-0">
							<select title="Comp�tence" name="stringCompetence" class="form-control">
								<option value="-1">Comp�tence...</option>
								<s:iterator value="Competences">
									<option value="<s:property value="sequence.module.identifiant" />,<s:property value="sequence.identifiant" />,<s:property value="identifiant" />"><s:property value="identifiant" /> -
										<s:property value="nomCourt" /></option>
								</s:iterator>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="identifiantNiveauAcquisition" class="col-sm-3 col-sm-offset-0 control-label text-left">Niveau d'acquisition </label>
						<s:iterator value="NiveauAcquisitions">
							<div class="col-sm-3 col-sm-offset-0 radio">
								<label class="radio-inline"> <input type="radio" name="stringNiveauAcquisition" value="<s:property value="identifiant" />"> <s:property value="libelle" />
								</label>
							</div>
						</s:iterator>
					</div>
					<div class="form-group">
						<label for="ressenti" class="col-sm-3 col-sm-offset-0 control-label text-left">Ressenti </label>
						<div class="col-sm-9 col-sm-offset-0">
							<div id="caractere-restant">
								<label class="control-label" id="label-nombre-caractere-restant">Nombre de caract�re restant </label>
								<p id="nombre-caractere-restant">4000</p>
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
					</div>
				</form>
			</div>
		</div>
		</section>
		<section id="information-creation-auto-evaluation" class="center-block">
		<div id="info-competence" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement s�lectionner une comp�tence</span>
		</div>
		<div id="info-niveau-acquisition" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement s�lectionner un niveau d'acquisition</span>
		</div>
		<div id="info-ressenti" class="alert alert-danger" role="alert">
			<span>Attention : Vous devez obligatoirement �crire un ressenti de moins de 4000 caract�res</span>
		</div>
		</section>
	</div>
	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>