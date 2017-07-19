package service.select;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

/**
 * Session Bean implementation class ServiceSelectCompetence
 */
@Stateless
@LocalBean
public class ServiceSelectSequence implements ServiceSelectSequenceLocal {

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
    public ServiceSelectSequence() {
       
    }
    
    @Override
	public Sequence selectSequence(Requete requete) throws UnfoundException {

    	Sequence sequence = (Sequence) requete.getObject();
		Sequence sequence2 = null;

		String hqlString = "facadeServiceSelect s from Sequence s where s.identifiant = ?1 and s.module.identifiant = ?2";
		
		try{

			sequence2 = (Sequence) em.createQuery(hqlString)
				.setParameter(1, sequence.getIdentifiant())
				.setParameter(2, sequence.getModule().getIdentifiant())
				.getSingleResult();

			if(sequence2 == null){
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Sequence [IN] : " + sequence + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
			}
			
			journaliseurNiveauInfo.log("[FacadeServiceSelect]  Sequence [IN] : " + sequence + " Sequence [OUT] : " + sequence2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Sequence [IN] : " + sequence + "[Exception] : NullPointerException "  + " [MESSAGE] : NotFound");
				throw new UnfoundException("selectSequence");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Sequence [IN] : " + sequence + "[Exception] : IllegalArgumentException " + " [MESSAGE] : NotFound");
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
	public Sequences selectSequenceByModule(Requete requete){
		
		Module module = (Module) requete.getObject();
		Sequences sequences = new Sequences();
		List list = null;
		
		String sqlQuery = "facadeServiceSelect s from Sequence s where s.module.identifiant = ?1 ORDER BY s.identifiant asc";
		Query query = em.createQuery(sqlQuery).setParameter(1, module.getIdentifiant());
		
		
		try{
			
			 list = query.getResultList();
			
			if( (list.isEmpty()) || (list == null) ) throw new UnfoundException("selectCompetenceByModule");

		}catch(Exception e){

			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] selectCompetenceByModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());

		}

		
		for (Object object : list) {
			
			sequences.add((Sequence) object);
			
		}
		
		return sequences;
		
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Sequences selectSequences(){
		
		Sequences sequences = new Sequences();
		
		String sqlQuery = "facadeServiceSelect s from Sequence s ORDER BY s.identifiant asc";
		
		List list = em.createQuery(sqlQuery).getResultList();
		
		for (Object object : list) {
			
			sequences.add((Sequence) object);
			
		}
		
		return sequences;
	}

}
