package module.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@link Class} {@link Entity}, {@link Module} elle représente une module de la formation.
 *
 * elle est composé obligatoirement d'un identifiant, d'un nom long,et d'un nom court.
 * 
 * elle est {@link Serializable} 
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 */
@Entity
public class Module implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mod_id", length=3, nullable=false)	
	private String identifiant;
	
	@Column(name="mod_nom_long", length=200, nullable=false)
	private String nomLong;
	
	@Column(name="mod_nom_court", length=200, nullable=false)
	private String nomCourt;

	/**
	 * Constructeur par default
	 * Attention tout les propriété sont obligatoire pour qu'une {@link Module} soit persisté
	 */
	public Module() {
		
	}
	
	/**
	 * Constructeur qui contient toute les informations d'une {@link Module} 
	 * 
	 * @param identifiant {@link String} exemple: "M1", Obligatoire pour persistance
	 * @param nomLong {@link String} Nom long du module, Obligatoire pour persistance
	 * @param nomCourt {@link String} Nom court du module, Obligatoire pour persistance
	 */
	public Module(String identifiant, String nomLong, String nomCourt) {
		super();
		this.identifiant = identifiant;
		this.nomLong = nomLong;
		this.nomCourt = nomCourt;
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

	@Override
	public String toString() {
		return "Module [identifiant=" + identifiant + ", nomLong=" + nomLong + ", nomCourt=" + nomCourt + "]";
	}

}
