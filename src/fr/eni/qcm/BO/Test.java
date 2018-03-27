package fr.eni.qcm.BO;

public class Test {
	private int idTest, duree;
	private float seuilHaut, seuilBas;
	private String libelle, description;
	
	public Test() {
		
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getSeuilHaut() {
		return seuilHaut;
	}

	public void setSeuilHaut(float seuilHaut) {
		this.seuilHaut = seuilHaut;
	}

	public float getSeuilBas() {
		return seuilBas;
	}

	public void setSeuilBas(float seuilBas) {
		this.seuilBas = seuilBas;
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

	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", duree=" + duree + ", seuilHaut=" + seuilHaut + ", seuilBas=" + seuilBas
				+ ", libelle=" + libelle + ", description=" + description + "]";
	}
	
}
