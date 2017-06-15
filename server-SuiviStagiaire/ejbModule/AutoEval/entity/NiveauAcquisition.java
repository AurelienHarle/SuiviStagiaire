package AutoEval.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@link Class} {@link Entity}, {@link NiveauAcquisition} elle représente l'éstimation du niveau d'acquisition d'un stagiaire sur une competence.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, et d'un niveau
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 *
 */
@Entity(name="niv_acqui")
public class NiveauAcquisition {

	@Id
	@Column(name="na_id", length=2, nullable=false)
	private String identifiant;
	
	@Column(name="na_niv", length=2, nullable=false)
	private String niveau;
	
	/**
	 * Default Constructor
	 */
	public NiveauAcquisition() {
	}

	/**
	 * @return the Identifiant
	 */
	public String getIndentifiant() {
		return identifiant;
	}

	/**
	 * @param Identifiant the Identifiant to set
	 */
	public void setIndentifiant(String Identifiant) {
		this.identifiant = Identifiant;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NiveauAcquisition ["
				+ (getIndentifiant() != null ? "getIndentifiant()=" + getIndentifiant() + ", " : "")
				+ (getNiveau() != null ? "getNiveau()=" + getNiveau() : "") + "]";
	}

}
