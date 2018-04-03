/**
 * 
 */
package fr.eni.qcm.RS;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BLL.UserManager;
import fr.eni.qcm.BO.User;
import fr.eni.qcm.BO.Users;

/**
 * @author wmodeste2017
 *	29 mars 2018
 */
@Path("/users")
public class GestionUsers {
private static Users users= new Users();

@GET
public List<User> getList()throws BusinessException
{
	System.out.println("dans getlist");
	UserManager umger= new UserManager();
	return umger.getAll();	
}

@GET
@Path("/nb")
public int getNb() throws BusinessException {
	UserManager umger=new UserManager();
	return umger.getAll().size();
}


	
}

