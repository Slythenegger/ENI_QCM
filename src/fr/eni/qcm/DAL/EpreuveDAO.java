package fr.eni.qcm.DAL;

import java.time.Instant;
import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.EpreuveCandidat;
import fr.eni.qcm.BO.ReponseUser;
import fr.eni.qcm.BO.Resultat;

public interface EpreuveDAO {

	public List<Epreuve> getUserEpreuve(int userID) throws BusinessException;
	public Boolean Create(Instant dateDebut, Instant dateFin, int idTest, int idUser )throws BusinessException;
	public List<Resultat> getResultatForTest(int testID) throws BusinessException;
	public List<EpreuveCandidat> getUserTest(int userId) throws BusinessException;
	public void ajoutReponseRadio(int idReponse, int idQuestion, int idEpreuve) throws BusinessException;
	public void ajoutReponseBox(int idReponse, int idQuestion, int idEpreuve) throws BusinessException;
	public List<ReponseUser> reponsesUser (int idEpreuve)throws BusinessException;
}
