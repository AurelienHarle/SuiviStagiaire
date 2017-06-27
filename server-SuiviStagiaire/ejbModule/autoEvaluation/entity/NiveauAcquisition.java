package autoEvaluation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * {@link Class} {@link Entity}, {@link NiveauAcquisition} elle représente l'éstimation du libelle d'acquisition d'un stagiaire sur une competence.
 * 
 * elle est composé obligatoirement d'un identifiant auto-généré, et d'un libelle
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 *
 */
@Entity
@Table(name="niv_acqui")
public class NiveauAcquisition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="na_id", length=2, nullable=false)
	private String identifiant;
	
	@Column(name="na_niv", length=20, nullable=false)
	private String libelle;
	
	public NiveauAcquisition() {
		
	}
	

	/**
	 * @param identifiant
	 * @param libelle
	 */
	public NiveauAcquisition(String identifiant, String libelle) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
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
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String niveau) {
		this.libelle = niveau;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NiveauAcquisition ["
				+ (getIdentifiant() != null ? "getIndentifiant()=" + getIdentifiant() + ", " : "")
				+ (getLibelle() != null ? "getNiveau()=" + getLibelle() : "") + "]";
	}

}
