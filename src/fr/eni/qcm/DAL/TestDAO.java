package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Test;

public interface TestDAO {

	List<Test> selectAll() throws BusinessException;
	Test getById(int id) throws BusinessException;
	void insert(Test test) throws BusinessException;
}
