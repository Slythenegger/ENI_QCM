package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Question;
import fr.eni.qcm.BO.QuestionTirage;
import fr.eni.qcm.BO.Test;

public interface TestDAO {

	List<Test> selectAll() throws BusinessException;
	Test getById(int id) throws BusinessException;
	public List<Question> selectQuesRepByIdTest(int idTest, int idEpreuve)throws BusinessException;
	void insert(Test test) throws BusinessException;
	/**
	 *	Methode servant à marquer une question à l'aide de son id:
	 * @param id
	 * @param idEpreuve 
	 * @throws BusinessException 
	 */
	void coche(int id, int idEpreuve) throws BusinessException;
	/**
	 *	Methode servant à démarquer une question à l'aide de son id :
	 * @param id
	 * @param idEpreuve 
	 * @throws BusinessException 
	 */
	void decoche(int id, int idEpreuve) throws BusinessException;
	/**
	 *	Methode servant à retrouver une question Tiré à l'aide de son Id Epreuve et son Id Question:
	 * @param idEpreuve
	 * @param idQuestion
	 * @return
	 */
	QuestionTirage findQuestT(int idEpreuve, int idQuestion)throws BusinessException;
	
	
	
}
