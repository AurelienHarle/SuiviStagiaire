package compteUtilisateur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * {@link Class} {@link Entity}, {@link Stagiaire} {@link Class} fille de {@link CompteUtilisateur} elle représente un stagiaire.
 * 
 * elle est composé obligatoirement d'un osia, d'un motDePasse, d'un nom, d'un prénom, d'un numéro de telephone administration,
 * d'un numéro de telephone formation, d'une adresse, d'un mail, d'un mail formation, et d'une humeur
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 15/06/2017
 *
 */
@Entity
@Table(name="stag")
public class Stagiaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stag_osia", length=8, nullable=false)
	private String osia;
	
	@Column(name="stag_mdp", length=30, nullable=false)
	private String motDePasse;
	
	@Column(name="stag_nom", length=60, nullable=false)
	private String nom;
	
	@Column(name="stag_prenom", length=60, nullable=false)
	private String prenom;
	
	@Column(name="stag_num_tel_admi", length=10, nullable=true)
	private String numeroTelephoneAdministration;
	
	@Column(name="stag_num_tel_forma", length=10, nullable=true)
	private String numeroTelephoneFormation;
	
	@Column(name="stag_adresse", length=200, nullable=true)
	private String adresse;
	
	@Column(name="stag_mail", length=50, nullable=true)
	private String mail;
	
	@Column(name="stag_mail_forma", length=50, nullable=true)
	private String mailFormation;
	
	@Column(name="stag_humeur", length=20, nullable=true)
	private String humeur;

	public Stagiaire() {
		
	}

	/**
	 * @param osia
	 * @param motDePasse
	 * @param nom
	 * @param prenom
	 * @param numeroTelephoneAdministration
	 * @param numeroTelephoneFormation
	 * @param adresse
	 * @param mail
	 * @param mailFormation
	 * @param humeur
	 */
	public Stagiaire(String osia, String motDePasse, String nom, String prenom, String numeroTelephoneAdministration,
			String numeroTelephoneFormation, String adresse, String mail, String mailFormation, String humeur) {
		super();
		this.osia = osia;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephoneAdministration = numeroTelephoneAdministration;
		this.numeroTelephoneFormation = numeroTelephoneFormation;
		this.adresse = adresse;
		this.mail = mail;
		this.mailFormation = mailFormation;
		this.humeur = humeur;
	}

	/**
	 * @return the osia
	 */
	public String getOsia() {
		return osia;
	}

	/**
	 * @param osia the osia to set
	 */
	public void setOsia(String osia) {
		this.osia = osia;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the numeroTelephoneAdministration
	 */
	public String getNumeroTelephoneAdministration() {
		return numeroTelephoneAdministration;
	}

	/**
	 * @param numeroTelephoneAdministration the numeroTelephoneAdministration to set
	 */
	public void setNumeroTelephoneAdministration(String numeroTelephoneAdministration) {
		this.numeroTelephoneAdministration = numeroTelephoneAdministration;
	}

	/**
	 * @return the numeroTelephoneFormation
	 */
	public String getNumeroTelephoneFormation() {
		return numeroTelephoneFormation;
	}

	/**
	 * @param numeroTelephoneFormation the numeroTelephoneFormation to set
	 */
	public void setNumeroTelephoneFormation(String numeroTelephoneFormation) {
		this.numeroTelephoneFormation = numeroTelephoneFormation;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the mailFormation
	 */
	public String getMailFormateur() {
		return mailFormation;
	}

	/**
	 * @param mailFormation the mailFormation to set
	 */
	public void setMailFormateur(String mailFormation) {
		this.mailFormation = mailFormation;
	}

	/**
	 * @return the humeur
	 */
	public String getHumeur() {
		return humeur;
	}

	/**
	 * @param humeur the humeur to set
	 */
	public void setHumeur(String humeur) {
		this.humeur = humeur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stagiaire [" + (getOsia() != null ? "getOsia()=" + getOsia() + ", " : "")
				+ (getMotDePasse() != null ? "getMotDePasse()=" + getMotDePasse() + ", " : "")
				+ (getNom() != null ? "getNom()=" + getNom() + ", " : "")
				+ (getPrenom() != null ? "getPrenom()=" + getPrenom() + ", " : "")
				+ (getNumeroTelephoneAdministration() != null
						? "getNumeroTelephoneAdministration()=" + getNumeroTelephoneAdministration() + ", " : "")
				+ (getNumeroTelephoneFormation() != null
						? "getNumeroTelephoneFormation()=" + getNumeroTelephoneFormation() + ", " : "")
				+ (getAdresse() != null ? "getAdresse()=" + getAdresse() + ", " : "")
				+ (getMail() != null ? "getMail()=" + getMail() + ", " : "")
				+ (getMailFormateur() != null ? "getMailFormateur()=" + getMailFormateur() + ", " : "")
				+ (getHumeur() != null ? "getHumeur()=" + getHumeur() : "") + "]";
	}

}
