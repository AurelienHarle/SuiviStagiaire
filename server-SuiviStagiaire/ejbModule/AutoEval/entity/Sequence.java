package AutoEval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * {@link Class} {@link Entity}, {@link Sequence} elle représente une sequence de la formation.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, d'un nom long, d'un nom court,
 * d'un {@link Module}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 */
@Entity
public class Sequence {
	
	@Id
	@Column(name="seq_id", length=3, nullable=false)
	private String identifiant;
	
	@ManyToOne
	@JoinColumn( name="mod_id", nullable=false)
	private Module module;
	
	@Column(name="seq_nom_long", length=200, nullable=false)
	private String nomLong;
	
	@Column(name="seq_nom_court", length=200, nullable=false)
	private String nomCourt;

	/**
	 * Default constructor
	 */
	public Sequence() {
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
		return "Sequence [" + (getIdentifiant() != null ? "getIdentifiant()=" + getIdentifiant() + ", " : "")
				+ (getNomLong() != null ? "getNomLong()=" + getNomLong() + ", " : "")
				+ (getNomCourt() != null ? "getNomCourt()=" + getNomCourt() + ", " : "")
				+ (getModule() != null ? "getModule()=" + getModule() : "") + "]";
	}

}
