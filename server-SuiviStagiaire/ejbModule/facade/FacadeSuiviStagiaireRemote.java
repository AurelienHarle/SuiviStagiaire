package facade;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import competence.technique.Competences;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import module.technique.Modules;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;
import sequence.entity.Sequence;
import sequence.technique.Sequences;
import stagiaire.entity.Stagiaire;

@Remote
public interface FacadeSuiviStagiaireRemote {
	
	/**
	 * Service qui permet d'inséré un {@link Module} dans la table module grace a un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertModule(Module module) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update un {@link Module} dans la table module grace a un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a update
	 */
	public void updateModule(Module module);

	/**
	 * Service qui permet de delete un {@link Module} dans la table module grace a un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a delete
	 */
	public void deleteModule(Module module);

	/**
	 * Service qui permet de select un {@link Module} grace  a sa clé primaire dans la table module grace a un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a select
	 * @throws {@link UnfoundException}
	 */
	public Module selectModule(Module module) throws UnfoundException;

	/**
	 * Service qui permet de select tout les {@link Module} dans la table module grace a un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a select
	 * @throws {@link UnfoundException}
	 */
	public Modules selectModules();

	/**
	 * Service qui permet d'inséré une {@link Sequence} dans la table seq grace a un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;

	public void updateSequence(Sequence sequence);

	public void deleteSequence(Sequence sequence);

	public Sequence selectSequence(Sequence sequence) throws UnfoundException;
	
	public Sequences selectSequenceByModule(Module module);

	public Sequences selectSequences();

	/**
	 * Service qui permet d'inséré une {@link Competence} dans la table comp grace a un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;

	public void updateCompetence(Competence competence);

	public void deleteCompetence(Competence competence);

	public Competence selectCompetence(Competence competence) throws UnfoundException;
	
	public Competences selectCompetenceByModule(Module module);

	public Competences selectCompetenceBySequence(Sequence sequence);

	public Competences selectCompetences();

	/**
	 * Service qui permet d'inséré un {@link NiveauAcquisition} dans la table niv_acqui grace a un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;

	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;

	public NiveauAcquisitions selectNiveauAcquisitions();

	/**
	 * Service qui permet d'inséré un {@link Stagiaire} dans la table stag grace a un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;

	public void updateStagiaire(Stagiaire stagiaire);

	public void deleteStagiaire(Stagiaire stagiaire);

	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;

	/**
	 * Service qui permet d'inséré un {@link AutoEvaluation} dans la table auto_eval grace a un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;

	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);

	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);

	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException;

	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation);

	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater, Module moduleRechercher,
			Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter);
	
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation);
}
