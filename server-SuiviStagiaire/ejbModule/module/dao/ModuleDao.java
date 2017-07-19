package module.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import logger.JournaliseurNiveauConfig;
import logger.JournaliseurNiveauError;
import logger.JournaliseurNiveauInfo;
import module.entity.Module;
import module.technique.Modules;

/**
 * Session Bean CompetenceDao qui permet l'insertion l'facadeServiceUpdate et le facadeServiceDelete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Stateless
@LocalBean
public class ModuleDao implements ModuleDaoLocal {
	
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
    public ModuleDao() {
    }

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		
		try{
			
			em.persist(module);
			em.flush();
			journaliseurNiveauInfo.log("[INSERT]  Module : " + module );
			
		}catch (Exception e) {
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
		
	}


	@Override
	public void updateModule(Module module) {
		
		try {
			
			em.merge(module);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Module : " + module );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] updateModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}
		
	}


	@Override
	public void deleteModule(Module module) {

		try {
			
			Module module2 = selectModule(module);
			em.remove(module2);
			em.flush();
			journaliseurNiveauInfo.log("[UPDATE]  Module : " + module);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			journaliseurNiveauError.log("[METHOD] deleteModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
		}

	}


	@Override
	public Module selectModule(Module module) throws UnfoundException {

		Module module2 = null;
		
		try{
			
			module2 = em.find(Module.class, module.getIdentifiant());
			journaliseurNiveauInfo.log("[FacadeServiceSelect]  Module [IN] : " + module + " Module [OUT] : " + module2);
			
		}catch (Exception e) {
			if(e instanceof NullPointerException){
				
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Module [IN] : " + module + " [MESSAGE] : NotFound" + " [Exception] " +  e.getClass().getName());
				throw new UnfoundException("selectModule");
				
			}else if(e instanceof IllegalArgumentException){
			
				journaliseurNiveauInfo.log("[FacadeServiceSelect]  Module [IN] : " + module + " [MESSAGE] : NotFound" + " [Exception] " +  e.getClass().getName());
				throw new UnfoundException("selectModule");
				
			}else{
				
				e.printStackTrace();
				journaliseurNiveauError.log("[METHOD] selectModule [Entity] " + module + " [Exception] " +  e.getClass().getName() + " [StackTrace] " + e.getMessage());
			
			}
		}
		
		return module2; 
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Modules selectModules(){
		
		Modules modules = new Modules();
		
		String sqlQuery = "facadeServiceSelect m from Module m ORDER BY m.identifiant asc";
		
		List list = em.createQuery(sqlQuery).getResultList();
		
		for (Object object : list) {
			
			modules.add((Module) object);
			
		}
		
		return modules;
	}

}
