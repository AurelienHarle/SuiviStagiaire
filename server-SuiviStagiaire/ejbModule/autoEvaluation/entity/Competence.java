package autoEvaluation.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * {@link Class} {@link Entity}, {@link Competences} elle représente une compétence de la formation.
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
public class Competence implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comp_id", length=3, nullable=false)
	private String identifiant;
	
	@Column(name="comp_nom_long", length=200, nullable=false)
	private String nomLong;
	
	@Column(name="comp_nom_court", length=200, nullable=false)
	private String nomCourt;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="seq_id",nullable=false)
	private Sequence sequence;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="mod_id",nullable=false)
	private Module module;
	
	public Competence() {
		
	}
	
	/**
	 * @param identifiant
	 * @param sequence
	 * @param module
	 * @param nomLong
	 * @param nomCourt
	 */
	public Competence(String identifiant, Sequence sequence, Module module, String nomLong, String nomCourt) {
		super();
		this.identifiant = identifiant;
		this.sequence = sequence;
		this.module = module;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Competences [identifiant=" + identifiant + ", nomLong=" + nomLong + ", nomCourt=" + nomCourt
				+ ", sequence=" + sequence + ", module=" + module + "]";
	}


}
