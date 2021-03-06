/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge de stocké les informations lié à une question
 * 
 * @author stropee2017
 * @date 29 mars 2018
 */
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idQuestion, points, idTheme;
	private String enonce, media;
	boolean estMulti;
	private List<Reponse> reponses;

	/**
	 * Constructeur vide
	 */
	public Question() {
		reponses = new ArrayList<Reponse>();
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

	/**
	 * Getter pour estMulti
	 * 
	 * @return the estMulti
	 */
	public boolean isEstMulti() {
		return estMulti;
	}

	/**
	 * Setter pour estMulti
	 * 
	 * @param estMulti
	 *            the estMulti to set
	 */
	public void setEstMulti(boolean estMulti) {
		this.estMulti = estMulti;
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
	 * Getter pour points
	 * 
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Setter pour points
	 * 
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Getter pour idTheme
	 * 
	 * @return the idTheme
	 */
	public int getIdTheme() {
		return idTheme;
	}

	/**
	 * Setter pour idTheme
	 * 
	 * @param idTheme
	 *            the idTheme to set
	 */
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	/**
	 * Getter pour enonce
	 * 
	 * @return the enonce
	 */
	public String getEnonce() {
		return enonce;
	}

	/**
	 * Setter pour enonce
	 * 
	 * @param enonce
	 *            the enonce to set
	 */
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	/**
	 * Getter pour media
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Setter pour media
	 * 
	 * @param media
	 *            the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * Méthode en charge de
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return this.getEnonce();
	}

}
