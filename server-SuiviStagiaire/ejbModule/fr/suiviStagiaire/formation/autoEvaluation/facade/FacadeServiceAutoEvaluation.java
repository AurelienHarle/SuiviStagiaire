package fr.suiviStagiaire.formation.autoEvaluation.facade;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import fr.suiviStagiaire.exception.DateNullException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.autoEvaluation.dao.facade.FacadeDaoAutoEvaluation;
import fr.suiviStagiaire.formation.autoEvaluation.entity.AutoEvaluation;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.entity.NiveauAcquisition;
import fr.suiviStagiaire.formation.autoEvaluation.technique.AutoEvaluations;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.stagiaire.entity.Stagiaire;

/**
 * Class qui est la facade principal de toute la partie "auto-�valuation" de l'application elle regroupe tout les services,
 * qui peuvent �tre rendu sur une auto-�valuation.
 * implementation de {@link FacadeServiceAutoEvaluationLocal}.
 * 
 * @author Aur�lien Harl�
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
	 * Service qui permet d'ins�r� une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a ins�r�
	 * @throws {@link DoublonException} 
	 * @throws {@link NullException}
	 */
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeDaoAutoEvaluation.insertAutoEvaluation(autoEvaluation);	
	}

	/**
	 * Service qui permet d'update une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a update
	 * @throws DateNullException 
	 * @throws NullException 
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException  {
		facadeDaoAutoEvaluation.updateAutoEvaluation(autoEvaluation);	
	}

	/**
	 * Service qui permet de delete une {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a delete
	 */
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeDaoAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � sa cl� primaire dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluation(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire}, de la {@link Competence}, et de la {@link Date} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStagCompDate(autoEvaluation);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStag(autoEvaluation);
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
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater,Module moduleRechercher, Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationsByMultipleCritere(autoEvaluationDater,moduleRechercher, sequenceRechercher, competenceRechercher,autoEvaluationNoter);
	}

	/**
	 * Service qui permet de select une {@link AutoEvaluation} gr�ce � la cl� primaire du {@link Stagiaire} et a la {@link Date} de l' {@link AutoEvaluation} dans la table auto_eval gr�ce � un {@link EntityManager}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation} l'autoEvaluation a select
	 * @return {@link AutoEvaluation} l'autoEvaluation select
	 */
	@Override
	public AutoEvaluations selectAutoEvaluationsByStagDate(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationsByStagDate(autoEvaluation);
	}

}
