package autoEvaluation.facade;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import autoEvaluation.dao.facade.FacadeDaoAutoEvaluation;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import exception.dao.DateNullException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

/**
 * Class qui est la facade principal de toute la partie "auto-évaluation" de l'application elle regroupe tout les services,
 * qui peuvent être rendu sur une auto-évaluation.
 * implementation de {@link FacadeServiceAutoEvaluationLocal}.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 13/07/2017
 *
 */
@Stateless
@LocalBean
public class FacadeServiceAutoEvaluation implements FacadeServiceAutoEvaluationLocal {

	@EJB
	private FacadeDaoAutoEvaluation facadeDaoAutoEvaluation;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceAutoEvaluation() {
        
    }

    /**
	 * FacadeApplication qui permet d'inséré une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeDaoAutoEvaluation.insertAutoEvaluation(autoEvaluation);	
	}

	/**
	 * FacadeApplication qui permet d'facadeServiceUpdate une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceUpdate
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException  {
		facadeDaoAutoEvaluation.updateAutoEvaluation(autoEvaluation);	
	}

	/**
	 * FacadeApplication qui permet de facadeServiceDelete une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceDelete
	 */
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeDaoAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à sa clé primaire dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluation(autoEvaluation);
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStagCompDate(autoEvaluation);
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStag(autoEvaluation);
	}

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
	@Override
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater,Module moduleRechercher, Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationsByMultipleCritere(autoEvaluationDater,moduleRechercher, sequenceRechercher, competenceRechercher,autoEvaluationNoter);
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationsByStagDate(autoEvaluation);
	}

}
