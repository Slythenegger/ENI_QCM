package fr.eni.qcm.DAL;

import fr.eni.qcm.BO.User;

public interface UserDAO {
	
	
	public User loginUser(String login, String password);
	public void createUser(User user);
	
	
	
	

}
