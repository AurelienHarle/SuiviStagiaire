package autoEvaluation.dao;

import java.sql.SQLIntegrityConstraintViolationException;
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
	
    /**
     * Default constructor. 
     */
    public Dao() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException {
		
		try{
			
			System.out.println(autoEvaluation);
			em.persist(autoEvaluation);
			em.flush();
			
		}catch (PersistenceException | NullPointerException e ) {
			
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
		System.out.println("J'ai rien fait ici");
	}

	@Override
	public void updateModule(Module module) {
		System.out.println("J'ai rien fait ici");
		
	}


	@Override
	public void updateSequence(Sequence sequence) {
		System.out.println("J'ai rien fait ici");
		
	}


	@Override
	public void updateCompetence(Competence competence) {
		System.out.println("J'ai rien fait ici");
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		System.out.println("J'ai rien fait ici");
		
	}


	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		System.out.println("J'ai rien fait ici");
		
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


	@Override
	public AutoEvaluations selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) {
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from AutoEvaluation where stag_id = ? and comp_id = ? and ae_date = ?";
		
		@SuppressWarnings("rawtypes")
		List result = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin())
			.setParameter(2, autoEvaluation.getCompetence().getIdentifiant())
			.setParameter(3, autoEvaluation.getDateAutoEvaluation()).getResultList();
		
		for (Object object : result) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}


	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		
		AutoEvaluations autoEvaluations = new AutoEvaluations();
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from AutoEvaluation where stag_id = ? and comp_id = ?";
		
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
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from AutoEvaluation where stag_id = ?";
		
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
		
		String sqlString = "select ae_id,ae_date,ae_ressenti,comp_id,mod_id,na_id,seq_id,stag_id from AutoEvaluation where stag_id = ?";
		
		@SuppressWarnings("rawtypes")
		List result = em.createQuery(sqlString)
			.setParameter(1, autoEvaluation.getStagiaire().getLogin()).getResultList();
		
		for (Object object : result) {
			autoEvaluations.add((AutoEvaluation) object);
		}
		
		return autoEvaluations;
	}

}
