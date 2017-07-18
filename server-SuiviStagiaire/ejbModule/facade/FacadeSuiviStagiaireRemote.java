package facade;

import java.sql.Date;

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

/**
 * Interface qui est la facade principal de l'application elle regroupe tout les services,
 * que l'application peux rendre.
 * 
 * @author Aur�lien Harl�
 * @version 1
 * @since 13/07/2017
 *
 */
@Remote
public interface FacadeSuiviStagiaireRemote {
	
	/**
	 * Service qui permet d'ins�r� un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertModule(Module module) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a update
	 */
	public void updateModule(Module module);

	/**
	 * Service qui permet de delete un {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a delete
	 */
	public void deleteModule(Module module);

	/**
	 * Service qui permet de select un {@link Module} gr�ce � sa cl� primaire dans la table module gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module a select
	 * @return {@link Module} le module select
	 * @throws {@link UnfoundException}
	 */
	public Module selectModule(Module module) throws UnfoundException;

	/**
	 * Service qui permet de select tout les {@link Module} dans la table module gr�ce � un {@link EntityManager}.
	 * @return {@link Modules} la liste des modules presents en base
	 */
	public Modules selectModules();

	/**
	 * Service qui permet d'ins�r� une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a update
	 */
	public void updateSequence(Sequence sequence);

	/**
	 * Service qui permet de delete une {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a delete
	 */
	public void deleteSequence(Sequence sequence);

	/**
	 * Service qui permet de select une {@link Sequence} gr�ce � sa cl� primaire dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence a select
	 * @return {@link Sequence} la sequence select
	 * @throws {@link UnfoundException} 
	 */
	public Sequence selectSequence(Sequence sequence) throws UnfoundException;
	
	/**
	 * Service qui permet de select une {@link Sequence} gr�ce � la cl� primaire du {@link Module} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module}
	 * @return {@link Sequences} la liste de {@link Sequence} qui appartienne a ce {@link Module}
	 */
	public Sequences selectSequenceByModule(Module module);

	/**
	 * Service qui permet de select toute les {@link Sequence} dans la table seq gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link Sequences} la liste de {@link Sequence} present en base
	 */
	public Sequences selectSequences();

	/**
	 * Service qui permet d'ins�r� une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a update
	 */
	public void updateCompetence(Competence competence);

	/**
	 * Service qui permet de delete une {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a delete
	 */
	public void deleteCompetence(Competence competence);

	/**
	 * Service qui permet de select une {@link Competence} gr�ce � sa cl� primaire dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param competence {@link Competence} la competence a select
	 * @return {@link Competence} la competence select
	 */
	public Competence selectCompetence(Competence competence) throws UnfoundException;
	
	/**
	 * Service qui permet de select une {@link Competence} gr�ce � la cl� primaire du {@link Module} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param module {@link Module} le module pour select
	 * @return {@link Competences} la liste de competence qui appartienne a ce {@link Module}
	 */
	public Competences selectCompetenceByModule(Module module);

	/**
	 * Service qui permet de select une {@link Competence} gr�ce � la cl� primaire de la {@link Sequence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @param sequence {@link Sequence} la sequence pour select
	 * @return {@link Competences} la liste de competence qui appartienne a cette {@link Sequence}
	 */
	public Competences selectCompetenceBySequence(Sequence sequence);

	/**
	 * Service qui permet de select toute les {@link Competence} dans la table comp gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link Competences} la liste de competence present en base
	 */
	public Competences selectCompetences();

	/**
	 * Service qui permet d'ins�r� un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a update
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Service qui permet de delete un {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a delete
	 */
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Service qui permet de select un {@link NiveauAcquisition} gr�ce � sa cl� primaire dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @param niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition a select
	 * @return niveauAcquisition {@link NiveauAcquisition} le niveauAcquisition select
	 * @throws {@link UnfoundException}
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;

	/**
	 * Service qui permet de select tout les {@link NiveauAcquisition} dans la table niv_acqui gr�ce � un {@link EntityManager}.
	 * 
	 * @return {@link NiveauAcquisitions} la liste de NiveauAcquisitions present en base
	 */
	public NiveauAcquisitions selectNiveauAcquisitions();

	/**
	 * Service qui permet d'ins�r� un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;

	/**
	 * Service qui permet d'update un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a update
	 */
	public void updateStagiaire(Stagiaire stagiaire);

	/**
	 * Service qui permet delete un {@link Stagiaire} dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a delete
	 */
	public void deleteStagiaire(Stagiaire stagiaire);

	/**
	 * Service qui permet de select un {@link Stagiaire} gr�ce � sa cl� primaire dans la table stag gr�ce � un {@link EntityManager}.
	 * 
	 * @param stagiaire {@link Stagiaire} le stagiaire a select
	 * @return {@link Stagiaire} le stagiaire select
	 * @throws {@link UnfoundException}
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;

	/**
	 * Service qui permet d'ins�r� une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;

	/**
	 * Service qui permet d'update une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a update
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;

	/**
	 * Service qui permet de delete une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a delete
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � sa cl� primaire dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException;

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation);

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
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater, Module moduleRechercher,
			Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter);
	
	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation);
	
}
