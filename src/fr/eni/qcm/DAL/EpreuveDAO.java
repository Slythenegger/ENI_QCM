package fr.eni.qcm.DAL;

import java.util.Date;
import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Epreuve;
import fr.eni.qcm.BO.Resultat;

public interface EpreuveDAO {

	public List<Epreuve> getUserEpreuve(int userID) throws BusinessException;
	public Epreuve Create(Date dateDebut, Date dateFin, int idTest, int idUser )throws BusinessException;
	public List<Resultat> getResultatForTest(int testID) throws BusinessException;
}
