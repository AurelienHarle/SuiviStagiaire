package fr.suiviStagiaire.formation.contenu.module.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.module.dao.ModuleDao;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.module.technique.Modules;

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


	@Override
	public Modules selectModules() {
		return moduleDao.selectModules();
	} 
    
}
