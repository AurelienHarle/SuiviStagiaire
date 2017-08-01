/**
 * Fonctionnalité qui contrôle si le formulaire de creation, d'une
 * auto-evaluation est completes
 */
function validateFormCreation(element) {

	var competences = element.querySelectorAll('option');
	var competenceSelected = false;
	var niveauAcquisitions = element.querySelectorAll('input[type="radio"]');
	var niveauAcquisitionSelected = false;
	var ressenti = element.querySelector('textarea');
	var ressentiLength = false;
	var formValidate = false;

	for (var i = 0; i < competences.length; i++) {

		if (competences[i].selected && competences[i].value != "-1") {
			var competenceSelected = true;
			break;
		}

	}

	if (!competenceSelected)
		informationSelectionCompetence();
	else
		disableInformationSelectionCompetence();

	for (var i = 0; i < niveauAcquisitions.length; i++) {

		if (niveauAcquisitions[i].checked) {
			var niveauAcquisitionSelected = true;
			break;
		}

	}

	if (!niveauAcquisitionSelected)
		informationSelectionNiveauAcquisition();
	else
		disableInformationSelectionNiveauAcquisition();

	if (ressenti.value.length < 4000)
		ressentiLength = true;

	if (!ressentiLength)
		informationRessentiLength();
	else
		disableInformationRessentiLength();

	if (competenceSelected && niveauAcquisitionSelected && ressentiLength)
		formValidate = true;
	
	console.log(competenceSelected);
	console.log(niveauAcquisitionSelected);
	console.log(ressentiLength);
	console.log(formValidate);
	return formValidate;
}

/**
 * 
 * @param element
 * @returns
 */
function validateFormRecherche(element) {

	var date = document.getElementById('datetimepicker4');
	var module = element.querySelectorAll('select')[0];
	var sequence = element.querySelectorAll('select')[1];
	var competence = element.querySelectorAll('select')[2];
	var niveauAcquisition = element.querySelectorAll('input[type="radio"]');

	var formValide = false;
	var dateSelected = false;
	var moduleSelected = false;
	var sequenceSelected = false;
	var competenceSelected = false;
	var niveauAcquisitionSelected = false;

	if (date.value.length > 0) {
		dateSelected = true;
	}

	for (var i = 0; i < module.length; i++) {

		if (module[i].selected && module[i].value != "-1") {
			moduleSelected = true;
			break;
		}

	}

	for (var i = 0; i < sequence.length; i++) {

		if (sequence[i].selected && sequence[i].value != "-1") {
			sequenceSelected = true;
			break;
		}

	}

	for (var i = 0; i < competence.length; i++) {

		if (competence[i].selected && competence[i].value != "-1") {
			competenceSelected = true;
			break;
		}

	}

	for (var i = 0; i < niveauAcquisition.length; i++) {

		if (niveauAcquisition[i].checked) {
			niveauAcquisitionSelected = true;
			break;
		}

	}

	if (dateSelected || moduleSelected || sequenceSelected
			|| competenceSelected || niveauAcquisitionSelected)
		formValide = true;
	if (!formValide)
		informationRecherche();
	return formValide;

}

/**
 * Informe l'utilisateur qu'il dois sélectionner un element pour rechercher
 */
function informationRecherche() {

	document.querySelector("#info-recherche").style.display = "block";
	document.querySelectorAll('.form-group')[0].className = "form-group has-error";
	document.querySelectorAll('.form-group')[1].className = "form-group has-error";
	document.querySelectorAll('.form-group')[2].className = "form-group has-error";
	document.querySelectorAll('.form-group')[3].className = "form-group has-error";
	document.querySelectorAll('.form-group')[4].className = "form-group has-error";

}

/**
 * Informe l'utilisateur qu'il dois sélectionner une competence
 */
function informationSelectionCompetence() {

	document.querySelector("#info-competence").style.display = "block";
	document.querySelectorAll('.form-group')[0].className = "form-group has-error";

}

/**
 * Retire les information utilisateur qu'il dois sélectionner une competence
 */
