package entity.requete;

import java.io.Serializable;

import exception.RequeteWithoutServiceException;

/**
 * 
 * Entit� qui repr�sente une requ�te du client vers les action propos� par le serveur.
 * 
 * @author Aur�lien Harl�
 * @version 1
 * @since 18/07/2017
 *
 */
public class Requete implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Service service;
	private Action action;
	private SpecificationAction specificationAction;
	private Object object;
	
	/**
	 * Construit une {@link Requete} en sp�cifiant obligatoirement l'{@link Service} demander par l'utilisateur, 
	 * suivant le type d'action demander un {@link Action}
	 * @param service
	 * @param action
	 * @param object
	 * @throws RequeteWithoutServiceException
	 */
	public Requete(Service service,Action action,Object object) throws RequeteWithoutServiceException{
		
		if(service == null) throw new RequeteWithoutServiceException();
		
		this.service = service;
		this.action = action;
		this.object = object;
		
	}

	public Service getNomService() {
		return service;
	}

	public void setNomService(Service service) {
		this.service = service;
	}

	public Action getActionService() {
		return action;
	}

	public void setActionService(Action action) {
		this.action = action;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public SpecificationAction getSpecificationAction() {
		return specificationAction;
	}

	public void setSpecificationAction(SpecificationAction specificationAction) {
		this.specificationAction = specificationAction;
	}

	/**
	 * TODO FacadeServiceDelete une {@link Requete} n'a pas besoin de savoir ce pr�sent� cette m�thode casse le principe object
	 * MAIS elle est d'utilit� pour le debuggage de l'application
	 */
	@Override
	public String toString() {
		return "Requete [service=" + service + ", action=" + action + ", object=" + object + "]";
	}
}