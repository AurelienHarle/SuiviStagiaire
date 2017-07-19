package autoEvaluation.dao;

import java.sql.Date;
import java.time.LocalDate;
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
import exception.InsertNotUpdateException;
import exception.NullException;
import exception.UnfoundException;
import exception.UpdateNotInsertException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

/**
 * Class qui est la couche d'accées a la persistance des données elle regroupe toute les méthodes,
 * qui peuvent être rendu pour la persistance des données.
 * Implementation de {@link AutoEvaluationDaoLocal}
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 13/07/2017
 * 
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
	private EntityManager em;
    @EJB
    private JournaliseurNiveauConfig journaliseurNiveauConfig;
    @EJB
    private JournaliseurNiveauError journaliseurNiveauError;
    @EJB
    private JournaliseurNiveauInfo journaliseurNiveauInfo;
	
    /**
	 * FacadeApplication qui permet d'inséré une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
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

									throw new NullException("insertAutoEvaluation [Exception] TransactionRequiredException [Entity] AutoEvaluation : " + autoEvaluation);
									
								}else if(t instanceof ConstraintViolationException){

									throw new NullException("insertAutoEvaluation [Exception] ConstraintViolationException [Entity] AutoEvaluation : " + autoEvaluation);
								}
								
								t = t.getCause();
							}
						}
						
						if(autoEvaluation.getDateAutoEvaluation() == null){

							throw new DateNullException("insertAutoEvaluation [Exception] PersistenceException [Entity] AutoEvaluation : " + autoEvaluation);
							
						}
						
						e.printStackTrace();
						journaliseurNiveauError.log("[METHOD] insertAutoEvaluation  [Exception]  " +  e.getClass().getName() + " [Entity]  " + autoEvaluation  + " [StackTrace]  " + e.getMessage());
					
					}else if(e instanceof NullPointerException){

						throw new NullException("insertAutoEvaluation [Exception] NullPointerException [Entity] AutoEvaluation : " + autoEvaluation);
						
					}else if(e instanceof IllegalArgumentException){

						throw new NullException("insertAutoEvaluation [Exception] IllegalArgumentException [Entity] AutoEvaluation :  " + autoEvaluation);
						
					}else{

						e.printStackTrace();
						journaliseurNiveauError.log("[METHOD] insertAutoEvaluation  [Exception]  " +  e.getClass().getName() + " [Entity] " + autoEvaluation +  " [StackTrace] " + e.getMessage());
						
					}
				}
				
			}
		}
	}
	
	/**
	 * FacadeApplication qui permet d'facadeServiceUpdate une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceUpdate
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException  {
		AutoEvaluation autoEvaluation2 = null;
		
		try {
			if(autoEvaluation.getDateAutoEvaluation() != LocalDate.now()) throw new InsertNotUpdateException("updateAutoEvaluation");
			autoEvaluation2 = selectAutoEvaluationByStagCompDate(autoEvaluation);
			autoEvaluation.setIdentifiant(autoEvaluation2.getIdentifiant());
			
			try {
				
				em.merge(autoEvaluation);
				em.flush();
				journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation );
				
			} catch (Exception e) {
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] updateAutoEvaluation [Exception]  " +  e.getClass().getName()  +" [Entity] " + autoEvaluation + "  [StackTrace]  " + e.getMessage());
			
			}	
		} catch (Exception e) {
			if(e instanceof InsertNotUpdateException){
				
				
				insertAutoEvaluation(autoEvaluation);
				
				
			}
			e.printStackTrace();
			
		}
	}
	
	/**
	 * FacadeApplication qui permet de facadeServiceDelete une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceDelete
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
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à sa clé primaire dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation){
		
		autoEvaluation = em.find(AutoEvaluation.class, autoEvaluation.getIdentifiant());
		
		return autoEvaluation;
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {

		AutoEvaluation autoEvaluation2 = null;
		
		try {

			String sqlString = "facadeServiceSelect ae from AutoEvaluation ae where stag_osia = ?1 and comp_id = ?2 and ae_date = ?3";
			
			autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString)
				.setParameter(1, autoEvaluation.getStagiaire().getOsia())
				.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
				.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getSingleResult();

			journaliseurNiveauInfo.log("[FacadeServiceSelect]  AutoEvaluation [IN] : " + autoEvaluation + " AutoEvaluation [OUT] : " + autoEvaluation2);
			
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
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {

		String sqlString = "facadeServiceSelect ae from AutoEvaluation ae where stag_osia = ?1";
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		List list = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getOsia())
			.getResultList();
		
		for (Object object : list) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}
	
	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce au paramètre spécifié cela peux être
	 * la {@link Date} de l' {@link AutoEvaluation},
	 * la clé primaire du {@link Module},
	 * la clé primaire de la {@link Sequence},
	 * la clé primaire de la {@link Competence},
	 * ou le {@link NiveauAcquisition} de l' {@link AutoEvaluation}
	 * si l'un des paramètre est null, il seras pas pris en compte dans le facadeServiceSelect.
	 * dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluationDater {@link AutoEvaluation} l'autoEvaluation dater qui permet de facadeServiceSelect par la date.
	 * @param moduleRechercher {@link Module} le module qui permet le facadeServiceSelect par l'identifiant module
	 * @param sequenceRechercher {@link Sequence} la sequence qui permet le facadeServiceSelect par l'identifiant sequence
	 * @param competenceRechercher {@link Competence} la competence qui permet le facadeServiceSelect par l'identifiant competence
	 * @param autoEvaluationNoter {@link AutoEvaluation} le l'auto-évaluation noter qui permet le facadeServiceSelect par le {@link NiveauAcquisition}
	 * @return {@link AutoEvaluations} l'autoEvaluations la liste des autoEvaluations correspondant au facadeServiceSelect
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater,Module moduleRechercher,Sequence sequenceRechercher,Competence competenceRechercher,AutoEvaluation autoEvaluationNoter){
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		boolean precedentAjouter = false;
		String sqlString = "facadeServiceSelect ae from AutoEvaluation ae where ";
		
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

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		AutoEvaluations autoEvaluations = new AutoEvaluations();

			String sqlString = "facadeServiceSelect ae from AutoEvaluation ae where stag_osia = ?1 and ae_date = ?2";
			
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
