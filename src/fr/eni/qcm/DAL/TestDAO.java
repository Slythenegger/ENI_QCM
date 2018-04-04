package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Question;
import fr.eni.qcm.BO.Test;
import fr.eni.qcm.BO.Theme;

public interface TestDAO {

	List<Test> selectAll() throws BusinessException;
	Test getById(int id) throws BusinessException;
	public List<Question> selectQuesRepByIdTest(int idTest, int idEpreuve)throws BusinessException;
	void insert(Test test) throws BusinessException;
	
	public List<Theme> getAllThemes() throws BusinessException;
	
}
