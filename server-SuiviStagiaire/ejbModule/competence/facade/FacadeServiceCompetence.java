package competence.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import competence.dao.facade.FacadeDaoCompetence;
import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;

/**
 * Session Bean implementation class FacadeServiceCompetence
 */
@Stateless
@LocalBean
public class FacadeServiceCompetence implements FacadeServiceCompetenceLocal {

	@EJB
	FacadeDaoCompetence facadeDaoCompetence;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceCompetence() {
    }
    
    @Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeDaoCompetence.insertCompetence(competence);	
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeDaoCompetence.updateCompetence(competence);
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeDaoCompetence.deleteCompetence(competence);
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeDaoCompetence.selectCompetence(competence);
	}

	@Override
	public Competences selectCompetenceByModule(Module module) {
		return facadeDaoCompetence.selectCompetenceByModule(module);
	}

	@Override
	public Competences selectCompetences() {
		return facadeDaoCompetence.selectCompetences();
	} 

}
