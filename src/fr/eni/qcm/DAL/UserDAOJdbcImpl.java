package fr.eni.qcm.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Role;
import fr.eni.qcm.BO.User;

/**
 * Classe en charge de faire des requêtes à la base de données
 * 
 * @author stropee2017
 * @date 27 mars 2018
 */
public class UserDAOJdbcImpl implements UserDAO {

	private String LOGIN_USER = "select * from Utilisateur where email = ? and password = ?";
	private String CREATE_USER = "insert into Utilisateur (nom, prenom, email, password, codeProfil, codePromo) values (?,?,?,?,?,?)";
	private String FIND_ROLES = "select * from Profil";
	private String FIND_PROMOS = "select * from Promotion";

	/**
	 * Méthode en charge de de vérifier l'existence de l'utilisateur en base
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.UserDAO#loginUser(java.lang.String, java.lang.String)
	 */
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

			rs.close();
			pst.close();
			cnx.close();

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return user;
	}

	/**
	 * Méthode en charge de créer un nouvel utilisateur-candidat dans la base
	 * 
	 * @param user
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.UserDAO#createUser(fr.eni.qcm.BO.User)
	 */
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

			rs.close();
			pst.close();
			cnx.close();

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_INSERT);
		}

	}

	/**
	 * Méthode en charge de récuperer la liste des roles dans la base
	 * 
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.UserDAO#findRole()
	 */
	@Override
	public List<Role> findRoles() throws BusinessException {

		List<Role> roles = new ArrayList<Role>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_ROLES);

			while (rs.next()) {
				Role role = new Role();
				role.setCodeRole(rs.getString(1));
				role.setLibelle(rs.getString(2));
				roles.add(role);
			}

			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return roles;
	}

	/**
	 * Méthode en charge de récuperer la liste des promotions dans la base
	 * 
	 * @return
	 * @throws BusinessException
	 * @see fr.eni.qcm.DAL.UserDAO#findPromo()
	 */
	@Override
	public List<Promo> findPromos() throws BusinessException {
		List<Promo> promos = new ArrayList<Promo>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_PROMOS);

			while (rs.next()) {
				Promo promo = new Promo();
				promo.setCodePromo(rs.getString(1));
				promo.setLibelle(rs.getString(2));
				promos.add(promo);
			}

			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new BusinessException(BusinessError.DATABASE_ERROR);
		}

		return promos;
	}
}
