package competence.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;

/**
 * Session Bean CompetenceDao qui permet l'insertion l'update et le delete dans la base de donn�es
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Stateless
@LocalBean
public class CompetenceDao implements CompetenceDaoLocal {
	
	//TODO Externalis� la construction des message dans une classe et faire la construction des message LOG dans un LogRecord

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
		
		try{
			
			competence2 = em.find(Competence.class, competence.getIdentifiant());
			
			if(competence2 == null){
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
			}
			
			journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " Competence [OUT] : " + competence2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectCompetence");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Competence [IN] : " + competence + " [MESSAGE] : NotFound");
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
