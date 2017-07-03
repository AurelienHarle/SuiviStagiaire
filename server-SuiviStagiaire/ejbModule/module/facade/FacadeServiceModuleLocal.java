package module.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;

@Local
public interface FacadeServiceModuleLocal {
	
	/**
	 * Insertion d'un Module
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertModule(Module module) throws DoublonException, NullException;
	
	/**
	 * Update d'un Module
	 */
	public void updateModule(Module module);
	
	/**
	 * Delete d'un Module
	 */
	public void deleteModule(Module module);
	
	/**
	 * Select d'un Module
	 * @throws UnfoundException 
	 */
	public Module selectModule(Module module) throws UnfoundException;
}
