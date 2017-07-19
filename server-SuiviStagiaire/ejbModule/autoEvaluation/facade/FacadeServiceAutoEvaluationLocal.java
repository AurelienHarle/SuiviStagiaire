package autoEvaluation.facade;

import java.sql.Date;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

/**
 * Interface qui est la facade principal de toute la partie "auto-évaluation" de l'application elle regroupe tout les services,
 * qui peuvent être rendu sur une auto-évaluation.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 13/07/2017
 *
 */
@Local
public interface FacadeServiceAutoEvaluationLocal {
	
	/**
	 * FacadeApplication qui permet d'inséré une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
	/**
	 * FacadeApplication qui permet d'facadeServiceUpdate une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceUpdate
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
	/**
	 * FacadeApplication qui permet de facadeServiceDelete une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceDelete
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à sa clé primaire dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException;
	
	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation);
	
	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce au paramètre spécifié cela peux être
	 * la {@link Date} de l' {@link AutoEvaluation},
	 * la clé primaire du {@link Module},
	 * la clé primaire de la {@link Sequence},
	 * la clé primaire de la {@link Competence},
	 * ou le {@link NiveauAcquisition} de l' {@link AutoEvaluation}
	 * si l'un des paramètre est null, il seras pas pris en compte dans le facadeServiceSelect.
	 * dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluationDater {@link AutoEvaluation} l'autoEvaluation dater qui permet de facadeServiceSelect par la date.
	 * @param moduleRechercher {@link Module} le module qui permet le facadeServiceSelect par l'identifiant module
	 * @param sequenceRechercher {@link Sequence} la sequence qui permet le facadeServiceSelect par l'identifiant sequence
	 * @param competenceRechercher {@link Competence} la competence qui permet le facadeServiceSelect par l'identifiant competence
	 * @param autoEvaluationNoter {@link AutoEvaluation} le l'auto-évaluation noter qui permet le facadeServiceSelect par le {@link NiveauAcquisition}
	 * @return {@link AutoEvaluations} l'autoEvaluations la liste des autoEvaluations correspondant au facadeServiceSelect
	 */
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater, Module moduleRechercher,
			Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter);
	
	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation);
	
}
