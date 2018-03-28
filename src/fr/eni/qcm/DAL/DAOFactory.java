package fr.eni.qcm.DAL;

/**
 * Classe en charge de fournir un objet de connexion à la base 
 * @author stropee2017
 * @date 27 mars 2018
 */

public class DAOFactory {

	/**
	 * Méthode en charge de fournir un obet de type EpreuveDAO
	 * @return
	 */
	public static EpreuveDAO getEpreuveDAO() {
		return new EpreuveDAOJdbcImpl();
	}
	
	/**
	 * Méthode en charge de  fournir un objet de typer UserDAO
	 * @return
	 */
	public static TestDAO getTestDAO() {
		return new TestDAOJdbcImpl();
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOJdbcImpl();
	}

	/**
	 *	Methode servant à :
	 * @return
	 */
	public static PromoDAO getPromoDAO() {
		// TODO Auto-generated method stub
		return new PromoDAOJdbcImpl();
	}

	
}
