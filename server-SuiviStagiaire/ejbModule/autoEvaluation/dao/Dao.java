package autoEvaluation.dao;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import parametre.Parametre;

/**
 * Session Bean Dao qui permet l'insertion l'update et le delete dans la base de donn�es
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Stateless
@LocalBean
public class Dao implements DaoLocal {
	
	//TODO Externalis� la construction des message dans une classe et faire la construction des message LOG dans un LogRecord
	//TODO Deplac� Stagiaire etc dans les bon package/classe
	
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
	public void insertModule(Module module) throws DoublonException, NullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertModule");
		journaliseurNiveauConfig.log("[METHOD IN] Module : " + module);
		
		try{
			
			em.persist(module);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Module : " + module );
			
		}catch (Exception e) {
			resultat = false;
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertModule [Entity] Module : " + module.toString());
					
				}
			}else if(e instanceof NullPointerException){
				
				throw new NullException("insertModule [Entity] Module : " + module.toString());
				
			}else if(e instanceof IllegalArgumentException && (module == null || module.getIdentifiant() == null || module.getNomCourt() == null || module.getNomLong() == null)){
				
				throw new NullException("insertModule [Entity] Module : " + module.toString());
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertModule [Entity] Module : " + module + " [Exception] " +  e.getClass().getName() + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertModule " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertModule");
		
	}


	@SuppressWarnings("null")
	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertSequence");
		journaliseurNiveauConfig.log("[METHOD IN] Sequence : " + sequence);
		
		try{

			em.persist(sequence);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Sequence : " + sequence );
			
		}catch (Exception e ) {
			resultat = false;
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertSequence [Entity] Sequence : " + sequence.toString());
					
				}
				
			}else if(e instanceof NullPointerException){
				
				throw new NullException("insertSequence [Entity] Sequence : " + sequence.toString());
				
			}else if(e instanceof IllegalArgumentException && sequence == null){
				
				throw new NullException("insertSequence [Entity] Sequence :  " + sequence.toString());
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertSequence " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertSequence");
		
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertCompetence");
		journaliseurNiveauConfig.log("[METHOD IN] Competence : " + competence);
		
		try{

			em.persist(competence);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Competence : " + competence );
			
		}catch (Exception e ) {
			resultat = false;
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
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertCompetence " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertCompetence");
		
	}
	
	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertNiveauAcquisition");
		journaliseurNiveauConfig.log("[METHOD IN] NiveauAcquisition : " + niveauAcquisition);
		
		try{

			em.persist(niveauAcquisition);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  NiveauAcquisition : " + niveauAcquisition );
			
		}catch (Exception e ) {
			resultat = false;
			if(e instanceof PersistenceException){
				
				Throwable t = e.getCause();
			
				while ((t != null) && !(t instanceof SQLIntegrityConstraintViolationException)) {
					t = t.getCause();
				}
				
				if(t instanceof SQLIntegrityConstraintViolationException){
	
					throw new DoublonException("insertNiveauAcquisition");
					
				}
				
			}else if(e instanceof NullPointerException){
				
				throw new NullException("insertNiveauAcquisition");
				
			}else if(e instanceof IllegalArgumentException && niveauAcquisition == null){
				
				throw new NullException("insertNiveauAcquisition");
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertNiveauAcquisition " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertNiveauAcquisition");
	}
	
	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : insertStagiaire");
		journaliseurNiveauConfig.log("[METHOD IN] Stagiaire : " + stagiaire);
		
		try{

			em.persist(stagiaire);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Stagiaire : " + stagiaire );
			
		}catch (Exception e ) {
			resultat = false;
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
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : insertStagiaire " + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : insertStagiaire");
		
	}

	

	@Override
	public void updateModule(Module module) {
		
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateModule");
		journaliseurNiveauConfig.log("[METHOD IN] Module : " + module);
		
		try {
			
			em.merge(module);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Module : " + module );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateModule :" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateModule");
		
	}


	@Override
	public void updateSequence(Sequence sequence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateSequence");
		journaliseurNiveauConfig.log("[METHOD IN] Sequence : " + sequence);
		
		try {
			
			em.merge(sequence);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Sequence : " + sequence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateSequence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateSequence");
		
	}


	@Override
	public void updateCompetence(Competence competence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateCompetence");
		journaliseurNiveauConfig.log("[METHOD IN] Competence : " + competence);
		
		try {
			
			em.merge(competence);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Competence : " + competence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateCompetence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateCompetence");
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateNiveauAcquisition");
		journaliseurNiveauConfig.log("[METHOD IN] NiveauAcquisition : " + niveauAcquisition);
		
		try {
			
			em.merge(niveauAcquisition);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  NiveauAcquisition : " + niveauAcquisition);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateNiveauAcquisition" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateNiveauAcquisition");
		
	}


	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : updateStagiaire");
		journaliseurNiveauConfig.log("[METHOD IN] Stagiaire : " + stagiaire);
		
		try {
			
			em.merge(stagiaire);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Stagiaire : " + stagiaire);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] updateStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : updateStagiaire" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : updateStagiaire");
		
	}


	

	@Override
	public void deleteModule(Module module) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteModule ");
		journaliseurNiveauConfig.log("[METHOD IN] Module : " + module);
		
		try {
			
			Module module2 = selectModule(module);
			em.remove(module2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Module : " + module);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteModule" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteModule");
	}


	@Override
	public void deleteSequence(Sequence sequence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteSequence ");
		journaliseurNiveauConfig.log("[METHOD IN] Sequence : " + sequence);
		
		try {
			
			Sequence sequence2 = selectSequence(sequence);
			em.remove(sequence2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Sequence : " + sequence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteSequence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteSequence");
	}


	@Override
	public void deleteCompetence(Competence competence) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteCompetence ");
		journaliseurNiveauConfig.log("[METHOD IN] Competence : " + competence);
		
		try {
			
			Competence competence2 = selectCompetence(competence);
			em.remove(competence2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Competence : " + competence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteCompetence [Entity] " + competence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteCompetence" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteCompetence");
	}


	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteNiveauAcquisition ");
		journaliseurNiveauConfig.log("[METHOD IN] NiveauAcquisition : " + niveauAcquisition);
		
		try {
			
			NiveauAcquisition niveauAcquisition2 = selectNiveauAcquisition(niveauAcquisition);
			em.remove(niveauAcquisition2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  NiveauAcquisition : " + niveauAcquisition);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteNiveauAcquisition" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteNiveauAcquisition");
	}


	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		boolean resultat = true;
		journaliseurNiveauConfig.log("[DEBUT METHOD] : deleteStagiaire ");
		journaliseurNiveauConfig.log("[METHOD IN] Stagiaire : " + stagiaire);
		
		try {
			
			Stagiaire stagiaire2 = selectStagiaire(stagiaire);
			em.remove(stagiaire2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Stagiaire : " + stagiaire);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			resultat = false;
			journaliseurNiveauError.log("[METHOD] deleteStagiaire [Entity] " + stagiaire + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : deleteStagiaire" + resultat);
		journaliseurNiveauConfig.log("[FIN METHOD] : deleteStagiaire");
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectModule ");
		journaliseurNiveauConfig.log("[METHOD IN] Module : " + module);
		Module module2 = null;
		
		try{
			
			module2 = em.find(Module.class, module.getIdentifiant());
			journaliseurNiveauInfo.log("[Select]  Module [IN] : " + module + " Module [OUT] : " + module2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Module [IN] : " + module + " [MESSAGE] : NotFound" + " [Exception] " +  e.getClass().getName());
				throw new UnfoundException("selectModule");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Module [IN] : " + module + " [MESSAGE] : NotFound" + " [Exception] " +  e.getClass().getName());
				throw new UnfoundException("selectModule");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectModule " + module2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectModule");
		
		return module2; 
		
	}


	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectSequence ");
		journaliseurNiveauConfig.log("[METHOD IN] Sequence : " + sequence);
		Sequence sequence2 = null;
		
		try{
			
			sequence2 = em.find(Sequence.class, sequence.getIdentifiant());
			
			if(sequence2 == null){
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
			}
			
			journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " Sequence [OUT] : " + sequence2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectSequence" + sequence2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectSequence");
		
		return sequence2; 
	
	}


	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException{
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectCompetence ");
		journaliseurNiveauConfig.log("[METHOD IN] Competence : " + competence);
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
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectCompetence" + competence2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectCompetence");
		
		return competence2; 
		 	
	}


	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectNiveauAcquisition ");
		journaliseurNiveauConfig.log("[METHOD IN] NiveauAcquisition : " + niveauAcquisition);
		NiveauAcquisition niveauAcquisition2 = null;
		
		try{
			
			niveauAcquisition2 = em.find(NiveauAcquisition.class, niveauAcquisition.getIdentifiant());
			
			if(niveauAcquisition2 == null){
				journaliseurNiveauInfo.log("[Select]  NiveauAcquisition [IN] : " + niveauAcquisition + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectNiveauAcquisition");
			}
			
			journaliseurNiveauInfo.log("[Select]  NiveauAcquisition [IN] : " + niveauAcquisition + " NiveauAcquisition [OUT] : " + niveauAcquisition2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  NiveauAcquisition [IN] : " + niveauAcquisition + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectNiveauAcquisition");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  NiveauAcquisition [IN] : " + niveauAcquisition + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectNiveauAcquisition");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectNiveauAcquisition" + niveauAcquisition2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectNiveauAcquisition");
		
		return niveauAcquisition2; 
		
	}


	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		
		journaliseurNiveauConfig.log("[DEBUT METHOD] : selectStagiaire ");
		journaliseurNiveauConfig.log("[METHOD IN] Stagiaire : " + stagiaire);
		Stagiaire stagiaire2 = null;
		
		try{
			
			stagiaire2 = em.find(Stagiaire.class, stagiaire.getLogin());
			
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
			
		journaliseurNiveauConfig.log("[RESULTAT METHOD] : selectStagiaire" + stagiaire2);
		journaliseurNiveauConfig.log("[FIN METHOD] : selectStagiaire");
		
		return stagiaire2;  
		
	}

}
