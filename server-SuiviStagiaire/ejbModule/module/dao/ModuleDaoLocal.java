package module.dao;

import javax.ejb.Local;

import competence.dao.CompetenceDao;
import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import module.entity.Module;
import module.technique.Modules;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'facadeServiceUpdate et le facadeServiceDelete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Local
public interface ModuleDaoLocal {
	
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
