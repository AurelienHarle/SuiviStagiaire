package facade.persistance.select;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import exception.requete.NullObjectException;
import exception.requete.NullSpecificationActionException;
import exception.requete.UndefinedObjectException;
import exception.requete.UndefinedSpecificationActionException;

/**
 * Session Bean implementation class FacadeServiceSelect
 */
@Stateless
@LocalBean
public class FacadeServiceSelect implements FacadeServiceSelectLocal {

    private static final String COMPETENCE = "Competence";
	private static final String SEQUENCE = "Sequence";
	private static final String MODULE = "Module";
	private static final String NIVEAU_ACQUISITION = "NiveauAcqusition";
	private static final String STAGIAIRE = "Stagiaire";
	private static final String AUTO_EVALUATION = "AutoEvaluation";
	
	
	private FacadeSelectCompetence facadeSelectCompetence;
	private FacadeSelectSequence facadeSelectSequence;
	private FacadeSelectModule facadeSelectModule;
	private FacadeSelectNiveauAcquisition facadeSelectNiveauAcquisition;
	private FacadeSelectStagiaire facadeSelectStagiaire;
	private FacadeSelectAutoEvaluation facadeSelectAutoEvaluation;

	/**
     * Default constructor. 
     */
    public FacadeServiceSelect() {
        // TODO Auto-generated constructor stub
    }

    /**
   	 * Contrôle vers quel service la requête dois être rediriger en utilisant pour ça le type de l'objet présent dans la requête.
   	 * 
   	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demandé elle dois contenir plus d'information.
     * @throws UndefinedObjectException 
     * @throws NullObjectException 
     * @throws UnfoundException 
     * @throws NullSpecificationActionException 
     * @throws UndefinedSpecificationActionException 
   	 * @throws {@link UndefinedActionException}
   	 */
	public void traite(Requete requete) throws UndefinedObjectException, NullObjectException, UnfoundException, UndefinedSpecificationActionException, NullSpecificationActionException {
		
		if(requete.getObject() == null) throw new NullObjectException();
		
		switch (requete.getObject().getClass().getName()) {
			case COMPETENCE:
				facadeSelectCompetence.traite(requete);
				break;
			case SEQUENCE:
				facadeSelectSequence.traite(requete);	
				break;
			case MODULE:
				facadeSelectModule.traite(requete);
				break;
			case NIVEAU_ACQUISITION:
				facadeSelectNiveauAcquisition.traite(requete);
				break;
			case STAGIAIRE:
				facadeSelectStagiaire.traite(requete);
				break;
			case AUTO_EVALUATION:
				facadeSelectAutoEvaluation.traite(requete);
				break;
			default:
				throw new UndefinedObjectException();
		}
		
	}

}
