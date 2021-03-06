package fr.eni.qcm;

public enum BusinessError {
	
	// 000 - Misc
	DATABASE_ERROR(1, "Une erreur est survenue lors de la connexion avec la base de données"),
	DATABASE_INSERT(2, "Une erreur est survenue lors de l'insertion dans la base de données"),	
	BLL_ERROR_CHAMP_VIDE(3, "Tous les champs doivent être correctement renseigné"),
	DATABASE_NO_MATCH(4, "Login ou mot de passe incorrect !"), 
	TEST_NO_MATCH(5, "Test introuvable !"), 
	QUESTIONS_NO_MATCH(6, "Pas de questions trouvées pour ce test"),
	USERS_NO_MATCH(7, "Aucun utilisateur trouvé"),
	USER_NO_MATCH(8, "Cet utilisateur n'existe pas"),
	PROMOS_NO_MATCH(9, "Aucune promo n'a été trouvée"),
	PROMO_NO_MATCH(10,"Cette promo n'existe pas")
	
	
	
	
	;
	
	private final int code;
	private final String description;
	
	private BusinessError(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	@Override
	public String toString() {
		return "Error " + code + ": " + description;
	}
}
