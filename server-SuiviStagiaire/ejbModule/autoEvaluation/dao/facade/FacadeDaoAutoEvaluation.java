package autoEvaluation.dao.facade;

import java.sql.Date;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import autoEvaluation.dao.AutoEvaluationDao;
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
 * Class qui est la facade qui permet l'accées a la persistance des données elle regroupe tout les services,
 * qui peuvent être rendu pour la persistance des données.
 * Implementation de {@link FacadeDaoAutoEvaluationLocal}
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 13/07/2017
 * 
 */
@Stateless
@LocalBean
public class FacadeDaoAutoEvaluation implements FacadeDaoAutoEvaluationLocal {

	@EJB
	private AutoEvaluationDao autoEvaluationDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoAutoEvaluation() {}

    /**
	 * FacadeApplication qui permet d'inséré une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a inséré
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
    @Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		autoEvaluationDao.insertAutoEvaluation(autoEvaluation);
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
		autoEvaluationDao.updateAutoEvaluation(autoEvaluation);
	}
    
    /**
	 * FacadeApplication qui permet de facadeServiceDelete une {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceDelete
	 */
    @Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		autoEvaluationDao.deleteAutoEvaluation(autoEvaluation);
	}
    
    /**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à sa clé primaire dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
    @Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
    	return autoEvaluationDao.selectAutoEvaluation(autoEvaluation);
	}

    /**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
    @Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		return autoEvaluationDao.selectAutoEvaluationByStagCompDate(autoEvaluation);
	}

    /**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return autoEvaluationDao.selectAutoEvaluationByStag(autoEvaluation);
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
		return autoEvaluationDao.selectAutoEvaluationsByMultipleCritere(autoEvaluationDater,moduleRechercher, sequenceRechercher, competenceRechercher,autoEvaluationNoter);
	}

	/**
	 * FacadeApplication qui permet de facadeServiceSelect une {@link AutoEvaluation} grâce à la clé primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval grâce à un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a facadeServiceSelect
	 * @return {@link AutoEvaluation} l'autoEvaluation facadeServiceSelect
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		return autoEvaluationDao.selectAutoEvaluationsByStagDate(autoEvaluation);
	}

    
}
