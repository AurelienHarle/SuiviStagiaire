package module.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.dao.facade.FacadeDaoModule;
import module.entity.Module;

/**
 * Session Bean implementation class FacadeServiceCompetence
 */
@Stateless
@LocalBean
public class FacadeServiceModule implements FacadeServiceModuleLocal {

	@EJB
	FacadeDaoModule facadeDaoModule;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceModule() {
    }
    
    @Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeDaoModule.insertModule(module);
	}

	@Override
	public void updateModule(Module module) {
		facadeDaoModule.updateModule(module);
		
	}

	@Override
	public void deleteModule(Module module) {
		facadeDaoModule.deleteModule(module);
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return facadeDaoModule.selectModule(module);
		
	} 

}
