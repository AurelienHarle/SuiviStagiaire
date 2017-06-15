package AutoEval.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import compteUtilisateur.entity.Stagiaire;

/**
 * {@link Class} {@link Entity}, {@link AutoEvaluation} elle représente l'évaluation du stagiaire sur une competence donner.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, d'une date d'evaluation mis a la date du jour de l'évaluation,
 * d'un {@link Stagiaire}, d'un {@link NiveauAcquisition}, et d'une {@link Competence}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 * 
 */
@Entity(name="auto_eval")
public class AutoEvaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ae_id", length=4, nullable=false)
	private String identifiant;
	
	@ManyToOne
	@JoinColumn( name="comp_id", nullable=false)
	private Competence competence;
	
	@ManyToOne
	@JoinColumn(name="seq_id", nullable=false)
	private Sequence sequence;
	
	@ManyToOne
	@JoinColumn(name="mod_id", nullable=false)
	private Module module;
	
	@ManyToOne
	@JoinColumn(name="na_id", nullable=false)
	private NiveauAcquisition niveauAcquisition;
	
	@ManyToOne
	@JoinColumn(name="stag_id", nullable=false)
	private Stagiaire stagiaire;
	
	@Column(name="ae_date", length=10, nullable=false)
	private LocalDate dateAutoEvaluation;
	
	@Column(name="ae_ressenti", length=4000, nullable=true)
	private String ressenti;
	

	

	

	
	/**
	 * Default constructor
	 */
	public AutoEvaluation() {
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AutoEvaluation [" + (getIdentifiant() != null ? "getIdentifiant()=" + getIdentifiant() + ", " : "")
				+ (getDateAutoEvaluation() != null ? "getDateAutoEvaluation()=" + getDateAutoEvaluation() + ", " : "")
				+ (getRessenti() != null ? "getRessenti()=" + getRessenti() + ", " : "")
				+ (getStagiaire() != null ? "getStagiaire()=" + getStagiaire() + ", " : "")
				+ (getNiveauAcquisition() != null ? "getNiveauAcquisition()=" + getNiveauAcquisition() + ", " : "")
				+ (getCompetence() != null ? "getCompetence()=" + getCompetence() : "") + "]";
	}

}
