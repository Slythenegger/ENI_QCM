package fr.eni.qcm.BLL;

import java.util.Date;
import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.EpreuveDAO;

public class EpreuveManager {
	private EpreuveDAO dao;
	
	public EpreuveManager() {
		this.dao = DAOFactory.getEpreuveDAO();
	}
	
	public List<Epreuve> getUserEpreuve(int userID) throws BusinessException {
		return this.dao.getUserEpreuve(userID);
	}
	
	public void createEpreuve(Date dateDebut, Date dateFin, int idTest, int idUser)throws BusinessException{
	this.dao.Create(dateDebut, dateFin, idTest, idUser);	
	}
}
