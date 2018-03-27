package fr.eni.qcm.BLL;

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
}
