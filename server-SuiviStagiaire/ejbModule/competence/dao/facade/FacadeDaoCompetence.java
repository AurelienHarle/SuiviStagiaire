package competence.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import competence.dao.CompetenceDao;
import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

/**
 * Session Bean implementation class FacadeDaoCompetence
 */
@Stateless
@LocalBean
public class FacadeDaoCompetence implements FacadeDaoCompetenceLocal {

	@EJB
	CompetenceDao competenceDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoCompetence() {
    }
	

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		competenceDao.insertCompetence(competence);
	}

	@Override
	public void updateCompetence(Competence competence) {
		competenceDao.updateCompetence(competence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		competenceDao.deleteCompetence(competence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return competenceDao.selectCompetence(competence);
		
	}

	@Override
	public Competences selectCompetences() {
		return competenceDao.selectCompetences();
	} 
    
}
