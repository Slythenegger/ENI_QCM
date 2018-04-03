package fr.eni.qcm.BLL;

import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Role;
import fr.eni.qcm.BO.User;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.UserDAO;

/**
 * Classe en charge de gérer les utilisateurs
 * 
 * @author stropee2017
 * @date 27 mars 2018
 */
/**
 * @author wmodeste2017
 *	29 mars 2018
 */
/**
 * @author wmodeste2017
 *	29 mars 2018
 */
public class UserManager {

	private UserDAO uDao;
	public List<User> getAll() throws BusinessException{
		return this.uDao.selectAll();
	}

	/**
	 * Constructeur vide
	 */
	public UserManager() {

		uDao = DAOFactory.getUserDAO();
	}

	/**
	 * Méthode en charge d'appeler la dao User de la couche dal pour récupérer la
	 * liste des roles
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Role> findRoles() throws BusinessException {

		return uDao.findRoles();
	}

	/**
	 * Méthode en charge de d'appeler la dao User de la couche dal pou récupérer la
	 * liste des promotions
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Promo> findPromos() throws BusinessException {

		return uDao.findPromos();
	}
	
	public List<User> findPromo(String codepromo) throws BusinessException{
		return uDao.selectPromo(codepromo);
	}

	/**
	 *	Methode servant à récupérer  une liste d'utilisateur appartenant à une promotion à l'aide 
	 *	du code promo :
	 * @param codepromo
	 * @return
	 * @throws BusinessException
	 */
	
	/**
	 *	Methode servant à  retrouver un stagiaire à l'aide de son nom:
	 * @param nom
	 * @return
	 * @throws BusinessException
	 */
	public List<User> findStagiaire(String nom) throws BusinessException {
		return uDao.selectStagiaireByName(nom);
	}
	/**
	 * Méthode en charge de vérifier les informations saisies et d'envoyer le tout à
	 * la base
	 * 
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
	 * Méthode en charge de vérifier les informations saisies et d'envoyer le tout à
	 * la base
	 * 
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
	 * 
	 * @param user
	 * @return
	 */
	private boolean validate(User user) {

		if (user == null) {
			return false;
		}

		if (user.getNom() == null || user.getNom().trim().equals("")) {
			return false;
		}
		if (user.getPrenom() == null || user.getPrenom().trim().equals("")) {
			return false;
		}
		if (user.getEmail() == null || user.getEmail().trim().equals("")) {
			return false;
		}
		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			return false;
		}
		if (user.getRole() == null || user.getRole().trim().equals("")) {
			return false;
		}

		return true;
	}

	/**
	 *	Methode servant à retrouver un candidat avec son nom :
	 * @param parameter
	 * @return
	 * @throws BusinessException 
	 */
	public List<User> findCandidat(String nom) throws BusinessException {
		// TODO Auto-generated method stub
		return uDao.selectCandidatByName(nom);
	}

	/**
	 *	Methode servant à :
	 * @param parameter
	 * @throws BusinessException 
	 */
	public User findUser(String parameter) throws BusinessException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(parameter);
		return uDao.selectUserById(id);
	}

}
