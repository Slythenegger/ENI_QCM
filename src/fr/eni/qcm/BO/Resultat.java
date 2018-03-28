/**
 * 
 */
package fr.eni.qcm.BO;

/**
 * @author mfouques2017
 *
 */
public class Resultat extends Epreuve {
	private int IdUtilisateur;
	private String nom, prenom;
	
	public Resultat() {
		
	}

	public int getIdUtilisateur() {
		return IdUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		IdUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return super.toString() + " Resultat [IdUtilisateur=" + IdUtilisateur + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
