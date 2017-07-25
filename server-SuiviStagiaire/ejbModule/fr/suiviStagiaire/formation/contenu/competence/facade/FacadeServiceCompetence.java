package fr.suiviStagiaire.formation.contenu.competence.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.competence.dao.facade.FacadeDaoCompetence;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.competence.technique.Competences;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;

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
	public Competences selectCompetenceBySequence(Sequence sequence) {
		return facadeDaoCompetence.selectCompetenceBySequence(sequence);
	}

	@Override
	public Competences selectCompetences() {
		return facadeDaoCompetence.selectCompetences();
	} 

}
