package module.dao.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import module.technique.Modules;

@Local
public interface FacadeDaoModuleLocal {


	/**
	 * Insertion d'un Module
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertModule(Module module) throws DoublonException, NullException;
	
	/**
	 * FacadeServiceUpdate d'un Module
	 */
	public void updateModule(Module module);
	
	/**
	 * FacadeServiceDelete d'un Module
	 */
	public void deleteModule(Module module);
	
	/**
	 * FacadeServiceSelect d'un Module
	 * @throws UnfoundException 
	 */
	public Module selectModule(Module module) throws UnfoundException;
	
	/**
	 * Sélectionne tout les modules de la table module
	 * @return {@link Modules}
	 */
	public Modules selectModules();
	
}
