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

	public static TestDAO getTestDAO() {
		return new TestDAOJdbcImpl();
	}
}
