
/**
 * Fonctionnalité qui contrôle si le formulaire de creation,
 * d'une auto-evaluation est completes
 */
function validateFormCreation(form){
	
	console.log(form);
	
	return true;
}


function cleanRessenti(element){
	
	element.innerHTML = "";
	
}

/**
 * Affiche le nombre de caractère restant pour le commentaire et le passe de vert a rouge.
 */
function calculCaractereRestant(element){

	var nombreCharaRestant = 4000 - element.value.length;
	var pNombreCharaRestant = document.getElementById('nombre-caractere-restant');

	var red =  255 - Math.trunc((nombreCharaRestant/15.68627450980392));
	var green = Math.trunc((nombreCharaRestant/15.68627450980392));
	
	var plusRougeTueLeRouge = "color:rgb(" + red + ","+ green +",0)";
	
	pNombreCharaRestant.setAttribute("style", plusRougeTueLeRouge); 
	pNombreCharaRestant.innerHTML = nombreCharaRestant;
	
}