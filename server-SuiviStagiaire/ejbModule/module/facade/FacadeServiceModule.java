package module.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import module.dao.facade.FacadeDaoModule;
import module.entity.Module;
import module.technique.Modules;

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

	@Override
	public Modules selectModules() {
		return facadeDaoModule.selectModules();
	} 

}
