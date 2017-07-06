
/**
 * Fonctionnalité qui contrôle si le formulaire de creation,
 * d'une auto-evaluation est completes
 */
function validateFormCreation(element){

	console.log('validateFormCreation');
	var competences = element.querySelectorAll('option');
	var competenceSelected = false;
	var niveauAcquisitions = element.querySelectorAll('input[type="radio"]');
	var niveauAcquisitionSelected = false;
	
	var formValidate = false;
	
	for(var i = 0; i < competences.length; i++){
		
		if(competences[i].selected){
			var competenceSelected = true;
			break;
		}
		
	}
	
	console.log('competenceSelected ' + competenceSelected);
	if(!competenceSelected) informationSelectionCompetence();
	
	for(var i = 0; i < niveauAcquisitions.length; i++){
		
		if(niveauAcquisitions[i].checked){
			var niveauAcquisitionSelected = true;
			break;
		}
		
	}
	
	console.log('niveauAcquisitionSelected ' + niveauAcquisitionSelected);
	if(!niveauAcquisitionSelected) informationSelectionNiveauAcquisition();
	
	if(competenceSelected && niveauAcquisitionSelected) formValidate = true;
	console.log('formValidate ' + formValidate);
	return formValidate;
}

/**
 * Informe l'utilisateur qu'il dois sélectionner une competence
 */
function informationSelectionCompetence(){
	
	console.log('informationSelectionCompetence ');
	document.querySelector("#info-competence").style.display = "block";
	document.querySelectorAll('.form-group')[0].className = "form-group has-error";
	
} 

/**
 * Informe l'utilisateur qu'il dois sélectionner un niveau d'acquisition
 */
function informationSelectionNiveauAcquisition(){
	console.log('informationSelectionNiveauAcquisition ');
	document.querySelector("#info-niveau-acquisition").style.display = "block";
	document.querySelectorAll('.form-group')[1].className = "form-group has-error";
}

/**
 * Vide le textArea ressenti
 * 
 * @param element TextArea
 */
function cleanRessenti(element){
	
	element.innerHTML = "";
	
}

/**
 * Affiche le nombre de caractère restant pour le commentaire et le passe de vert a rouge.
 */
function calculCaractereRestant(element){

	var nombreCharaRestant = 4000 - element.value.length;
	
	if (nombreCharaRestant < 0 ) document.querySelectorAll('.form-group')[2].className = "form-group has-error";
	else document.querySelectorAll('.form-group')[2].className = "form-group";
	
	var pNombreCharaRestant = document.getElementById('nombre-caractere-restant');

	var red =  255 - Math.trunc((nombreCharaRestant/15.68627450980392));
	var green = Math.trunc((nombreCharaRestant/15.68627450980392));
	
	var plusRougeTueLeRouge = "color:rgb(" + red + ","+ green +",0)";
	
	pNombreCharaRestant.setAttribute("style", plusRougeTueLeRouge); 
	pNombreCharaRestant.innerHTML = nombreCharaRestant;
	
}

function validationSuppression(){
	
	if (confirm("Êtes vous sur de vouloir supprimer cette auto-évaluation?")) {
	    var retour = true;
	} else {
		var retour = false;
	}
	
	return retour;
}