function disableInformationSelectionCompetence() {

	document.querySelector("#info-competence").style.display = "none";
	document.querySelectorAll('.form-group')[0].className = "form-group";

}

/**
 * Informe l'utilisateur qu'il dois sélectionner un niveau d'acquisition
 */
function informationSelectionNiveauAcquisition() {

	document.querySelector("#info-niveau-acquisition").style.display = "block";
	document.querySelectorAll('.form-group')[1].className = "form-group has-error";
}

/**
 * Retire l'information utilisateur qu'il dois sélectionner un niveau
 * d'acquisition
 */
function disableInformationSelectionNiveauAcquisition() {

	document.querySelector("#info-niveau-acquisition").style.display = "none";
	document.querySelectorAll('.form-group')[1].className = "form-group";
}

/**
 * Informe l'utilisateur qu'il dois pas ecrire un ressenti de plus de 4000
 * caractere
 */
function informationRessentiLength() {

	document.querySelector("#info-ressenti").style.display = "block";
	document.querySelectorAll('.form-group')[2].className = "form-group has-error";

}

/**
 * Retire l'information utilisateur qu'il dois pas ecrire un ressenti de plus de
 * 4000 caractere
 */
function disableInformationRessentiLength() {

	document.querySelector("#info-ressenti").style.display = "none";
	document.querySelectorAll('.form-group')[2].className = "form-group";

}

/**
 * Vide le textArea ressenti
 * 
 * @param element
 *            TextArea
 */
function cleanRessenti(element) {

	element.innerHTML = "";

}

/**
 * Affiche le nombre de caractère restant pour le commentaire et le passe de
 * vert a rouge.
 */
function calculCaractereRestant(element) {

	var nombreCharaRestant = 4000 - element.value.length;

	if (nombreCharaRestant < 0)
		document.querySelectorAll('.form-group')[2].className = "form-group has-error";
	else
		document.querySelectorAll('.form-group')[2].className = "form-group";

	var pNombreCharaRestant = document
			.getElementById('nombre-caractere-restant');

	var red = 255 - Math.trunc((nombreCharaRestant / 15.68627450980392));
	var green = Math.trunc((nombreCharaRestant / 15.68627450980392));

	var plusRougeTueLeRouge = "color:rgb(" + red + "," + green + ",0)";

	pNombreCharaRestant.setAttribute("style", plusRougeTueLeRouge);
	pNombreCharaRestant.innerHTML = nombreCharaRestant;

}

/**
 * Demande a l'utilisateur si il est sur de vouloir supprimer une
 * auto-évaluation
 * 
 * @returns true if user click on yes
 */
function validationSuppression() {

	if (confirm("Etes vous sur de vouloir supprimer cette auto-evaluation?")) {
		var retour = true;
	} else {
		var retour = false;
	}

	return retour;
}

/**
 * Fonction qui creer une requette ajax si un module ou une sequence est selectionner afin de mettre a jour les sequence ou competence lié a la selection
 * 
 * @Param element Formulaire de recherche
 */
function ajaxRecherche(element) {

	//Récupere tout les elements options du formulaire
	var options = element.getElementsByTagName('option');

	//Controle celui qui est selectionné
	for (var i = 0; i < options.length; i++) {
		if (options[i].selected) {
			option = options[i];
			break;
		}
	}
	
	//Controle si c'est le boutton reset qui a apeller la fonction
	if (element.tagName == "BUTTON") {
		
		//Si c'est le bouton reset on creer une requete qui demande de retourné tout les module/sequence/competence
		var request = new Object();
		request.all = new Object();
		var jsonData = JSON.stringify(request);

	} else if (element.value != "-1") {
		//Si ce n'est pas le titre de l'option on recupere l'identifiant de l'option selectionné
		var identifiants = option.value.split(',');

		switch (identifiants.length) {
		
		//Si l'identifiant a une longueur de 1 on sais que c'est un module
		case 1:
		
			//Creation et stringyfication du module en objet JSon
			var module = new Object();
			module.identifiant = identifiants[0];
			var jsonData = JSON.stringify(module);

			break;
			
		//Si l'identifiant a une longueur de 2 on sais que c'est une sequence
		case 2:

			//Creation et stringyfication de la sequence en objet JSon
			var sequence = new Object();
			sequence.module = new Object();
			sequence.identifiant = identifiants[1];
			sequence.module.identifiant = identifiants[0];
			var jsonData = JSON.stringify(sequence);
			break;

		default:
			break;
		}

	}

	if (jsonData != null) {

		url = "../ajax/ajax-recherche";
		
		//Requete ajax
		$.ajax({

			url : url,
			data : {
				jsonData : jsonData
			},
			type : 'get',
			dataType : 'json',
			error : function() {
				message = "error";
			},
			success : function() {
				message = "success";
			},
			complete : function(data) {

				if (message == "success") {

					response = JSON.parse(data.responseText);
					updateView(response);
				}
			}
		})
	}
}

