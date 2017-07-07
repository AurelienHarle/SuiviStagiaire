
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

/**
 * Demande a l'utilisateur si il est sur de vouloir supprimer une auto-évaluation
 * @returns true if user click on yes
 */
function validationSuppression(){
	
	if (confirm("&Ecirc;tes vous sur de vouloir supprimer cette auto-&eacute;valuation?")) {
	    var retour = true;
	} else {
		var retour = false;
	}
	
	return retour;
}

/**
 * 
 * @returns
 */
function ajaxRecherche(element){
	
	console.log('ajaxRecherche');
	console.log(element);
	var options = element.getElementsByTagName('option');
	console.log(options);
	
	for(var i = 0; i < options.length;i++){
		if(options[i].selected){
			option = options[i];
			break;
		}
	}
	
	if(option.value != "-1"){

		var identifiants = option.value.split(',');
		
		switch (identifiants.length) {
		case 1:
			var module = new Object();
			module.identifiant = identifiants[0];
			var jsonData = JSON.stringify(module);
			break;
		case 2:
			var sequence = new Object();
			sequence.module = new Object();
			sequence.identifiant = identifiants[1];
			sequence.module.identifiant = identifiants[0];
			var jsonData = JSON.stringify(sequence);
			break;
		default:
			break;
		}

		console.log(jsonData);
		
		url = "../ajax/ajax-recherche";
		
		$.ajax({
			
			url : url,
			data : {jsonData : jsonData},
			type : 'get',
			dataType : 'json',
			error : function(){message = "error";},
			success : function(){message = "success";},
			complete : function(data){
				
				console.log(message);
				console.log(data);
				console.log(data.responseText);
				
				if(message == "success"){
					
					console.log(data.responseText);
					response = JSON.parse(data.responseText);
					updateView(response);
				}
			}
		})
		
	}else{
		
		//ajax reclamant tout :3
		
	}
}

/**
 * Met a jour la page JSP avec les nouvelles informations reçu par ajax
 * 
 * @param response
 * @returns
 */
function updateView(response){
		
	selects = document.getElementsByTagName("select");
	selectSequence = selects[1];
	selectCompetence = selects[2];
	
	if(response.sequences != null){
		while (selectSequence.firstChild) {
			selectSequence.removeChild(selectSequence.firstChild);
		}
		
		var option = document.createElement("option");
		option.value =  "-1";
		option.innerHTML = "S&eacute;quence...";
		selectSequence.appendChild(option);
		for(var i = 0;i < response.sequences.length;i++){
			
			var option = document.createElement("option");
			option.value =  response.sequences[i].module.identifiant + "," + response.sequences[i].identifiant;
			option.innerHTML = response.sequences[i].identifiant + " - " +  response.sequences[i].nomCourt;
			selectSequence.appendChild(option);
			
		}
		
	}
	
	if(response.competences != null){
		while (selectCompetence.firstChild) {
			selectCompetence.removeChild(selectCompetence.firstChild);
		}
		
		
		var option = document.createElement("option");
		option.value =  "-1";
		option.innerHTML = "Comp&eacute;tence...";
		selectCompetence.appendChild(option);
		for(var i = 0;i < response.competences.length;i++){
			
			var option = document.createElement("option");
			option.value =  response.competences[i].sequence.module.identifiant 
							+ "," + response.competences[i].sequence.identifiant 
							+ " , " + response.competences[i].identifiant;
			option.innerHTML = response.competences[i].identifiant + " - " +  response.competences[i].nomCourt;
			selectCompetence.appendChild(option);
			
	}
	}
	
}