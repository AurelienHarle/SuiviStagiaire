package stagiaire.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import stagiaire.dao.facade.FacadeDaoStagiaire;
import stagiaire.entity.Stagiaire;

/**
 * Session Bean implementation class FacadeServiceCompetence
 */
@Stateless
@LocalBean
public class FacadeServiceStagiaire implements FacadeServiceStagiaireLocal {

	@EJB
	FacadeDaoStagiaire facadeDaoStagiaire;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceStagiaire() {
    }
    
    @Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeDaoStagiaire.insertStagiaire(stagiaire);
	}
	
	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeDaoStagiaire.updateStagiaire(stagiaire);
	}
	
	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeDaoStagiaire.deleteStagiaire(stagiaire);
	}
	
	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeDaoStagiaire.selectStagiaire(stagiaire);
	}

}
