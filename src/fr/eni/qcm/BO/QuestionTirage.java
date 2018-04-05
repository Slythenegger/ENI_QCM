/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;

/**
 * @author wmodeste2017
 *	4 avr. 2018
 */
public class QuestionTirage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean estMarquee;
	int idQuest, numOrdre, idEpreuve;
	/**
	 * 
	 */
	public QuestionTirage() {
		super();
	}
	/**
	 * @param estMarquee
	 * @param idQuest
	 * @param numOrdre
	 * @param idEpreuve
	 */
	public QuestionTirage(boolean estMarquee, int idQuest, int numOrdre, int idEpreuve) {
		super();
		this.estMarquee = estMarquee;
		this.idQuest = idQuest;
		this.numOrdre = numOrdre;
		this.idEpreuve = idEpreuve;
	}
	/**
	 * @return the estMarquee
	 */
	public boolean isEstMarquee() {
		return estMarquee;
	}
	/**
	 * @param estMarquee the estMarquee to set
	 */
	public void setEstMarquee(boolean estMarquee) {
		this.estMarquee = estMarquee;
	}
	/**
	 * @return the idQuest
	 */
	public int getIdQuest() {
		return idQuest;
	}
	/**
	 * @param idQuest the idQuest to set
	 */
	public void setIdQuest(int idQuest) {
		this.idQuest = idQuest;
	}
	/**
	 * @return the numOrdre
	 */
	public int getNumOrdre() {
		return numOrdre;
	}
	/**
	 * @param numOrdre the numOrdre to set
	 */
	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}
	/**
	 * @return the idEpreuve
	 */
	public int getIdEpreuve() {
		return idEpreuve;
	}
	/**
	 * @param idEpreuve the idEpreuve to set
	 */
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionTirage [estMarquee=" + estMarquee + ", idQuest=" + idQuest + ", numOrdre=" + numOrdre
				+ ", idEpreuve=" + idEpreuve + "]";
	}

	
}
