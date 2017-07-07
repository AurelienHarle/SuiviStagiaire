package sequence.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import competence.entity.Competence;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

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
public class SequenceDao implements SequenceDaoLocal {
	
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
    public SequenceDao() {
    }

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		
		try{

			em.persist(sequence);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Sequence : " + sequence );
			
		}catch (Exception e ) {
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
				
				throw new NullException("insertSequence [Entity] Sequence : Null ");
				
			}else{
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] insertSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}
		
	}

	@Override
	public void updateSequence(Sequence sequence) {
		
		try {
			
			em.merge(sequence);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Sequence : " + sequence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] updateSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
	}


	@Override
	public void deleteSequence(Sequence sequence) {

		try {
			
			Sequence sequence2 = selectSequence(sequence);
			em.remove(sequence2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Sequence : " + sequence);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
	}


	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {

		Sequence sequence2 = null;

		String hqlString = "select s from Sequence s where s.identifiant = ?1 and s.module.identifiant = ?2";
		
		try{

			sequence2 = (Sequence) em.createQuery(hqlString)
				.setParameter(1, sequence.getIdentifiant())
				.setParameter(2, sequence.getModule().getIdentifiant())
				.getSingleResult();

			if(sequence2 == null){
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
			}
			
			journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + " Sequence [OUT] : " + sequence2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + "[Exception] : NullPointerException "  + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[Select]  Sequence [IN] : " + sequence + "[Exception] : IllegalArgumentException " + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectSequence [Entity] " + sequence + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			}
		}

		return sequence2; 
	
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Sequences selectSequenceByModule(Module module){
		
		Sequences sequences = new Sequences();
		String sqlQuery = "select s from Sequence s where s.module.identifiant = ?1 ORDER BY s.identifiant asc";
		Query query = em.createQuery(sqlQuery).setParameter(1, module.getIdentifiant());
		List list = query.getResultList();
		
		for (Object object : list) {
			
			sequences.add((Sequence) object);
			
		}
		
		return sequences;
		
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Sequences selectSequences(){
		
		Sequences sequences = new Sequences();
		
		String sqlQuery = "select s from Sequence s ORDER BY s.identifiant asc";
		
		List list = em.createQuery(sqlQuery).getResultList();
		
		for (Object object : list) {
			
			sequences.add((Sequence) object);
			
		}
		
		return sequences;
	}

}
