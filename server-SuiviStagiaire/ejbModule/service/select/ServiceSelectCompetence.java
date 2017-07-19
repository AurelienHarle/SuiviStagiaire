package service.select;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import competence.entity.Competence;
import competence.technique.Competences;
import entity.requete.Requete;
import exception.dao.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import sequence.entity.Sequence;

/**
 * Service de selection d'une {@link Competence}
 */
@Stateless
@LocalBean
public class ServiceSelectCompetence implements ServiceSelectCompetenceLocal {

	private static final String PERSISTENCE_UNIT_NAME = "suiviStag";

	@PersistenceContext(unitName=PERSISTENCE_UNIT_NAME)
	EntityManager em;
	@EJB
	JournaliseurNiveauConfig journaliseurNiveauConfig;
	@EJB
	JournaliseurNiveauError journaliseurNiveauError;
	@EJB
	JournaliseurNiveauInfo journaliseurNiveauInfo;

	/**
	 * Default constructor. 
	 */
	public ServiceSelectCompetence() {
	}

	/**
	 * Sélectionne une {@link Competence} de la table comp selon sa clé primaire.
	 */
	@Override
	public Competence selectCompetence(Requete requete) throws UnfoundException{

		final String HQL_STRING = "select c from Competence c where c.identifiant = ?1 and c.sequence.identifiant = ?2 and c.sequence.module.identifiant = ?3";
		
		Competence competence = (Competence) requete.getObject();
		Competence competence2 = null;
		
		try{

			competence2 = (Competence) em.createQuery(HQL_STRING)
					.setParameter(1, competence.getIdentifiant())
					.setParameter(2, competence.getSequence().getIdentifiant())
					.setParameter(3, competence.getSequence().getModule().getIdentifiant())
					.getSingleResult();

			if(competence2 == null){
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Competence [IN] : " + competence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
			}

			journaliseurNiveauInfo.log("[FacadeServiceSelect]  Competence [IN] : " + competence + " Competence [OUT] : " + competence2);

		}catch (Exception e) {
			if(e instanceof NullPointerException){

				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Competence [IN] : " + competence + "[Exception] : NullPointerException "  + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");

			}else if(e instanceof IllegalArgumentException){

				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Competence [IN] : " + competence + "[Exception] : IllegalArgumentException " + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");

			}else{

				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}

		return competence2; 

	}

	/**
	 * Sélectionne les {@link Competence} de la table comp selon la clé primaire d'un {@link Module}.
	 * @throws UnfoundException 
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetenceByModule(Requete requete) throws UnfoundException{

		final String SQL_STRING = "select c from Competence c where c.sequence.module.identifiant = ?1 ORDER BY c.identifiant asc";
		
		Module module = (Module) requete.getObject();
		Competences competences = new Competences();
		List list = null;
		
		try{

			list = em.createQuery(SQL_STRING).setParameter(1, module.getIdentifiant()).getResultList();

			if( (list.isEmpty()) || (list == null) ) throw new UnfoundException("selectCompetenceByModule");

		}catch(Exception e){

			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] selectCompetenceByModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());

		}

		for (Object object : list) {

			competences.add((Competence) object);

		}

		return competences;


	}

	/**
	 * Sélectionne les {@link Competence} de la table comp selon la clé primaire d'un {@link Sequence}.
	 * @throws UnfoundException 
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetenceBySequence(Requete requete) throws UnfoundException{

		Sequence sequence = (Sequence) requete.getObject();
		Competences competences = new Competences();
		List list = null;
		final String SQL_STRING = "select c from Competence c where c.sequence.identifiant = ?1 and c.sequence.module.identifiant = ?2 ORDER BY c.identifiant asc";

		try{

			list = em.createQuery(SQL_STRING)
					.setParameter(1, sequence.getIdentifiant())
					.setParameter(2, sequence.getModule().getIdentifiant())
					.getResultList();

			if( (list.isEmpty()) || (list == null) ) throw new UnfoundException("selectCompetenceByModule");

		}catch(Exception e){

			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] selectCompetenceByModule [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());

		}

		for (Object object : list) {

			competences.add((Competence) object);

		}

		return competences;


	}

	/**
	 * Sélectionne toute les {@link Competence} de la table comp.
	 * @throws UnfoundException
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetences() throws UnfoundException{

		Competences competences = new Competences();
		List list = null;
		String sqlQuery = "select c from Competence c ORDER BY c.identifiant asc";
		
		try{
			
			list = em.createQuery(sqlQuery).getResultList();
			
			if( (list.isEmpty()) || (list == null) ) throw new UnfoundException("selectCompetences");
			
		}catch(Exception e){

			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] selectCompetences [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());

		}

		for (Object object : list) {

			competences.add((Competence) object);

		}

		return competences;
	}

}
