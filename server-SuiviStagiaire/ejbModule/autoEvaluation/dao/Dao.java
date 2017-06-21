package autoEvaluation.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import parametre.Parametre;

/**
 * Session Bean Dao qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Stateless
@LocalBean
public class Dao implements DaoLocal {
	
	@PersistenceContext(unitName=Parametre.PERSISTENCE_UNIT_NAME)
	EntityManager em;
	
	JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();
	JournaliseurNiveauError journaliseurNiveauError = JournaliseurNiveauError.getINSTANCE();
	JournaliseurNiveauInfo journaliseurNiveauInfo = JournaliseurNiveauInfo.getINSTANCE();
	
    /**
     * Default constructor. 
     */
    public Dao() {
        
    }


	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException {

		journaliseurNiveauConfig.log("[Debut methode] : insertAutoEvaluation| [autoEvaluation IN] : " + autoEvaluation);
		
		//AutoEvaluation autoEvaluationVerifDate = selectAutoEvaluationByStagCompDate(autoEvaluation);
		
		//journaliseurNiveauConfig.log("autoEvaluationVerifDate : " + autoEvaluationVerifDate);
		
		//if(autoEvaluationVerifDate == null){
			
			try{
				
				journaliseurNiveauConfig.log("Avant Persit : " + autoEvaluation);
				em.persist(autoEvaluation);
				em.flush();
				journaliseurNiveauConfig.log("après Persit : " + autoEvaluation);
				
			}catch (PersistenceException | NullPointerException e ) {
				journaliseurNiveauConfig.log("EXCEPTION : " + e);
				e.printStackTrace();
				
				if(e instanceof PersistenceException){
					
					Throwable t = e.getCause();
				
					while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
						t = t.getCause();
					}
					
					if(t instanceof SQLIntegrityConstraintViolationException){
		
						throw new DoublonException("insertAutoEval");
						
					}
					
				}else{
					
					throw new NullException("insertAutoEval");
					
				}
			}
