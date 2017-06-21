package autoEvaluation.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import compteUtilisateur.entity.Stagiaire;


/**
 * {@link Class} {@link Entity}, {@link AutoEvaluation} elle représente l'évaluation du stagiaire sur une competence donner.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, d'une date d'evaluation mis a la date du jour de l'évaluation,
 * d'un {@link Stagiaire}, d'un {@link NiveauAcquisition}, et d'une {@link Competences}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
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
	
	//TODO CascadeType.ALL -> Aucun
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn( name="comp_id", nullable=false)
	private Competence competence;
	
	//TODO CascadeType.ALL -> Aucun
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn( name="seq_id", nullable=false)
	private Sequence sequence;
	
	//TODO CascadeType.ALL -> Aucun
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn( name="mod_id", nullable=false)
	private Module module;
	
	//TODO CascadeType.ALL -> Aucun
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="na_id", nullable=false)
	private NiveauAcquisition niveauAcquisition;
	
	//TODO CascadeType.ALL -> Aucun
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="stag_id", nullable=false)
	private Stagiaire stagiaire;
	
	@Column(name="ae_date", length=10, nullable=false)
	private LocalDate dateAutoEvaluation;
	
	@Column(name="ae_ressenti", length=4000, nullable=true)
	private String ressenti;

	public AutoEvaluation() {
		
	}
	
	/**
	 * Complete constructor
	 * 
	 * @param competence
	 * @param sequence
	 * @param module
	 * @param niveauAcquisition
	 * @param stagiaire
	 * @param dateAutoEvaluation
	 * @param ressenti
	 */
	public AutoEvaluation(Competence competence, Sequence sequence, Module module,
			NiveauAcquisition niveauAcquisition, Stagiaire stagiaire, LocalDate dateAutoEvaluation, String ressenti) {
		
		super();
		this.competence = competence;
		this.sequence = sequence;
		this.module = module;
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

	/**
	 * @return the sequence
	 */
	public Sequence getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AutoEvaluation [identifiant=" + identifiant + ", competence=" + competence + ", sequence=" + sequence
				+ ", module=" + module + ", niveauAcquisition=" + niveauAcquisition + ", stagiaire=" + stagiaire
				+ ", dateAutoEvaluation=" + dateAutoEvaluation + ", ressenti=" + ressenti + "]";
	}
	
	

}
