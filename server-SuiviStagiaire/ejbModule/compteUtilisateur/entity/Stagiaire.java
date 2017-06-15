package compteUtilisateur.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * {@link Class} {@link Entity}, {@link Stagiaire} {@link Class} fille de {@link CompteUtilisateur} elle repr�sente un stagiaire.
 * 
 * elle est compos� obligatoirement d'un login, d'un motDePasse, d'un nom, d'un pr�nom, d'un num�ro de telephone administration,
 * d'un num�ro de telephone formation, d'une adresse, d'un mail, d'un mail formation, et d'une humeur
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 15/06/2017
 *
 */
@Entity(name="stag")
public class Stagiaire {
	
	@Id
	@Column(name="stag_login", length=3, nullable=false)
	private String login;
	
	@Column(name="stag_mdp", length=3, nullable=false)
	private String motDePasse;
	
	@Column(name="stag_nom", length=3, nullable=false)
	private String nom;
	
	@Column(name="stag_prenom", length=3, nullable=false)
	private String prenom;
	
	@Column(name="stag_num_tel_admi", length=3, nullable=false)
	private String numeroTelephoneAdministration;
	
	@Column(name="stag_num_tel_forma", length=3, nullable=false)
	private String numeroTelephoneFormation;
	
	@Column(name="stag_adresse", length=3, nullable=false)
	private String adresse;
	
	@Column(name="stag_mail", length=3, nullable=false)
	private String mail;
	
	@Column(name="stag_mail_forma", length=3, nullable=false)
	private String mailFormation;
	
	@Column(name="stag_humeur", length=3, nullable=false)
	private String humeur;

	/**
	 * Default construtor
	 */
	public Stagiaire() {
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
		return "Stagiaire [" + (getLogin() != null ? "getLogin()=" + getLogin() + ", " : "")
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
