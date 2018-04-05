package fr.eni.qcm.BLL;

import java.time.Instant;
import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.EpreuveCandidat;
import fr.eni.qcm.BO.ReponseUser;
import fr.eni.qcm.BO.Resultat;
import fr.eni.qcm.BO.Test;
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

	public void createEpreuve(Instant dateFin, Instant dateDebut, int idTest, int idUser) throws BusinessException {

		TestManager tmger = new TestManager();
		Test test = new Test();
		test = tmger.getById(idTest);

		this.dao.Create(dateDebut, dateFin, test.getIdTest(), idUser);
	}

	public List<Resultat> getResultatForTest(int testID) throws BusinessException {
		return this.dao.getResultatForTest(testID);
	}

	public List<EpreuveCandidat> getUserTest(int userId) throws BusinessException {
		return this.dao.getUserTest(userId);
	}

	public void ajoutReponse(int idReponse, int idQuestion, int idEpreuve) throws BusinessException {
		this.dao.ajoutReponseRadio(idReponse, idQuestion, idEpreuve);
	}

	public List<ReponseUser> getReponsesUser(int idEpreuve) throws BusinessException {

		return this.dao.reponsesUser(idEpreuve);
	}
	public void ajouterReponseBox (int idReponse, int idQuestion, int idEpreuve) throws BusinessException {
		
		this.dao.ajoutReponseBox(idReponse, idQuestion, idEpreuve);
	}
	
	
}
