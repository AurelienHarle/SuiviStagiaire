package competence.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import competence.dao.CompetenceDao;
import competence.entity.Competence;
import competence.technique.Competences;
import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;

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
	public Competences selectCompetenceByModule(Module module) {
		return competenceDao.selectCompetenceByModule(module);
	}


	@Override
	public Competences selectCompetenceBySequence(Sequence sequence) {
		return competenceDao.selectCompetenceBySequence(sequence);
	}


	@Override
	public Competences selectCompetences() {
		return competenceDao.selectCompetences();
	} 
    
}
