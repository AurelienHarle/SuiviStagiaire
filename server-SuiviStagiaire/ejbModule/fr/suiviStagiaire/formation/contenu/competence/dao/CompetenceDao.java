package fr.suiviStagiaire.formation.contenu.competence.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.competence.technique.Competences;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.logger.JournaliseurNiveauConfig;
import fr.suiviStagiaire.logger.JournaliseurNiveauError;
import fr.suiviStagiaire.logger.JournaliseurNiveauInfo;

/**
 * Session Bean CompetenceDao qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Stateless
@LocalBean
public class CompetenceDao implements CompetenceDaoLocal {
	
	//TODO Externalisé la construction des message dans une classe et faire la construction des message LOG dans un LogRecord

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
    public CompetenceDao() {
        
    }

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		
		try{

			em.persist(competence);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Competence : " + competence );
			
		}catch (Exception e ) {
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertCompetence");
					
				}
				
			}else if(e instanceof NullPointerException){
				
				throw new NullException("insertCompetence");
				
			}else if(e instanceof IllegalArgumentException && competence == null){
				
				throw new NullException("insertCompetence");
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}	
	}
	
	@Override
	public void updateCompetence(Competence competence) {
		
		try {
			
			em.merge(competence);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Competence : " + competence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] updateCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}		
	}

	@Override
	public void deleteCompetence(Competence competence) {

		try {
			
			Competence competence2 = selectCompetence(competence);
			em.remove(competence2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Competence : " + competence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}

	}


	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException{

		Competence competence2 = null;

		String hqlString = "select c from Competence c where c.identifiant = ?1 and c.sequence.identifiant = ?2 and c.sequence.module.identifiant = ?3";
		
		try{

			competence2 = (Competence) em.createQuery(hqlString)
				.setParameter(1, competence.getIdentifiant())
				.setParameter(2, competence.getSequence().getIdentifiant())
				.setParameter(3, competence.getSequence().getModule().getIdentifiant())
				.getSingleResult();

			if(competence2 == null){
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
			}
			
			journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " Competence [OUT] : " + competence2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + "[Exception] : NullPointerException "  + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + "[Exception] : IllegalArgumentException " + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}

		return competence2; 
		 	
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetenceByModule(Module module){
		
		Competences competences = new Competences();
		
		String sqlQuery = "select c from Competence c where c.sequence.module.identifiant = ?1 ORDER BY c.identifiant asc";
		
		List list = em.createQuery(sqlQuery).setParameter(1, module.getIdentifiant()).getResultList();
		
		for (Object object : list) {
			
			competences.add((Competence) object);
			
		}
		
		return competences;
		
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetenceBySequence(Sequence sequence){
		
		Competences competences = new Competences();
		
		String sqlQuery = "select c from Competence c where c.sequence.identifiant = ?1 and c.sequence.module.identifiant = ?2 ORDER BY c.identifiant asc";
		
		List list = em.createQuery(sqlQuery)
				.setParameter(1, sequence.getIdentifiant())
				.setParameter(2, sequence.getModule().getIdentifiant())
		.getResultList();
		
		for (Object object : list) {
			
			competences.add((Competence) object);
			
		}
		
		return competences;
		
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Competences selectCompetences(){
		
		Competences competences = new Competences();
		
		String sqlQuery = "select c from Competence c ORDER BY c.identifiant asc";
		
		List list = em.createQuery(sqlQuery).getResultList();
		
		for (Object object : list) {
			
			competences.add((Competence) object);
			
		}
		
		return competences;
	}

}
