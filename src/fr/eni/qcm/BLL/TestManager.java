package fr.eni.qcm.BLL;

import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.QuestionReponses;
import fr.eni.qcm.BO.Test;
import fr.eni.qcm.DAL.DAOFactory;
import fr.eni.qcm.DAL.TestDAO;

public class TestManager {
	private TestDAO dao;

	public TestManager() {
		this.dao = DAOFactory.getTestDAO();
	}

	public List<Test> getAll() throws BusinessException {
		return this.dao.selectAll();
	}

	public Test getById(int id) throws BusinessException {

		Test test = this.dao.getById(id);
		
		if (test == null)
			throw new BusinessException(BusinessError.TEST_NO_MATCH);

		return test;
	}
	
	public List<QuestionReponses> getQuesRepByIdTest(int idTest) throws BusinessException{
		
		List<QuestionReponses> liste = this.dao.selectQuesRepByIdTest(idTest);
		
		if (liste == null)
			throw new BusinessException(BusinessError.QUESTIONS_NO_MATCH);		
		
		return liste;
		
		
	}

}
