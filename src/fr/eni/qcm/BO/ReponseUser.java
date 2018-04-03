/**
 * 
 */
package fr.eni.qcm.BO;

/**
 * Classe en charge de
 * 
 * @author stropee2017
 * @date 3 avr. 2018
 */
public class ReponseUser {

	private int idReponse, idQuestion, idEpreuve;

	/**
	 * Constructeur
	 */
	public ReponseUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter pour idReponse
	 * 
	 * @return the idReponse
	 */
	public int getIdReponse() {
		return idReponse;
	}

	/**
	 * Setter pour idReponse
	 * 
	 * @param idReponse
	 *            the idReponse to set
	 */
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}

	/**
	 * Getter pour idQuestion
	 * 
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}

	/**
	 * Setter pour idQuestion
	 * 
	 * @param idQuestion
	 *            the idQuestion to set
	 */
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	/**
	 * Getter pour idEpreuve
	 * 
	 * @return the idEpreuve
	 */
	public int getIdEpreuve() {
		return idEpreuve;
	}

	/**
	 * Setter pour idEpreuve
	 * 
	 * @param idEpreuve
	 *            the idEpreuve to set
	 */
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

}
