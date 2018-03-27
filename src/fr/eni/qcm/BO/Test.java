package fr.eni.qcm.BO;

import java.util.Date;

/**
 * @author wmodeste2017
 *
 */
public class Test {
	
/**
 * 
 */
private int id, seuilhaut, seuilbas;
private String libelle, description;
private Date duree;


public Test() {
	super();
}

/**
 * @param id
 * @param seuilhaut
 * @param seuilbas
 * @param libelle
 * @param description
 * @param duree
 */
public Test(int id, int seuilhaut, int seuilbas, String libelle, String description, Date duree) {
	super();
	this.id = id;
	this.seuilhaut = seuilhaut;
	this.seuilbas = seuilbas;
	this.libelle = libelle;
	this.description = description;
	this.duree = duree;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getSeuilhaut() {
	return seuilhaut;
}
public void setSeuilhaut(int seuilhaut) {
	this.seuilhaut = seuilhaut;
}
public int getSeuilbas() {
	return seuilbas;
}
public void setSeuilbas(int seuilbas) {
	this.seuilbas = seuilbas;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDuree() {
	return duree;
}
public void setDuree(Date duree) {
	this.duree = duree;
}



}
