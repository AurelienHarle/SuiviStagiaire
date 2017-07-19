package entity.requete;

import java.io.Serializable;

import exception.RequeteWithoutServiceException;

/**
 * 
 * Entité qui représente une requête du client vers les action proposé par le serveur.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 18/07/2017
 *
 */
public class Requete implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Action action;
	private TypeAction typeAction;
	private Object object;
	
	/**
	 * Construit une {@link Requete} en spécifiant obligatoirement l'{@link Action} demander par l'utilisateur, 
	 * suivant le type d'action demander un {@link TypeAction}
	 * @param action
	 * @param typeAction
	 * @param object
	 * @throws RequeteWithoutServiceException
	 */
	public Requete(Action action,TypeAction typeAction,Object object) throws RequeteWithoutServiceException{
		
		if(action == null) throw new RequeteWithoutServiceException();
		
		this.action = action;
		this.typeAction = typeAction;
		this.object = object;
		
	}

	public Action getService() {
		return action;
	}

	public void setService(Action action) {
		this.action = action;
	}

	public TypeAction getAction() {
		return typeAction;
	}

	public void setAction(TypeAction typeAction) {
		this.typeAction = typeAction;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * TODO FacadeServiceDelete une {@link Requete} n'a pas besoin de savoir ce présenté cette méthode casse le principe object
	 * MAIS elle est d'utilité pour le debuggage de l'application
	 */
	@Override
	public String toString() {
		return "Requete [action=" + action + ", typeAction=" + typeAction + ", object=" + object + "]";
	}
}