package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Promo;
import fr.eni.qcm.BO.Role;
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
	public User selectCandidatByName(String name)throws BusinessException;
	public User selectPromo(int idpromo)throws BusinessException;
	
	
	/**
	 * Méthode en charge de récupérer la lsite des roles en bases
	 * @return
	 * @throws BusinessException
	 */
	public List<Role> findRoles()throws BusinessException;
	
	/**
	 * Méthode en charge de récupérer la liste des promotions en base
	 * @return
	 * @throws BusinessException
	 */
	public List<Promo> findPromos()throws BusinessException;


	
	
	
	

}
