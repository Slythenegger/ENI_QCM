/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;

/**
 * Classe en charge de stockée les informations d'une réponse
 * @author stropee2017
 * @date 29 mars 2018
 */
public class Reponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReponse, idQuestion;
	private String enonce;
	boolean correct;
	
	/**
	 * Constructeur vide
	 */
	public Reponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 *Getter pour idReponse
	 * @return the idReponse
	 */
	public int getIdReponse() {
		return idReponse;
	}
	/**
	 * Setter pour idReponse
	 * @param idReponse the idReponse to set
	 */
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
	/**
	 *Getter pour idQuestion
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}
	/**
	 * Setter pour idQuestion
	 * @param idQuestion the idQuestion to set
	 */
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	/**
	 *Getter pour enonce
	 * @return the enonce
	 */
	public String getEnonce() {
		return enonce;
	}
	/**
	 * Setter pour enonce
	 * @param enonce the enonce to set
	 */
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	/**
	 *Getter pour correct
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}
	/**
	 * Setter pour correct
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	/**
	 * Méthode en charge de 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getEnonce();
	}
	

}
