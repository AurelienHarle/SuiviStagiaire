package facade;

import javax.ejb.Remote;

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
	 * TODO 
	 * 
	 * @param module
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertModule(Module module) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateModule(Module module);

	/**
	 * Delete d'un Module
	 */
	public void deleteModule(Module module);

	/**
	 * Select d'un Module
	 * @return 
	 * @throws UnfoundException 
	 */
	public Module selectModule(Module module) throws UnfoundException;

	/**
	 * Sélectionne tout les modules de la table module
	 * @return {@link Modules}
	 */
	public Modules selectModules();
	
	/**
	 * TODO 
	 * 
	 * @param sequence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateSequence(Sequence sequence);

	/**
	 * Delete d'une Sequence
	 */
	public void deleteSequence(Sequence sequence);

	/**
	 * Select d'une Sequence
	 * @throws UnfoundException 
	 */
	public Sequence selectSequence(Sequence sequence) throws UnfoundException;
	
	/**
	 * Selectionne les {@link Sequences} d'un {@link Module}
	 * @param module {@link Module}
	 * @return {@link Sequences}
	 */
	public Sequences selectSequenceByModule(Module module);
	
	/**
	 * Selectionne tout les sequences de la table seq
	 * @return {@link Sequences}
	 */
	public Sequences selectSequences();

	/**
	 * TODO 
	 * 
	 * @param competence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateCompetence(Competence competence);

	/**
	 * Delete d'une Competences
	 */
	public void deleteCompetence(Competence competence);

	/**
	 * Select d'une Competences
	 * @throws UnfoundException 
	 */
	public Competence selectCompetence(Competence competence) throws UnfoundException;
	
	/**
	 * select les {@link Competences} d'après un module
	 * @param module {@link Module}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceByModule(Module module);

	/**
	 * select les {@link Competences} d'après une {@link Sequence}
	 * @param module {@link Sequence}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceBySequence(Sequence sequence);
	
	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();

	/**
	 * TODO 
	 * 
	 * @param niveauAcquisition
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Delete NiveauAcquisition
	 */
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Select NiveauAcquisition
	 * @throws UnfoundException 
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;

	/**
	 * Select NiveauAcquisitions
	 * @throws UnfoundException 
	 */
	public NiveauAcquisitions selectNiveauAcquisitions();
	
	/**
	 * TODO 
	 * 
	 * @param stagiaire
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateStagiaire(Stagiaire stagiaire);

	/**
	 * Delete Stagiaire
	 */
	public void deleteStagiaire(Stagiaire stagiaire);

	/**
	 * Select Stagiaire
	 * @throws UnfoundException 
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;

	/**
	 * Contrôle et insert une {@link AutoEvaluation} si elle correspond au règle métier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
	/**
	 * Contrôle et update une {@link AutoEvaluation} si elle correspond au règle métier
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Supprime une {@link AutoEvaluation}
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Select une {@link AutoEvaluation} par son {@link identifiant}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation}
	 * @return autoEvaluation {@link AutoEvaluation}
	 */
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contrôle
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException;
	
	/**
	 * Select d'une auto evaluation par son Stagiaire
	 */
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation);
	
	/**
	 * Sélectionne une autoEvaluation celons les critères envoyé
	 * @param autoEvaluationDater {@link AutoEvaluation}
	 * @param moduleRechercher {@link Module}
	 * @param sequenceRechercher {@link Sequence}
	 * @param competenceRechercher {@link Competence}
	 * @param autoEvaluationNoter {@link AutoEvaluation}
	 * @return {@link AutoEvaluations}
	 */
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater, Module moduleRechercher,
			Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter);
	
	/**
	 * Sélectionne une auto-évaluation a une date donnée pour un stagiaire donné
	 * 
	 * @param autoEvaluation {@link AutoEvaluation}
	 * @return {@link AutoEvaluations}
	 */
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation);
}
