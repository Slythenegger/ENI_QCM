/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;

/**
 * Classe en charge de stocké les sections pour un test donné
 * @author stropee2017
 * @date 29 mars 2018
 */
public class Section implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbQuestions, idTest, idTheme;
	
	/**
	 * Constructeur vide
	 */
	public Section() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 *Getter pour nbQuestions
	 * @return the nbQuestions
	 */
	public int getNbQuestions() {
		return nbQuestions;
	}

	/**
	 * Setter pour nbQuestions
	 * @param nbQuestions the nbQuestions to set
	 */
	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	/**
	 *Getter pour idTest
	 * @return the idTest
	 */
	public int getIdTest() {
		return idTest;
	}

	/**
	 * Setter pour idTest
	 * @param idTest the idTest to set
	 */
	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	/**
	 *Getter pour idTheme
	 * @return the idTheme
	 */
	public int getIdTheme() {
		return idTheme;
	}

	/**
	 * Setter pour idTheme
	 * @param idTheme the idTheme to set
	 */
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	
	

}
