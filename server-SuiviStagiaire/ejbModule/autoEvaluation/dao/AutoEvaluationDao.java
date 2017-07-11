package autoEvaluation.dao;

import java.util.List;

import javax.ejb.EJB;
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
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import exception.UpdateNotInsertException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

/**
 * Session Bean implementation class AutoEvaluationDao
 */
@Stateless
@LocalBean
public class AutoEvaluationDao implements AutoEvaluationDaoLocal {

	private static final String PERSISTENCE_UNIT_NAME = "suiviStag";
    /**
     * Default constructor. 
     */
    public AutoEvaluationDao() {
       
    }
    
    @PersistenceContext(unitName=PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
    @EJB
	JournaliseurNiveauConfig journaliseurNiveauConfig;
    @EJB
	JournaliseurNiveauError journaliseurNiveauError;
    @EJB
	JournaliseurNiveauInfo journaliseurNiveauInfo;
	
	/**
	 * Contr�le et insert une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {

		AutoEvaluation autoEvaluation2 = null;

		try {

			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			if(autoEvaluation2 != null) throw new UpdateNotInsertException("insertAutoEvaluation");

		} catch (UpdateNotInsertException | UnfoundException e1) {

			if(e1 instanceof UpdateNotInsertException){

				updateAutoEvaluation(autoEvaluation);
				
			}else if(e1 instanceof UnfoundException){

				try{

					em.persist(autoEvaluation);
					em.flush();
					journaliseurNiveauInfo.log("[INSERT]  AutoEvaluation : " + autoEvaluation );

				}catch (Exception e) {

					if(e instanceof PersistenceException){
						
						if(e.getCause() != null){
							Throwable t = e.getCause();

							while (t != null) {
								
								if(t instanceof TransactionRequiredException){

									throw new NullException("insertAutoEvaluation [Exception] TransactionRequiredException [Entity] AutoEvaluation : " + autoEvaluation.toString());
								}else if(t instanceof ConstraintViolationException){

									throw new NullException("insertAutoEvaluation [Exception] ConstraintViolationException [Entity] AutoEvaluation : " + autoEvaluation.toString());
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
						
					}else if(e instanceof IllegalArgumentException){

						throw new NullException("insertAutoEvaluation [Exception] IllegalArgumentException [Entity] AutoEvaluation : Null ");
						
					}else{

						e.printStackTrace();
						journaliseurNiveauError.log("[METHOD] insertAutoEvaluation [Exception] Exception [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
						
					}
				}
				
			}
		}
	}
	
	/**
	 * Contr�le et update une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {

		AutoEvaluation autoEvaluation2 = null;
		
		try {

			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			autoEvaluation.setIdentifiant(autoEvaluation2.getIdentifiant());
			
			try {
				
				em.merge(autoEvaluation);
				em.flush();
				journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation );
				
			} catch (Exception e) {
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] updateAutoEvaluation [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}	
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	}
	
	/**
	 * Supprime une {@link AutoEvaluation} 
	 */
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
	
	/**
	 * Select une {@link AutoEvaluation} par son {@link identifiant}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation}
	 * @return autoEvaluation {@link AutoEvaluation}
	 * 
	 */
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation){
		
		autoEvaluation = em.find(AutoEvaluation.class, autoEvaluation.getIdentifiant());
		
		return autoEvaluation;
	}

	/**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contr�le
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {

		AutoEvaluation autoEvaluation2 = null;
		
		try {

			String sqlString = "select ae from AutoEvaluation ae where stag_osia = ?1 and comp_id = ?2 and ae_date = ?3";
			
			autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString)
				.setParameter(1, autoEvaluation.getStagiaire().getOsia())
				.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
				.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getSingleResult();

			journaliseurNiveauInfo.log("[Select]  AutoEvaluation [IN] : " + autoEvaluation + " AutoEvaluation [OUT] : " + autoEvaluation2);
			
		}catch (Exception e) {
			if(e instanceof PersistenceException){
				
				throw new UnfoundException("selectAutoEvaluation");

			}else if(e instanceof NullPointerException){

				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof IllegalArgumentException){

				throw new UnfoundException("selectAutoEvaluation");
				
			}else if(e instanceof NoResultException){

				throw new UnfoundException("selectAutoEvaluation");
				
			}else{

				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectAutoEvaluationByStagCompDate [Entity] " + autoEvaluation + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}

		return autoEvaluation2;
	}

	/**
	 * Recherche toute les {@link AutoEvaluation} d'un stagiaire
	 * @return {@link AutoEvaluations}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {

		String sqlString = "select ae from AutoEvaluation ae where stag_osia = ?1";
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		List list = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getOsia())
			.getResultList();
		
		for (Object object : list) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater,Module moduleRechercher,Sequence sequenceRechercher,Competence competenceRechercher,AutoEvaluation autoEvaluationNoter){
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		boolean precedentAjouter = false;
		String sqlString = "select ae from AutoEvaluation ae where ";
		
		if(autoEvaluationDater != null){
			sqlString = sqlString + "ae.dateAutoEvaluation = to_date('" + autoEvaluationDater.getDateAutoEvaluation() + "','YYYY-MM-DD')";
			precedentAjouter = true;
		}
		
		if(moduleRechercher != null){
			if(precedentAjouter){
				sqlString = sqlString + " and ";
			}
			sqlString = sqlString + "ae.competence.sequence.module.identifiant = '" + moduleRechercher.getIdentifiant() + "'";
			precedentAjouter = true;
		}
		
		if(sequenceRechercher != null){
			if(precedentAjouter){
				sqlString = sqlString + " and ";
			}
			sqlString = sqlString + "ae.competence.sequence.identifiant = '" + sequenceRechercher.getIdentifiant() + "'";
			precedentAjouter = true;
		}
		
		if(competenceRechercher != null){
			if(precedentAjouter){
				sqlString = sqlString + " and ";
			}
			sqlString = sqlString + "ae.competence.identifiant = '" + competenceRechercher.getIdentifiant()+ "'";
			precedentAjouter = true;
		}
		
		if(autoEvaluationNoter != null){
			if(precedentAjouter){
				sqlString = sqlString + " and ";
			}
			sqlString = sqlString + "ae.niveauAcquisition.identifiant = '" + autoEvaluationNoter.getNiveauAcquisition().getIdentifiant() + "'";
			precedentAjouter = true;
		}
		
		sqlString = sqlString + " order by ae.dateAutoEvaluation desc";
		
		List list = em.createQuery(sqlString).getResultList();
		
		for (Object object : list) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
		
	}

	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		AutoEvaluations autoEvaluations = new AutoEvaluations();

			String sqlString = "select ae from AutoEvaluation ae where stag_osia = ?1 and ae_date = ?2";
			
			@SuppressWarnings("rawtypes")
			List list = em.createQuery(sqlString)
				.setParameter(1, autoEvaluation.getStagiaire().getOsia())
				.setParameter(2, autoEvaluation.getDateAutoEvaluation()).getResultList();
			
			for (Object object : list) {
				autoEvaluations.add((AutoEvaluation)object);
			}

		return autoEvaluations;
	}
}
