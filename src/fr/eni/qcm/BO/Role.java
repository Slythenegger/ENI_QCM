/**
 * 
 */
package fr.eni.qcm.BO;

/**
 * Classe en charge de 
 * @author stropee2017
 * @date 27 mars 2018
 */
public class Role {
	
	private String codeRole, libelle;

	
	/**
	 * Constructeur vide
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}


	/**
	 *Getter pour codeRole
	 * @return the codeRole
	 */
	public String getCodeRole() {
		return codeRole;
	}


	/**
	 * Setter pour codeRole
	 * @param codeRole the codeRole to set
	 */
	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}


	/**
	 *Getter pour libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}


	/**
	 * Setter pour libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
