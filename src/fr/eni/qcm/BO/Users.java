/**
 * 
 */
package fr.eni.qcm.BO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wmodeste2017
 *	29 mars 2018
 */
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users;

	public Users() {
		this.users=new ArrayList<>();
	}
	
	public Users(List<User> users) {
		if(users!=null)
		this.users=users;
		else
			this.users=new ArrayList<>();
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	public void removeUser(User u) {
		users.remove(u);
	}
	public void removeUser(int id) {
		User u=null;
		for (User user : users) {
			if (user.getIdUser()==id)
		 u=user;
			
		}
		if (u!=null) {
			removeUser(u);
		}
		
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
