package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.QuestionReponses;
import fr.eni.qcm.BO.Test;

public interface TestDAO {

	List<Test> selectAll() throws BusinessException;
	Test getById(int id) throws BusinessException;
	public List<QuestionReponses> selectQuesRepByIdTest(int idTest)throws BusinessException;
	
	
	
	
}
