package AutoEval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@link Class} {@link Entity}, {@link Module} elle repr�sente une module de la formation.
 *
 * elle est compos� obligatoirement d'un identifiant, d'un nom long,et d'un nom court.
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 15/06/2017
 */
@Entity
public class Module {

	@Id
	@Column(name="mod_id", length=3, nullable=false)	
	private String identifiant;
	
	@Column(name="mod_nom_long", length=200, nullable=false)
	private String nomLong;
	
	@Column(name="mod_nom_court", length=200, nullable=false)
	private String nomCourt;
	
	/**
	 * Default Constructor
	 */
	public Module() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Module [" + (getIdentifiant() != null ? "getIdentifiant()=" + getIdentifiant() + ", " : "")
				+ (getNomLong() != null ? "getNomLong()=" + getNomLong() + ", " : "")
				+ (getNomCourt() != null ? "getNomCourt()=" + getNomCourt() : "") + "]";
	}

}
