package fr.suiviStagiaire.stagiaire.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.stagiaire.dao.facade.FacadeDaoStagiaire;
import fr.suiviStagiaire.stagiaire.entity.Stagiaire;

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
