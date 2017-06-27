package autoEvaluation.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import org.hibernate.exception.ConstraintViolationException;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import exception.UpdateNotInsertException;
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

	//TODO REFAIRE MESSAGE LOGGER
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
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		String trace = "";
		trace = trace + "[insertAutoEvaluation] " + autoEvaluation.getRessenti();
		AutoEvaluation autoEvaluation2 = null;
		
		//Select de test pour savoir si l'auto eval existe si elle existe on update sinon on insert
		try {
			
			trace = trace + "[Try select]";
			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			if(autoEvaluation2 != null) throw new UpdateNotInsertException("insertAutoEvaluation");
			
			trace = trace + "[Pas de catch select]";
			
		} catch (UpdateNotInsertException | UnfoundException e1) {
			trace = trace + "[catch select]";

			if(e1 instanceof UpdateNotInsertException){
				trace = trace + "[UpdateNotInsertException]";
				updateAutoEvaluation(autoEvaluation);
				
			}else if(e1 instanceof UnfoundException){
				trace = trace + "[UnfoundException]";
				try{
					trace = trace + "[Try persist]";
					em.persist(autoEvaluation);
					em.flush();
					journaliseurNiveauInfo.log("[INSERT]  AutoEvaluation : " + autoEvaluation );
					trace = trace + "[Pas de catch persist]";
				}catch (Exception e) {
					trace = trace + "[catch persist]";
					if(e instanceof PersistenceException){
						trace = trace + "[PersistenceException]";
						
						Throwable test = e.getCause();
						//Test
						while(!(test instanceof TransactionRequiredException)){
							journaliseurNiveauConfig.log("[T] : " + test);
							test = test.getCause();
						}
						
						if(e.getCause() != null){
							Throwable t = e.getCause();
							trace = trace + "[Cause]" + t;
							while (t != null) {
								
								if(t instanceof TransactionRequiredException){
									trace = trace + "[TransactionRequiredException]";
									throw new NullException("insertAutoEvaluation [Exception] TransactionRequiredException [Entity] AutoEvaluation : " + autoEvaluation.toString());
								}else if(t instanceof ConstraintViolationException){
									trace = trace + "[ConstraintViolationException]";
									throw new NullException("insertAutoEvaluation [Exception] ConstraintViolationException [Entity] AutoEvaluation : " + autoEvaluation.toString());
								}
								
								t = t.getCause();
							}
						}
						
						if(autoEvaluation.getDateAutoEvaluation() == null){
							trace = trace + "[Date Null]";
							throw new DateNullException("insertAutoEvaluation [Exception] PersistenceException [Entity] AutoEvaluation : " + autoEvaluation);
						}
						
						e.printStackTrace();
						journaliseurNiveauError.log("[METHOD] insertAutoEvaluation  [Exception] PersistenceException [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
					
					}else if(e instanceof NullPointerException){
						trace = trace + "[NullPointerException]";
						throw new NullException("insertAutoEvaluation [Exception] NullPointerException [Entity] AutoEvaluation : " + autoEvaluation.toString());
						
					}else if(e instanceof IllegalArgumentException){
						trace = trace + "[IllegalArgumentException]";
						throw new NullException("insertAutoEvaluation [Exception] IllegalArgumentException [Entity] AutoEvaluation : Null ");
						
					}else{
						trace = trace + "[Exception]" + e;
						e.printStackTrace();
						journaliseurNiveauError.log("[METHOD] insertAutoEvaluation [Exception] Exception [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
						
					}
				}
				
			}
			
			trace = trace + "[Fin]";
			journaliseurNiveauConfig.log(trace);
		}
	}
	
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		String trace = "";
		trace = trace + "[updateAutoEvaluation] " + autoEvaluation.getRessenti();
		AutoEvaluation autoEvaluation2 = null;
		
		try {
			trace = trace + "[try select]";
			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			trace = trace + "[Pas de catch select]";
			
			autoEvaluation.setIdentifiant(autoEvaluation2.getIdentifiant());
			
			try {
				
				trace = trace + "[try update]";
				em.merge(autoEvaluation);
				em.flush();
				journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation );
				trace = trace + "[Pas de catch update]";
				
			} catch (Exception e) {
				trace = trace + "[Exception]" + e;
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] updateAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}	
		} catch (Exception e) {

			trace = trace + "[Exception]" + e;
			e.printStackTrace();
			
		}
		trace = trace + "[Fin]";
		journaliseurNiveauConfig.log(trace);
	}
	
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		
		try {
			
			AutoEvaluation autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			em.remove(autoEvaluation2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {

		String trace = "";
		trace = trace + "[selectAutoEvaluationByStagCompDate] " + autoEvaluation.getRessenti();
		
		AutoEvaluation autoEvaluation2 = null;
		
		try {
			
			trace = trace + "[Try SQL select]";
			String sqlString = "select ae from AutoEvaluation ae where stag_osia = ?1 and comp_id = ?2 and ae_date = ?3";
			
			autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString)
				.setParameter(1, autoEvaluation.getStagiaire().getOsia())
				.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
				.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getSingleResult();

			journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " AutoEvaluation [OUT] : " + autoEvaluation2);
			trace = trace + "[Pas de catch]";
			
		}catch (Exception e) {
			if(e instanceof PersistenceException){
				trace = trace + "[PersistenceException]";
				throw new UnfoundException("selectAutoEvaluation");

			}else if(e instanceof NullPointerException){
				trace = trace + "[NullPointerException]";
				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof IllegalArgumentException){
				trace = trace + "[IllegalArgumentException]";
				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof NoResultException){
				trace = trace + "[NoResultException]";
				throw new UnfoundException("selectAutoEvaluation");
				
			}else{
				trace = trace + "[Exception]" + e;
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectAutoEvaluationByStagCompDate [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}
		
		trace = trace + "[Fin]";
		journaliseurNiveauConfig.log(trace);
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
