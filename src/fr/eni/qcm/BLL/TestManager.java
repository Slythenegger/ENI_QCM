package fr.eni.qcm.BLL;

import java.util.List;

import fr.eni.qcm.BusinessError;
import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Question;
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
	
	public List<Question> getQuesRepByIdTest(int idTest, int idEpreuve) throws BusinessException{
		
		List<Question> liste = this.dao.selectQuesRepByIdTest(idTest, idEpreuve);
		
		if (liste == null)
			throw new BusinessException(BusinessError.QUESTIONS_NO_MATCH);		
		
		return liste;
		
		
	}


	public void insert(Test test) throws BusinessException {
		this.dao.insert(test);		
	}
	public void cocheQuest(int idQuestion, int idEpreuve)throws BusinessException{
		
		this.dao.coche( idQuestion,  idEpreuve);
	}
	public void decocheQuest(int idQuestion, int idEpreuve)throws BusinessException{
		this.dao.decoche( idQuestion,  idEpreuve);
	}
}
