package fr.eni.qcm.DAL;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.User;

public interface UserDAO {
	
	
	/**
	 * Méthode en charge  de vérifier l'existence de l'utilisateur en base
	 * @param login
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public User loginUser(String login, String password) throws BusinessException;
	
	
	/**
	 * Méthode en charge de crééer un nouvel utilisateur-candidat dans la base
	 * @param user
	 * @throws BusinessException
	 */
	public void createUser(User user)throws BusinessException;
	
	
	
	

}
