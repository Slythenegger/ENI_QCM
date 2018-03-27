package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.User;

public class UserDAOJdbcImpl implements UserDAO {

	private String LOGIN_USER = "select * from Utilisateur where email = ? and password = ?";
	private String CREATE_USER = "insert into Utilisateur (nom, prenom, email, password, codeProfil, codePromo) values (?,?,?,?,?,?)";

	@Override
	public User loginUser(String email, String password) throws BusinessException {

		User user = new User();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pst = cnx.prepareStatement(LOGIN_USER);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				user.setIdUser(rs.getInt(1));
				user.setNom(rs.getString(2));
				user.setPrenom(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setIdPromo(rs.getString(7));
			} else
				user = null;

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return user;
	}

	@Override
	public void createUser(User user) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pst = cnx.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getNom());
			pst.setString(2, user.getPrenom());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getRole());
			pst.setString(6, user.getIdPromo());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next())
				user.setIdUser(rs.getInt(1));

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_INSERT);
		}

	}

}
