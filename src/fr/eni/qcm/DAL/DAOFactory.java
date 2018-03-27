package fr.eni.qcm.DAL;

public class DAOFactory {

	public static EpreuveDAO getEpreuveDAO() {
		return new EpreuveDAOJdbcImpl();
	}
	
	public static UserDAO getUserDAO() {
		return new UserDAOJdbcImpl();
	}

}
