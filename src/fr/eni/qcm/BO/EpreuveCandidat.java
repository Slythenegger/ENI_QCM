/**
 * 
 */
package fr.eni.qcm.BO;



/**
 * @author mfouques2017
 *
 */
public class EpreuveCandidat  extends Epreuve {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String libelleTest;	
	
	
	/**
	 * Constructeur Vide
	 */
	public EpreuveCandidat() {
		// TODO Auto-generated constructor stub
	}



	/**
	 *Getter pour libelleTest
	 * @return the libelleTest
	 */
	public String getLibelleTest() {
		return libelleTest;
	}



	/**
	 * Setter pour libelleTest
	 * @param libelleTest the libelleTest to set
	 */
	public void setLibelleTest(String libelleTest) {
		this.libelleTest = libelleTest;
	}
	
	
}