//		}else{
//		
//			updateAutoEvaluation(autoEvaluation);
//			
//		}
		journaliseurNiveauConfig.log("[Fin methode] : insertAutoEvaluation");
	}


	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		
		try{
			
			System.out.println(module);
			em.persist(module);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
			
			e.printStackTrace();
			
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertModule");
					
				}
				
			}else{
				
				throw new NullException("insertModule");
				
			}
		}
		
	}


	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		
		try{
			
			System.out.println(sequence);
			em.persist(sequence);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
			
			e.printStackTrace();
			
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertSequence");
					
				}
				
			}else{
				
				throw new NullException("insertSequence");
				
			}
		}
		
	}


	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		
		try{
			
			System.out.println(competence);
			em.persist(competence);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
						
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
				
			}

			e.printStackTrace();
			
		}
		
	}
	
	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		
		try{
			
			System.out.println(niveauAcquisition);
			em.persist(niveauAcquisition);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
			
			e.printStackTrace();
			
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertCompetence");
					
				}
				
			}else{
				
				throw new NullException("insertCompetence");
				
			}
		}
		
	}
	
	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		
		try{
			
			System.out.println(stagiaire);
			em.persist(stagiaire);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
			
			e.printStackTrace();
			
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertCompetence");
					
				}
				
			}else{
				
				throw new NullException("insertCompetence");
				
			}
		}
		
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateAutoEvaluation");
		journaliseurNiveauConfig.log("[METHOD IN] autoEvaluation : " + autoEvaluation);
		
		autoEvaluation = selectAutoEvaluationByStagCompDate(autoEvaluation);
		
		try {
			
			em.merge(autoEvaluation);
			journaliseurNiveauInfo.log("[UPDATE]  AutoEvaluation : " + autoEvaluation );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + autoEvaluation + " [StackTrace] " + e.getMessage());
		
		}	
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateAutoEvaluation" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateAutoEvaluation");
		
	}

	@Override
	public void updateModule(Module module) {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateModule");
		journaliseurNiveauConfig.log("[METHOD IN] module : " + module);
		
		try {
			
			em.merge(module);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + module + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateModule :" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateModule");
		
	}


	@Override
	public void updateSequence(Sequence sequence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateSequence");
		journaliseurNiveauConfig.log("[METHOD IN] sequence : " + sequence);
		
		try {
			
			em.merge(sequence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + sequence + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateSequence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateSequence");
		
	}


	@Override
	public void updateCompetence(Competence competence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateCompetence");
		journaliseurNiveauConfig.log("[METHOD IN] autoEvaluation : " + competence);
		
		try {
			
			em.merge(competence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + competence + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateCompetence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateCompetence");
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateNiveauAcquisition");
		journaliseurNiveauConfig.log("[METHOD IN] autoEvaluation : " + niveauAcquisition);
		
		try {
			
			em.merge(niveauAcquisition);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + niveauAcquisition + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateNiveauAcquisition" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateNiveauAcquisition");
		
	}


	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateAutoEvaluation");
		journaliseurNiveauConfig.log("[METHOD IN] autoEvaluation : " + stagiaire);
		
		try {
			
			em.merge(stagiaire);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Module] " + stagiaire + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateAutoEvaluation" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateAutoEvaluation");
		
	}


	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		em.remove(autoEvaluation);
		em.flush();
	}

	@Override
	public void deleteModule(Module module) {
		em.remove(module);
		em.flush();
	}


	@Override
	public void deleteSequence(Sequence sequence) {
		em.remove(sequence);
		em.flush();
	}


	@Override
	public void deleteCompetence(Competence competence) {
		em.remove(competence);
		em.flush();
	}


	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		em.remove(niveauAcquisition);
		em.flush();
	}


	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		em.remove(stagiaire);
		em.flush();
	}


	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return em.find(AutoEvaluation.class, autoEvaluation.getIdentifiant());
	}


	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {

		String sqlString = "select ae from AutoEvaluation ae where ae_date = ?1 and ae_ressenti = ?2 and comp_id = ?3 and mod_id = ?4 and na_id = ?5 and seq_id = ?6 and stag_id = ?7";

		
		AutoEvaluation autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString).setParameter(1, autoEvaluation.getDateAutoEvaluation())
		.setParameter(2, autoEvaluation.getRessenti())
		.setParameter(3, autoEvaluation.getCompetence().getIdentifiant())
		.setParameter(4, autoEvaluation.getModule().getIdentifiant())
		.setParameter(5, autoEvaluation.getNiveauAcquisition().getIdentifiant())
		.setParameter(6, autoEvaluation.getSequence().getIdentifiant())
		.setParameter(7, autoEvaluation.getStagiaire().getLogin()).getSingleResult();
		
		return autoEvaluation2;
	}


	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) {
		
		journaliseurNiveauConfig.log("[Debut methode] : selectAutoEvaluationByStagCompDate ");
		journaliseurNiveauConfig.log("[AutoEvaluation IN] : " + autoEvaluation);
		
		AutoEvaluation autoEvaluation2 = null;
		
//		String sqlString = "select identifiant,dateAutoEvaluation,ressenti,competence,module,niveauAcquisition,sequence,stagiaire"
//							+ " from AutoEvaluation"
//								+ " where stag_id = ?"
//								+ " and comp_id = ?"
//								+ " and ae_date = ?";
		
		String sqlString = "select ae"
						+ " from AutoEvaluation ae"
							+ " where stag_id = ?1"
							+ " and comp_id = ?2"
							+ " and ae_date = ?3";

		autoEvaluation2 = (AutoEvaluation) em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin())
			.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
			.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getSingleResult();

		journaliseurNiveauConfig.log("AutoEvaluation OUT : " + autoEvaluation2);
		journaliseurNiveauConfig.log("[Fin methode] : selectAutoEvaluationByStagCompDate ");
		return autoEvaluation2;
		
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from " + autoEvaluation.getClass().getName() + " where stag_id = ? and comp_id = ?";
		
		@SuppressWarnings("rawtypes")
		List result = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin())
			.setParameter(2, autoEvaluation.getCompetence().getIdentifiant()).getResultList();
		
		for (Object object : result) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		//TODO (persist/delete/find) generalisé grace class name
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from " + autoEvaluation.getClass().getName() + " where stag_id = ?";
		
		@SuppressWarnings("rawtypes")
		List result = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin()).getResultList();
		
		for (Object object : result) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByComp(AutoEvaluation autoEvaluation) {
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from " + autoEvaluation.getClass().getName() + " where stag_id = ?";
		
		@SuppressWarnings("rawtypes")
		List result = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin()).getResultList();
		
		for (Object object : result) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}


	@Override
	public Module selectModule(Module module) {
		return em.find(Module.class, module.getIdentifiant());
		
	}


	@Override
	public Sequence selectSequence(Sequence sequence) {
		return em.find(Sequence.class, sequence.getIdentifiant());
		
	}


	@Override
	public Competence selectCompetence(Competence competence) {
		return em.find(Competence.class, competence.getIdentifiant());
		
	}


	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		return em.find(NiveauAcquisition.class, niveauAcquisition.getIdentifiant());
		
	}


	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) {
		return em.find(Stagiaire.class, stagiaire.getLogin());
		
	}

}
