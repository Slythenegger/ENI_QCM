package fr.eni.qcm.DAL;

public class DAOFactory {

	public static EpreuveDAO getEpreuveDAO() {
		return new EpreuveDAOJdbcImpl();
	}
	
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
