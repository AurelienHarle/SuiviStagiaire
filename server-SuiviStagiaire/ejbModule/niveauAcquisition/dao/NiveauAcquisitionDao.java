package niveauAcquisition.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

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
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;

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
public class NiveauAcquisitionDao implements NiveauAcquisitionDaoLocal {
	
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
    public NiveauAcquisitionDao() { 
    }

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		
		try{

			em.persist(niveauAcquisition);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  NiveauAcquisition : " + niveauAcquisition );
			
		}catch (Exception e ) {
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
	}
	
	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		
		try {
			
			em.merge(niveauAcquisition);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  NiveauAcquisition : " + niveauAcquisition);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] updateNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
	}


	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		
		try {
			
			NiveauAcquisition niveauAcquisition2 = selectNiveauAcquisition(niveauAcquisition);
			em.remove(niveauAcquisition2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  NiveauAcquisition : " + niveauAcquisition);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteNiveauAcquisition [Entity] " + niveauAcquisition + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}

	}


	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {

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

		return niveauAcquisition2; 
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NiveauAcquisitions selectNiveauAcquisitions() {
		
		NiveauAcquisitions niveauAcquisitions = new NiveauAcquisitions();
		
		String sqlQuery = "select c from Competence c ORDER BY c.identifiant asc";
		
		List list = em.createQuery(sqlQuery).getResultList();
		
		for (Object object : list) {
			
			niveauAcquisitions.add((NiveauAcquisition) object);
			
		}
		
		return niveauAcquisitions;
		
	}

}
