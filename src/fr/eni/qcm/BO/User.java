package fr.eni.qcm.BO;

/**
 * @author stropee2017
 *
 */
public class User {
	
	private int idUser;
	private String  password, nom, prenom, email, role, idPromo;
	
	
	
	/**
	 * Constructeur vide
	 */
	public User() {
	
	}



	/**
	 *Getter pour idUser
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}



	/**
	 * Setter pour idUser
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	/**
	 *Getter pour password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * Setter pour password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 *Getter pour nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * Setter pour nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 *Getter pour prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}



	/**
	 * Setter pour prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 *Getter pour email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * Setter pour email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 *Getter pour role
	 * @return the role
	 */
	public String getRole() {
		return role;
	}



	/**
	 * Setter pour role
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}



	/**
	 *Getter pour idPromo
	 * @return the idPromo
	 */
	public String getIdPromo() {
		return idPromo;
	}



	/**
	 * Setter pour idPromo
	 * @param idPromo the idPromo to set
	 */
	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}



	
	

	
	
	

}
