package fr.eni.qcm.BO;



/**
 * @author wmodeste2017
 *
 */
public class Test {
	
/**
 * 
 */
private int idTest;
private float seuilHaut, seuilBas;
private String libelle, description;
private int duree;


public Test() {
	super();
}


/**
 * @param idTest
 * @param seuilHaut
 * @param seuilBas
 * @param libelle
 * @param description
 * @param duree
 */
public Test(int idTest, float seuilHaut, float seuilBas, String libelle, String description, int duree) {
	super();
	this.idTest = idTest;
	this.seuilHaut = seuilHaut;
	this.seuilBas = seuilBas;
	this.libelle = libelle;
	this.description = description;
	this.duree = duree;
}



/**
 * @return the idTest
 */
public int getIdTest() {
	return idTest;
}


/**
 * @param idTest the idTest to set
 */
public void setIdTest(int idTest) {
	this.idTest = idTest;
}


/**
 * @return the seuilHaut
 */
public float getSeuilHaut() {
	return seuilHaut;
}


/**
 * @param seuilHaut the seuilHaut to set
 */
public void setSeuilHaut(float seuilHaut) {
	this.seuilHaut = seuilHaut;
}


/**
 * @return the seuilBas
 */
public float getSeuilBas() {
	return seuilBas;
}


/**
 * @param seuilBas the seuilBas to set
 */
public void setSeuilBas(float seuilBas) {
	this.seuilBas = seuilBas;
}


/**
 * @return the libelle
 */
public String getLibelle() {
	return libelle;
}


/**
 * @param libelle the libelle to set
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}


/**
 * @return the description
 */
public String getDescription() {
	return description;
}


/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}


/**
 * @return the duree
 */
public int getDuree() {
	return duree;
}


/**
 * @param duree the duree to set
 */
public void setDuree(int duree) {
	this.duree = duree;
}










}