/**
 * Met a jour la page JSP avec les nouvelles informations reçu par ajax
 * 
 * @param response
 * @returns
 */
function updateView(response) {

	selects = document.getElementsByTagName("select");
	selectModule = selects[0]
	selectSequence = selects[1];
	selectCompetence = selects[2];

	if (response.modules != null) {

		while (selectModule.firstChild) {
			selectModule.removeChild(selectModule.firstChild);
		}

		var option = document.createElement("option");
		option.value = "-1";
		option.innerHTML = "Module...";
		selectModule.appendChild(option);
		for (var i = 0; i < response.modules.length; i++) {

			var option = document.createElement("option");
			option.value = response.modules[i].identifiant;
			option.innerHTML = response.modules[i].identifiant + " - "
					+ response.modules[i].nomCourt;
			selectModule.appendChild(option);

		}
	}

	if (response.sequences != null) {

		while (selectSequence.firstChild) {
			selectSequence.removeChild(selectSequence.firstChild);
		}

		var option = document.createElement("option");
		option.value = "-1";
		option.innerHTML = "S&eacute;quence...";
		selectSequence.appendChild(option);
		for (var i = 0; i < response.sequences.length; i++) {

			var option = document.createElement("option");
			option.value = response.sequences[i].module.identifiant + ","
					+ response.sequences[i].identifiant;
			option.innerHTML = response.sequences[i].identifiant + " - "
					+ response.sequences[i].nomCourt;
			selectSequence.appendChild(option);

		}

	}

	if (response.competences != null) {

		while (selectCompetence.firstChild) {
			selectCompetence.removeChild(selectCompetence.firstChild);
		}

		var option = document.createElement("option");
		option.value = "-1";
		option.innerHTML = "Comp&eacute;tence...";
		selectCompetence.appendChild(option);
		for (var i = 0; i < response.competences.length; i++) {

			var option = document.createElement("option");
			option.value = response.competences[i].sequence.module.identifiant
					+ "," + response.competences[i].sequence.identifiant
					+ " , " + response.competences[i].identifiant;
			option.innerHTML = response.competences[i].identifiant + " - "
					+ response.competences[i].nomCourt;
			selectCompetence.appendChild(option);

		}
	}

}

/**
 * Redirige les pages après 5 seconds
 */
function redirectSuccessPage() {

	url = window.location.href;

	switch (url) {
	case "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/auto-evaluation-creer":
		redirectUrl = "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/creation-auto-evaluation"
		break;
	case "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/auto-evaluation-modifier":
		redirectUrl = "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/modification-auto-evaluation"
		break;
	case "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/auto-evaluation-supprimer":
		redirectUrl = "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/suppression-auto-evaluation"
		break;
	default:
		redirectUrl = "http://localhost:8080/client-SuiviStagiaire/accueil"
		break;
	}

	if (url
			.startsWith("http://localhost:8080/client-SuiviStagiaire/auto-evaluation/auto-evaluation-rechercher"))
		redirectUrl = "http://localhost:8080/client-SuiviStagiaire/auto-evaluation/recherche-auto-evaluation"

	console.log(redirectUrl);
	var i = 5;
	setInterval(function() {
		i--;
		document.getElementById('seconde').innerHTML = i;
		if (i == 0) {
			window.location.replace(redirectUrl);
		}
	}, 1000)
}
