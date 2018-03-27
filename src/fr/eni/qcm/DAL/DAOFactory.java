package fr.eni.qcm.DAL;

public class DAOFactory {

	public static UserDAO getUserDAO() {

		return new UserDAOJdbcImpl();
	}

}
