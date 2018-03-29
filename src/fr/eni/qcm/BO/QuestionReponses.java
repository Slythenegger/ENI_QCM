/**
 * 
 */
package fr.eni.qcm.BO;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de 
 * @author stropee2017
 * @date 29 mars 2018
 */
public class QuestionReponses {
	
	Question question;
	List<Reponse> reponses;
	
	/**
	 * Constructeur
	 */
	public QuestionReponses() {
		this.reponses = new ArrayList<Reponse>();
	}

	/**
	 *Getter pour question
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Setter pour question
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 *Getter pour reponses
	 * @return the reponses
	 */
	public List<Reponse> getReponses() {
		return reponses;
	}

	/**
	 * Setter pour reponses
	 * @param reponses the reponses to set
	 */
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}
	

}
