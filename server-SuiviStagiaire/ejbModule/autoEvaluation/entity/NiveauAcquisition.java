package autoEvaluation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@link Class} {@link Entity}, {@link NiveauAcquisition} elle repr�sente l'�stimation du niveau d'acquisition d'un stagiaire sur une competence.
 * 
 * elle est compos� obligatoirement d'un identifiant auto-g�n�r�, et d'un niveau
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 15/06/2017
 *
 */
@Entity(name="niv_acqui")
public class NiveauAcquisition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="na_id", length=2, nullable=false)
	private String identifiant;
	
	@Column(name="na_niv", length=2, nullable=false)
	private String niveau;
	
	public NiveauAcquisition() {
		
	}
	

	/**
	 * @param identifiant
	 * @param niveau
	 */
	public NiveauAcquisition(String identifiant, String niveau) {
		super();
		this.identifiant = identifiant;
		this.niveau = niveau;
	}

	/**
	 * @return the Identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param Identifiant the Identifiant to set
	 */
	public void setIdentifiant(String Identifiant) {
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
				+ (getIdentifiant() != null ? "getIndentifiant()=" + getIdentifiant() + ", " : "")
				+ (getNiveau() != null ? "getNiveau()=" + getNiveau() : "") + "]";
	}

}
