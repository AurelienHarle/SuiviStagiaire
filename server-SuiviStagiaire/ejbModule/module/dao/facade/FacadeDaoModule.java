package module.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.dao.ModuleDao;
import module.entity.Module;

/**
 * Session Bean implementation class FacadeDaoCompetence
 */
@Stateless
@LocalBean
public class FacadeDaoModule implements FacadeDaoModuleLocal {

	@EJB
	ModuleDao moduleDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoModule() {
    }
	

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		moduleDao.insertModule(module);
		
	}

	@Override
	public void updateModule(Module module) {
		moduleDao.updateModule(module);
		
	}

	@Override
	public void deleteModule(Module module) {
		
		moduleDao.deleteModule(module);
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return moduleDao.selectModule(module);
		
	} 
    
}
