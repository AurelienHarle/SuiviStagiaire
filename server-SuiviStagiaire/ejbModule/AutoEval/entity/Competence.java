package AutoEval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * {@link Class} {@link Entity}, {@link Competence} elle représente une compétence de la formation.
 * 
 * elle est composé obligatoirement :
 * d'un identifiant auto-généré fournis par la BDD, d'un nom long, d'un nom court,
 * d'une {@link Sequence},et d'un {@link Module}.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 * 
 */
@Entity(name="comp")
public class Competence {
	
	@Id
	@Column(name="comp_id", length=3, nullable=false)
	private String identifiant;
	
	@ManyToOne
	@JoinColumn( name="seq_id", nullable=false)
	private Sequence sequence;
	
	@ManyToOne
	@JoinColumn( name="mod_id", nullable=false)
	private Module module;
	
	@Column(name="comp_nom_long", length=200, nullable=false)
	private String nomLong;
	
	@Column(name="comp_nom_court", length=200, nullable=false)
	private String nomCourt;

	/**
	 * Default constructor
	 */
	public Competence() {
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
	 * @return the nomLong
	 */
	public String getNomLong() {
		return nomLong;
	}

	/**
	 * @param nomLong the nomLong to set
	 */
	public void setNomLong(String nomLong) {
		this.nomLong = nomLong;
	}

	/**
	 * @return the nomCourt
	 */
	public String getNomCourt() {
		return nomCourt;
	}

	/**
	 * @param nomCourt the nomCourt to set
	 */
	public void setNomCourt(String nomCourt) {
		this.nomCourt = nomCourt;
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
		return "Competence [" + (getIdentifiant() != null ? "getIdentifiant()=" + getIdentifiant() + ", " : "")
				+ (getNomLong() != null ? "getNomLong()=" + getNomLong() + ", " : "")
				+ (getNomCourt() != null ? "getNomCourt()=" + getNomCourt() + ", " : "")
				+ (getSequence() != null ? "getSequence()=" + getSequence() + ", " : "")
				+ (getModule() != null ? "getModule()=" + getModule() : "") + "]";
	}
}
