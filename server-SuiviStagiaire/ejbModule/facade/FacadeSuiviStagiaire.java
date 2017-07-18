package facade;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.facade.FacadeServiceAutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import competence.facade.FacadeServiceCompetence;
import competence.technique.Competences;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import module.entity.Module;
import module.facade.FacadeServiceModule;
import module.technique.Modules;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.facade.FacadeServiceNiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;
import sequence.entity.Sequence;
import sequence.facade.FacadeServiceSequence;
import sequence.technique.Sequences;
import stagiaire.entity.Stagiaire;
import stagiaire.facade.FacadeServiceStagiaire;

/**
 * Class qui est la facade principal de l'application elle regroupe tout les services,
 * que l'application peux rendre.
 * Implementation de {@link FacadeSuiviStagiaireRemote}
 * 
 * @author Aur�lien Harl�
 * @version 1
 * @since 13/07/2017
 * 
 */
@Stateless
@Remote(FacadeSuiviStagiaireRemote.class)
public class FacadeSuiviStagiaire implements FacadeSuiviStagiaireRemote {

    /**
     * Default constructor. 
     */
    public FacadeSuiviStagiaire() {
    }

    @EJB
    private FacadeServiceAutoEvaluation facadeServiceAutoEvaluation;
    @EJB
    private FacadeServiceCompetence facadeServiceCompetence;
    @EJB
    private FacadeServiceSequence facadeServiceSequence;
    @EJB
    private FacadeServiceModule facadeServiceModule;
    @EJB
    private FacadeServiceStagiaire facadeServiceStagiaire;
    @EJB
    private FacadeServiceNiveauAcquisition facadeServiceNiveauAcquisition;
    
    /*
     * Utiliser pour debugger l'application.
     */
    @SuppressWarnings("unused")
	private JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();

    /**
	 * Service qui permet d'ins�r� un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeServiceModule.insertModule(module);
	}

	/**
	 * Service qui permet d'update un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a update
	 */
	@Override
	public void updateModule(Module module) {
		facadeServiceModule.updateModule(module);
	}

	/**
	 * Service qui permet de delete un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a delete
	 */
	@Override
	public void deleteModule(Module module) {
		facadeServiceModule.deleteModule(module);
	}

