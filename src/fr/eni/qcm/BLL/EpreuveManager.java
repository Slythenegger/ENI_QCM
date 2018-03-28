package fr.eni.qcm.BLL;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.EpreuveCandidat;
import fr.eni.qcm.BO.Resultat;
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
	
	public void createEpreuve(Instant dateFin, Instant dateDebut, int idTest, int idUser)throws BusinessException{
	System.out.println("on est passé ici");
		this.dao.Create(dateFin, dateDebut, idTest, idUser);	
	}

	public List<Resultat> getResultatForTest(int testID) throws BusinessException {
		return this.dao.getResultatForTest(testID);
	}

	public List<EpreuveCandidat> getUserTest(int userId) throws BusinessException {
		return this.dao.getUserTest(userId);
	}
}
