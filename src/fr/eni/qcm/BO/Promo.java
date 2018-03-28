/**
 * 
 */
package fr.eni.qcm.BO;

/**
 * @author wmodeste2017
 *	28 mars 2018
 */
public class Promo {
private String codePromo, libellePromo;

/**
 * @return the codePromo
 */
public String getCodePromo() {
	return codePromo;
}

/**
 * 
 */
public Promo() {
	super();
}

/**
 * @param codePromo
 * @param libellePromo
 */
public Promo(String codePromo, String libellePromo) {
	super();
	this.codePromo = codePromo;
	this.libellePromo = libellePromo;
}

/**
 * @param codePromo the codePromo to set
 */
public void setCodePromo(String codePromo) {
	this.codePromo = codePromo;
}

/**
 * @return the libellePromo
 */
public String getLibellePromo() {
	return libellePromo;
}

/**
 * @param libellePromo the libellePromo to set
 */
public void setLibellePromo(String libellePromo) {
	this.libellePromo = libellePromo;
}



}
