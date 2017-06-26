package autoEvaluation.dao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import parametre.Parametre;

/**
 * Session Bean implementation class AutoEvaluationDao
 */
@Stateless
@LocalBean
public class AutoEvaluationDao implements AutoEvaluationDaoLocal {

	//TODO CHECK LOGGER 
    /**
     * Default constructor. 
     */
    public AutoEvaluationDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName=Parametre.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();
	JournaliseurNiveauError journaliseurNiveauError = JournaliseurNiveauError.getINSTANCE();
	JournaliseurNiveauInfo journaliseurNiveauInfo = JournaliseurNiveauInfo.getINSTANCE();
	
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException, DateNullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertAutoEvaluation");
		journaliseurNiveauConfig.log("[METHOD IN] AutoEvaluation : " + autoEvaluation);
		AutoEvaluation autoEvaluation2 = null;
		
		journaliseurNiveauConfig.log("[TRY] selectAutoEvaluationByStagCompDate");
		try {
			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
		} catch (UnfoundException e1) {
			
			journaliseurNiveauConfig.log("[CATCH] selectAutoEvaluationByStagCompDate");
			e1.printStackTrace();
			
		}
		
		journaliseurNiveauConfig.log("[FIN TRY] selectAutoEvaluationByStagCompDate");
		
		if(autoEvaluation2 != null){
			
			updateAutoEvaluation(autoEvaluation);
			
		}else{
			
			journaliseurNiveauConfig.log("[TRY] persist");
			try{

				em.persist(autoEvaluation);
				em.flush();
				journaliseurNiveauInfo.log("[INSERT]  AutoEvaluation : " + autoEvaluation );
				
			}catch (Exception e) {
				//journaliseurNiveauConfig.log("[CATCH] persist [Exception] " + e);
				resultat = false;
				if(e instanceof PersistenceException){
					
					journaliseurNiveauConfig.log("[CATCH] persist [Exception] " + e + "[Instance] PersistenceException");
					journaliseurNiveauConfig.log("[CONDITION] e.getCause() != null " + (e.getCause() != null));
					
					if(e.getCause() != null){
						Throwable t = e.getCause();
						while (t != null) {
							
							journaliseurNiveauConfig.log("[WHILE][CATCH] persist  [Exception] " + e + "[Instance] PersistenceException [CAUSE] " + t + "[Message] " + t.getMessage());
							
							if(t instanceof SQLIntegrityConstraintViolationException){
								
								throw new DoublonException("insertAutoEvaluation [Exception] SQLIntegrityConstraintViolationException [Entity] AutoEvaluation  " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage() + " [Cause] " + t.getMessage());
							
							}else if(t instanceof TransactionRequiredException){
								throw new NullException("insertAutoEvaluation [Exception] TransactionRequiredException [Entity] AutoEvaluation : " + autoEvaluation.toString());
							}
							
							t = t.getCause();
						}
					}
					
					if(autoEvaluation.getDateAutoEvaluation() == null){
						throw new DateNullException("insertAutoEvaluation [Exception] PersistenceException [Entity] AutoEvaluation : " + autoEvaluation);
					}
					e.printStackTrace();
					journaliseurNiveauError.log("[METHOD] insertAutoEvaluation  [Exception] PersistenceException [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
				
				}else if(e instanceof NullPointerException){
					
					throw new NullException("insertAutoEvaluation [Exception] NullPointerException [Entity] AutoEvaluation : " + autoEvaluation.toString());
					
				}else if(e instanceof IllegalArgumentException && autoEvaluation == null){
					
					throw new NullException("insertAutoEvaluation [Exception] IllegalArgumentException [Entity] AutoEvaluation : Null ");
					
				}else if(e instanceof TransactionRequiredException){
					
					journaliseurNiveauConfig.log("[CATCH] persist [Exception] " + e + "[Instance] TransactionRequiredException");
					throw new NullException("insertAutoEvaluation [Exception] TransactionRequiredException [Entity] AutoEvaluation : " + autoEvaluation.toString());
				
				}else{
					
					e.printStackTrace();
					journaliseurNiveauError.log("[METHOD] insertAutoEvaluation [Exception] Exception [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
					
				}
			}
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertAutoEvaluation " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertAutoEvaluation");
	}
	
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateAutoEvaluation");
		journaliseurNiveauConfig.log("[METHOD IN] AutoEvaluation : " + autoEvaluation);
		
		AutoEvaluation autoEvaluation2 = null;
		
		try {
			
			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			
		} catch (UnfoundException | NullException e1) {
			
			e1.printStackTrace();
			
		}
		
		if(autoEvaluation2 != null){
			autoEvaluation.setIdentifiant(autoEvaluation2.getIdentifiant());
			
			try {
				
				em.merge(autoEvaluation);
				em.flush();
				journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation );
				
			} catch (Exception e) {
				
				e.printStackTrace();
				resultat = false;
				journaliseurNiveauError.log("[METHOD] updateAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}	
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateAutoEvaluation " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateAutoEvaluation");
		
	}
	
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteAutoEvaluation");
		journaliseurNiveauConfig.log("[METHOD IN] AutoEvaluation : " + autoEvaluation);
		
		try {
			
			AutoEvaluation autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			em.remove(autoEvaluation2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteAutoEvaluation " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteAutoEvaluation");
	}
	
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) throws UnfoundException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectAutoEvaluation ");
		journaliseurNiveauConfig.log("[METHOD IN] AutoEvaluation : " + autoEvaluation);
		AutoEvaluation autoEvaluation2 = null;
		
		try{
			
			autoEvaluation2 = em.find(AutoEvaluation.class, autoEvaluation.getIdentifiant());
			
			if(autoEvaluation2 == null){
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectAutoEvaluation");
			}
			
			journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " AutoEvaluation [OUT] : " + autoEvaluation2);
			
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectAutoEvaluation");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectAutoEvaluation " + autoEvaluation2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectAutoEvaluation");
		
		return autoEvaluation2;
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectAutoEvaluationByStagCompDate ");
		journaliseurNiveauConfig.log("[METHOD IN] AutoEvaluation : " + autoEvaluation);
		AutoEvaluation autoEvaluation2 = null;
		
		try {
			
			String sqlString = "select ae from AutoEvaluation ae where stag_id = ?1 and comp_id = ?2 and ae_date = ?3";
			
			autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString)
				.setParameter(1, autoEvaluation.getStagiaire().getLogin())
				.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
				.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getSingleResult();
			
			if(autoEvaluation2 == null){
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectAutoEvaluationByStagCompDate");
			}
			
			journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " AutoEvaluation [OUT] : " + autoEvaluation2);
			
		}catch (Exception e) {
			if(e instanceof PersistenceException){

				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound Enity null");
				throw new UnfoundException("selectAutoEvaluation");

			}else if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound Enity null");
				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound Enity null");
				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof NoResultException){
				
				journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectAutoEvaluation");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectAutoEvaluationByStagCompDate [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectAutoEvaluationByStagCompDate " + autoEvaluation2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectAutoEvaluationByStagCompDate");
		return autoEvaluation2;
	}
	
	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(AutoEvaluation autoEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByComp(AutoEvaluation autoEvaluation) {
		// TODO Auto-generated method stub
		return null;
	}


}
