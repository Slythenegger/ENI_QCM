package fr.eni.qcm.BLL;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.User;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.UserDAO;

/**
 * Classe en charge de gérer les utilisateurs
 * @author stropee2017
 * @date 27 mars 2018
 */
public class UserManager {

	private UserDAO uDao;

	/**
	 * Constructeur vide
	 */
	public UserManager() {

		uDao = DAOFactory.getUserDAO();
	}

	/**
	 * Méthode en charge de vérifier les informations saisies et d'envoyer le tout à la base
	 * @param email
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public User loginUser(String email, String password) throws BusinessException {

		User user = null;

		if (email == null || password == null || email.trim().equals("") || password.trim().equals("")) {

			throw new BusinessException(BusinessError.BLL_ERROR_CHAMP_VIDE);

		} else {

			user = uDao.loginUser(email, password);
			if (user == null) {
				throw new BusinessException(BusinessError.DATABASE_NO_MATCH);
			}
		}

		return user;
	}

	/**
	 * Méthode en charge de vérifier les informations saisies et d'envoyer le tout à la base
	 * @param user
	 * @throws BusinessException
	 */
	public void createUser(User user) throws BusinessException {

		boolean valide = validate(user);

		if (!valide) {

			throw new BusinessException(BusinessError.BLL_ERROR_CHAMP_VIDE);

		} else {

			uDao.createUser(user);
		}

	}

	/**
	 * Méthode en charge de vérifier le contenu d'un objet de type User
	 * @param user
	 * @return
	 */
	private boolean validate(User user) {

		boolean valide = true;

		if (user == null) {
			valide = false;
			return valide;
		}

		if (user.getNom() == null || user.getNom().trim().equals("")) {
			valide = false;
			return valide;
		}
		if (user.getPrenom() == null || user.getPrenom().trim().equals("")) {
			valide = false;
			return valide;
		}
		if (user.getEmail() == null || user.getEmail().trim().equals("")) {
			valide = false;
			return valide;
		}
		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			valide = false;
			return valide;
		}
		if (user.getRole() == null || user.getRole().trim().equals("")) {
			valide = false;
			return valide;
		}

		return valide;
	}

}
