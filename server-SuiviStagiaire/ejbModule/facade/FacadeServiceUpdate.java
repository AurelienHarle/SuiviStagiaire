package facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;

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
