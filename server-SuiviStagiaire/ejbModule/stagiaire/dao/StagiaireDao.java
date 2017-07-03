package stagiaire.dao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import stagiaire.entity.Stagiaire;

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
public class StagiaireDao implements StagiaireDaoLocal {
	
	//TODO Externalisé la construction des message dans une classe et faire la construction des message LOG dans un LogRecord
	//TODO Deplacé Stagiaire etc dans les bon package/classe
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
    public StagiaireDao() {
        
    }

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		
		try{

			em.persist(stagiaire);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Stagiaire : " + stagiaire );
			
		}catch (Exception e ) {
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertStagiaire");
					
				}
				
			}else if(e instanceof NullPointerException){
				
				throw new NullException("insertStagiaire");
				
			}else if(e instanceof IllegalArgumentException && stagiaire == null){
				
				throw new NullException("insertStagiaire");
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}		
	}

	

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {

		try {
			
			em.merge(stagiaire);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Stagiaire : " + stagiaire);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] updateStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}

	}


	

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		
		try {
			
			Stagiaire stagiaire2 = selectStagiaire(stagiaire);
			em.remove(stagiaire2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Stagiaire : " + stagiaire);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}

	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {

		Stagiaire stagiaire2 = null;
		
		try{
			
			stagiaire2 = em.find(Stagiaire.class, stagiaire.getOsia());
			
			if(stagiaire2 == null){
				journaliseurNiveauInfo.log("[Select]  Stagiaire [IN] : " + stagiaire + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectStagiaire");
			}
			
			journaliseurNiveauInfo.log("[Select]  Stagiaire [IN] : " + stagiaire + " Stagiaire [OUT] : " + stagiaire2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Stagiaire [IN] : " + stagiaire + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectStagiaire");
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Stagiaire [IN] : " + stagiaire + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectStagiaire");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}

		return stagiaire2;  
		
	}

}
