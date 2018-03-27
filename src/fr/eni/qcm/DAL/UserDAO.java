package fr.eni.qcm.DAL;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.User;

public interface UserDAO {
	
	
	public User loginUser(String login, String password) throws BusinessException;
	public void createUser(User user)throws BusinessException;
	public User selectCandidatByName(String name)throws BusinessException;
	public User selectPromo(int idpromo)throws BusinessException;
	
	
	
	

}
