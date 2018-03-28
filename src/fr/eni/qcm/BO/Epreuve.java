package fr.eni.qcm.BO;

import java.time.Instant;

public class Epreuve {
	private int idEpreuve, idTest, idUtilisateur, tempsEcoule;
	private float noteObtenue;
	private String etat, niveauObtenu;
	private Instant debut, fin;
	
	public Epreuve() {

	}

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getTempsEcoule() {
		return tempsEcoule;
	}

	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	public float getNoteObtenue() {
		return noteObtenue;
	}

	public void setNoteObtenue(float nodeObtenue) {
		this.noteObtenue = nodeObtenue;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getNiveauObtenu() {
		return niveauObtenu;
	}

	public void setNiveauObtenu(String niveauObtenu) {
		this.niveauObtenu = niveauObtenu;
	}

	public Instant getDebut() {
		return debut;
	}

	public void setDebut(Instant debut) {
		this.debut = debut;
	}

	public Instant getFin() {
		return fin;
	}

	public void setFin(Instant fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Epreuve [idEpreuve=" + idEpreuve + ", idTest=" + idTest + ", idUtilisateur=" + idUtilisateur
				+ ", tempsEcoule=" + tempsEcoule + ", nodeObtenue=" + noteObtenue + ", etat=" + etat + ", niveauObtenu="
				+ niveauObtenu + ", debut=" + debut + ", fin=" + fin + "]";
	}
	
}
