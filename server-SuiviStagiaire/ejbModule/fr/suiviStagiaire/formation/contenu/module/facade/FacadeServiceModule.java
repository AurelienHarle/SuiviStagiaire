package fr.suiviStagiaire.formation.contenu.module.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.module.dao.facade.FacadeDaoModule;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.module.technique.Modules;

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
