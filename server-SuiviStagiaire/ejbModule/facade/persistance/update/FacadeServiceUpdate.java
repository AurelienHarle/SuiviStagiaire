package facade.persistance.update;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import facade.persistance.select.FacadeServiceSelectLocal;

/**
 * Session Bean implementation class FacadeServiceSelect
 */
@Stateless
@LocalBean
public class FacadeServiceUpdate implements FacadeServiceSelectLocal {

    /**
     * Default constructor. 
     */
    public FacadeServiceUpdate() {
        // TODO Auto-generated constructor stub
    }

	public void traite(Requete requete) {
		// TODO Auto-generated method stub
		
	}

}
