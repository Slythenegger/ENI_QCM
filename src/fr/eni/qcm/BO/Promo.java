/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;

/**
 * Classe en charge de 
 * @author stropee2017
 * @date 27 mars 2018
 */
public class Promo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codePromo, libelle;
	
	/**
	 * Constructeur vide
	 */
	public Promo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *Getter pour codePromo
	 * @return the codePromo
	 */
	public String getCodePromo() {
		return codePromo;
	}

	/**
	 * Setter pour codePromo
	 * @param codePromo the codePromo to set
	 */
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
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
