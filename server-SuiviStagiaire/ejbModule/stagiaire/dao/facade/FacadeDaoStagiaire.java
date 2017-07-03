package stagiaire.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import stagiaire.dao.StagiaireDao;
import stagiaire.entity.Stagiaire;

/**
 * Session Bean implementation class FacadeDaoCompetence
 */
@Stateless
@LocalBean
public class FacadeDaoStagiaire implements FacadeDaoStagiaireLocal {

	@EJB
	StagiaireDao stagiaireDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoStagiaire() {
    }
	

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		stagiaireDao.insertStagiaire(stagiaire);
		
	}

	

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		stagiaireDao.updateStagiaire(stagiaire);
		
	}

	

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		stagiaireDao.deleteStagiaire(stagiaire);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return stagiaireDao.selectStagiaire(stagiaire);
		
	} 
    
}