	/**
	 * Service qui permet de select un {@link Module} gr�ce � sa cl� primaire dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a select
	 * @return {@link Module} le module select
	 * @throws {@link UnfoundException}
	 */
	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return facadeServiceModule.selectModule(module);
	}

	/**
	 * Service qui permet de select tout les {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * @return {@link Modules} la liste des modules presents en base
	 */
	@Override
	public Modules selectModules() {
		return facadeServiceModule.selectModules();
	}

	/**
	 * Service qui permet d'ins�r� une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeServiceSequence.insertSequence(sequence);
	}

	/**
	 * Service qui permet d'update une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a update
	 */
	@Override
	public void updateSequence(Sequence sequence) {
		facadeServiceSequence.updateSequence(sequence);
	}

	/**
	 * Service qui permet de delete une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a delete
	 */
	@Override
	public void deleteSequence(Sequence sequence) {
		facadeServiceSequence.deleteSequence(sequence);
	}

	/**
	 * Service qui permet de select une {@link Sequence} gr�ce � sa cl� primaire dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a select
	 * @return {@link Sequence} la sequence select
	 * @throws {@link UnfoundException} 
	 */
	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeServiceSequence.selectSequence(sequence);
	}

	/**
	 * Service qui permet de select une {@link Sequence} gr�ce � la cl� primaire du {@link Module} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module}
	 * @return {@link Sequences} la liste de {@link Sequence} qui appartienne a ce {@link Module}
	 */
	@Override
	public Sequences selectSequenceByModule(Module module) {
		return facadeServiceSequence.selectSequenceByModule(module);
	}

	/**
	 * Service qui permet de select toute les {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link Sequences} la liste de {@link Sequence} present en base
	 */
	@Override
	public Sequences selectSequences() {
		return facadeServiceSequence.selectSequences();
	}

	/**
	 * Service qui permet d'ins�r� une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeServiceCompetence.insertCompetence(competence);
	}

	/**
	 * Service qui permet d'update une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a update
	 */
	@Override
	public void updateCompetence(Competence competence) {
		facadeServiceCompetence.updateCompetence(competence);
	}

	/**
	 * Service qui permet de delete une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a delete
	 */
	@Override
	public void deleteCompetence(Competence competence) {
		facadeServiceCompetence.deleteCompetence(competence);
	}

	/**
	 * Service qui permet de select une {@link Competence} gr�ce � sa cl� primaire dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a select
	 * @return {@link Competence} la competence select
	 */
	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeServiceCompetence.selectCompetence(competence);
	}

	/**
	 * Service qui permet de select une {@link Competence} gr�ce � la cl� primaire du {@link Module} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module pour select
	 * @return {@link Competences} la liste de competence qui appartienne a ce {@link Module}
	 */
	@Override
	public Competences selectCompetenceByModule(Module module) {
		return facadeServiceCompetence.selectCompetenceByModule(module);
	}

	/**
	 * Service qui permet de select une {@link Competence} gr�ce � la cl� primaire de la {@link Sequence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence pour select
	 * @return {@link Competences} la liste de competence qui appartienne a cette {@link Sequence}
	 */
	@Override
	public Competences selectCompetenceBySequence(Sequence sequence) {
		return facadeServiceCompetence.selectCompetenceBySequence(sequence);
	}

	/**
	 * Service qui permet de select toute les {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link Competences} la liste de competence present en base
	 */
	@Override
	public Competences selectCompetences() {
		return facadeServiceCompetence.selectCompetences();
	}

	/**
	 * Service qui permet d'ins�r� un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeServiceNiveauAcquisition.insertNiveauAcquisition(niveauAcquisition);
	}

	/**
	 * Service qui permet d'update un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a update
	 */
	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceNiveauAcquisition.updateNiveauAcquisition(niveauAcquisition);
	}

	/**
	 * Service qui permet de delete un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a delete
	 */
	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceNiveauAcquisition.deleteNiveauAcquisition(niveauAcquisition);
	}

	/**
	 * Service qui permet de select un {@link NiveauAcquisition} gr�ce � sa cl� primaire dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a select
	 * @return niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition select
	 * @throws {@link UnfoundException}
	 */
	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeServiceNiveauAcquisition.selectNiveauAcquisition(niveauAcquisition);
	}

	/**
	 * Service qui permet de select tout les {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link NiveauAcquisitions} la liste de NiveauAcquisitions present en base
	 */
	@Override
	public NiveauAcquisitions selectNiveauAcquisitions() {
		return facadeServiceNiveauAcquisition.selectNiveauAcquisitions();
	}

	/**
	 * Service qui permet d'ins�r� un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeServiceStagiaire.insertStagiaire(stagiaire);
	}

	/**
	 * Service qui permet d'update un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a update
	 */
	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeServiceStagiaire.updateStagiaire(stagiaire);
	}

	/**
	 * Service qui permet delete un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a delete
	 */
	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeServiceStagiaire.deleteStagiaire(stagiaire);
	}

	/**
	 * Service qui permet de select un {@link Stagiaire} gr�ce � sa cl� primaire dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a select
	 * @return {@link Stagiaire} le stagiaire select
	 * @throws {@link UnfoundException}
	 */
	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeServiceStagiaire.selectStagiaire(stagiaire);
	}

	/**
	 * Service qui permet d'ins�r� une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeServiceAutoEvaluation.insertAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet d'update une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a update
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeServiceAutoEvaluation.updateAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet de delete une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a delete
	 */
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � sa cl� primaire dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByStagCompDate(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByStag(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce au param�tre sp�cifi� cela peux �tre
	 * la {@link Date} de l' {@link AutoEvaluation},
	 * la cl� primaire du {@link Module},
	 * la cl� primaire de la {@link Sequence},
	 * la cl� primaire de la {@link Competence},
	 * ou le {@link NiveauAcquisition} de l' {@link AutoEvaluation}
	 * si l'un des param�tre est null, il seras pas pris en compte dans le select.
	 * dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluationDater {@link AutoEvaluation} l'autoEvaluation dater qui permet de select par la date.
	 * @param moduleRechercher {@link Module} le module qui permet le select par l'identifiant module
	 * @param sequenceRechercher {@link Sequence} la sequence qui permet le select par l'identifiant sequence
	 * @param competenceRechercher {@link Competence} la competence qui permet le select par l'identifiant competence
	 * @param autoEvaluationNoter {@link AutoEvaluation} le l'auto-�valuation noter qui permet le select par le {@link NiveauAcquisition}
	 * @return {@link AutoEvaluations} l'autoEvaluations la liste des autoEvaluations correspondant au select
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater,
			Module moduleRechercher, Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationsByMultipleCritere(autoEvaluationDater,moduleRechercher, sequenceRechercher, competenceRechercher,autoEvaluationNoter);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationsByStagDate(autoEvaluation);
	}
    
}
