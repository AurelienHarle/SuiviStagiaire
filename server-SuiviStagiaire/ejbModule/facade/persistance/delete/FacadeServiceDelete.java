package facade.persistance.delete;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import facade.persistance.select.FacadeServiceSelectLocal;

/**
 * Session Bean implementation class FacadeServiceSelect
 */
@Stateless
@LocalBean
public class FacadeServiceDelete implements FacadeServiceSelectLocal {

    /**
     * Default constructor. 
     */
    public FacadeServiceDelete() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Controle le type d'objet qui dois etre supprimer
     * @param requete
     */
	public void traite(Requete requete) {
		
		
	}

}
