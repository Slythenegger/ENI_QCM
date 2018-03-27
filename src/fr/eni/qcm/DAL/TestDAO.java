package fr.eni.qcm.DAL;

import java.util.List;

import fr.eni.qcm.BusinessException;
import fr.eni.qcm.BO.Test;

public interface TestDAO {

	List<Test> selectAll() throws BusinessException;
	
}
