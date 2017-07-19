package autoEvaluation.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import competence.entity.Competence;
import niveauAcquisition.entity.NiveauAcquisition;
import stagiaire.entity.Stagiaire;


/**
 * {@link Class} {@link Entity}, {@link AutoEvaluation} elle représente l'évaluation du stagiaire sur une competence donner.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, d'une date d'evaluation mis a la date du jour de l'évaluation,
 * d'un {@link Stagiaire}, d'un {@link NiveauAcquisition}, et d'une {@link Competence}
 * 
 * elle est {@link Serializable} 
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 * 
 */
@Entity
@Table(name="auto_eval")
public class AutoEvaluation implements Serializable {

	private static final long serialVersionUID = 4240756771457540324L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ae_id", length=4, nullable=false)
	private int identifiant;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(value={
			
			@JoinColumn(name="mod_id",nullable=false,referencedColumnName="mod_id"),
			@JoinColumn(name="seq_id",nullable=false,referencedColumnName="seq_id"),
			@JoinColumn(name="comp_id", nullable=false,referencedColumnName="comp_id")
			
	})
	private Competence competence;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="na_id", nullable=false,unique=false)
	private NiveauAcquisition niveauAcquisition;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="stag_osia", nullable=false,unique=false)
	private Stagiaire stagiaire;
	
	@Column(name="ae_date", length=10, nullable=false,unique=false)
	private LocalDate dateAutoEvaluation;
	
	@Column(name="ae_ressenti", length=4000, nullable=true,unique=false)
	private String ressenti;

	/**
	 * Constructeur par default
	 * Attention certaine propriété sont obligatoire pour qu'une {@link AutoEvaluation} soit persisté
	 */
	public AutoEvaluation() {
		
	}
	
	/**
	 * Constructeur avec seulement l'id pour permetre les FacadeServiceSelect depuis la base de données
	 * Attention certaine propriété sont obligatoire pour qu'une {@link AutoEvaluation} soit persisté
	 */
	public AutoEvaluation(int identifiant) {
		setIdentifiant(identifiant);
	}
	
	/**
	 * Constructeur qui contient toute les informations sauf l'identifiant d'une {@link AutoEvaluation}
	 * 
	 * @param competence {@link Competence} Obligatoire pour persistance
	 * @param niveauAcquisition {@link NiveauAcquisition} Obligatoire pour persistance
	 * @param stagiaire {@link Stagiaire} Obligatoire pour persistance
	 * @param dateAutoEvaluation {@link LocalDate} Obligatoire pour persistance
	 * @param ressenti {@link String} Non Obligatoire pour persistance
	 */
	public AutoEvaluation(Competence competence,NiveauAcquisition niveauAcquisition, Stagiaire stagiaire, LocalDate dateAutoEvaluation, String ressenti) {
		
		super();
		this.competence = competence;
		this.niveauAcquisition = niveauAcquisition;
		this.stagiaire = stagiaire;
		this.dateAutoEvaluation = dateAutoEvaluation;
		this.ressenti = ressenti;
		
	}
	
	/**
	 * Constructeur qui contient toute les informations d'une {@link AutoEvaluation}
	 * 
	 * @param competence {@link Competence} Obligatoire pour persistance
	 * @param niveauAcquisition {@link NiveauAcquisition} Obligatoire pour persistance
	 * @param stagiaire {@link Stagiaire} Obligatoire pour persistance
	 * @param dateAutoEvaluation {@link LocalDate} Obligatoire pour persistance
	 * @param ressenti {@link String} Non Obligatoire pour persistance
	 */
	public AutoEvaluation(int identifiant,Competence competence,NiveauAcquisition niveauAcquisition, Stagiaire stagiaire, LocalDate dateAutoEvaluation, String ressenti) {
		
		super();
		this.identifiant = identifiant;
		this.competence = competence;
		this.niveauAcquisition = niveauAcquisition;
		this.stagiaire = stagiaire;
		this.dateAutoEvaluation = dateAutoEvaluation;
		this.ressenti = ressenti;
		
	}

	/**
	 * @return the identifiant
	 */
	public int getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the dateAutoEvaluation
	 */
	public LocalDate getDateAutoEvaluation() {
		return dateAutoEvaluation;
	}

	/**
	 * @param dateAutoEvaluation the dateAutoEvaluation to set
	 */
	public void setDateAutoEvaluation(LocalDate dateAutoEvaluation) {
		this.dateAutoEvaluation = dateAutoEvaluation;
	}

	/**
	 * @return the ressenti
	 */
	public String getRessenti() {
		return ressenti;
	}

	/**
	 * @param ressenti the ressenti to set
	 */
	public void setRessenti(String ressenti) {
		this.ressenti = ressenti;
	}

	/**
	 * @return the stagiaire
	 */
	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	/**
	 * @param stagiaire the stagiaire to set
	 */
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	/**
	 * @return the niveauAcquisition
	 */
	public NiveauAcquisition getNiveauAcquisition() {
		return niveauAcquisition;
	}

	/**
	 * @param niveauAcquisition the niveauAcquisition to set
	 */
	public void setNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		this.niveauAcquisition = niveauAcquisition;
	}
	
	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}

	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	@Override
	public String toString() {
		return "AutoEvaluation [identifiant=" + identifiant + ", competence=" + competence + ", niveauAcquisition="
				+ niveauAcquisition + ", stagiaire=" + stagiaire + ", dateAutoEvaluation=" + dateAutoEvaluation
				+ ", ressenti=" + ressenti + "]";
	}
	

}
